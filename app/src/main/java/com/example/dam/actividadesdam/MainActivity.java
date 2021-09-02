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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_titulo= findViewById(R.id.editTxtTitulo);
    EditText editText_precio = findViewById(R.id.editTextPrecio);
    EditText editText_email = findViewById(R.id.editTextEmail);
    EditText editText_descripcion = findViewById(R.id.editTextDescripcion);
    EditText editText_retiro = findViewById(R.id.editTextDireccionRetiro);
    CheckBox checkbox_retiro = findViewById(R.id.checkBoxRetiro);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Llenar el spinner de categorias

        final String[] categorias = {"Indumentaria", "Electrónica", "Entretenimiento", "Jardin", "Vehículos", "Juguetes"};
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,categorias);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        //Visibilidad del seekbar

        Switch switch_descuento = findViewById(R.id.switchDescuento);
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

        checkbox_retiro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged (CompoundButton buttonView , boolean isChecked ){

                if(isChecked){
                    editText_retiro.setVisibility(View.VISIBLE);
                }else{
                    editText_retiro.setVisibility(View.GONE);
                }
            }});

        //Validacion de datos obligatorios


    }

    //Validar elementos al presionar el boton PUBLICAR
    public void Publicar(View view){

        String titulo = editText_titulo.getText().toString();
        String precioAux = editText_precio.getText().toString();
        String direccionRetiro = editText_retiro.getText().toString();
        String email = editText_email.getText().toString();

        if(titulo.isEmpty()){
            Toast.makeText(this,"Debes ingresar un titulo",Toast.LENGTH_LONG).show(); //Mensaje que avisa al usuario.
        }

        if(precioAux.isEmpty()){
            Toast.makeText(this, "Debe ingresar un precio",Toast.LENGTH_LONG).show();
        }else{
            Float precio = Float.parseFloat(precioAux);
            if(precio<=0){
                Toast.makeText(this, "El precio debe ser positivo",Toast.LENGTH_LONG).show();
            }
        }

        //Categoria esta definido automaticamente indumentaria

        if(checkbox_retiro.isChecked() && direccionRetiro.isEmpty()){
            Toast.makeText(this, "Debe ingresar una direccion de retiro",Toast.LENGTH_LONG).show();
        }

        if(!email.isEmpty()){

        }

    }

}