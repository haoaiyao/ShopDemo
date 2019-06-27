package com.example.myapp.model.apis;

import com.example.myapp.model.bean.IndexBean;
import com.example.myapp.model.bean.home.HomeBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface MyApi {

    @GET("index/index")
    Flowable<IndexBean> getIndexData();

    //首页
    @GET("index/index")
    Flowable<HomeBean> getHomeBean();


}
