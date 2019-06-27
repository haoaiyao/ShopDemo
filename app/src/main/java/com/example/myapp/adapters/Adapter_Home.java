package com.example.myapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapp.R;
import com.example.myapp.model.bean.home.HomeBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class Adapter_Home extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<HomeBean.DataBean.BannerBean> homebanner;
    private ArrayList<HomeBean.DataBean.ChannelBean> homechannel;//居家
    private ArrayList<HomeBean.DataBean.BrandListBean> homeBran;//Ck居灶上
    private ArrayList<HomeBean.DataBean.CategoryListBean>  homeCate;//居家


    public Adapter_Home(Context context, ArrayList<HomeBean.DataBean.BannerBean> homebanner, ArrayList<HomeBean.DataBean.CategoryListBean> homeCate, ArrayList<HomeBean.DataBean.BrandListBean> homeBran) {
        this.context = context;
        this.homebanner = homebanner;
        this.homeCate=homeCate;
        this.homeBran = homeBran;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==0){
            View view = View.inflate(context, R.layout.layout_banner, null);
            ViewHolder1 holder1 = new ViewHolder1(view);
            return holder1;
        }else if (i==1){
            View view = View.inflate(context, R.layout.layout_homeitem, null);
            ViewHolder3 holder3 = new ViewHolder3(view);
            return holder3;
        }
        else {
            View view = View.inflate(context, R.layout.layout_homerec, null);
            ViewHolder2 holder2 = new ViewHolder2(view);
            return holder2;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int type = getItemViewType(i);
        if(type==0){
            ViewHolder1 viewHolder1 = (ViewHolder1) viewHolder;
            viewHolder1.mBanner.setImages(homebanner).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    HomeBean.DataBean.BannerBean path1 = (HomeBean.DataBean.BannerBean) path;
                    Glide.with(context).load(path1.getImage_url()).placeholder(R.mipmap.ic_launcher).into(imageView);
                }
            }).start();
        }else if (type==1){
            ViewHolder3 viewHolder3 = (ViewHolder3) viewHolder;
            //Glide.with(context).load(homechannel.get(i).getIcon_url()).placeholder(R.mipmap.ic_launcher).into(viewHolder3.mImage);
            viewHolder3.mTv1.setText(homeCate.get(0).getName());
            viewHolder3.mTv2.setText(homeCate.get(1).getName());
            viewHolder3.mTv3.setText(homeCate.get(2).getName());
            viewHolder3.mTv4.setText(homeCate.get(3).getName());
            viewHolder3.mTv5.setText(homeCate.get(4).getName());
        }
        else{
            ViewHolder2 viewHolder2 = (ViewHolder2) viewHolder;

            viewHolder2.mRec.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
            Adapter_HomeRec homeRec = new Adapter_HomeRec(context, homeBran);
            viewHolder2.mRec.setAdapter(homeRec);
            homeRec.notifyDataSetChanged();
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else if (position==1){
            return 1;
        }else {
            return 2;
        }
    }

    @Override
    public int getItemCount() {
        if (homebanner.size()>0){
           return homeBran.size()-1;
        }else {
            return homeBran.size();
        }
    }
    class ViewHolder1 extends RecyclerView.ViewHolder{

        private Banner mBanner;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            mBanner = itemView.findViewById(R.id.banner);
        }
    }

    class ViewHolder3 extends RecyclerView.ViewHolder{
        private ImageView mImage;
        private TextView mTv1;
        private TextView mTv2;
        private TextView mTv3;
        private TextView mTv4;
        private TextView mTv5;

        public ViewHolder3(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mTv1 = itemView.findViewById(R.id.tv1);
            mTv2 = itemView.findViewById(R.id.tv2);
            mTv3 = itemView.findViewById(R.id.tv3);
            mTv4 = itemView.findViewById(R.id.tv4);
            mTv5 = itemView.findViewById(R.id.tv5);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder{

        private RecyclerView mRec;


        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            mRec = itemView.findViewById(R.id.rec);

        }
    }

}
