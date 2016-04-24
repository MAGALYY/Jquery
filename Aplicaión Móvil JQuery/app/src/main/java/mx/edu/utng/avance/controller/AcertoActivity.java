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

public class AcertoActivity extends Activity implements View.OnClickListener{//Clase que extiende de la clase Activity

    private ImageButton botonSiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {//Método onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acerto_layout_1);//Actividad que pasará a la suiguiente actividad
        //Da al contenido de la ventana el valor del layout
        initComponents();//Implementando método initComponents
    }

    public void initComponents() {//Método inicializar componentes

        botonSiguiente = (ImageButton) findViewById(R.id.btnSiguiente);
        botonSiguiente.setOnClickListener(this);

    }//Cierre del método initComponents

    @Override
    public void onClick(View v) {//Método onClick

        //Condición

        if(v.getId()==findViewById(R.id.btnSiguiente).getId()){
            //Intento de la condición
            Intent i=new Intent(this,   MyMenu.class);
            startActivity(i);//Empezar actividad
        }


    }
}




