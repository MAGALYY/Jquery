package mx.edu.utng.avance.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import mx.edu.utng.avance.model.RespuestaExamen;
import mx.edu.utng.avance.model.Usuario;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica
public class UsuarioDAOImpl {
    //Declaración de variables
    private SQLiteDatabase db;
    private String user;
    public static final String TABLE_NAME_5 = "tbl_estadoexamen";

    //Método Agregar a BD
    public void agregar(Usuario usuario, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        //values.put(DBHelperUsuario.ID_USUARIO, usuario.getIdUsuario());
        values.put(DBHelperUsuario.NOMBRE, usuario.getNombre());
        values.put(DBHelperUsuario.APELLIDOP, usuario.getApellidop());
        values.put(DBHelperUsuario.APELLIDOM, usuario.getApellidom());
        values.put(DBHelperUsuario.USUARIO, usuario.getUsuario());
        values.put(DBHelperUsuario.PASSWORD, usuario.getPassword());
        values.put(DBHelperUsuario.CORREO, usuario.getCorreo());
        db.insert(DBHelper.TABLE_NAME_1, null, values);//Insertar en la primer tabla los valores
    }//Cierre de método

    public String verificarUsuario(SQLiteDatabase db){
        Cursor c = db.query("tbl_usuario",
                new String[]{"usuario"},
                "idUsuario=1",
                null, null, null,
                null);
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    user = c.getString(0);
                } while (c.moveToNext());
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return user;//Devuelve el número

    }

}//Cierre de la clase
