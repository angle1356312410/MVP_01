package com.example.dell.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.demo.R;
import com.example.dell.demo.model.Bean;
import com.squareup.picasso.Picasso;

/**
 * 张艳： on 2017/9/17.
 */
public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.ViewHolder> {
    Context context;
    Bean bean;

    public MyAdapter1(Context context, Bean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(context).load(bean.getResult().getData().get(position).getThumbnail_pic_s()).into(holder.image);
        holder.name.setText(bean.getResult().getData().get(position).getTitle());
        holder.price.setText(bean.getResult().getData().get(position).getAuthor_name());
    }

    @Override
    public int getItemCount() {
        return bean.getResult().getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView name;
        private final TextView price;

        public ViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }
    }
}
