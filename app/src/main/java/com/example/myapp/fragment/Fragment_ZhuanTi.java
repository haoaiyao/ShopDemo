package com.example.myapp.fragment;


import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.base.BaseFragment;
import com.example.myapp.interfaces.IPersenter;


public class Fragment_ZhuanTi extends BaseFragment {


    public Fragment_ZhuanTi() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fragment__zhuan_ti;
    }

    @Override
    protected void initView(Bundle bundle) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected IPersenter createPersenter() {
        return null;
    }
}
