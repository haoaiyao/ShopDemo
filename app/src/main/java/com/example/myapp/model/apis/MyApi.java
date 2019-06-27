package com.example.myapp.model.apis;

import com.example.myapp.model.bean.IndexBean;
<<<<<<< HEAD
import com.example.myapp.model.bean.home.HomeBean;
=======
import com.example.myapp.model.bean.JujiaBeam;
>>>>>>> 4927d6cd37b638a5d6d96d00c2fccaa49c638490

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface MyApi {

    @GET("index/index")
    Flowable<IndexBean> getIndexData();

<<<<<<< HEAD
    //首页
    @GET("index/index")
    Flowable<HomeBean> getHomeBean();

=======
    @GET("catalog/index")
    Flowable<JujiaBeam> getJuJia();
>>>>>>> 4927d6cd37b638a5d6d96d00c2fccaa49c638490

}
