package com.example.myapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.myapp.R;
import com.example.myapp.adapters.Adapter_ZhuanLanXG;
import com.example.myapp.base.BaseActivity;
import com.example.myapp.interfaces.IPersenter;
import com.example.myapp.interfaces.zhuanlan.XiangGuan;
import com.example.myapp.model.bean.ZhuanLan_XiangGuan;
import com.example.myapp.persenter.zhuanlanpresenter.XiangGuanPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhuanLanActivity extends BaseActivity implements XiangGuan.View {


    @BindView(R.id.rv_lianbiao)
    RecyclerView rvLianbiao;
    @BindView(R.id.text_xg)
    TextView textXg;
    private String id;
    private ArrayList<ZhuanLan_XiangGuan.DataBean> dataBeans;
    private Adapter_ZhuanLanXG adapter_zhuanLanXG;

    @Override
    protected int getLayout() {
        return R.layout.activity_zhuan_lan;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        dataBeans = new ArrayList<>();
        rvLianbiao.setLayoutManager(new GridLayoutManager(context,2));
        adapter_zhuanLanXG = new Adapter_ZhuanLanXG(dataBeans, context);
        rvLianbiao.setAdapter(adapter_zhuanLanXG);
    }

    @Override
    protected void initData() {
        ((XiangGuanPresenter)persenter).getXiangGuanP(id);
    }

    @Override
    protected IPersenter createPersenter() {
        return new XiangGuanPresenter();
    }

    @Override
    public void getXiangGuan(ZhuanLan_XiangGuan zhuanLan_xiangGuan) {
        List<ZhuanLan_XiangGuan.DataBean> data = zhuanLan_xiangGuan.getData();
        for (int i = 0; i <data.size() ; i++) {
            textXg.setText(data.get(i).getTitle());
        }
        dataBeans.addAll(data);
        adapter_zhuanLanXG.notifyDataSetChanged();
    }
}
