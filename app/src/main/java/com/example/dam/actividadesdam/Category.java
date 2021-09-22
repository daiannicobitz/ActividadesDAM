package com.example.dam.actividadesdam;

import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable {


    private String id;
    private String nombreCategoria;

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

}
