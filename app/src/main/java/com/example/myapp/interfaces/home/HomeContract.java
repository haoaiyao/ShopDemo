package com.example.myapp.interfaces.home;

import com.example.myapp.interfaces.IBaseView;
import com.example.myapp.interfaces.IPersenter;
import com.example.myapp.model.bean.IndexBean;
import com.example.myapp.model.bean.home.HomeBean;

public interface HomeContract {
    //主页数据
    interface View extends IBaseView {

        void getHomeReturn(HomeBean homeBean);
    }

    //新闻的Presenter层接口定义
    interface Presenter extends IPersenter<View> {
        void getHome();

    }
}