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
import mx.edu.utng.avance.R;
import mx.edu.utng.avance.dao.DBHelper;
import mx.edu.utng.avance.dao.RespuestaExamenDAOImpl;
import mx.edu.utng.avance.model.RespuestaExamen;


/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica que extiende de la clase Activity
public class Examen1 extends Activity implements View.OnClickListener {
    private Button botonAceptar;//Declaración privada tipo botón
    private Button botonSiguiente;
    private CheckBox chkPlat;//Declaración privada tipo checkBox
    private CheckBox chkBiblio;
    private CheckBox chkEst;
    private SQLiteDatabase db;//Declaración privada tipo SQLiteDatabase
    private RespuestaExamen respuestaExamen;//Declaración privada tipo RespuestaExamen de la clase RespuestaExamen
    private RespuestaExamenDAOImpl dao;
    private DBHelper dbHelper;//Declaración privada tipo  DBHelper de la clase  DBHelper
    private Bundle respuestaBundle;
    private boolean resultadoCheck;//Declaración de resultadoCheck como booleano
    private Chronometer cronometro;
    String estado="inactivo";
    @Override
    public void onCreate(Bundle savedInstanceState) {//Método onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fm_examen);//Da al contenido de la ventana el valor del layout
        Typeface font = Typeface.createFromAsset(getAssets(), "robotobold.ttf");
        cronometro = (Chronometer)findViewById(R.id.chronometer);
        cronometro.setTypeface(font);
        initComponents();//Implementando método initComponents
    }
    private void initComponents(){//Método inicializar componentes
        botonAceptar =(Button) findViewById(R.id.btnAceptar);//Inicialización tipo botón con id btnAceptar
        botonAceptar.setOnClickListener(this);
        botonSiguiente =(Button) findViewById(R.id.btnSiguiente);
        botonSiguiente.setOnClickListener(this);
        chkPlat = (CheckBox) findViewById(R.id.checkBox);//Inicialización tipo checkBox con id checkBox
        chkBiblio = (CheckBox) findViewById(R.id.checkBox2);
        chkEst = (CheckBox) findViewById(R.id.checkBox3);
        dbHelper = new DBHelper(this,DBHelper.DATABASE_NAME,null,DBHelper.DATABASE_VERSION);
        db = dbHelper.getWritableDatabase();
        dao = new RespuestaExamenDAOImpl();
        if(estado == "inactivo"){
            cronometro.setBase(SystemClock.elapsedRealtime());
            cronometro.start();
        }
    }//Cierre del método initComponents

        @Override
        public void onClick(View v) {//Método onclick


            switch (v.getId()) {//Sentencia de decisión

                //Para el caso de pulsar el botón con id btnSiguiente
                case R.id.btnSiguiente:
                    Intent i = new Intent(Examen1.this, Examen2.class);
                    startActivity(i);//Comenzar Actividad
                    finish();//Finalizar Actividad
                    break;//Corte de la Actividad

                case R.id.btnAceptar:
                    cronometro.stop();
                    botonAceptar.setText("Aceptar");
                    estado = "inactivo";

                    //Decisión si marca el checkBox con Id chkPlat
                    if (chkPlat.isChecked()) {
                        //Manda mensaje "Incorrecto"
                        Toast toast = Toast.makeText(this, "InCorrecto", Toast.LENGTH_SHORT);
                        toast.show();
                        resultadoCheck = false;
                    }else if (chkBiblio.isChecked()) {
                        //Manda mensaje "Correcto"
                        Toast toast = Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT);
                        toast.show();
                        resultadoCheck= true;//Si es cierto redirecciona al examen2
                        Intent in = new Intent(Examen1.this, Examen2.class);
                        startActivity(in);//Comenzar Actividad
                        finish();//Finalizar Actividad
                    } else if (chkEst.isChecked()) {
                        Toast toast = Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT);
                        toast.show();
                        resultadoCheck = false;
                    }
                    respuestaExamen = new RespuestaExamen(1,1,1,resultadoCheck);
                    int registros = dao.verificarId(respuestaExamen, db);
                    Log.d("registros"," "+registros);
                    if(registros==0){
                        dao.agregar(respuestaExamen, db);
                    }else{
                        dao.cambiar(respuestaExamen, db);
                    }
                    Log.d("Guardando datos", " " + respuestaExamen.getIdPregunta() + " el estado es: " + respuestaExamen.isEstadoPregunta());
                    break;
            }//Cierre de Condición

        }//Cierre del método onClick
} //Cierre de la clase