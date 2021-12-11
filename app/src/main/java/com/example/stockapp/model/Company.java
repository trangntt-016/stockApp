package com.example.stockapp.model;

import java.util.Locale;

public class Company {
    public String logo;
    public String country;
    public String industry;
    public String name;
    public String symbol;
    public Long marketcap;
    public String description;

    public Company(String logo,
                   String country,
                   String industry,
                   String name,
                   String symbol,
                   Long marketcap,
                   String description){
        this.logo = logo;
        this.country = country.toUpperCase(Locale.ROOT);
        this.industry = industry;
        this.name = name;
        this.symbol = symbol;
        this.marketcap = marketcap;
        this.description = description;
    }

}
