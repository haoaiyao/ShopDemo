package com.example.myapp.fragment;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapp.R;
import com.example.myapp.adapters.Adapter_FenLei;
import com.example.myapp.base.BaseFragment;
import com.example.myapp.interfaces.IPersenter;
import com.example.myapp.interfaces.news.JuJiaContract;
import com.example.myapp.model.bean.JujiaBeam;
import com.example.myapp.persenter.JuJiaPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class Fragment_FenLei extends BaseFragment implements JuJiaContract.juJiaView {

    @BindView(R.id.SOusuo_image)
    ImageView SOusuoImage;
    @BindView(R.id.SOusuo_ed1)
    EditText SOusuoEd1;
    @BindView(R.id.RLsousuo)
    RelativeLayout RLsousuo;
    @BindView(R.id.SOusuo_quxiao)
    TextView SOusuoQuxiao;
    @BindView(R.id.SOusuo_Tab)
    VerticalTabLayout SOusuoTab;
    @BindView(R.id.SOusuo_image2)
    ImageView SOusuoImage2;
    @BindView(R.id.SOusuo_tv1)
    TextView SOusuoTv1;
    @BindView(R.id.RLsousuo2)
    RelativeLayout RLsousuo2;
    @BindView(R.id.SOusuo_tv2)
    TextView SOusuoTv2;
    @BindView(R.id.MyRcy)
    RecyclerView MyRcy;

    private ArrayList<JujiaBeam.DataBean.CurrentCategoryBean.SubCategoryListBean> arrayList;
    private Adapter_FenLei adapter_fenLei;

    //杨彬
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fragment__fen_lei;
    }

    @Override
    protected void initView(Bundle bundle) {
        arrayList=new ArrayList<>();
        MyRcy.setLayoutManager(new GridLayoutManager(getActivity(),3));
        adapter_fenLei = new Adapter_FenLei(arrayList, getActivity());
        MyRcy.setAdapter(adapter_fenLei);
    }

    @Override
    protected void initData() {
        SOusuoEd1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Animation animation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_sousuo2);
                    Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_sousuo1);
                    SOusuoImage.startAnimation(animation2);
                    SOusuoEd1.startAnimation(animation);
                    animation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                             SOusuoQuxiao.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                } else {
                    //失去焦点
                    SOusuoQuxiao.setVisibility(View.GONE);
                }
            }
        });

        ((JuJiaPresenter)persenter).getJuJia();
    }


    @Override
    protected IPersenter createPersenter() {
        return new JuJiaPresenter();
    }


    @OnClick({R.id.SOusuo_image, R.id.SOusuo_ed1, R.id.SOusuo_quxiao, R.id.RLsousuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.SOusuo_image:
                break;
            case R.id.SOusuo_ed1:
                break;
            case R.id.SOusuo_quxiao:
                SOusuoQuxiao.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "跳转到搜索结果", Toast.LENGTH_SHORT).show();
               /* SOusuoEd1.clearFocus();
                SOusuoEd1.setFocusable(false);*/
                break;
            case R.id.RLsousuo:
                break;
        }
    }

    @Override
    public void getIndexReturn(JujiaBeam jujiaBeam) {
       if(jujiaBeam.getErrno()==0){
           JujiaBeam.DataBean.CurrentCategoryBean currentCategory = jujiaBeam.getData().getCurrentCategory();
          // setTab(currentCategory.getName());
           List<JujiaBeam.DataBean.CategoryListBean> categoryList = jujiaBeam.getData().getCategoryList();
           Glide.with(getActivity()).load(currentCategory.getBanner_url()).into(SOusuoImage2);
           SOusuoTv1.setText(currentCategory.getFront_name());
           List<JujiaBeam.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = currentCategory.getSubCategoryList();
           for (JujiaBeam.DataBean.CategoryListBean beam:
                   categoryList) {
               String front_name = beam.getName();
               setTab(front_name);
           }

           //加载九宫格数据
           List<JujiaBeam.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList1 = currentCategory.getSubCategoryList();
           arrayList.addAll(subCategoryList);
           //刷新适配器
            adapter_fenLei.notifyDataSetChanged();
       }else {
           Toast.makeText(getActivity(), jujiaBeam.getErrmsg(), Toast.LENGTH_SHORT).show();
       }
    }

    private void setTab(String aa) {
        SOusuoTab.addTab(new QTabView(getActivity()).setTitle(new QTabView.TabTitle.Builder().setContent(aa).build()));
    }
}
