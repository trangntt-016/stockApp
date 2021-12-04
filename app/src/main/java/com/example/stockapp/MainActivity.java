package com.example.stockapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stockapp.model.Stock;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements StocksAdapter.stockClickListener,
        NetworkingService.NetworkingListener {
    List<Stock> stocks = new ArrayList<>();
    RecyclerView recyclerView;
    StocksAdapter adapter;
    NetworkingService networkingManager;
    JSonService jsonService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        networkingManager = ((myApp)getApplication()).getNetworkingService();
        jsonService = ((myApp)getApplication()).getJsonService();
        networkingManager.listener = this;
        recyclerView = findViewById(R.id.stock_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        networkingManager.getAllStocksFromApi();
        adapter = new StocksAdapter(this,stocks);
        recyclerView.setAdapter(adapter);
        setTitle("Search for new stocks");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem searchViewMenuItem = menu.findItem(R.id.search);

        SearchView searchView = (SearchView) searchViewMenuItem.getActionView();
        String searchFor = searchView.getQuery().toString();
        if (!searchFor.isEmpty()) {
            searchView.setIconified(false);
            searchView.setQuery(searchFor, false);
        }

        searchView.setQueryHint("Search for stocks");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {// when the user clicks enter
                Log.d("query", query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {// after each char
                if (newText.length() >= 3) {
                    // search for cities
                    //networkingManager.initializeStocks(newText);
                }
                else {
                    stocks = new ArrayList<>(0);
                    adapter.stockList = stocks;
                    adapter.notifyDataSetChanged();

                }
                return false;
            }
        });
        return true;
    }

    @Override
    public void dataListener(String jsonString) {
        // for testing
        jsonString =   "[{\"symbol\": \"SNAP\",\"bidSize\": 200,\"bidPrice\": 110.94,\"askSize\": 100,\"askPrice\": 111.82,\"volume\": 177265,\"lastSalePrice\": 111.76,\"lastSaleSize\": 5,\"lastSaleTime\": 1480446905681,\"lastUpdated\": 1480446910557,\"sector\":\"softwareservices\",\"securityType\":\"commonstock\"}]";
        stocks =  jsonService.getStocksFromJson(jsonString);
        adapter = new StocksAdapter(this,stocks);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void imageListener(Bitmap image) {

    }

    @Override
    public void stockClicked(Stock selectedStock) {

    }
}