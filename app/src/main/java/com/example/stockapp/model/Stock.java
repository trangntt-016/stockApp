package com.example.stockapp.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

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


    public Double getPrice() {
        if (bidPrice == null)
            return null;
        return bidPrice;
    }
    public Double getPrevPrice() {
        if (lastSalePrice == null)
            return null;
        return lastSalePrice;
    }


    public static Double getPrice(Stock quote) {
        if (quote == null)
            return null;
        return quote.getPrice();
    }

    public Double getPriceChange() {
        if (this.bidPrice == null || this.lastSalePrice == null)
            return null;
        return this.bidPrice - this.lastSalePrice;
    }

}
