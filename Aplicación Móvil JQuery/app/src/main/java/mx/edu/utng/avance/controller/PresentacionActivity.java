package mx.edu.utng.avance.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mx.edu.utng.avance.R;
import mx.edu.utng.avance.model.Correo;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica que extiende de la clase Activity
public class PresentacionActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {//Método onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentacion);//de la actividad que pasara a la suiguiente actividad
        //Da al contenido de la ventana el valor del layout

        View boton = findViewById(R.id.button);//Declaración tipo botón
        boton.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {//Método onclick

        if(v.getId()==findViewById(R.id.button).getId()){
            Intent i=new Intent(this,   MyMenu.class);//Intento redirección a MyMenu
            startActivity(i);//Comenzar Actividad
            finish();//Finalizar Actividad*/

        }//Cierre del método onClick


    }//Cierre del método onCreate
} //Cierre de la clase

