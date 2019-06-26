package com.example.myapp.persenter;

import com.example.myapp.base.BasePersenter;
import com.example.myapp.component.CommonSubscriber;
import com.example.myapp.interfaces.news.JuJiaContract;
import com.example.myapp.model.bean.IndexBean;
import com.example.myapp.model.bean.JujiaBeam;
import com.example.myapp.model.http.HttpManager;
import com.example.myapp.utils.RxUtils;

public class JuJiaPresenter extends BasePersenter<JuJiaContract.juJiaView> implements JuJiaContract.Presenter {
    @Override
    public void getJuJia() {
        addSubscribe(HttpManager.getMyApi().getJuJia()
                .compose(RxUtils.<JujiaBeam> rxScheduler())
                .subscribeWith(new CommonSubscriber<JujiaBeam>(mView){
                    @Override
                    public void onNext(JujiaBeam jujiaBeam) {
                        mView.getIndexReturn(jujiaBeam);
                    }
                }));
    }
}
