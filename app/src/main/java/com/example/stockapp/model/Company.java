package com.example.stockapp.model;


public class Company {
    public String logo;
    public String name;
    public String symbol;
    public String description;

    public Company(String logo,
                   String name,
                   String symbol,
                   String description){
        this.logo = logo;
        this.name = name;
        this.symbol = symbol;
        this.description = description;
    }

}
