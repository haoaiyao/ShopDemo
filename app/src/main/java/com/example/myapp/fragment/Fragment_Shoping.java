package com.example.myapp.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.myapp.R;
import com.example.myapp.base.BaseFragment;
import com.example.myapp.interfaces.IPersenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class Fragment_Shoping extends BaseFragment {

    @BindView(R.id.item_txt1)
    TextView itemTxt1;
    @BindView(R.id.item_txt2)
    TextView itemTxt2;
    @BindView(R.id.item_txt3)
    TextView itemTxt3;
    @BindView(R.id.re)
    RecyclerView re;
    @BindView(R.id.rb_btn)
    RadioButton rbBtn;
    @BindView(R.id.rb_btn_1)
    TextView rbBtn1;
    @BindView(R.id.bianji)
    TextView bianji;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fragment__shoping;
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
