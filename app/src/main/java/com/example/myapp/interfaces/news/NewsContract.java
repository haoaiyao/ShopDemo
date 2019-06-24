package com.example.myapp.interfaces.news;

import com.example.myapp.interfaces.IBaseView;
import com.example.myapp.interfaces.IPersenter;
import com.example.myapp.model.bean.IndexBean;

import java.util.List;

public interface NewsContract {
    //主页数据
    interface View extends IBaseView {

        void getIndexReturn(IndexBean indexBean);
    }

    //新闻的Presenter层接口定义
    interface Presenter extends IPersenter<View> {
        void getIndex();

    }
}