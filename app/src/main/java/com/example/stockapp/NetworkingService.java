package com.example.stockapp;


import android.os.Build;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.RequiresApi;
import androidx.room.util.DBUtil;

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
    private String TOKEN = "pk_84fdc2a79dc94e02a9eac3bfc3e1f717";
    private String symbolsURL = "https://cloud.iexapis.com/stable/tops?token=" + TOKEN;


    public static ExecutorService networkExecutorService = Executors.newFixedThreadPool(4);
    public static Handler networkingHandler = new Handler(Looper.getMainLooper());

    interface NetworkingListener{
        void dataListener(List<Stock> stockList);
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
                            listener.dataListener(finalStocks);
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
                listener.dataListener(stockList);
            }
        });
    }
}
