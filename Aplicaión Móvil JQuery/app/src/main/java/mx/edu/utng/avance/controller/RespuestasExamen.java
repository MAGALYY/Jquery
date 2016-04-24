package mx.edu.utng.avance.controller;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.AdapterView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import mx.edu.utng.avance.R;
import mx.edu.utng.avance.dao.DBHelper;
import mx.edu.utng.avance.dao.RespuestaExamenDAOImpl;
import mx.edu.utng.avance.model.RespuestaExamen;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica que extiende de la clase Activity
public class RespuestasExamen extends Activity {

    private ListView lista;//Declaración privada tipo lista
    private DBHelper dbHelper;
    private RespuestaExamenDAOImpl dao;//Declaración privada tipo RespuestaExamenDAOImpl de la clase RespuestaExamenDAOImpl
    private RespuestaExamen cliente;//Declaración privada tipo RespuestaExamen de la clase RespuestaExamen
    private SQLiteDatabase db;//Declaración privada tipo DB
    private TextView tv_preguntaID;
    private TextView tv_Status;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {//Método onCreate
        super.onCreate(savedInstanceState);//Da al contenido de la ventana el valor del layout
        setContentView(R.layout.respuestas_examen);
        initComponents();


    }

    private void initComponents() {
        lista = (ListView) findViewById(R.id.lsv_respuestas);
        dbHelper = new DBHelper(this, DBHelper.DATABASE_NAME, null,
                DBHelper.DATABASE_VERSION);
        db = dbHelper.getWritableDatabase();
        dao = new RespuestaExamenDAOImpl();
    }

    // Tomar los datos desde la base de datos para poner en el cursor y después en el adapter
    Cursor cursor = dao.leerDatos();

    String[] from = new String[]{
            DBHelper.ID_USUARIO,
            DBHelper.ID_EXAMEN,
            DBHelper.ID_PREGUNTA,
            DBHelper.ESTADO_PREGUNTA
    };
    int[] to = new int[]{

            R.id.user_id,
            R.id.examen_id,
            R.id.pregunta_id,
            R.id.estatus
    };

    SimpleCursorAdapter adapter = new SimpleCursorAdapter(
            RespuestasExamen.this, R.layout.layout_row_format, cursor, from, to);

}
