package com.example.stockapp;

import android.app.Application;

public class myApp extends Application {
    private NetworkingService networkingService = new NetworkingService();

    public JSonService getJsonService() {
        return jsonService;
    }

    private JSonService jsonService = new JSonService();


    public NetworkingService getNetworkingService() {
        return networkingService;
    }
}
