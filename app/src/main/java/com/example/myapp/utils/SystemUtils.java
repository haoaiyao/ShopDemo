package com.example.myapp.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;

import com.example.myapp.apps.MyApplication;

public class SystemUtils {

    /**
     * 检查是否有网络
     * @return
     */
    public static boolean checkNetWork(){
        ConnectivityManager manager = (ConnectivityManager) MyApplication.app.getSystemService(Context.CONNECTIVITY_SERVICE);
        return manager.getActiveNetworkInfo() != null;
    }

    /**
     * 当前是否是wifi链接
     * @return
     */
    public static boolean isWifiConnected(){
        ConnectivityManager manager = (ConnectivityManager) MyApplication.app.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return info != null;
    }

    /**
     * 检查手机（4,3,2）G是否链接
     */
    public static boolean isMobileNetworkConnected(){
        ConnectivityManager manager = (ConnectivityManager) MyApplication.app.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return info != null;
    }

    /**
     * 获取屏幕的dpi
     * @param at
     * @return
     */
    public static int getDpi(Activity at){
        DisplayMetrics dm = new DisplayMetrics();
        at.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.densityDpi;
    }



}
