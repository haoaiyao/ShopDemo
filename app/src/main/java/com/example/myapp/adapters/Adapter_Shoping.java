package com.example.myapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.myapp.R;
import com.example.myapp.interfaces.news.NewsContract;

import java.util.ArrayList;

public class Adapter_Shoping extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<String> list;

    public Adapter_Shoping(ArrayList<String> list) {
        this.list = list;
    }

    public Adapter_Shoping(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.adapter_shopingitem, null);
        viewHolders viewHolders = new viewHolders(inflate);
        return viewHolders;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        viewHolders viewHolder1= (viewHolders) viewHolder;
        viewHolder1.item_tv1.setText(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class viewHolders extends RecyclerView.ViewHolder {
        private TextView item_tv1;
        private TextView item_tv2;
        private TextView item_tv3;
        private ImageView  item_img;
        private CheckBox item_rbton;
        public viewHolders(@NonNull View itemView) {
            super(itemView);
            item_tv1=itemView.findViewById(R.id.item_tv1);
            item_tv2=itemView.findViewById(R.id.item_tv2);
            item_tv3=itemView.findViewById(R.id.item_tv3);
            item_img=itemView.findViewById(R.id.item_img);
            item_rbton=itemView.findViewById(R.id.item_rbton);

        }

    }
}
