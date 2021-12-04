package com.example.stockapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stockapp.model.Stock;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements StocksAdapter.stockClickListener,
        NetworkingService.NetworkingListener {
    ArrayList<Stock> stocks = new ArrayList<Stock>();
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

        stocks.add(new Stock("temp"));
        adapter = new StocksAdapter(this,stocks);
        recyclerView.setAdapter(adapter);
        setTitle("Search for new cities..");
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

                return false;
            }
        });
        return true;
    }

    @Override
    public void dataListener(String josnString) {

    }

    @Override
    public void imageListener(Bitmap image) {

    }

    @Override
    public void stockClicked(Stock selectedStock) {

    }
}