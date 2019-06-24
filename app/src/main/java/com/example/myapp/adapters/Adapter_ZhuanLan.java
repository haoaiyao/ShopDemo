package com.example.myapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.myapp.R;
import com.example.myapp.model.bean.SpecialBean;


import java.util.List;

public class Adapter_ZhuanLan extends RecyclerView.Adapter<Adapter_ZhuanLan.ViewHolder> {
    private List<SpecialBean.DataBeanX.DataBean> data;
    private Context context;

    public Adapter_ZhuanLan(List<SpecialBean.DataBeanX.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.zhuanlan_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SpecialBean.DataBeanX.DataBean dataBean = data.get(position);
        ViewHolder holder1=(ViewHolder) holder;
        holder1.tv1.setText(dataBean.getTitle());
        holder1.tv2.setText(dataBean.getSubtitle());
        holder1.tv3.setText(dataBean.getPrice_info()+"元起");
        Glide.with(context).load(dataBean.getScene_pic_url()).into(holder1.im1);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView im1;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im1 = itemView.findViewById(R.id.im_special);
            tv1 = itemView.findViewById(R.id.tv1_special);
            tv2 = itemView.findViewById(R.id.tv2_special);
            tv3 = itemView.findViewById(R.id.tv3_special);
        }
    }
}
