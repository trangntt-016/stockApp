package com.example.stockapp.utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.stockapp.model.WalletStock;

import java.util.List;
import java.util.stream.Collectors;

public class WalletStockUtils {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean  isStockInWallet(String symbol, List<WalletStock>walletStockList){
        List<WalletStock> founds = walletStockList.stream().filter(s->s.symbol.equals(symbol)).collect(Collectors.toList());

        return !founds.isEmpty();
    }
}
