package mx.edu.utng.avance.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mx.edu.utng.avance.R;


/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica que extiende de la clase Activity
public class DefinicionActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.definicion);//Da al contenido de la ventana el valor del layout

        View boton1 = findViewById(R.id.img_button1); //Declaración tipo botón con id img_button1
        View boton2 = findViewById(R.id.img_button2);
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);

        View boton = findViewById(R.id.btn_examen);
        boton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {//Método onClick

        switch (v.getId()){//Sentencia de decisión

            //Para el caso de pulsar el botón con id btn_examen
            case R.id.btn_examen:
                Intent i=new Intent(this,   Examen1.class);
                startActivity(i);//Comenzar Actividad
                finish();//Finalizar Actividad
                break;//Corte de la Actividad

            case R.id.img_button1:
                Intent intento=new Intent(this,   SpinnerExampleActivity.class);
                startActivity(intento);
                finish();
                break;
            case R.id.img_button2:
                Intent in=new Intent(this,   VideoActivity.class);
                startActivity(in);

                break;

            default://Si no es ninguna de las 3 decisiones entonces toma por default
                break;


        }//Cierre del switch

    }//Cierre del método onClick

}//Cierre de la clase