package com.example.myapp.persenter;

import com.example.myapp.base.BasePersenter;
import com.example.myapp.component.CommonSubscriber;
import com.example.myapp.interfaces.IBaseView;
import com.example.myapp.interfaces.IPersenter;
import com.example.myapp.interfaces.news.NewsContract;
import com.example.myapp.model.bean.IndexBean;
import com.example.myapp.model.http.HttpManager;
import com.example.myapp.utils.RxUtils;

public class MyPersenter extends BasePersenter<NewsContract.View> implements NewsContract.Presenter {


    @Override
    public void getIndex() {
        addSubscribe(HttpManager.getMyApi().getIndexData()
        .compose(RxUtils.<IndexBean> rxScheduler())
        .subscribeWith(new CommonSubscriber<IndexBean>(mView){
            @Override
            public void onNext(IndexBean indexBean) {
                mView.getIndexReturn(indexBean);
            }
        }));
    }
}