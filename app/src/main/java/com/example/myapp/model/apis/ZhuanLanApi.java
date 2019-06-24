package com.example.myapp.model.apis;



import com.example.myapp.model.bean.SpecialBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ZhuanLanApi {
    @GET("topic/list")
    Flowable<SpecialBean> getZhuanLan();
}
