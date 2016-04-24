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

public class Examen3 extends Activity implements View.OnClickListener {
    private Button botonAceptar;
    private Button botonSiguiente;
    private EditText edtInventada;
    private SQLiteDatabase db;
    private RespuestaExamen respuestaExamen;
    private RespuestaExamenDAOImpl dao;
    private DBHelper dbHelper;
    private Bundle respuestaBundle;
    private boolean resultado;
    private String respuesta = "John Resig";
    private Chronometer cronometro;
    String estado="inactivo";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examen3);
        Typeface font = Typeface.createFromAsset(getAssets(), "robotobold.ttf");
        cronometro = (Chronometer)findViewById(R.id.chronometer);
        cronometro.setTypeface(font);
        initComponents();
    }

    public void initComponents() {
        edtInventada = (EditText) findViewById(R.id.editText);
        botonAceptar = (Button) findViewById(R.id.button);
        botonAceptar.setOnClickListener(this);
        botonSiguiente = (Button) findViewById(R.id.button4);
        botonSiguiente.setOnClickListener(this);
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
            case R.id.button:
                cronometro.stop();
                botonAceptar.setText("Aceptar");
                estado = "inactivo";

                if ((edtInventada.getText().toString()).equalsIgnoreCase(respuesta)) {
                    resultado = true;
                    Toast toast = Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intento = new Intent(Examen3.this, Examen4.class);
                    startActivity(intento);
                } else {
                    resultado = false;
                    Toast toast = Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT);
                    toast.show();

                }
                respuestaExamen = new RespuestaExamen(1, 1, 3, resultado);
                int registros = dao.verificarId(respuestaExamen, db);
                Log.d("registros"," "+registros);
                if(registros==0){
                    dao.agregar(respuestaExamen, db);
                }else{
                    dao.cambiar(respuestaExamen, db);
                }
                Log.d("Guardando datos", " " + respuestaExamen.getIdPregunta() + " el estado es: " + respuestaExamen.isEstadoPregunta());

                break;
            case R.id.button4:
                Intent i = new Intent(Examen3.this, Examen4.class);
                startActivity(i);
                break;
        }
    }
}
