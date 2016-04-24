package mx.edu.utng.avance.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import mx.edu.utng.avance.model.RespuestaExamen;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica implementada de la clase RespuestaExamenDAO
public class RespuestaExamenDAOImpl implements RespuestaExamenDAO {

    //Declaración de variables
    private SQLiteDatabase db;
    private int numero=0;
    public static final String TABLE_NAME_5 = "tbl_estadoexamen";

    //Método Agregar Respuesta
    @Override
    public void agregar(RespuestaExamen respuestaExamen, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.ID_USUARIO, respuestaExamen.getIdUsuario());
        values.put(DBHelper.ID_EXAMEN,
                respuestaExamen.getIdExamen());
        values.put(DBHelper.ID_PREGUNTA, respuestaExamen.getIdPregunta());
        values.put(DBHelper.ESTADO_PREGUNTA, respuestaExamen.isEstadoPregunta());
        db.insert(DBHelper.TABLE_NAME_4, null, values);

    }

    //Método Obtener Respuesta
    public Integer obtenerResultados(SQLiteDatabase db,Integer estado){
        Log.i("SQLite", "query -> Consulta solo registros estado='TRUE' ");
        Cursor c = db.query("tbl_respuesta",//Posición del cursor
                new String[]{"count(estadoPregunta)"},
                " estadoPregunta=1 and idExamen=1 and idUsuario=1",
                null, null, null,
                null);
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
            if(numero>=4 ){
                if(estado==0){
                    final String INSERT_TABLE_5 ="INSERT INTO "+TABLE_NAME_5+
                            "(idUsuario, idExamen, estadoExamen) VALUES (1,1,1);";
                    db.execSQL(INSERT_TABLE_5);
                }else{
                    final String UPDATE_TABLE_5 ="UPDATE "+TABLE_NAME_5+" SET "+
                            "idUsuario=1, idExamen=1, estadoExamen1;";
                    db.execSQL(UPDATE_TABLE_5);
                }
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");//Mensaje de error
        }
        return numero;//Devuelve valor de numero
    }

    public Integer obtenerResultados2(SQLiteDatabase db,Integer estado){
        Log.i("SQLite", "query -> Consulta solo registros estado='TRUE' ");
        Cursor c = db.query("tbl_respuesta",//Posición del cursor
                new String[]{"count(estadoPregunta)"},
                " estadoPregunta=1 and idExamen=2 and idUsuario=1",
                null, null, null,
                null);
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
            if(numero>=4 ){
                if(estado==0){
                    final String INSERT_TABLE_5 ="INSERT INTO "+TABLE_NAME_5+
                            "(idUsuario, idExamen, estadoExamen) VALUES (1,2,1);";
                    db.execSQL(INSERT_TABLE_5);
                }else{
                    final String UPDATE_TABLE_5 ="UPDATE "+TABLE_NAME_5+" SET "+
                            "idUsuario=1, idExamen=2, estadoExamen1;";
                    db.execSQL(UPDATE_TABLE_5);
                }
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");//Mensaje de error
        }
        return numero;
    }
    //Método Obtener Resultados
    public Integer obtenerResultados3(SQLiteDatabase db,Integer estado){
        Log.i("SQLite", "query -> Consulta solo registros estado='TRUE' ");
        Cursor c = db.query("tbl_respuesta",//Posición del cursor
                new String[]{"count(estadoPregunta)"},
                " estadoPregunta=1 and idExamen=3 and idUsuario=1",
                null, null, null,
                null);
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
            if(numero>=4 ){
                if(estado==0){
                    final String INSERT_TABLE_5 ="INSERT INTO "+TABLE_NAME_5+
                            "(idUsuario, idExamen, estadoExamen) VALUES (1,3,1);";
                    db.execSQL(INSERT_TABLE_5);
                }else{
                    final String UPDATE_TABLE_5 ="UPDATE "+TABLE_NAME_5+" SET "+
                            "idUsuario=1, idExamen=3, estadoExamen1;";
                    db.execSQL(UPDATE_TABLE_5);
                }
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public Integer obtenerResultados4(SQLiteDatabase db,Integer estado){
        Log.i("SQLite", "query -> Consulta solo registros estado='TRUE' ");
        Cursor c = db.query("tbl_respuesta",
                new String[]{"count(estadoPregunta)"},
                " estadoPregunta=1 and idExamen=4 and idUsuario=1",
                null, null, null,
                null);
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
            if(numero>=4 ){
                if(estado==0){
                    final String INSERT_TABLE_5 ="INSERT INTO "+TABLE_NAME_5+
                            "(idUsuario, idExamen, estadoExamen) VALUES (1,4,1);";
                    db.execSQL(INSERT_TABLE_5);
                }else{
                    final String UPDATE_TABLE_5 ="UPDATE "+TABLE_NAME_5+" SET "+
                            "idUsuario=1, idExamen=4, estadoExamen1;";
                    db.execSQL(UPDATE_TABLE_5);
                }
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public Integer obtenerResultados5(SQLiteDatabase db,Integer estado){
        Log.i("SQLite", "query -> Consulta solo registros estado='TRUE' ");
        Cursor c = db.query("tbl_respuesta",
                new String[]{"count(estadoPregunta)"},
                " estadoPregunta=1 and idExamen=5 and idUsuario=1",
                null, null, null,
                null);
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
            if(numero>=4 ){
                if(estado==0){
                    final String INSERT_TABLE_5 ="INSERT INTO "+TABLE_NAME_5+
                            "(idUsuario, idExamen, estadoExamen) VALUES (1,5,1);";
                    db.execSQL(INSERT_TABLE_5);
                }else{
                    final String UPDATE_TABLE_5 ="UPDATE "+TABLE_NAME_5+" SET "+
                            "idUsuario=1, idExamen=5, estadoExamen1;";
                    db.execSQL(UPDATE_TABLE_5);
                }
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public Integer obtenerResultados6(SQLiteDatabase db,Integer estado){
        Log.i("SQLite", "query -> Consulta solo registros estado='TRUE' ");
        Cursor c = db.query("tbl_respuesta",
                new String[]{"count(estadoPregunta)"},
                " estadoPregunta=1 and idExamen=6 and idUsuario=1",
                null, null, null,
                null);
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
            if(numero>=4 ){
                if(estado==0){
                    final String INSERT_TABLE_5 ="INSERT INTO "+TABLE_NAME_5+
                            "(idUsuario, idExamen, estadoExamen) VALUES (1,6,1);";
                    db.execSQL(INSERT_TABLE_5);
                }else{
                    final String UPDATE_TABLE_5 ="UPDATE "+TABLE_NAME_5+" SET "+
                            "idUsuario=1, idExamen=6, estadoExamen1;";
                    db.execSQL(UPDATE_TABLE_5);
                }
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }
    //Método Cambiar
    @Override
    public void cambiar(RespuestaExamen respuestaExamen, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.ESTADO_PREGUNTA, respuestaExamen.isEstadoPregunta());
        db.update(DBHelper.TABLE_NAME_4, values, DBHelper.ID_USUARIO + "=" + respuestaExamen.getIdUsuario() +" and "+DBHelper.ID_EXAMEN + "=" + respuestaExamen.getIdExamen() +" and "+DBHelper.ID_PREGUNTA + "=" + respuestaExamen.getIdPregunta(),
                null);
    }

    //Método Verificar ID

    public int verificarId(RespuestaExamen respuestaExamen, SQLiteDatabase db){
        Cursor c = db.query("tbl_respuesta",
                new String[]{"count(*)"},
                " idPregunta= "+respuestaExamen.getIdPregunta()+" and idExamen="+respuestaExamen.getIdExamen()+
                        " and idUsuario="+respuestaExamen.getIdUsuario(),
                null, null, null,
                null);
        Log.d("Datos: ", " " + "idPregunta= " + respuestaExamen.getIdPregunta() + " and idExamen=" + respuestaExamen.getIdExamen() +
                " and idUsuario=" + respuestaExamen.getIdUsuario());
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    numero = c.getInt(0);
                    Log.d("Obtuve respuesta exis", " " + numero);
                } while (c.moveToNext());
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");//Mensaje de error
        }
        return numero;

    }

    //Método verificar el estado del examen

    public int verificarEstado(RespuestaExamen respuestaExamen, SQLiteDatabase db){
        Cursor c = db.query("tbl_estadoexamen",
                new String[]{"count(*)"},
                " idExamen="+respuestaExamen.getIdExamen()+" and idUsuario="+respuestaExamen.getIdUsuario(),
                null, null, null,
                null);
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    numero = c.getInt(0);
                } while (c.moveToNext());
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;//Devuelve el número

    }


    public Cursor leerDatos() {//Leer Datos
        //Arreglo de cadenas
        String[] todasLasColumnas = new String[] {
                DBHelper.ID_USUARIO,
                DBHelper.ID_EXAMEN,
                DBHelper.ID_PREGUNTA,
                DBHelper.ESTADO_PREGUNTA
        };
        Cursor c = db.query(DBHelper.TABLE_NAME_4, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();//Mover al primero
        }
        return c;//Devuelve valor de c
    }//Cierre del Cursor

}//Cierre de clase