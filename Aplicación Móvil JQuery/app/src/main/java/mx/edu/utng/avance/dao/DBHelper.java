package mx.edu.utng.avance.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica que extiende de la clase SQLiteOpenHelper
public class DBHelper extends SQLiteOpenHelper {

    //Declaración de variables estaticas
    public static final String DATABASE_NAME = "prueba2.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME_1 = "tbl_usuario";
    public static final String TABLE_NAME_2 = "tbl_examen";
    public static final String TABLE_NAME_3 = "tbl_pregunta";
    public static final String TABLE_NAME_4 = "tbl_respuesta";
    public static final String TABLE_NAME_5 = "tbl_estadoexamen";
    public static final String ID_USUARIO = "idUsuario";
    public static final String ID_EXAMEN = "idExamen";
    public static final String ID_PREGUNTA = "idPregunta";
    public static final String ESTADO_PREGUNTA = "estadoPregunta";
    public static final String ESTADO_EXAMEN = "estadoExamen";


    //Sentencia Crear Tabla

    private static final String CREATE_TABLE_1 ="CREATE TABLE IF NOT EXISTS "+TABLE_NAME_1+
            "(idUsuario INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
            "nombre  TEXT NOT NULL, "+
            "apellidop  TEXT NOT NULL, "+
            "apellidom  TEXT NOT NULL, "+
            "usuario  TEXT NOT NULL, "+
            "password  TEXT NOT NULL, "+
            "correo TEXT NOT NULL);";

    //Insertar en tabla

    private static final String INSERT_TABLE_1 ="INSERT INTO "+TABLE_NAME_1+
            "(idUsuario, nombre, apellidop, apellidom, usuario, password, correo) VALUES (1,'Magali','Perez','Perez','Magi','password','magaliperez285@gmail.com');" ;

    //Crear una segunda tabla
    private static final String CREATE_TABLE_2 ="CREATE TABLE IF NOT EXISTS "+TABLE_NAME_2+
            "(idExamen INTEGER NOT NULL PRIMARY KEY, "+
            "descripcion  TEXT NOT NULL);";
    //Insertar en la segunda tabla
    private static final String INSERT_TABLE_2 =
            "INSERT INTO tbl_examen SELECT 1,'Que es JQuery'" +
                    "UNION SELECT 2,'Eventos'" +
                    "UNION SELECT 3,'Vincular Eventos'" +
                    "UNION SELECT 4,'Tabla de Eventos DOM'" +
                    "UNION SELECT 5,'Metodos Utilitarios'" +
                    "UNION SELECT 6,'Obtener y Establecer Informacion de Elementos'";
    //Crear tercer tabla
    private static final String CREATE_TABLE_3 = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME_3+
            "(idPregunta INTEGER NOT NULL PRIMARY KEY, "+
            "pregunta  TEXT NOT NULL, "+
            "idExamen INTEGER NOT NULL, "+
            "FOREIGN KEY (idExamen) REFERENCES "+
            TABLE_NAME_2+"(idExamen));";
    //Insertar en la tercera tabla y seleccionar
    private static final String INSERT_TABLE_3 =
            "INSERT INTO "+TABLE_NAME_3+" SELECT 1,'P1',1" +
                    " UNION SELECT 2,'P2',1" +
                    " UNION SELECT 3,'P3',1" +
                    " UNION SELECT 4,'P4',1" +
                    " UNION SELECT 5,'P5',1" +
                    " UNION SELECT 6,'P1',2" +
                    " UNION SELECT 7,'P2',2" +
                    " UNION SELECT 8,'P3',2" +
                    " UNION SELECT 9,'P4',2" +
                    " UNION SELECT 10,'P5',2"+
                    " UNION SELECT 11,'P1',3" +
                    " UNION SELECT 12,'P2',3" +
                    " UNION SELECT 13,'P3',3" +
                    " UNION SELECT 14,'P4',3" +
                    " UNION SELECT 15,'P5',3"+
                    " UNION SELECT 16,'P1',4" +
                    " UNION SELECT 17,'P2',4" +
                    " UNION SELECT 18,'P3',4" +
                    " UNION SELECT 19,'P4',4" +
                    " UNION SELECT 20,'P5',4"+
                    " UNION SELECT 21,'P1',5" +
                    " UNION SELECT 22,'P2',5" +
                    " UNION SELECT 23,'P3',5" +
                    " UNION SELECT 24,'P4',5" +
                    " UNION SELECT 25,'P5',5"+
                    " UNION SELECT 26,'P1',6" +
                    " UNION SELECT 27,'P2',6" +
                    " UNION SELECT 28,'P3',6" +
                    " UNION SELECT 29,'P4',6" +
                    " UNION SELECT 30,'P5',6";
    //Crear tabla cuatro
    private static final String CREATE_TABLE_4 ="CREATE TABLE IF NOT EXISTS "+TABLE_NAME_4+
            "(idUsuario INTEGER, "+
            "idExamen INTEGER, "+
            "idPregunta INTEGER , "+
            "estadoPregunta BOOLEAN, "+
            "FOREIGN KEY (idUsuario) REFERENCES "+
            TABLE_NAME_1+"(idUsuario),"+
            "FOREIGN KEY (idExamen) REFERENCES "+
            TABLE_NAME_2+"(idExamen),"+
            "FOREIGN KEY (idPregunta) REFERENCES "+
            TABLE_NAME_3+"(idPregunta)," +
            "PRIMARY KEY(idUsuario,idExamen,idPregunta));";

    //Crear tabla cinco
    private static final String CREATE_TABLE_5 ="CREATE TABLE IF NOT EXISTS "+TABLE_NAME_5+
            "(idUsuario INTEGER, "+
            "idExamen INTEGER, "+
            "estadoExamen BOOLEAN, "+
            "FOREIGN KEY (idUsuario) REFERENCES "+
            TABLE_NAME_1+"(idUsuario),"+
            "FOREIGN KEY (idExamen) REFERENCES "+
            TABLE_NAME_2+"(idExamen),"+
            "PRIMARY KEY (idUsuario,idExamen));";



    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Crear en BD las siguientes tablas

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_1);
        db.execSQL(CREATE_TABLE_2);
        db.execSQL(CREATE_TABLE_3);
        db.execSQL(CREATE_TABLE_4);
        db.execSQL(CREATE_TABLE_5);
        db.execSQL(INSERT_TABLE_1);
        db.execSQL(INSERT_TABLE_2);
        db.execSQL(INSERT_TABLE_3);

    }
    //Eliminar tablas
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_1+";");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_2+";");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_3+";");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_4+";");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_5+";");
        onCreate(db);
    }
}
