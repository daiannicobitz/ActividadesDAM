package com.example.dam.actividadesdam;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CategoryViewHolder extends RecyclerView.ViewHolder{

    TextView id;
    TextView nombreCat;



    public CategoryViewHolder(View v) {
        super(v);
        //id = v.findViewById(R.id.idcat);
        //nombreCat = v.findViewById(nombrecat);
    }
}
