package mx.edu.utng.avance.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.utng.avance.R;
import mx.edu.utng.avance.dao.DBHelper;
import mx.edu.utng.avance.dao.DBHelperUsuario;
import mx.edu.utng.avance.dao.RespuestaExamenDAOImpl;
import mx.edu.utng.avance.dao.UsuarioDAOImpl;
import mx.edu.utng.avance.model.RespuestaExamen;
import mx.edu.utng.avance.model.Usuario;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

    public class CambioContrasena extends Activity implements View.OnClickListener{
    private EditText edtUsuario;
    private Button botonAceptar;
    private Button botonCancelar;
    private EditText edtNueva;
    private SQLiteDatabase db;
    private Usuario usuario;
    private UsuarioDAOImpl dao;
    private DBHelperUsuario dbHelperUsuario;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.cambiocontrasena);//Da al
            initComponents();
        }

    public void initComponents() {
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtNueva = (EditText) findViewById(R.id.edtNueva);
        botonAceptar = (Button) findViewById(R.id.btnAceptar);
        botonAceptar.setOnClickListener(this);
        botonCancelar = (Button) findViewById(R.id.btnCancelar);
        botonCancelar.setOnClickListener(this);
        dbHelperUsuario = new DBHelperUsuario(this, DBHelperUsuario.DATABASE_NAME, null, DBHelperUsuario.DATABASE_VERSION);
        db = dbHelperUsuario.getWritableDatabase();
        dao = new UsuarioDAOImpl();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAceptar:

                String user=dao.verificarUsuario(db);
                Log.d("Usuario 1", " " + user);
                Log.d("Usuario 2", " " + edtUsuario.getText().toString());
                usuario = new Usuario(1, "", "", "", user, edtNueva.getText().toString(), "");
                if ((edtUsuario.getText().toString()).equalsIgnoreCase(user)) {
                        ContentValues values = new ContentValues();
                        values.put(DBHelperUsuario.PASSWORD, usuario.getPassword());
                        db.update(DBHelperUsuario.TABLE_NAME_1, values, DBHelperUsuario.ID_USUARIO + "= 1",
                                null);
                    Log.d("Pass", " " + usuario.getPassword());
                    Intent intent = new Intent(CambioContrasena.this, Login.class);
                    startActivity(intent);
                    }
                 else {
                    Toast toast = Toast.makeText(this, "Usuario no válido", Toast.LENGTH_SHORT);
                    toast.show();
                }

                break;
            case R.id.btnCancelar:
                Intent in = new Intent(CambioContrasena.this, MyMenu.class);
                startActivity(in);
                break;
        }
    }
}