package com.example.myapp.interfaces.zhuanlan;

import com.example.myapp.interfaces.IBaseView;
import com.example.myapp.interfaces.IPersenter;
import com.example.myapp.model.bean.ZhuanLan_XiangGuan;

public interface XiangGuan {
    interface View extends IBaseView{
        void getXiangGuan(ZhuanLan_XiangGuan zhuanLan_xiangGuan);

    }
    interface Presenter extends IPersenter<View>{
        void getXiangGuanP(String id);
    }
}
