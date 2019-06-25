package com.example.myapp.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.adapters.Adapter_ZhuanLan;
import com.example.myapp.base.BaseFragment;
import com.example.myapp.interfaces.IPersenter;
import com.example.myapp.interfaces.zhuanlan.ZhuanLanContract;
import com.example.myapp.model.bean.SpecialBean;
import com.example.myapp.persenter.zhuanlanpresenter.ZhuanLanPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class Fragment_ZhuanTi extends BaseFragment implements ZhuanLanContract.View {


    @BindView(R.id.rv_zhuanlan)
    RecyclerView rvZhuanlan;
    private ArrayList<SpecialBean.DataBeanX.DataBean> dataBeans;
    private Adapter_ZhuanLan adapter_zhuanLan;


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
        adapter_zhuanLan = new Adapter_ZhuanLan(dataBeans, getActivity());
        rvZhuanlan.setAdapter(adapter_zhuanLan);
    }

    @Override
    protected void initData() {
        ((ZhuanLanPresenter)persenter).getSpicalPP();
    }

    @Override
    protected ZhuanLanPresenter createPersenter() {
        return new ZhuanLanPresenter();
    }

    @Override
    public void getspecial(SpecialBean special) {
        Log.e("sp:",special.getErrmsg());
        List<SpecialBean.DataBeanX.DataBean> data = special.getData().getData();
        dataBeans.addAll(data);
        adapter_zhuanLan.notifyDataSetChanged();
    }
}
