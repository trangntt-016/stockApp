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
    public Long lastSaleTime;
    public Long lastUpdated;
    public String sector;
    public String securityType;


    public Stock(String symbol,
                 Integer bidSize,
                 Double bidPrice,
                 Integer askSize,
                 Double askPrice,
                 Integer volume,
                 Double lastSalePrice,
                 Integer lastSaleSize,
                 Long lastSaleTime,
                 Long lastUpdated,
                 String sector,
                 String securityType) {
        this.symbol = symbol;
        this.bidSize = bidSize;
        this.bidPrice = bidPrice;
        this.askSize = askSize;
        this.askPrice = askPrice;
        this.volume = volume;
        this.lastSalePrice = lastSalePrice;
        this.lastSaleSize = lastSaleSize;
        this.lastSaleTime = lastSaleTime;
        this.lastUpdated = lastUpdated;
        this.sector = sector;
        this.securityType = securityType;
    }


    public Double getPriceChange() {
        if (this.bidPrice == null) this.bidPrice = 0.0;
        if(this.lastSalePrice == null) this.lastSalePrice = 0.0;
        return this.bidPrice - this.lastSalePrice;
    }

}
