package com.example.dam.actividadesdam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class CategoryRecyclerActivity extends AppCompatActivity {

    Category categoria;

//    private RecyclerView recyclerView;
      private CategoryRecyclerAdapter mAdapter;
//    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categoria = new Category();
        setContentView(R.layout.activity_cat_recycler);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listaRecycler);
       // recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new CategoryRecyclerAdapter(Category.lista());
        recyclerView.setAdapter(mAdapter);
    }




}
