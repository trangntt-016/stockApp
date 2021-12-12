package com.example.stockapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stockapp.database.DatabaseManager;
import com.example.stockapp.database.WalletStockDatabase;
import com.example.stockapp.model.Company;
import com.example.stockapp.model.Stock;
import com.example.stockapp.model.WalletStock;
import com.example.stockapp.model.WalletStockManager;
import com.example.stockapp.utils.JsonUtils;
import com.example.stockapp.utils.StockUtils;
import com.example.stockapp.utils.WalletStockUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

public class CompanyActivity extends AppCompatActivity implements NetworkingService.NetworkingListener{
    NetworkingService networkingManager;
    JsonUtils jsonConverterUtils;

    ImageView imageView;
    TextView companyNameTv;
    TextView descriptionTv;
    TextView askPriceTv;
    TextView bidPriceTv;
    TextView lastSalePriceTv;
    TextView volumeTv;

    List<Stock>stockList = null;
    Company selectedCompany = null;

    static WalletStockManager walletStockManager = new WalletStockManager();
    WalletStock walletStock = new WalletStock();
    DatabaseManager dbManager;
    WalletStockDatabase db;

    private AlertDialog.Builder dialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        String symbol = getIntent().getStringExtra("symbol");


        networkingManager = ((myApp)getApplication()).getNetworkingService();
        jsonConverterUtils = ((myApp)getApplication()).getJsonService();
        networkingManager.listener = this;

        networkingManager.getCompanyDataForStock(symbol);

        imageView = findViewById(R.id.image);
        companyNameTv = findViewById(R.id.companyName);
        descriptionTv = findViewById(R.id.description);
        askPriceTv = findViewById(R.id.company_askPrice);
        bidPriceTv = findViewById(R.id.company_bidPrice);
        lastSalePriceTv = findViewById(R.id.company_lastSalePrice);
        volumeTv = findViewById(R.id.volume);

        FloatingActionButton fab = findViewById(R.id.addToWallet);
        fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                // check if this stock already exists in the wallet
                if(WalletStockUtils.isStockInWallet(selectedCompany.symbol, walletStockManager.getListOfWalletStocks())){
                    dialogBuilder = new AlertDialog.Builder(view.getContext());
                    dialogBuilder.setTitle("Error").setMessage("This symbol is already added in your wallet");
                    dialogBuilder.setCancelable(true);

                    dialogBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }}
                    );

                    dialogBuilder.setPositiveButton("View Your Wallet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(view.getContext(),WalletStockListActivity.class);
                            intent.putParcelableArrayListExtra("listOfWalletStocks",walletStockManager.getListOfWalletStocks());
                            startActivity(intent);
                        }}
                    );
                    dialogBuilder.show();

                }
                else{
                    walletStock.symbol = selectedCompany.symbol;
                    walletStock.logo = selectedCompany.logo;
                    walletStock.name = selectedCompany.name;

                    walletStockManager.addNewWalletStock(walletStock);
                    dbManager.insertNewWalletStock(walletStock);
                    walletStock = new WalletStock();

                    Toast.makeText(view.getContext()
                            ,"Successfully added!",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

        db = DatabaseManager.getDBInstance(this);
        dbManager = ((myApp)getApplication()).getDatabaseManager();

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void stockDataListener(List<Stock> stockList) {
        DecimalFormat dfChange = new DecimalFormat("'$' #,###.#",new DecimalFormatSymbols(Locale.ENGLISH));
        DecimalFormat dfVolume = new DecimalFormat("#,###.#",new DecimalFormatSymbols(Locale.ENGLISH));
        this.stockList = stockList;
        Stock selectedStock = StockUtils.searchForStocks(this.selectedCompany.symbol, stockList).get(0);
        String companyStr = this.selectedCompany.symbol + " - " + this.selectedCompany.name;
        companyNameTv.setText(companyStr);
        descriptionTv.setText(this.selectedCompany.description);
        askPriceTv.setText(dfChange.format(selectedStock.askPrice));
        bidPriceTv.setText(dfChange.format(selectedStock.bidPrice));
        lastSalePriceTv.setText(dfChange.format(selectedStock.lastSalePrice));
        volumeTv.setText(dfVolume.format(selectedStock.volume));

        networkingManager.getLogoCompanyFromUrl(this.selectedCompany.logo);

    }

    @Override
    public void companyDataListener(Company company) {
        this.selectedCompany = company;
        networkingManager.getAllStocksFromApi();

    }

    @Override
    public void companyLogoListener(Bitmap image) {
        imageView.setImageBitmap(image);
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

        if(item.getItemId()== R.menu.wallet_stock_list_menu || item.getItemId()==R.id.view_wallet){
            Intent intent = new Intent(getApplicationContext(),WalletStockListActivity.class);
            intent.putParcelableArrayListExtra("listOfWalletStocks",walletStockManager.getListOfWalletStocks());
            startActivity(intent);
        }

        else{
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }

        return true;
    }




}
