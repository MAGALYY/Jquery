package mx.edu.utng.avance.controller;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import mx.edu.utng.avance.R;


/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica que extiende de la clase Activity
public class VentanaRegistrarActivity extends Activity implements OnClickListener{

    private Button btnPreferencias;//Declaración privada tipo botón


    @Override
    protected void onCreate(Bundle savedInstanceState) {//Método onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ventana_registro_layout);//Da al contenido de la ventana el valor del layout
        initComponents();//Implementando método initComponents
    }

    private void initComponents(){//Método inicializar componentes

        btnPreferencias = (Button)findViewById(R.id.btn_preferencias);
        btnPreferencias.setOnClickListener(this);



    }

    public void onClick(View v){//Método onclick

        //Condición
        if (v.getId()==R.id.btn_preferencias){
            startActivity(new Intent(
                    this, Registrarme.class));
        }


    }//Cierre del método onClick
} //Cierre de la clase
