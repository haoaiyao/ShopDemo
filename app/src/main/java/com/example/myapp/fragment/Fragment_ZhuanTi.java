package com.example.myapp.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.base.BaseFragment;
import com.example.myapp.interfaces.IPersenter;
import com.example.myapp.model.bean.SpecialBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class Fragment_ZhuanTi extends BaseFragment {


    @BindView(R.id.rv_zhuanlan)
    RecyclerView rvZhuanlan;
    private ArrayList<SpecialBean.DataBeanX.DataBean> dataBeans;


    public Fragment_ZhuanTi() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fragment__zhuan_ti;
    }

    @Override
    protected void initView(Bundle bundle) {
rvZhuanlan.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataBeans = new ArrayList<>();

    }

    @Override
    protected void initData() {

    }

    @Override
    protected IPersenter createPersenter() {
        return null;
    }

}
