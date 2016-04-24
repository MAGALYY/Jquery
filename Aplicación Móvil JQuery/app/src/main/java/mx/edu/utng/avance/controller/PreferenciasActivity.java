package mx.edu.utng.avance.controller;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import mx.edu.utng.avance.R;



/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica que extiende de la clase Activity
public class PreferenciasActivity extends Activity implements OnClickListener{

    private Button btnPreferencias;//Declaración privada tipo botón
    private Button btnListar;
    private Button btnContrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {//Método onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferencias_layout);//Da al contenido de la ventana el valor del layout
        initComponents();//Implementando método initComponents
    }

    private void initComponents(){//Método inicializar componentes
        btnListar = (Button)findViewById(R.id.btn_listar);//Inicialización tipo botón con id btn_listar
        btnListar.setOnClickListener(this);
        btnPreferencias = (Button)findViewById(R.id.btn_preferencias);
        btnPreferencias.setOnClickListener(this);
        btnContrasena = (Button)findViewById(R.id.btn_cambiar);
        btnContrasena.setOnClickListener(this);



    }

    public void onClick(View v){//Método onclick

        //Condición
        if (v.getId()==R.id.btn_preferencias){
            startActivity(new Intent(
                    this, Registrarme.class));
        }

        if (v.getId()==R.id.btn_cambiar){
            startActivity(new Intent(
                    this, CambioContrasena.class));
        }
        //Condición para el botón con Id btn_listar
        if (v.getId()==R.id.btn_listar){


            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);


                    String mensaje =
                            preferences.getBoolean("modulo_cinco", false)==true?"SI":"NO";//Mensaje

            mensaje+= "\nIdioma: "
                    + preferences.getString("idioma","")//Obtener la cadena
                    + "\nContrasena: "
                    + preferences.getString("contrasena_db","")
                    + "\nNombre: "
                    + preferences.getString("nombre_usuario","");




            Toast.makeText(this, "Pasar Modulo 5: "+ mensaje,
                    Toast.LENGTH_LONG).show();//Mensaje
        }//Cierre de Condción



    }//Cierre del método onClick
} //Cierre de la clase
