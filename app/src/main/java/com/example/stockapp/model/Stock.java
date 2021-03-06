package com.example.stockapp.model;


public class Stock {
    public String symbol;
    public Integer bidSize;
    public Double bidPrice;
    public Integer askSize;
    public Double askPrice;
    public Integer volume;
    public Double lastSalePrice;
    public Integer lastSaleSize;
    public String sector;


    public Stock(String symbol,
                 Integer bidSize,
                 Double bidPrice,
                 Integer askSize,
                 Double askPrice,
                 Integer volume,
                 Double lastSalePrice,
                 Integer lastSaleSize,
                 String sector
    ) {
        this.symbol = symbol;
        this.bidSize = bidSize;
        this.bidPrice = bidPrice;
        this.askSize = askSize;
        this.askPrice = askPrice;
        this.volume = volume;
        this.lastSalePrice = lastSalePrice;
        this.lastSaleSize = lastSaleSize;
        this.sector = sector;
    }


    public Double getPriceChange() {
        if (this.bidPrice == null) this.bidPrice = 0.0;
        if(this.lastSalePrice == null) this.lastSalePrice = 0.0;
        return this.bidPrice - this.lastSalePrice;
    }

}
