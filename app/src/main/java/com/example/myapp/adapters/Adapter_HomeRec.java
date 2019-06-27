package com.example.myapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapp.R;
import com.example.myapp.model.bean.home.HomeBean;

import java.util.ArrayList;

public class Adapter_HomeRec extends RecyclerView.Adapter<Adapter_HomeRec.ViewHolder> {
    private Context context;
    private ArrayList<HomeBean.DataBean.BrandListBean> brand;

    public Adapter_HomeRec(Context context, ArrayList<HomeBean.DataBean.BrandListBean> brand) {
        this.context = context;
        this.brand = brand;
    }

    @NonNull
    @Override
    public Adapter_HomeRec.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_home, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_HomeRec.ViewHolder viewHolder, int i) {
        Glide.with(context).load(brand.get(i).getNew_pic_url()).placeholder(R.mipmap.ic_launcher).into(viewHolder.mImg);
        viewHolder.mText1.setText(brand.get(i).getName());
        viewHolder.mText2.setText(brand.get(i).getFloor_price()+"元起");
    }

    @Override
    public int getItemCount() {
        return brand.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImg;
        private TextView mText1;
        private TextView mText2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.img);
            mText1 = itemView.findViewById(R.id.text1);
            mText2 = itemView.findViewById(R.id.text2);
        }
    }
}
