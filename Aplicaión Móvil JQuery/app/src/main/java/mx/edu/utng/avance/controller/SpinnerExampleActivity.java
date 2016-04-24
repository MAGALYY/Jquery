package mx.edu.utng.avance.controller;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import mx.edu.utng.avance.R;
import mx.edu.utng.avance.dao.DBHelper;
import mx.edu.utng.avance.dao.RespuestaExamenDAOImpl;
import mx.edu.utng.avance.model.Correo;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */


public class SpinnerExampleActivity extends Activity implements AdapterView.OnItemSelectedListener{

    private Spinner cboMenu;
    private RespuestaExamenDAOImpl dao;
    private int numero=0;
    private String correo="";
    private SQLiteDatabase db;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_example_layout);
        initComponents();
    }

    private void initComponents(){
        cboMenu = (Spinner)findViewById(R.id.cbo_menu);
        ArrayAdapter adapter=
                ArrayAdapter.createFromResource(this, R.array.opciones,
                                                        android.R.layout.simple_spinner_item);
        cboMenu.setAdapter(adapter);
        cboMenu.setOnItemSelectedListener(this);
        dbHelper = new DBHelper(this, DBHelper.DATABASE_NAME, null, DBHelper.DATABASE_VERSION);
        db = dbHelper.getWritableDatabase();
        dao = new RespuestaExamenDAOImpl();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 1:
                startActivity(new Intent(this, DefinicionActivity.class));
                break;
            case 2:
                int estado = obtenerEstadoExamen();
                if(estado !=1){
                    Toast.makeText(SpinnerExampleActivity.this, "Tema Bloqueado", Toast.LENGTH_SHORT).show();
                    initComponents();
                }else {
                    startActivity(new Intent(this, EventosActivity.class));

                }
                break;
            case 3:
                int aciertos2=obtenerEstadoExamen2();
                if(aciertos2!=1){
                    Toast.makeText(SpinnerExampleActivity.this, "Tema Bloqueado", Toast.LENGTH_SHORT).show();
                    initComponents();
                }else {
                    startActivity(new Intent(this, VincularEventosActivity.class));

                }
                break;
            case 4:
                int aciertos3=obtenerEstadoExamen3();
                if(aciertos3!=1) {
                    Toast.makeText(SpinnerExampleActivity.this, "Tema Bloqueado", Toast.LENGTH_SHORT).show();
                    initComponents();
                }else {
                    startActivity(new Intent(this, TablaEventosDomActivity.class));

                }
                break;
            case 5:
                int aciertos4=obtenerEstadoExamen4();
                if(aciertos4!=1) {
                    Toast.makeText(SpinnerExampleActivity.this, "Tema Bloqueado", Toast.LENGTH_SHORT).show();
                    initComponents();
                }else {
                    startActivity(new Intent(this, MetodosUtilitariosActivity.class));

                }
                break;
            case 6:
                int aciertos5=obtenerEstadoExamen5();
                if(aciertos5!=1) {
                    Toast.makeText(SpinnerExampleActivity.this, "Tema Bloqueado", Toast.LENGTH_SHORT).show();
                    initComponents();
                }else {
                    startActivity(new Intent(this, ObtenerInformacionActivity.class));

                }
                break;
            case 7:
                int aciertos6=obtenerEstadoExamen6();
                if(aciertos6!=1) {
                    Toast.makeText(SpinnerExampleActivity.this, "Primero Completa Todos los Temas", Toast.LENGTH_SHORT).show();
                    initComponents();
                }else {
                    //startActivity(new Intent(this, Certificado.class));
                    startActivity(new Intent(this, Certificado.class));
                    String email = obtenerCorreo();
                    Correo correo  =  new Correo(email,"Curso JQuery","Felicidades!!! Has aprovado el curso.");
                    correo.enviarResultado();

                }
                break;
            default:
                break;


        }
    }
    public Integer obtenerEstadoExamen(){
        Log.i("SQLite", "query -> Consulta solo registros estadoExamen' " );
        Cursor c = db.query("tbl_estadoexamen",new String[]{"estadoExamen"},
                " idUsuario=1 and idExamen=1",null, null, null,null);
        try{
            if (c.moveToFirst()) {
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public Integer obtenerEstadoExamen2(){
        Log.i("SQLite", "query -> Consulta solo registros estadoExamen' ");
        Cursor c = db.query("tbl_estadoexamen",new String[]{"estadoExamen"},
                " idUsuario=1 and idExamen=2",null, null, null,null);
        try{
            if (c.moveToFirst()) {
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public Integer obtenerEstadoExamen3(){
        Log.i("SQLite", "query -> Consulta solo registros estadoExamen' ");
        Cursor c = db.query("tbl_estadoexamen", new String[]{"estadoExamen"},
                " idUsuario=1 and idExamen=3", null, null, null, null);
        try{
            if (c.moveToFirst()) {
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public Integer obtenerEstadoExamen4(){
        Log.i("SQLite", "query -> Consulta solo registros estadoExamen' " );
        Cursor c = db.query("tbl_estadoexamen", new String[]{"estadoExamen"},
                " idUsuario=1 and idExamen=4", null, null, null, null);
        try{
            if (c.moveToFirst()) {
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }


    public Integer obtenerEstadoExamen5(){
        Log.i("SQLite", "query -> Consulta solo registros estadoExamen' " );
        Cursor c = db.query("tbl_estadoexamen",new String[]{"estadoExamen"},
                " idUsuario=1 and idExamen=5",null, null, null,null);
        try{
            if (c.moveToFirst()) {
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public Integer obtenerEstadoExamen6(){
        Log.i("SQLite", "query -> Consulta solo registros estadoExamen' " );
        Cursor c = db.query("tbl_estadoexamen",new String[]{"estadoExamen"},
                " idUsuario=1 and idExamen=6",null, null, null,null);
        try{
            if (c.moveToFirst()) {
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public String obtenerCorreo(){
        Log.i("SQLite", "query -> Consulta correo' " );
        Cursor c = db.query("tbl_usuario",new String[]{"correo"},
                " idUsuario=1",null, null, null,null);
        try{
            if (c.moveToFirst()) {
                do {
                    correo= c.getString(0);
                    Log.d("Obtuve correo"," "+correo);
                } while(c.moveToNext());
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return correo;
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}