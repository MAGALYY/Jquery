package mx.edu.utng.avance.controller;

import android.app.Activity;
import android.os.Bundle;

import mx.edu.utng.avance.R;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica que extiende de la clase Activity
public class Registro extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {//Método onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferencias_layout);//Da al contenido de la ventana el valor del layout
    }//Cierre del método
}//Cierre de la clase
