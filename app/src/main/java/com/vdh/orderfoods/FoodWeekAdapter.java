package com.vdh.orderfoods;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodWeekAdapter extends RecyclerView.Adapter<FoodWeekAdapter.ViewHolder> {
    private List<Foods>mFoods;
    private IItemOoclick clickme;

    public FoodWeekAdapter(IItemOoclick clickme) {
        this.clickme = clickme;
    }

    public FoodWeekAdapter() {
    }

    public void setData(List<Foods>foodsList){
        this.mFoods=foodsList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.food_week,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Foods foods=mFoods.get(position);
       holder.imgAnh.setImageResource(foods.getmAnh());
       holder.tvTen.setText(foods.getmTen());
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
        TextView tvTen;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAnh=itemView.findViewById(R.id.img_anhmonan);
            tvTen=itemView.findViewById(R.id.tv_foodname);
        }
    }
}
