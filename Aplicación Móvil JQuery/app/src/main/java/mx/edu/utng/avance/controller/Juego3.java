package mx.edu.utng.avance.controller;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import mx.edu.utng.avance.R;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica que extiende de la clase Activity
public class Juego3 extends Activity implements View.OnClickListener {
    private Button botonAceptar;//Declaración privada tipo botón
    private ImageButton botonSiguiente;
    private ImageButton botonRegresar;
    private EditText edtInventada;
    private boolean resultado;
    private String respuesta = "JS";


    @Override
    public void onCreate(Bundle savedInstanceState) {//Método onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego_layout_3);//Da al contenido de la ventana el valor del layout
        initComponents();//Implementando método initComponents
    }

    public void initComponents() {//Método inicializar componentes
        edtInventada = (EditText) findViewById(R.id.edtRespuesta);//Inicialización tipo editText
        botonAceptar = (Button) findViewById(R.id.btnAceptar);//Inicialización tipo botón con id btnAceptar
        botonAceptar.setOnClickListener(this);
        botonSiguiente = (ImageButton) findViewById(R.id.btnSiguiente);
        botonSiguiente.setOnClickListener(this);
        botonRegresar = (ImageButton) findViewById(R.id.btnRegresar);
        botonRegresar.setOnClickListener(this);

    }//Cierre del método initComponents

    @Override
    public void onClick(View v) {//Método onclick
        switch (v.getId()) {//Sentencia de decisión
            //Para el caso de pulsar el botón con id
            case R.id.btnAceptar:
                    // Desición respuesta verdadera
                if ((edtInventada.getText().toString()).equalsIgnoreCase(respuesta)) {
                    resultado = true;
                    Toast toast = Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intento = new Intent(Juego3.this, Juego4.class);
                    startActivity(intento);
                    // Desición respuesta falsa
                } else {
                    resultado = false;
                    Toast toast = Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT);
                    toast.show();
                }

                break;

            case R.id.btnSiguiente:
                Intent i = new Intent(Juego3.this, Juego4.class);
                startActivity(i);
                finish();
                break;
            case R.id.btnRegresar:
                Intent in = new Intent(Juego3.this, Juego2.class);
                startActivity(in);
                finish();
                break;

            default:
                break;
        }//Cierre de la Sentencia de desición
    }//Cierre de método onClick
}//Cierre de Clase

