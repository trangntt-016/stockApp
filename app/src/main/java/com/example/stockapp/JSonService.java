package com.example.stockapp;

import com.example.stockapp.model.Stock;
import com.example.stockapp.utils.EntityConverterUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSonService {

    public ArrayList<Stock> getStocksFromJson(String jsonArr)  {
        ArrayList<Stock> stocksList = new ArrayList<>(0);
        try {
            JSONArray json_stocks = new JSONArray(jsonArr);
            for (int i = 0 ; i< json_stocks.length(); i++){
                // {"symbol":"SNAP","bidSize":200,...}
                String fullStrStocks = json_stocks.getString(i);
                JSONObject json = new JSONObject(fullStrStocks);
                Stock stock = EntityConverterUtils.convertJsonToStockEntity(fullStrStocks);
                stocksList.add(stock);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
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