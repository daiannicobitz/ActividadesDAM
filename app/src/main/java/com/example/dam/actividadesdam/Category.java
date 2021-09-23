package com.example.dam.actividadesdam;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Category implements Parcelable {


    private String id;
    private String nombreCategoria;

    public Category(String id, String nom){
        this.id = id;
        this.nombreCategoria = nom;
    }
    public Category(){}

    private Category(Parcel in) {
        this.readFromParcel(in);
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nombreCategoria);
    }

    public void readFromParcel(Parcel ini) {
        id = ini.readString();
        nombreCategoria = ini.readString();
    }

    public static List<Category> lista(){
        Category categoria1 = new Category("MLA5725", "Accesorios para Vehículos");
        Category categoria2 = new Category("MLA1512", "Agro");
        Category categoria3 = new Category("MLA1403", "Alimentos y Bebidas");
        Category categoria4 = new Category("MLA1071", "Animales y Mascotas");
        Category categoria5 = new Category("MLA1367", "Antigüedades y Colecciones");
        Category categoria6 = new Category("MLA1368", "Arte, Librería y Mercería");
        Category categoria7 = new Category("MLA1743", "Autos, Motos y Otros");
        Category categoria8 = new Category("MLA1384", "Bebés");
        Category categoria9 = new Category("MLA1246", "Belleza y Cuidado Personal");
        Category categoria10 = new Category("MLA1039", "Cámaras y Accesorios");

        List<Category> listaCat = new ArrayList<Category>();
        listaCat.add(categoria1);
        listaCat.add(categoria2);
        listaCat.add(categoria3);
        listaCat.add(categoria4);
        listaCat.add(categoria5);
        listaCat.add(categoria6);
        listaCat.add(categoria7);
        listaCat.add(categoria8);
        listaCat.add(categoria9);
        listaCat.add(categoria10);
        return listaCat;
    }

    public String getId() {
        return id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
