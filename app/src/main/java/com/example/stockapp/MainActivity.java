package com.example.stockapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stockapp.model.Company;
import com.example.stockapp.model.Stock;
import com.example.stockapp.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements StocksAdapter.StockClickedListener,
NetworkingService.NetworkingListener{
    List<Stock> stocks = new ArrayList<>();
    RecyclerView recyclerView;
    StocksAdapter adapter;
    NetworkingService networkingManager;
    JsonUtils jsonConverterUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        networkingManager = ((myApp)getApplication()).getNetworkingService();
        jsonConverterUtils = ((myApp)getApplication()).getJsonService();

        networkingManager.listener = this;
        recyclerView = findViewById(R.id.stock_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        networkingManager.getAllStocksFromApi();
        adapter = new StocksAdapter(this,stocks);
        recyclerView.setAdapter(adapter);
        setTitle("Search for a symbol");
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

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public boolean onQueryTextChange(String newText) {// after each char
                if (newText.length() >0) {
                    // search for cities
                    networkingManager.searchForStocks(newText, stocks);
                }
                else {
                    networkingManager.getAllStocksFromApi();
                    adapter.notifyDataSetChanged();

                }
                return false;
            }
        });
        return true;
    }




    @Override
    public void stockClicked(Stock selectedStock) {
        Intent intent = new Intent(this,CompanyActivity.class);
        intent.putExtra("symbol",selectedStock.symbol);
        startActivity(intent);
    }



    @Override
    public void stockDataListener(List<Stock> stockList) {
        this.stocks = stockList;
        adapter = new StocksAdapter(this,stockList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void companyDataListener(Company company) {

    }

    @Override
    public void companyLogoListener(Bitmap image) {

    }

}