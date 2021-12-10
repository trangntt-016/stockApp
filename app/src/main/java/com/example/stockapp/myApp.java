package com.example.stockapp;

import android.app.Application;

import com.example.stockapp.utils.JsonUtils;

public class myApp extends Application {
    private NetworkingService networkingService = new NetworkingService();

    public JsonUtils getJsonService() {
        return jsonConverterUtils;
    }

//    public DatabaseService getDbService(){
//        return DatabaseService.getDbInstance();
//    }

    private JsonUtils jsonConverterUtils = new JsonUtils();


    public NetworkingService getNetworkingService() {
        return networkingService;
    }
}
