package com.example.dam.actividadesdam;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CategoryViewHolder extends RecyclerView.ViewHolder{

    public TextView id;
    public TextView nombreCat;

    public CategoryViewHolder(View v) {
        super(v);
        id = (TextView) v.findViewById(R.id.idcat);
        nombreCat = (TextView) v.findViewById(R.id.nombrecat);
    }
}
