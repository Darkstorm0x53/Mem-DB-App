package com.example.memdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleAdaptor extends RecyclerView.Adapter<ViewHolder>
{
    ArrayList brand_id, subBrand_id, speed_id, die_id;
    Context context;

    public RecycleAdaptor(Context contextTemp,
                          ArrayList brand_idTemp,
                          ArrayList subBrand_idTemp,
                          ArrayList speed_idTemp,
                          ArrayList die_idTemp)
    {
        this.context = contextTemp;
        this.brand_id = brand_idTemp;
        this.subBrand_id = subBrand_idTemp;
        this.speed_id = speed_idTemp;
        this.die_id = die_idTemp;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.brandItem.setText(String.valueOf(brand_id.get(position)));
        holder.subBrandItem.setText(String.valueOf(subBrand_id.get(position)));
        holder.speedItem.setText(String.valueOf(speed_id.get(position)));
        holder.dieItem.setText(String.valueOf(die_id.get(position)));
    }

    @Override
    public int getItemCount()
    {
        return brand_id.size();
    }
}
