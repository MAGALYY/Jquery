package mx.edu.utng.avance.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import mx.edu.utng.avance.R;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica que extiende de la clase Activity
public class ReferenciasActivity extends Activity implements View.OnClickListener{

    private ImageButton imgSiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {//Método onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.referencias_layout);//Da al contenido de la ventana el valor del layout

        initComponents();
    }//Cierre del método

    private void initComponents() {
        imgSiguiente =(ImageButton) findViewById(R.id.btnSiguiente);//Inicialización tipo botón con id btnAceptar
        imgSiguiente.setOnClickListener(this);


    }

    public void onClick(View v) {//Método onClick
        Intent i = new Intent(ReferenciasActivity.this, MyMenu.class);
        startActivity(i);//Comenzar Actividad
        finish();//Finalizar Actividad




    }


}//Cierre de la clase
