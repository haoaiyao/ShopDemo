package com.example.myapp.persenter.zhuanlanpresenter;

import com.example.myapp.base.BasePersenter;
import com.example.myapp.component.CommonSubscriber;
import com.example.myapp.interfaces.zhuanlan.XiangGuan;
import com.example.myapp.interfaces.zhuanlan.ZhuanLan_Detail;
import com.example.myapp.model.bean.ZhuanLan_XiangGuan;
import com.example.myapp.model.bean.ZhuanLan_detailBean;
import com.example.myapp.model.http.HttpManager;
import com.example.myapp.ui.ZhuanLan_detail;
import com.example.myapp.utils.RxUtils;

public class XiangDetailPresenter extends BasePersenter<ZhuanLan_Detail.View>implements ZhuanLan_Detail.Presenter {
    @Override
    public void getDetail(String id) {
        addSubscribe(HttpManager.getZhuanLanApi().getZhuanlan3(id)
                .compose(RxUtils.<ZhuanLan_detailBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<ZhuanLan_detailBean>(mView){
                    @Override
                    public void onNext(ZhuanLan_detailBean zhuanLan_detailBean) {
                        mView.getDetail(zhuanLan_detailBean);
                    }
                }));
    }

}
