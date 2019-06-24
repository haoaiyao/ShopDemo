package com.example.myapp.interfaces.zhuanlan;


import com.example.myapp.interfaces.IBaseView;
import com.example.myapp.interfaces.IPersenter;
import com.example.myapp.model.bean.SpecialBean;

public interface ZhuanLanContract {
    interface View extends IBaseView {
        void getspecial(SpecialBean special);
    }
    interface Presenter extends IPersenter<View> {
        void getSpicalPP();
    }
}
