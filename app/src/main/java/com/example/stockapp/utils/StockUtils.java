package com.example.stockapp.utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.stockapp.model.Stock;

import java.util.ArrayList;
import java.util.List;

public class StockUtils {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<Stock>searchForStocks(String stockChars, List<Stock>stockList){
        List<Stock>returnedStocks = new ArrayList<>();
        int left = 0, right = stockList.size() - 1;
        while(left <= right){
            if(stockList.get(left).symbol.indexOf(stockChars)>=0){
                returnedStocks.add(stockList.get(left));
            }
            if(left < right && stockList.get(right).symbol.indexOf(stockChars)>=0){
                returnedStocks.add(stockList.get(right));
            }
            left++;
            right--;

        }
        return returnedStocks;
    }
}
