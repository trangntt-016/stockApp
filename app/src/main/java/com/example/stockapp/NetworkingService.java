package com.example.stockapp;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.RequiresApi;

import com.example.stockapp.model.Company;
import com.example.stockapp.model.Stock;
import com.example.stockapp.utils.JsonUtils;
import com.example.stockapp.utils.DbUtils;
import com.example.stockapp.utils.StockUtils;

import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkingService {
    private final String symbolsURL = "https://cloud.iexapis.com/stable/tops?token=pk_84fdc2a79dc94e02a9eac3bfc3e1f717";
    private final String companyURL = "https://api.polygon.io/v1/meta/symbols/AMZN/company?apiKey=ee9v19qRNzXpkUj4FVI7cyRg6LA2KRfs";


    public static ExecutorService networkExecutorService = Executors.newFixedThreadPool(4);
    public static Handler networkingHandler = new Handler(Looper.getMainLooper());

    interface NetworkingListener{
        void stockDataListener(List<Stock> stockList);
        void companyDataListener(Company company);
        void companyLogoListener(Bitmap image);
    }


    public NetworkingListener listener;

    public void getAllStocksFromApi(){
        networkExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection httpURLConnection = null;
                List<Stock>tempStocks = new ArrayList<>();
                try {
                    // connect to api
                    String jsonData = "";
                    URL urlObj = new URL(symbolsURL);
                    httpURLConnection = (HttpURLConnection) urlObj.openConnection();
                    httpURLConnection.setRequestMethod("GET");// post, delete, put
                    httpURLConnection.setRequestProperty("Conent-Type","application/json");
                    // read data
                    InputStream in = httpURLConnection.getInputStream();
                    InputStreamReader ipReader = new InputStreamReader(in);
                    final BufferedReader bfReader = new BufferedReader(ipReader);
                    for (String line; (line = bfReader.readLine()) != null;) {
                        jsonData +=line;
                    }
                    // the data is ready
                    //final String jsonStr = jsonData;
                    final String jsonStr = DbUtils.getText();
                    // convert from jSon to List<Stock>
                    List<Stock> stocks =  JsonUtils.getStocksFromJson(jsonStr);
                    final List<Stock>finalStocks = stocks;
                    networkingHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            // any code here will run in main thread
                            listener.stockDataListener(finalStocks);
                        }
                    });
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    httpURLConnection.disconnect();

                }

            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void searchForStocks(String stockChars){
        final List<Stock>stockList = StockUtils.searchForStocks(stockChars);
        networkingHandler.post(new Runnable() {
            @Override
            public void run() {
                // any code here will run in main thread
                listener.stockDataListener(stockList);
            }
        });
    }

    public void getCompanyDataForStock(String symbol){
        networkExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection httpURLConnection = null;
                List<Company>companyList = new ArrayList<>();
                try {
                    // connect to api
                    String jsonData = "";
                    URL urlObj = new URL(companyURL);
                    httpURLConnection = (HttpURLConnection) urlObj.openConnection();
                    httpURLConnection.setRequestMethod("GET");// post, delete, put
                    httpURLConnection.setRequestProperty("Conent-Type","application/json");
                    // read data
                    InputStream in = httpURLConnection.getInputStream();
                    InputStreamReader ipReader = new InputStreamReader(in);
                    final BufferedReader bfReader = new BufferedReader(ipReader);
                    for (String line; (line = bfReader.readLine()) != null;) {
                        jsonData +=line;
                    }
                    // the data is ready
                    final Company company =  JsonUtils.getCompanyFromJson(jsonData);
                    networkingHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            // any code here will run in main thread
                            listener.companyDataListener(company);
                        }
                    });
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    httpURLConnection.disconnect();
                }
            }
        });
    }

    public void getLogoCompanyFromUrl(String logoUrl){
        networkExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL urlObj = new URL(logoUrl);
                    Bitmap bitmap = BitmapFactory.decodeStream((InputStream) urlObj.getContent());
                    networkingHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            // any code here will run in main thread
                            listener.companyLogoListener(bitmap);
                        }
                    });
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
