package com.example.myapp.model.apis;

import com.example.myapp.model.bean.IndexBean;
import com.example.myapp.model.bean.JujiaBeam;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface MyApi {

    @GET("index/index")
    Flowable<IndexBean> getIndexData();

    @GET("catalog/index")
    Flowable<JujiaBeam> getJuJia();

}
