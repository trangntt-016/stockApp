package com.example.stockapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stockapp.MainActivity;
import com.example.stockapp.R;
import com.example.stockapp.database.DatabaseManager;
import com.example.stockapp.model.WalletStock;
import com.example.stockapp.myApp;

import java.util.ArrayList;
import java.util.List;

public class WalletStockListActivity extends AppCompatActivity implements DatabaseManager.DatabaseListener {
    TextView symbolTv;
    ListView walletStockLV;

    DatabaseManager dbManager;
    ArrayList<WalletStock> walletStockListFromDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_stock_list);
        symbolTv = findViewById(R.id.symbol);
        walletStockLV = findViewById(R.id.list_of_wallet_stocks);
        dbManager = ((myApp) getApplication()).getDatabaseManager();
        dbManager.listener = this;
        dbManager.getAllWalletStocks();

    }
    @Override
    public void databaseAllWalletStocksListener(List<WalletStock> list) {
        walletStockListFromDB = new ArrayList<>(list);
        WalletStockListAdapter adapter = new WalletStockListAdapter(walletStockListFromDB,this);
        walletStockLV.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.wallet_stock_list_menu,menu);

        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.home:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
            case R.id.view_wallet:
                break;
            default:
                intent = new Intent(getApplicationContext(), CompanyActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}
