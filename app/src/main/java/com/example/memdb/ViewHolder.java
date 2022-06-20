package com.example.memdb;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder
{
    TextView brandItem, subBrandItem, dieItem, speedItem;

    public ViewHolder(@NonNull View itemView)
    {
        super(itemView);
        brandItem = (TextView) itemView.findViewById(R.id.brand);
        subBrandItem = (TextView) itemView.findViewById(R.id.subBrand);
        speedItem = (TextView) itemView.findViewById(R.id.speed);
        dieItem = itemView.findViewById(R.id.die);
    }
}
