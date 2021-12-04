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
    interface stockClickListener {
        void stockClicked(Stock selectedStock);
    }

    private Context mCtx;
    public List<Stock> stockList;
    stockClickListener listener;

    public StocksAdapter(Context mCtx, List<Stock> stockList) {
        this.mCtx = mCtx;
        this.stockList = stockList;
        listener = (stockClickListener)mCtx;
    }


    @NonNull
    @Override
    public StocksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_stocks, parent, false);
        return new StocksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StocksAdapter.StocksViewHolder holder, int position) {
        Stock stock = stockList.get(position);
        holder.stockTextView.setText(stock.getPrice() +": "+stock.getPrevPrice());
    }

    @Override
    public int getItemCount() {
        return stockList.size();
    }

    class StocksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView stockTextView;

        public StocksViewHolder(View itemView) {
            super(itemView);

            stockTextView = itemView.findViewById(R.id.symbol);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Stock stock = stockList.get(getAdapterPosition());
            listener.stockClicked(stock);

        }
    }
}
