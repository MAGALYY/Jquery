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
import mx.edu.utng.avance.model.Correo;
import mx.edu.utng.avance.model.RespuestaExamen;


/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

public class Examen5 extends Activity implements View.OnClickListener {
    private Button botonAceptar;
    private Button botonSiguiente;
    private CheckBox chkAjax;
    private CheckBox chkHTML;
    private CheckBox chkSRCRUM;
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
        setContentView(R.layout.examen5);
        Typeface font = Typeface.createFromAsset(getAssets(), "robotobold.ttf");
        cronometro = (Chronometer)findViewById(R.id.chronometer);
        cronometro.setTypeface(font);
        initComponents();
    }

    public void initComponents() {
        botonAceptar = (Button) findViewById(R.id.btnA);
        botonAceptar.setOnClickListener(this);
        botonSiguiente = (Button) findViewById(R.id.btnS);
        botonSiguiente.setOnClickListener(this);
        chkAjax = (CheckBox) findViewById(R.id.checkAjax);
        chkHTML = (CheckBox) findViewById(R.id.checkHTML);
        chkSRCRUM = (CheckBox) findViewById(R.id.checkSCRUM);
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
            case R.id.btnA:
                cronometro.stop();
                botonAceptar.setText("Aceptar");
                estado = "inactivo";

                if (chkAjax.isChecked()) {
                    Toast toast = Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT);
                    toast.show();
                    resultado = true;

                } else if(chkHTML.isChecked()) {
                    Toast toast = Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT);
                    toast.show();
                    resultado = false;
                }else if(chkSRCRUM.isChecked()) {
                    Toast toast = Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT);
                    toast.show();
                    resultado = false;
                }
                respuestaExamen = new RespuestaExamen(1, 1, 5, resultado);
                int registros = dao.verificarId(respuestaExamen, db);
                Log.d("registros"," "+registros);
                if(registros==0){
                    dao.agregar(respuestaExamen, db);
                    int estado = dao.verificarEstado(respuestaExamen, db);
                    int aciertos = dao.obtenerResultados(db, estado);
                    Log.d("Aciertos "," "+aciertos);
                    if(aciertos>=4){
                        Toast toast = Toast.makeText(this, "Examen Aprobado", Toast.LENGTH_SHORT);
                        toast.show();

                        Intent intentografica = new Intent(Examen5.this, GraphAChartEngineActivity.class);
                        startActivity(intentografica);
                        finish();


                    }else {
                        Toast toast = Toast.makeText(this, "Examen No Aprobado", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }else{
                    dao.cambiar(respuestaExamen, db);
                    int estado = dao.verificarEstado(respuestaExamen, db);
                    int aciertos = dao.obtenerResultados(db, estado);
                    Log.d("Aciertos ", " " + aciertos);
                    if(aciertos>=4){
                        Toast toast = Toast.makeText(this, "Examen Aprobado", Toast.LENGTH_SHORT);
                        toast.show();


                    }else {
                        Toast toast = Toast.makeText(this, "Examen No Aprobado", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }

                Log.d("Guardando datos", " " + respuestaExamen.getIdPregunta() + " el estado es: " + respuestaExamen.isEstadoPregunta());
                break;
            case R.id.btnS:
                Intent i = new Intent(Examen5.this, SpinnerExampleActivity.class);
                startActivity(i);
                finish();
                break;
          default:
                break;
        }
    }
}
