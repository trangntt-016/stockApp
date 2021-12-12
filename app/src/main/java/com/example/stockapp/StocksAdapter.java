package com.example.stockapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stockapp.model.Stock;
import com.example.stockapp.model.WalletStock;
import com.example.stockapp.model.WalletStockManager;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StocksAdapter extends RecyclerView.Adapter<StocksAdapter.StocksViewHolder>{
    Context mCtx;
    List<Stock> stockList;
    StockClickedListener listener;



    public interface StockClickedListener {
        void stockClicked(Stock selectedStock);
    }


    public StocksAdapter(Context mCtx, List<Stock> stockList) {
        this.mCtx = mCtx;
        this.stockList = stockList;
        listener = (StockClickedListener)mCtx;
    }


    class StocksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView symbolTv;
        private final TextView sectorTv;
        private final TextView bidPriceTv;
        private final TextView changeInPriceTv;

        public StocksViewHolder(@NonNull View itemView) {
            super(itemView);
            symbolTv = itemView.findViewById(R.id.symbol);
            sectorTv = itemView.findViewById(R.id.sector);
            bidPriceTv = itemView.findViewById(R.id.bidPrice);
            changeInPriceTv = itemView.findViewById(R.id.changeInPrice);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Stock stock = stockList.get(getAdapterPosition());
            listener.stockClicked(stock);
        }

    }

    @Override
    public StocksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_stocks, parent, false);
        return new StocksViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull StocksViewHolder holder, int position) {
        DecimalFormat dfBidPrice = new DecimalFormat("'$' #,###.##",new DecimalFormatSymbols(Locale.ENGLISH));
        Stock stock = stockList.get(position);
        holder.symbolTv.setText(stock.symbol);
        holder.bidPriceTv.setText(dfBidPrice.format(stock.bidPrice));
        holder.sectorTv.setText(stock.sector);

        Double afterRounding = Math.round(stock.getPriceChange() * Math.pow(10, 1)) / Math.pow(10, 1);

        holder.changeInPriceTv.setText(String.valueOf(afterRounding));
        if(afterRounding < 0.0){
            holder.changeInPriceTv.setBackgroundColor(mCtx.getResources().getColor(R.color.red));
        }

    }

    @Override
    public int getItemCount() {
        return this.stockList.size();
    }

    public List<Stock>getStockList(){
        return stockList;
    }
}
