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
public class TablaEventosDomActivity extends Activity  implements View.OnClickListener{
    private Button botonSiguiente;//Declaración privada tipo botón
    private ImageButton imgButton1;//Declaración privada tipo botón imagen
    private ImageButton imgButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//Método onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabla);//Da al contenido de la ventana el valor del layout
        initComponents();//Implementando método initComponents

    }
    private void initComponents() {//Método inicializar componentes

        botonSiguiente = (Button) findViewById(R.id.btnSiguiente);//Declaración tipo botón con id btn_siguiente
        botonSiguiente.setOnClickListener(this);
        imgButton1 = (ImageButton) findViewById(R.id.img_button1);//Declaración tipo botón imagen con id img_button1
        imgButton1.setOnClickListener(this);
        imgButton2 = (ImageButton) findViewById(R.id.img_button2);
        imgButton2.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {//Método onclick

        switch (v.getId()){//Sentencia de decisión

            //Para el caso de pulsar el botón con id btn_siguiente
            case R.id.btnSiguiente:
                Intent i=new Intent(this,   MetodosRecorridoActivity.class);
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
                finish();
                break;

            default://Si no es ninguna de las decisiones anteriores entonces toma por default
                break;


        }//Cierre del switch

    }//Cierre del método onClick
} //Cierre de la clase