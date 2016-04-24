package mx.edu.utng.avance.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mx.edu.utng.avance.R;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */
public class Certificado extends Activity implements View.OnClickListener {
    private Button botonVolver;//Declaración privada tipo botón


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.certificado);//Da al
        initComponents();//Implementando método initComponents
    }

    private void initComponents() {//Método inicializar componentes
        botonVolver = (Button) findViewById(R.id.btnVolver);//Inicialización tipo botón con id btnAceptar
        botonVolver.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {//Método onclick
        Intent i = new Intent(this, MyMenu.class);
        startActivity(i);//Comenzar Actividad
        finish();//Finalizar Actividad

    }

}
