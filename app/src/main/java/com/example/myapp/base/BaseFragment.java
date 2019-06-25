package com.example.myapp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.interfaces.IBaseView;
import com.example.myapp.interfaces.IPersenter;
import com.example.myapp.utils.SystemUtils;

import butterknife.ButterKnife;

public abstract class BaseFragment<V extends IBaseView, P extends IPersenter> extends Fragment implements IBaseView {
    protected P persenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        View inflate = inflater.inflate(getLayoutId(), null);
        ButterKnife.bind(this, inflate);
        initView(bundle);
        persenter = createPersenter();
        if (persenter != null) {
            persenter.attchView(this);
        }
        initData();
        return inflate;
    }

    //获取布局
    protected abstract int getLayoutId();

    //初始化布局
    protected abstract void initView(Bundle bundle);

    //初始化数据
    protected abstract void initData();

    //创建P
    protected abstract P createPersenter();

    @Override
    public void onResume() {
        super.onResume();
        if (persenter != null) {
            persenter.attchView(this);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String err) {
        Log.e("err",err);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (persenter != null) {
            persenter.detachView();
        }
    }
}
