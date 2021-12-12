package com.example.stockapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stockapp.model.WalletStock;

import java.util.ArrayList;

public class WalletStockListAdapter extends BaseAdapter {
    ArrayList<WalletStock> walletStockList;
    Context list_activity_Context;

    WalletStockListAdapter(ArrayList<WalletStock> list, Context activity_context){
        walletStockList = list;
        list_activity_Context = activity_context;
    }
    @Override
    public int getCount() {
        return walletStockList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(list_activity_Context).inflate(R.layout.wallet_stock_item,null);
        TextView symbol = view.findViewById(R.id.symbol);
        return view;
    }
}
