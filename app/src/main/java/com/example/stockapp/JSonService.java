package com.example.stockapp;

import static android.text.TextUtils.indexOf;
import static android.text.TextUtils.substring;

import android.text.TextUtils;

import com.example.stockapp.model.Stock;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSonService {

    public ArrayList<Stock> getCitiesFromJSON(String json)  {
        ArrayList<Stock> arrayList = new ArrayList<>(0);
        try {
            JSONArray json_stocks = new JSONArray(json);
            for (int i = 0 ; i< json_stocks.length(); i++){
                // "Torbert, LA, United States"
                String fullCityName = json_stocks.getString(i);
                int index = fullCityName.indexOf(fullCityName,',');
                String cityName = substring(fullCityName,0,indexOf(fullCityName,','));
                String countryName = substring(fullCityName,indexOf(fullCityName,',') + 1, fullCityName.length());
                Stock c = new Stock(cityName);
                arrayList.add(c);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
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