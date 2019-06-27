package com.example.myapp.persenter.presenter;

import com.example.myapp.base.BasePersenter;
import com.example.myapp.component.CommonSubscriber;
import com.example.myapp.interfaces.home.HomeContract;
import com.example.myapp.model.bean.IndexBean;
import com.example.myapp.model.bean.home.HomeBean;
import com.example.myapp.model.http.HttpManager;
import com.example.myapp.utils.RxUtils;

public class Presenter_Home extends BasePersenter<HomeContract.View> implements HomeContract.Presenter {

    @Override
    public void getHome() {
        addSubscribe(HttpManager.getMyApi().getHomeBean()
                .compose(RxUtils.<HomeBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<HomeBean>(mView){
                    @Override
                    public void onNext(HomeBean homeBean) {
                        mView.getHomeReturn(homeBean);
                    }
                }));
    }
}
