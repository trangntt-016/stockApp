package com.example.stockapp.utils;

import com.example.stockapp.model.Stock;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

public class JsonUtils {
    public static Stock convertJsonToStockEntity(String jsonStr) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonStr);
        Gson gson= new Gson();
        Stock stock = gson.fromJson(jsonObject.toString(),Stock.class);
        stock.bidPrice = (Double) (Math.round(stock.bidPrice * 100.0)/100.0);
        stock.lastSalePrice = (Double) (Math.round(stock.lastSalePrice * 100.0)/100.0);
        stock.askPrice = (Double) (Math.round(stock.askPrice * 100.0)/100.0);
        return stock;
    }


    public static ArrayList<Stock> getStocksFromJson(String jsonArr)  {
        ArrayList<Stock> stocksList = new ArrayList<>(0);
        try {
            JSONArray json_stocks = new JSONArray(jsonArr);
            for (int i = 0 ; i< json_stocks.length(); i++){
                // {"symbol":"SNAP","bidSize":200,...}
                String fullStrStocks = json_stocks.getString(i);
                JSONObject json = new JSONObject(fullStrStocks);
                Stock stock = JsonUtils.convertJsonToStockEntity(fullStrStocks);
                stocksList.add(stock);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        // display the stocks with highest bid price to lowest
        Collections.sort(stocksList,(s1, s2)-> (int) (s2.bidPrice - s1.bidPrice));
        // only display 100 stocks, otherwise it will crash
        if(!stocksList.isEmpty())    stocksList.subList(0, 50);

        return stocksList;
    }


//    public WeatherData getWeatherData(String jsonString) {
//        WeatherData weatherData = new WeatherData();
//
//        try {
//            JSONObject jsonObject = new JSONObject(jsonString);
//            JSONArray weatherArray = jsonObject.getJSONArray("weather");
//            JSONObject weathedDataObject = weatherArray.getJSONObject(0);
//            String mainWeatherValue = weathedDataObject.getString("main");
//            String iconValue = weathedDataObject.getString("icon");
//
//
//
//            JSONObject tempObject = jsonObject.getJSONObject("main");
//            Double temp = tempObject.getDouble("temp");
//
//            weatherData = new WeatherData(mainWeatherValue,iconValue,temp);
//
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return weatherData;
//    }


}