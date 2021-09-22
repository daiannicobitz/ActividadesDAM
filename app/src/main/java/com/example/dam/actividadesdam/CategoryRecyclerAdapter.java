package com.example.dam.actividadesdam;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryViewHolder> {


    private List<Category> listaCategorias;

    public CategoryRecyclerAdapter(List<Category> lista){
        listaCategorias = lista;
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int tipo) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cat_fila, viewGroup, false);
        //....
        CategoryViewHolder vh = new CategoryViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(CategoryViewHolder categoryViewHolder, int i) {
//        categoryViewHolder.id.setTag(i);
//        categoryViewHolder.nombreCat.setTag(i);
        categoryViewHolder.id.setText(listaCategorias.get(i).getId());
        categoryViewHolder.nombreCat.setText(listaCategorias.get(i).getNombreCategoria());
    }

    @Override
    public int getItemCount(){
        return listaCategorias.size();
    }
}
