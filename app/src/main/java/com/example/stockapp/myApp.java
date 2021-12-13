package com.example.stockapp;

import android.app.Application;

import com.example.stockapp.database.DatabaseManager;
import com.example.stockapp.service.NetworkingService;
import com.example.stockapp.utils.JsonUtils;

public class myApp extends Application {
    private NetworkingService networkingService = new NetworkingService();

    public JsonUtils getJsonService() {
        return jsonConverterUtils;
    }


    private JsonUtils jsonConverterUtils = new JsonUtils();

    public NetworkingService getNetworkingService() {
        return networkingService;
    }

    private DatabaseManager databaseManager = new DatabaseManager();

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }
}
