package com.example.stockapp.utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.stockapp.model.WalletStock;

import java.util.List;
import java.util.stream.Collectors;

public class WalletStockUtils {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean  isStockInWallet(String symbol, List<WalletStock>walletStockList){
        int left = 0, right = walletStockList.size() - 1;
        while(left <=right){
            if(walletStockList.get(left).symbol.equals(symbol)||walletStockList.get(right).symbol.equals(symbol)){
                return true;
            }
            left++;
            right--;
        }

        return false;
    }
}
