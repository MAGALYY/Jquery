package mx.edu.utng.avance.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import mx.edu.utng.avance.R;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

public class AcercaActivity extends Activity implements View.OnClickListener{//Clase AcercaActivity que extiende de la clase Activity

    private Button btnReferencia;
    private ImageButton imgUbicacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {//Método onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fm_acerca);//Actividad que pasará a la suiguiente actividad
        //Da al contenido de la ventana el valor del layout
        initComponents();

    }

    private void initComponents() {
        btnReferencia =(Button) findViewById(R.id.btnReferencia);//Inicialización tipo botón con id btnAceptar
        btnReferencia.setOnClickListener(this);
        imgUbicacion =(ImageButton) findViewById(R.id.img_ubicacion);//Inicialización tipo botón con id btnAceptar
        imgUbicacion.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {//Método onClick

        switch (v.getId()) {//Sentencia de decisión

            //Para el caso de pulsar el botón con id btnSiguiente
            case R.id.btnReferencia:
                Intent i = new Intent(AcercaActivity.this, ReferenciasActivity.class);
                startActivity(i);//Comenzar Actividad
                finish();//Finalizar Actividad
                break;//Corte de la Actividad

            case R.id.img_ubicacion:
                Intent intento = new Intent(AcercaActivity.this, MyMenu.class);//clase del mapa
                startActivity(intento);//Comenzar Actividad
                finish();//Finalizar Actividad
                break;//Corte de la Actividad
            default:
                break;
        }

    }
}





