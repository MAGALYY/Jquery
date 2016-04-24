package mx.edu.utng.avance.controller;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.utng.avance.R;
import mx.edu.utng.avance.dao.DBHelper;
import mx.edu.utng.avance.dao.RespuestaExamenDAOImpl;
import mx.edu.utng.avance.model.RespuestaExamen;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

public class Examen4 extends Activity implements View.OnClickListener {
    private Button botonAceptar;
    private Button botonSiguiente;
    private CheckBox chkJS;
    private CheckBox chkHTML;
    private CheckBox chkXML;
    private SQLiteDatabase db;
    private RespuestaExamen respuestaExamen;
    private RespuestaExamenDAOImpl dao;
    private DBHelper dbHelper;
    private Bundle respuestaBundle;
    private boolean resultado;
    private Chronometer cronometro;
    String estado="inactivo";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examen4);
        Typeface font = Typeface.createFromAsset(getAssets(), "robotobold.ttf");
        cronometro = (Chronometer)findViewById(R.id.chronometer);
        cronometro.setTypeface(font);
        initComponents();
    }

    public void initComponents() {
        botonAceptar = (Button) findViewById(R.id.buttonAceptar);
        botonAceptar.setOnClickListener(this);
        botonSiguiente = (Button) findViewById(R.id.buttonSiguiente);
        botonSiguiente.setOnClickListener(this);
        chkJS = (CheckBox) findViewById(R.id.chkJS);
        chkHTML = (CheckBox) findViewById(R.id.chkHTML);
        chkXML = (CheckBox) findViewById(R.id.chkXML);
        dbHelper = new DBHelper(this, DBHelper.DATABASE_NAME, null, DBHelper.DATABASE_VERSION);
        db = dbHelper.getWritableDatabase();
        dao = new RespuestaExamenDAOImpl();
        if(estado == "inactivo"){
            cronometro.setBase(SystemClock.elapsedRealtime());
            cronometro.start();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAceptar:
                cronometro.stop();
                botonAceptar.setText("Aceptar");
                estado = "inactivo";


                if (chkJS.isChecked()) {
                    Toast toast = Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT);
                    toast.show();
                    resultado = false;
                } else if(chkHTML.isChecked()) {
                Toast toast = Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT);
                toast.show();
                    resultado = true;
                    Intent intento = new Intent(Examen4.this, Examen5.class);
                    startActivity(intento);
                    finish();
                }else if(chkXML.isChecked()) {
                    Toast toast = Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT);
                    toast.show();
                    resultado = false;
                }
                respuestaExamen = new RespuestaExamen(1, 1, 4, resultado);
                int registros = dao.verificarId(respuestaExamen, db);
                Log.d("registros"," "+registros);
                if(registros==0){
                    dao.agregar(respuestaExamen, db);
                }else{
                    dao.cambiar(respuestaExamen, db);
                }

                Log.d("Guardando datos", " " + respuestaExamen.getIdPregunta() + " el estado es: " + respuestaExamen.isEstadoPregunta());

                break;
            case R.id.buttonSiguiente:
                Intent i = new Intent(Examen4.this, Examen5.class);
                startActivity(i);
                finish();
                break;
        }
    }
}
