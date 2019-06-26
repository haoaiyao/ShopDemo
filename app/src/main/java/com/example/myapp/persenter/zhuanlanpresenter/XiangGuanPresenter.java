package com.example.myapp.persenter.zhuanlanpresenter;

import com.example.myapp.base.BasePersenter;
import com.example.myapp.component.CommonSubscriber;
import com.example.myapp.interfaces.zhuanlan.XiangGuan;
import com.example.myapp.model.bean.SpecialBean;
import com.example.myapp.model.bean.ZhuanLan_XiangGuan;
import com.example.myapp.model.http.HttpManager;
import com.example.myapp.utils.RxUtils;

public class XiangGuanPresenter extends BasePersenter<XiangGuan.View>implements XiangGuan.Presenter {
    @Override
    public void getXiangGuanP(String id) {
        addSubscribe(HttpManager.getZhuanLanApi().getZhuanlan2(id)
                .compose(RxUtils.<ZhuanLan_XiangGuan> rxScheduler())
                .subscribeWith(new CommonSubscriber<ZhuanLan_XiangGuan>(mView){
                    @Override
                    public void onNext(ZhuanLan_XiangGuan zhuanLan_xiangGuan) {
                        mView.getXiangGuan(zhuanLan_xiangGuan);
                    }
                }));
    }
}
