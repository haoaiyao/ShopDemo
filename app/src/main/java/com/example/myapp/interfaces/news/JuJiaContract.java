package com.example.myapp.interfaces.news;

import com.example.myapp.interfaces.IBaseView;
import com.example.myapp.interfaces.IPersenter;
import com.example.myapp.model.bean.IndexBean;
import com.example.myapp.model.bean.JujiaBeam;

public interface JuJiaContract {

    interface juJiaView extends IBaseView {
        void getIndexReturn(JujiaBeam jujiaBeam);
    }

    //居家的Presenter层接口定义
    interface Presenter extends IPersenter<juJiaView> {
        void getJuJia();
    }
}