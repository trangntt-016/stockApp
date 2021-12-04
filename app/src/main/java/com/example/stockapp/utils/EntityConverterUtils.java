package com.example.stockapp.utils;

import com.example.stockapp.model.Stock;

import org.json.JSONException;
import org.json.JSONObject;


public class EntityConverterUtils {
    public static Stock convertJsonToStockEntity(String jsonStr) throws JSONException {
        JSONObject json = new JSONObject(jsonStr);
        String symbol = (String)json.get("symbol");
        Integer bidSize = (Integer)json.get("bidSize");
        Double bidPrice = (Double)json.get("bidPrice");
        Integer askSize = (Integer)json.get("askSize");
        Double askPrice = (Double)json.get("askPrice");
        Integer volume = (Integer)json.get("volume");
        Double lastSalePrice = (Double)json.get("lastSalePrice");
        Integer lastSaleSize = (Integer)json.get("lastSaleSize");
        Long lastSaleTime = (Long)json.get("lastSaleTime");
        Long lastUpdated = (Long)json.get("lastUpdated");
        String sector = (String)json.get("sector");
        String securityType = (String)json.get("securityType");
        return new Stock(symbol,bidSize,bidPrice,askSize,askPrice,volume,lastSalePrice,lastSaleSize,lastSaleTime,lastUpdated,sector,securityType);
    }
}
