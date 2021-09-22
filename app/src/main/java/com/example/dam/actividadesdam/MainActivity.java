package com.example.dam.actividadesdam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout_seekbar_descuento;
    ScrollView scrollView;
    EditText editText_titulo;
    EditText editText_precio;
    EditText editText_email;
    EditText editText_descripcion;
    EditText editText_retiro;
    TextView textView_direccionRetiro;
    TextView textView_porcentajeSeekbar;
    TextView textView_seekBarMax;
    TextView textView_categoriaSeleccionada;
    CheckBox checkbox_retiro;
    CheckBox checkbox_terminosYCondiciones;
    Switch switch_descuento;
//    Spinner spinner;
    SeekBar seekBar;
    Button botonCategoria;
    Button botonPublicar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView = findViewById(R.id.scrollPantalla1);
        //Llenar el spinner de categorias
//
//        final String[] categorias = {"Indumentaria", "Electrónica", "Entretenimiento", "Jardin", "Vehículos", "Juguetes"};
//        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,categorias);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

//        spinner = findViewById(R.id.spinner);
//        spinner.setAdapter(adapter);

        //Visibilidad del seekbar

        switch_descuento = findViewById(R.id.switchDescuento);
        layout_seekbar_descuento = findViewById(R.id.layout_descuento);
        textView_porcentajeSeekbar = (TextView)findViewById(R.id.textViewCero);
        textView_seekBarMax = (TextView)findViewById(R.id.textViewCien);

        botonCategoria = findViewById(R.id.botonCategoria);
        botonCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( MainActivity.this , CategoryRecyclerActivity.class);
                i.putExtra("UN_EXTRA", 9999L);
                startActivityForResult(i,999);
            }
        });

        switch_descuento.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener () {
        @Override
        public void onCheckedChanged (CompoundButton buttonView , boolean isChecked ){

            if(isChecked){
                textView_seekBarMax.setVisibility(View.VISIBLE);
                textView_porcentajeSeekbar.setText("0");
                layout_seekbar_descuento.setVisibility(View.VISIBLE);
            }else{
                layout_seekbar_descuento.setVisibility(View.GONE);
            }
        }});

        //Visibilidad del editText direccion de retiro

        editText_retiro = findViewById(R.id.editTextDireccionRetiro);
        checkbox_retiro = findViewById(R.id.checkBoxRetiro);
        textView_direccionRetiro = findViewById(R.id.textViewDireccionRetiro);

        checkbox_retiro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged (CompoundButton buttonView , boolean isChecked ){

                if(isChecked){
                    editText_retiro.setVisibility(View.VISIBLE);
                    textView_direccionRetiro.setVisibility(View.VISIBLE);
                }else{
                    editText_retiro.setVisibility(View.GONE);
                    textView_direccionRetiro.setVisibility(View.GONE);
                }
            }});

        checkbox_terminosYCondiciones = findViewById(R.id.checkBoxTerminosCondiciones);
        botonPublicar = findViewById(R.id.buttonPublicar);

        checkbox_terminosYCondiciones.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged (CompoundButton buttonView , boolean isChecked ){

                if(isChecked){
                    botonPublicar.setVisibility(View.VISIBLE);
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                        }
                    });
                }else{
                    botonPublicar.setVisibility(View.GONE);
                }
            }});


        //Validacion de datos obligatorios
        editText_titulo = findViewById(R.id.editTxtTitulo);
        editText_precio = findViewById(R.id.editTextPrecio);
        editText_email = findViewById(R.id.editTextEmail);
        editText_descripcion = findViewById(R.id.editTextDescripcion);
        seekBar = findViewById(R.id.seekBar);

        //Mostrar el progreso del seekBar
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //hace un llamado a la perilla cuando se arrastra
                    @Override
                    public void onProgressChanged(SeekBar seekBar,
                                                  int progress, boolean fromUser) {
                        textView_seekBarMax.setVisibility(View.GONE);
                        textView_porcentajeSeekbar.setText(String.valueOf(progress)+" %");
                    }
                    //hace un llamado  cuando se toca la perilla
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    //hace un llamado  cuando se detiene la perilla
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });

    }

    //Validar elementos al presionar el boton PUBLICAR

    public void Publicar(View view){

        String titulo = editText_titulo.getText().toString();
        String precioAux = editText_precio.getText().toString();
        String direccionRetiro = editText_retiro.getText().toString();
        String email = editText_email.getText().toString();
        String descripcion = editText_descripcion.getText().toString();
        boolean todoCorrecto = true;
        boolean datosObligatorios=true;
        //Validar datos obligatorios

        if(titulo.isEmpty()){
            todoCorrecto = false;
            datosObligatorios=false;
            Toast.makeText(this,"Debes ingresar un titulo",Toast.LENGTH_LONG).show(); //Mensaje que avisa al usuario.
        }else if(precioAux.isEmpty()){
                    todoCorrecto = false;
                    datosObligatorios=false;
                    Toast.makeText(this, "Debe ingresar un precio",Toast.LENGTH_LONG).show();
        }else if(checkbox_retiro.isChecked()){
                if(direccionRetiro.isEmpty()){
                    todoCorrecto = false;
                    datosObligatorios=false;
                    Toast.makeText(this, "Debe ingresar una direccion de retiro",Toast.LENGTH_LONG).show();
                }
        }

        if(datosObligatorios){
            Float precio = Float.parseFloat(precioAux);
            if(precio<=0){
                todoCorrecto = false;
                Toast.makeText(this, "El precio debe ser positivo",Toast.LENGTH_LONG).show();
            }else  if(!validarLinea(titulo)){
                todoCorrecto=false;
                Toast.makeText(this,"El titulo es invalido (Solo se aceptan simbolos como . y , y no se aceptan saltos en linea)",Toast.LENGTH_LONG).show();

            }else if(!validarTexto(descripcion)){
                todoCorrecto=false;
                Toast.makeText(this,"La descripcion es invalida (Solo se aceptan simbolos como . y ,)",Toast.LENGTH_LONG).show();
            }else if(!validarLinea(direccionRetiro)){
                Toast.makeText(this,"La direccion de retiro es invalida (Solo se aceptan simbolos como . y , y no se aceptan saltos en linea)",Toast.LENGTH_LONG).show();
            }else if((switch_descuento.isChecked()) && (seekBar.getProgress()==0)){ //Validacion seekbar !=0
                todoCorrecto = false;
                Toast.makeText(this, "Por favor seleccione un porcentaje mayor a 0 o quite la opcion de ofrecer descuento de envio",Toast.LENGTH_LONG).show();
            }else if(!email.isEmpty()){           //Se valida que el email no este vacio
                if(email.length()<5){
                    todoCorrecto = false;//Se valida que el email contenga 5 caracteres 0 + (x@xxx)
                    Toast.makeText(this, "El correo debe contener 5 caracteres como minimo",Toast.LENGTH_LONG).show();
                }else{
                    int asciiValue = 64;
                    char convertedChar = (char)asciiValue;
                    if(!email.contains(String.valueOf(convertedChar))){ //Se valida que contenga @
                        todoCorrecto = false;
                        Toast.makeText(this, "El correo debe contener el caracter '@'",Toast.LENGTH_LONG).show();
                    }else if(email.length()-email.indexOf(String.valueOf(convertedChar))-1<3){
                        //Se valida que la cantidad de caracteres luego del @ sea 3 o mas
                        todoCorrecto = false;
                        Toast.makeText(this, "El correo debe contener 3 caracteres luego del '@'",Toast.LENGTH_LONG).show();
                    }
                }
            }



        }

        if(todoCorrecto){
            Toast.makeText(this, "Producto publicado correctamente",Toast.LENGTH_LONG).show();
        }

    }

    public boolean validarLinea(String linea){

        return linea.matches("[a-zA-Z|0-9|.|,\\s]*");
    }

    public boolean validarTexto(String texto){

        return texto.matches("[a-zA-Z|0-9|.|,|,\\s\n]*");
    }

    /*public boolean validarPrecio(Float precio){

        return precio.toString().matches("^[0-9]+([,][0-9]+)?$");
    }*/


}