package mx.edu.utng.avance.controller;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import mx.edu.utng.avance.R;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica que extiende de la clase Activity
public class SeleccionPreferenciasActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {//Método onCreate
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.opciones_preferencia);//Da al contenido de la ventana el valor del xml

        new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {//Método onPreferenceClick
                //Inicia Actvidad con un nuevo intento de esta clase redirecciona a la clase preferencias
                startActivity(new Intent(SeleccionPreferenciasActivity.this, PreferenciasActivity.class));
                return false;//retorno falso
            }


        };


    }
}