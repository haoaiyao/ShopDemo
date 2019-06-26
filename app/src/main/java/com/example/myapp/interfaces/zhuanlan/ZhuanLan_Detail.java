package com.example.myapp.interfaces.zhuanlan;

import com.example.myapp.interfaces.IBaseView;
import com.example.myapp.interfaces.IPersenter;
import com.example.myapp.model.bean.ZhuanLan_XiangGuan;
import com.example.myapp.model.bean.ZhuanLan_detailBean;

public interface ZhuanLan_Detail {
    interface View extends IBaseView{
        void getDetail(ZhuanLan_detailBean zhuanLan_detailBean);

    }
    interface Presenter extends IPersenter<View>{
        void getDetail(String id);
    }
}
