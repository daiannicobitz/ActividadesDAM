package com.example.dam.actividadesdam;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryViewHolder> {


    private List<Category> listaCategorias;
    private CategoryRecyclerActivity actividad;

    public CategoryRecyclerAdapter(List<Category> lista , CategoryRecyclerActivity act ){
        listaCategorias = lista;
        actividad = act;
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int tipo) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cat_fila, viewGroup, false);
        CategoryViewHolder vh = new CategoryViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(CategoryViewHolder categoryViewHolder, int i) {
//        categoryViewHolder.id.setTag(i);
//        categoryViewHolder.nombreCat.setTag(i);
        categoryViewHolder.id.setText(listaCategorias.get(i).getId());
        categoryViewHolder.nombreCat.setText(listaCategorias.get(i).getNombreCategoria());
        categoryViewHolder.setOnClickListener(actividad);
    }



    @Override
    public int getItemCount(){
        return listaCategorias.size();
    }
}
