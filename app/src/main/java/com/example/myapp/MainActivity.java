package com.example.myapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.myapp.base.BaseActivity;
import com.example.myapp.fragment.Fragment_FenLei;
import com.example.myapp.fragment.Fragment_My;
import com.example.myapp.fragment.Fragment_Shoping;
import com.example.myapp.fragment.Fragment_ZhuanTi;
import com.example.myapp.fragment.Fragment_home;
import com.example.myapp.persenter.MyPersenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//呼雅琴
public class MainActivity extends BaseActivity {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.context)
    FrameLayout context;
    private ArrayList<Fragment> fragments;
    private FragmentManager manager;
    private Toolbar toolbar;
    private ArrayList<String> titles;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initView() {
        titles = new ArrayList<>();
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fragments = new ArrayList<>();
        fragments.add(new Fragment_home());
        fragments.add(new Fragment_ZhuanTi());
        fragments.add(new Fragment_FenLei());
        fragments.add(new Fragment_Shoping());
        fragments.add(new Fragment_My());

        tab.addTab(tab.newTab().setText("首页").setIcon(R.drawable.home_select));
        tab.addTab(tab.newTab().setText("专题").setIcon(R.drawable.zhuanti_select));
        tab.addTab(tab.newTab().setText("分类").setIcon(R.drawable.fenlei_select));
        tab.addTab(tab.newTab().setText("购物车").setIcon(R.drawable.shopping_select));
        tab.addTab(tab.newTab().setText("我的").setIcon(R.drawable.my_select));

        titles.add("首页");
        titles.add("专题");
        titles.add("分类");
        titles.add("购物车");
        titles.add("我的");

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                init(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (!fragments.get(0).isAdded()) {
            transaction.add(R.id.context, fragments.get(0));
        }
        transaction.show(fragments.get(0));
        transaction.commit();
        toolbar.setTitle("首页");
        tab.getTabAt(0).select();
    }

    int lastPosition = 0;

    private void init(int position) {
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = fragments.get(position);

        if (!fragment.isAdded()) {
            transaction.add(R.id.context, fragment);
        }

        Fragment lastFragment = fragments.get(lastPosition);
        transaction.hide(lastFragment);

        transaction.show(fragment);
        toolbar.setTitle(titles.get(position));
        transaction.commit();

        lastPosition = position;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected MyPersenter createPersenter() {
        return null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String err) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
