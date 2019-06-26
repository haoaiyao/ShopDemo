package com.example.myapp.apps;

import android.app.Application;




public class MyApplication extends Application {

    public static MyApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        //初始化Density
        //DensityUtils.setDensity(this);

    }
}
