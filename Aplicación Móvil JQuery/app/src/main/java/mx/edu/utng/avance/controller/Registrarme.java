package mx.edu.utng.avance.controller;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import mx.edu.utng.avance.R;
import mx.edu.utng.avance.dao.DBHelperUsuario;
import mx.edu.utng.avance.dao.UsuarioDAOImpl;
import mx.edu.utng.avance.model.Usuario;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica que extiende de la clase Activity
public class Registrarme extends Activity implements View.OnClickListener {

    private Button botonRegistrarme;//Declaración privada tipo botón
    private EditText edtNombre;//Declaración privada tipo editText
    private EditText edtApp;
    private EditText edtApm;
    private EditText edtUsuario;
    private EditText edtPassword;
    private EditText edtCorreo;
    private SQLiteDatabase db;//Declaración privada tipo DB
    private Usuario usuario;//Declaración privada tipo Usuario de la clase Usuario
    private UsuarioDAOImpl dao;//Declaración privada tipo UsuarioDAOimpl de la clase UsuarioDAOimpl
    private DBHelperUsuario dbHelperUsuario;//Declaración privada tipo DBHelperUsuario de la clase DBHelperUsuario
    private Bundle respuestaBundle;



    @Override
    public void onCreate(Bundle savedInstanceState) {//Método onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);//Da al contenido de la ventana el valor del layout
        initComponents();//Implementando método initComponents
    }
    public void initComponents() {//Método inicializar componentes
        edtNombre = (EditText) findViewById(R.id.edtNombre);//Inicialización tipo editText con id edtNombre
        edtApp = (EditText) findViewById(R.id.edtApp);
        edtApm = (EditText) findViewById(R.id.edtApm);
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtCorreo = (EditText) findViewById(R.id.edtCorreo);
        botonRegistrarme = (Button) findViewById(R.id.buttonReg);
        botonRegistrarme.setOnClickListener(this);

        //Nueva insatancia DBHelperUsuario con sus siguientes parámetros
        dbHelperUsuario = new DBHelperUsuario(this, DBHelperUsuario.DATABASE_NAME, null, DBHelperUsuario.DATABASE_VERSION);
        db = dbHelperUsuario.getWritableDatabase();
        dao = new UsuarioDAOImpl();//implementar UsuarioDAOImpl

    }

    @Override
    public void onClick(View v) {//Método onclick
        usuario = new Usuario(0,edtNombre.getText().toString(),edtApp.getText().toString(), edtApm.getText().toString(),
                edtUsuario.getText().toString(),edtPassword.getText().toString(),edtCorreo.getText().toString());//Obtener Cadenas


            dao.agregar(usuario, db);//Agregar en BD


        Log.d("Guardando datos", " " + usuario.getIdUsuario() + " el estado es: " + usuario.getNombre());
        startActivity(new Intent(this, Login.class));
    }//Cierre del método onClick
}//Cierre de la Clase
