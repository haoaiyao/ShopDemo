package com.example.myapp.model.apis;



import com.example.myapp.model.bean.SpecialBean;
import com.example.myapp.model.bean.ZhuanLan_XiangGuan;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ZhuanLanApi {
    @GET("topic/list")
    Flowable<SpecialBean> getZhuanLan();

    @GET("topic/related?")
    Flowable<ZhuanLan_XiangGuan>getZhuanlan2(@Query("id")String id);
}
