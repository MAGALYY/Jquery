package mx.edu.utng.avance.dao;


import android.database.sqlite.SQLiteDatabase;
import mx.edu.utng.avance.model.RespuestaExamen;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Interface publica
public interface RespuestaExamenDAO {
    void agregar(RespuestaExamen respuestaExamen,SQLiteDatabase db);//Agregar la respuesta a la BD
    void cambiar(RespuestaExamen respuestaExamen,SQLiteDatabase db);//Actualizar la respuesta de la BD

}//Cierre de la interface