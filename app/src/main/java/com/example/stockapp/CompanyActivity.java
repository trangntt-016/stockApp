package com.example.stockapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stockapp.model.Company;
import com.example.stockapp.model.Stock;
import com.example.stockapp.utils.JsonUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class CompanyActivity extends AppCompatActivity implements NetworkingService.NetworkingListener{
    NetworkingService networkingManager;
    TextView companyNameTv;
    TextView countryTv;
    TextView descriptionTv;
    ImageView imageView;
    JsonUtils jsonConverterUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        String symbol = getIntent().getStringExtra("symbol");


        networkingManager = ((myApp)getApplication()).getNetworkingService();
        jsonConverterUtils = ((myApp)getApplication()).getJsonService();
        networkingManager.listener = this;

        networkingManager.getCompanyDataForStock(symbol);

        companyNameTv = findViewById(R.id.companyName);
        imageView = findViewById(R.id.image);
        descriptionTv = findViewById(R.id.description);

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


    @Override
    public void stockDataListener(List<Stock> stockList) {

    }

    @Override
    public void companyDataListener(Company company) {
        String companyStr = company.symbol + " - " + company.name;
        companyNameTv.setText(companyStr);
        descriptionTv.setText(company.description);

        //List<Stock>stockList = DatabaseService.getDbInstance().getStocksFromApi();
        networkingManager.getLogoCompanyFromUrl(company.logo);
    }

    @Override
    public void companyLogoListener(Bitmap image) {
        imageView.setImageBitmap(image);
    }


}
