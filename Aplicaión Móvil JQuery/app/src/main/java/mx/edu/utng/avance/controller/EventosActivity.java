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


//Clase publica que extiende de la clase Activity
public class EventosActivity extends Activity implements View.OnClickListener {

    private Button botonSiguiente;//Declaración privada tipo botón
    private ImageButton imgButton1;//Declaración privada tipo botón imagen
    private ImageButton imgButton2;


    @Override
    public void onCreate(Bundle savedInstanceState) {//Método onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventos);//Da al contenido de la ventana el valor del layout .eventos
        initComponents();//Implementando método initComponents

    }
    private void initComponents() {//Método inicializar componentes

        botonSiguiente = (Button) findViewById(R.id.btn_siguiente);//Declaración tipo botón con id btn_siguiente
        botonSiguiente.setOnClickListener(this);
        imgButton1 = (ImageButton) findViewById(R.id.img_button1);//Declaración tipo botón imagen con id img_button1
        imgButton1.setOnClickListener(this);
        imgButton2 = (ImageButton) findViewById(R.id.img_button2);
        imgButton2.setOnClickListener(this);


    }

    @Override
        public void onClick(View v) {//Método onclick
        switch (v.getId()) {//Sentencia de decisión

            //Para el caso de pulsar el botón con id btn_siguiente
            case R.id.btn_siguiente:
                Intent i = new Intent(EventosActivity.this, SintaxisActivity.class);
                startActivity(i);//Comenzar Actividad
                finish();//Finalizar Actividad
                break;//Corte de la Actividad

            case R.id.img_button1:
                Intent intento = new Intent(EventosActivity.this, SpinnerExampleActivity.class);
                startActivity(intento);

                break;
            case R.id.img_button2:
                Intent in = new Intent(EventosActivity.this, VideoActivity.class);
                startActivity(in);

                break;

            default://Si no es ninguna de las decisiones anteriores entonces toma por default
                break;


        }//Cierre del switch

    }//Cierre del método onClick
} //Cierre de la clase