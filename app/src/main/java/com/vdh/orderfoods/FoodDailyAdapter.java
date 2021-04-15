package com.vdh.orderfoods;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.net.InterfaceAddress;
import java.util.List;

public class FoodDailyAdapter extends RecyclerView.Adapter<FoodDailyAdapter.ViewHolder> {
    private List<Foods>mFoods;

    public void setData(List<Foods>foodsList){
        this.mFoods=foodsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_food,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Foods foods=mFoods.get(position);
       holder.imgAnh.setImageResource(foods.getmAnh());
       holder.tvTen.setText(foods.getmTen());
       holder.tvDanhGia.setText(foods.getmDanhGia());
       holder.tvMoTa.setText(foods.getmMoTa());
       holder.tvGia.setText(foods.getmGia());
    }

    @Override
    public int getItemCount() {
        if(mFoods.size()==0){
            return 0;
        }
        return  mFoods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAnh;
        TextView tvTen,tvDanhGia,tvMoTa,tvGia;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAnh=itemView.findViewById(R.id.img_anhnen);
            tvTen=itemView.findViewById(R.id.tv_ten);
            tvDanhGia=itemView.findViewById(R.id.tv_rate);
            tvMoTa=itemView.findViewById(R.id.tv_description);
            tvGia=itemView.findViewById(R.id.tv_price);
        }
    }

}
