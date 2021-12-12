package com.example.stockapp;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stockapp.model.Company;
import com.example.stockapp.model.Stock;
import com.example.stockapp.utils.JsonUtils;
import com.example.stockapp.utils.StockUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Currency;
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
            @Override
            public void onClick(View view) {
            // add a new owner
//            AddNewOwnerFragment fragment = new AddNewOwnerFragment();
//            fragment.show(getSupportFragmentManager(),"1");
//            fragment.listener = MainActivity.this;
            }
        });
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


}
