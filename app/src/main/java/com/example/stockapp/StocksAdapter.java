package com.example.stockapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stockapp.model.Stock;

import java.util.List;

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


    public static class StocksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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
//            Stock stock = stockList.get(getAdapterPosition());
//            listener.stockClicked(stock);
        }

    }

    @Override
    public StocksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_stocks, parent, false);
        return new StocksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StocksViewHolder holder, int position) {
        Stock stock = stockList.get(position);
        holder.symbolTv.setText(stock.symbol);
        holder.bidPriceTv.setText(String.valueOf(stock.bidPrice));
        holder.sectorTv.setText(stock.sector);
        holder.changeInPriceTv.setText(String.valueOf(stock.getPriceChange()));

    }

    @Override
    public int getItemCount() {
        return stockList.size();
    }
}
