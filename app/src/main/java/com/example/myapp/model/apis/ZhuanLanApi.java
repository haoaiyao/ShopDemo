package com.example.myapp.model.apis;



import com.example.myapp.model.bean.SpecialBean;
import com.example.myapp.model.bean.ZhuanLan_XiangGuan;
import com.example.myapp.model.bean.ZhuanLan_detailBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ZhuanLanApi {
    @GET("topic/list")
    Flowable<SpecialBean> getZhuanLan();

    @GET("topic/related?")
    Flowable<ZhuanLan_XiangGuan>getZhuanlan2(@Query("id")String id);

    @GET("topic/detail")
    Flowable<ZhuanLan_detailBean>getZhuanlan3(@Query("id")String id);
}
