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
import android.widget.Toast;

import java.lang.Override;import mx.edu.utng.avance.R;
import mx.edu.utng.avance.dao.DBHelper;
import mx.edu.utng.avance.dao.RespuestaExamenDAOImpl;
import mx.edu.utng.avance.model.RespuestaExamen;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

public class Examen10 extends Activity implements View.OnClickListener {
    private Button botonAceptar;
    private Button botonSiguiente;
    private CheckBox chkFunctions;
    private CheckBox chkFunction;
    private CheckBox chkFunciones;
    private SQLiteDatabase db;
    private RespuestaExamen respuestaExamen;
    private RespuestaExamenDAOImpl dao;
    private DBHelper dbHelper;
    private Bundle respuestaBundle;
    private boolean resultadoCheck;
    private Chronometer cronometro;
    String estado="inactivo";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examen10);
        Typeface font = Typeface.createFromAsset(getAssets(), "robotobold.ttf");
        cronometro = (Chronometer)findViewById(R.id.chronometer);
        cronometro.setTypeface(font);
        initComponents();
    }
    private void initComponents(){

        botonAceptar =(Button) findViewById(R.id.btnAceptar);
        botonAceptar.setOnClickListener(this);
        botonSiguiente =(Button) findViewById(R.id.btnSiguiente);
        botonSiguiente.setOnClickListener(this);
        chkFunctions = (CheckBox) findViewById(R.id.checkFunctions);
        chkFunction = (CheckBox) findViewById(R.id.checkFunction);
        chkFunciones = (CheckBox) findViewById(R.id.checkFunciones);
        dbHelper = new DBHelper(this,DBHelper.DATABASE_NAME,null,DBHelper.DATABASE_VERSION);
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
                case R.id.btnSiguiente:
                    Intent i = new Intent(Examen10.this, SpinnerExampleActivity.class);
                    startActivity(i);
                    finish();
                    break;
                case R.id.btnAceptar:
                    cronometro.stop();
                    botonAceptar.setText("Aceptar");
                    estado = "inactivo";
                    //boolean isChecked = ((CheckBox)view).isChecked();
                    if (chkFunctions.isChecked()) {
                        Toast toast = Toast.makeText(this, "InCorrecto", Toast.LENGTH_SHORT);
                        toast.show();
                        resultadoCheck = false;
                    }else if (chkFunction.isChecked()) {
                        //chkBiblio.setText("Checkbox marcado!");
                        Toast toast = Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT);
                        toast.show();
                        resultadoCheck= true;

                    } else if (chkFunciones.isChecked()) {
                        Toast toast = Toast.makeText(this, "InCorrecto", Toast.LENGTH_SHORT);
                        toast.show();
                        resultadoCheck = false;
                    }
                    respuestaExamen = new RespuestaExamen(1,2,10,resultadoCheck);
                    int registros = dao.verificarId(respuestaExamen, db);
                    Log.d("registros"," "+registros);
                    if(registros==0){
                        dao.agregar(respuestaExamen, db);
                        int estado = dao.verificarEstado(respuestaExamen, db);
                        int aciertos = dao.obtenerResultados2(db, estado);
                        Log.d("Aciertos ", " " + aciertos);
                        if(aciertos>=4){
                            Toast toast = Toast.makeText(this, "Examen Aprobado", Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intentografica = new Intent(this, GraphAChartEngineActivity1.class);
                            startActivity(intentografica);
                            finish();

                        }else {
                            Toast toast = Toast.makeText(this, "Examen No Aprobado", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }else{
                        dao.cambiar(respuestaExamen, db);
                        int estado = dao.verificarEstado(respuestaExamen, db);
                        int aciertos = dao.obtenerResultados2(db, estado);
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
               default:
                    break;
            }
        }
}