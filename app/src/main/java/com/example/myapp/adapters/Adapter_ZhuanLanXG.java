package com.example.myapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapp.R;
import com.example.myapp.model.bean.ZhuanLan_XiangGuan;
import com.example.myapp.ui.ZhuanLan_detail;

import java.util.List;

public class Adapter_ZhuanLanXG extends RecyclerView.Adapter<Adapter_ZhuanLanXG.ViewHodler> {
    private List<ZhuanLan_XiangGuan.DataBean> data;
    private Context context;

    public Adapter_ZhuanLanXG(List<ZhuanLan_XiangGuan.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.zhuanlan_xg_item, null);
        ViewHodler viewHodler = new ViewHodler(view);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, final int i) {
        final ZhuanLan_XiangGuan.DataBean dataBean = data.get(i);
         viewHodler.tv1.setText(data.get(i).getSubtitle());
         viewHodler.tv2.setText(data.get(i).getPrice_info()+"元");
        Glide.with(context).load(data.get(i).getScene_pic_url()).into(viewHodler.im);
        viewHodler.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = dataBean.getId();
                Intent intent = new Intent(context, ZhuanLan_detail.class);
                intent.putExtra("iid",id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private ImageView im;
        private TextView tv1;
        private TextView tv2;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.im1_xg);
            tv1=itemView.findViewById(R.id.tv1_xg);
            tv2=itemView.findViewById(R.id.tv2_xg);
        }
    }
}
