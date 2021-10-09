package com.example.dam.actividadesdam;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CategoryViewHolder extends RecyclerView.ViewHolder{

    public TextView id;
    public TextView nombreCat;
    public Button botonAgregar;

    public CategoryViewHolder(View v) {
        super(v);
        id = (TextView) v.findViewById(R.id.idcat);
        nombreCat = (TextView) v.findViewById(R.id.nombrecat);
        botonAgregar =  (Button) v.findViewById(R.id.buttonAgregarCat);
    }
}
