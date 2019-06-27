package com.example.myapp.fragment;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.adapters.Adapter_Home;
import com.example.myapp.base.BaseFragment;
import com.example.myapp.interfaces.IPersenter;
import com.example.myapp.interfaces.home.HomeContract;
import com.example.myapp.model.bean.home.HomeBean;
import com.example.myapp.persenter.presenter.Presenter_Home;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.support.constraint.Constraints.TAG;


public class Fragment_home extends BaseFragment implements HomeContract.View {


    @BindView(R.id.rec)
    RecyclerView rec;
    Unbinder unbinder;
    private ArrayList<HomeBean.DataBean.BannerBean> mBanner;
    private ArrayList<HomeBean.DataBean.CategoryListBean> mCate;
    private Adapter_Home mAdapter;
    private ArrayList<HomeBean.DataBean.BrandListBean> mBrand;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fragment_home;
    }

    @Override
    protected void initView(Bundle bundle) {
        rec.setLayoutManager(new LinearLayoutManager(getContext()));
        mBanner = new ArrayList<>();//banner
        mCate = new ArrayList<>();//居家
        mBrand = new ArrayList<>();
        mAdapter = new Adapter_Home(getContext(), mBanner, mCate,mBrand);
        rec.setAdapter(mAdapter);
    }


    @Override
    protected void initData() {
        ((Presenter_Home) persenter).getHome();
    }

    @Override
    protected IPersenter createPersenter() {
        return new Presenter_Home();
    }

    @Override
    public void getHomeReturn(HomeBean homeBean) {
        if (homeBean!=null){
            mBanner.addAll(homeBean.getData().getBanner());
            mCate.addAll(homeBean.getData().getCategoryList());
            mBrand.addAll(homeBean.getData().getBrandList());
        }
        Log.e(TAG, "getHomeReturn: "+homeBean.getData().getBanner() );
        mAdapter.notifyDataSetChanged();
    }

}
