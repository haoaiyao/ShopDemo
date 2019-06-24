package com.example.myapp.persenter.zhuanlanpresenter;


import com.example.myapp.base.BasePersenter;
import com.example.myapp.component.CommonSubscriber;
import com.example.myapp.interfaces.zhuanlan.ZhuanLanContract;
import com.example.myapp.model.bean.SpecialBean;
import com.example.myapp.model.http.HttpManager;
import com.example.myapp.utils.RxUtils;

public class ZhuanLanPresenter extends BasePersenter<ZhuanLanContract.View> implements ZhuanLanContract.Presenter {
    @Override
    public void getSpicalPP() {
        addSubscribe(HttpManager.getZhuanLanApi().getZhuanLan()
                .compose(RxUtils.<SpecialBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<SpecialBean>(mView){
                    @Override
                    public void onNext(SpecialBean special) {
                        mView.getspecial(special);
                    }
                }));
    }
}
