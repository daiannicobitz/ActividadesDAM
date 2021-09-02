package com.example.dam.actividadesdam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] categorias = {"Indumentaria", "Electrónica", "Entretenimiento", "Jardin", "Vehículos", "Juguetes"};
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,categorias);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        //Visibilidad del seekbar
        Switch switch_descuento = findViewById(R.id.switch1);
        LinearLayout layout_seekbar_descuento = findViewById(R.id.layout_descuento);

        switch_descuento.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener () {
        @Override
        public void onCheckedChanged (CompoundButton buttonView , boolean isChecked ){

            if(isChecked){
                layout_seekbar_descuento.setVisibility(View.VISIBLE);
            }else{
                layout_seekbar_descuento.setVisibility(View.GONE);
            }
        }});

        //Visibilidad del editText direccion de retiro
        CheckBox checkbox_retiro = findViewById(R.id.checkBox1);

        EditText editText_retiro = findViewById(R.id.editTextTextPersonName3);

        checkbox_retiro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged (CompoundButton buttonView , boolean isChecked ){

                if(isChecked){
                    editText_retiro.setVisibility(View.VISIBLE);
                }else{
                    editText_retiro.setVisibility(View.GONE);
                }
            }});

    }

}