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
import com.example.myapp.model.bean.JujiaBeam;

import java.util.ArrayList;

public class Adapter_FenLei extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<JujiaBeam.DataBean.CurrentCategoryBean.SubCategoryListBean> arr;
    private Context con;

    public Adapter_FenLei(ArrayList<JujiaBeam.DataBean.CurrentCategoryBean.SubCategoryListBean> arr, Context con) {
        this.arr = arr;
        this.con = con;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(con, R.layout.layout_9gongge, null);
        return new hoder1(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            hoder1 ho = (hoder1) viewHolder;
            JujiaBeam.DataBean.CurrentCategoryBean.SubCategoryListBean listBean = arr.get(i);
            Glide.with(con).load(listBean.getWap_banner_url()).into(ho.image1);
            ho.tv1.setText(listBean.getName());

    }

    @Override
    public int getItemCount() {
        return arr.size()-1;
    }
    class hoder1 extends RecyclerView.ViewHolder{
        ImageView image1;
        TextView tv1;
        public hoder1(@NonNull View itemView) {
            super(itemView);
            image1=itemView.findViewById(R.id.GeZi_image1);
            tv1=itemView.findViewById(R.id.GeZi_tv1);
        }
    }
}
