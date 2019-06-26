package com.example.myapp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapp.R;
import com.example.myapp.base.BaseActivity;
import com.example.myapp.interfaces.IPersenter;
import com.example.myapp.interfaces.zhuanlan.ZhuanLan_Detail;
import com.example.myapp.model.bean.ZhuanLan_detailBean;
import com.example.myapp.persenter.zhuanlanpresenter.XiangGuanPresenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhuanLan_detail extends BaseActivity implements ZhuanLan_Detail.View {

    @BindView(R.id.detail_ban)
    Banner detailBan;
    @BindView(R.id.tv_detail)
    TextView tvDetail;
    @BindView(R.id.tv2_detail)
    TextView tv2Detail;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.rb4)
    RadioButton rb4;
    @BindView(R.id.eg_detail)
    RadioGroup egDetail;
    @BindView(R.id.tv3_detail)
    TextView tv3Detail;
    private int id;

    @Override
    protected int getLayout() {
        return R.layout.activity_zhuan_lan_detail;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        id = intent.getIntExtra("iid",0);
        egDetail.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        Toast.makeText(context, "收藏成功，快去看看吧！", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb2:
                        Toast.makeText(context, "添加到购物车！", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
    }

    @Override
    protected void initData() {
        ((XiangGuanPresenter) persenter).getXiangGuanP(id+"");
    }

    @Override
    protected IPersenter createPersenter() {
        return new XiangGuanPresenter();
    }

    @Override
    public void getDetail(ZhuanLan_detailBean zhuanLan_detailBean) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add(zhuanLan_detailBean.getData().getAvatar());
        strings.add(zhuanLan_detailBean.getData().getItem_pic_url());
        strings.add(zhuanLan_detailBean.getData().getScene_pic_url());
        detailBan.setImages(strings).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();
         tvDetail.setText(zhuanLan_detailBean.getData().getTitle());
         tv2Detail.setText(zhuanLan_detailBean.getData().getSubtitle());
         tv3Detail.setText("￥"+zhuanLan_detailBean.getData().getPrice_info());
    }

}
