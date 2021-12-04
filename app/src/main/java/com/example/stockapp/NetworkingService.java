package com.example.stockapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;

import com.example.stockapp.model.Stock;

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
    private String weatherURL = "https://api.openweathermap.org/data/2.5/weather?q=+" ;
    private String  weatherURL2 = "+&appid=071c3ffca10be01d334505630d2c1a9c";
    private String iconURL = "https://openweathermap.org/img/wn/";
    private String iconURL2 = "@2x.png";


    public static ExecutorService networkExecutorService = Executors.newFixedThreadPool(4);
    public static Handler networkingHandler = new Handler(Looper.getMainLooper());

    interface NetworkingListener{
        void dataListener(String josnString);
        void imageListener(Bitmap image);
    }

    public NetworkingListener listener;

    public void searchForStock(String stockChars){
        String urlString = symbolsURL + TOKEN;
        //initializeStocks(urlString);
    }

    public void getWeatherDataForCity(String city){
        String urlFoWeather = weatherURL + city + weatherURL2;
        //initializeStocks(urlFoWeather);
    }


    public void getImageData(String icon){
        String urlstr = iconURL + icon + iconURL2;
        networkExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL urlObj = new URL(urlstr);
                    Bitmap bitmap = BitmapFactory.decodeStream((InputStream) urlObj.getContent());
                    networkingHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            // any code here will run in main thread
                            listener.imageListener(bitmap);
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


    public void getAllStocksFromApi(){
        final List<Stock> stockList = new ArrayList<>();
        JSonService jSonService = null;
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
                    final String jsonStr = jsonData;
                    networkingHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            // any code here will run in main thread
                            listener.dataListener(jsonStr);
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
}
