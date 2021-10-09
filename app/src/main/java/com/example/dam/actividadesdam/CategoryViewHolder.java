package com.example.dam.actividadesdam;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView id;
    public TextView nombreCat;
    public Button botonAgregar;
    public CategoryRecyclerActivity actividad;

    public CategoryViewHolder(View v) {
        super(v);
        id = (TextView) v.findViewById(R.id.idcat);
        nombreCat = (TextView) v.findViewById(R.id.nombrecat);
        botonAgregar =  (Button) v.findViewById(R.id.buttonAgregarCat);
    }

    public void setOnClickListener(CategoryRecyclerActivity act) {
        botonAgregar.setOnClickListener(this);
        actividad = act;
    }

    @Override
    public void onClick(View v) {
        actividad.volverActividad(nombreCat);
    }
}
