package com.example.stockapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkingService {
    private String TOKEN = "pk_84fdc2a79dc94e02a9eac3bfc3e1f717";
    private String symbolsURL = "https://cloud.iexapis.com/stable/tops?token=";
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
        connect(urlString);
    }

    public void getWeatherDataForCity(String city){
        String urlFoWeather = weatherURL + city + weatherURL2;
        connect(urlFoWeather);
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


    public void connect(String url){
        networkExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection httpURLConnection = null;
                try {
                    String jsonData = "";
                    URL urlObj = new URL(url);
                    httpURLConnection = (HttpURLConnection) urlObj.openConnection();
                    httpURLConnection.setRequestMethod("GET");// post, delete, put
                    httpURLConnection.setRequestProperty("Conent-Type","application/json");
                    InputStream in = httpURLConnection.getInputStream();
                    InputStreamReader reader = new InputStreamReader(in);
                    int inputSteamData = 0;
                    while ( (inputSteamData = reader.read()) != -1){// there is data in this stream
                        char current = (char)inputSteamData;
                        jsonData += current;
                    }
                    final String finalData = jsonData;
                    // the data is ready
                    networkingHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            // any code here will run in main thread
                            listener.dataListener(finalData);
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
