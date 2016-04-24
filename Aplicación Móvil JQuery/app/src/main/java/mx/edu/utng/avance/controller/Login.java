package mx.edu.utng.avance.controller;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.utng.avance.R;
import mx.edu.utng.avance.dao.DBHelperUsuario;
import mx.edu.utng.avance.dao.UsuarioDAOImpl;
import mx.edu.utng.avance.model.RespuestaExamen;
import mx.edu.utng.avance.model.Usuario;


/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */



//Clase publica que extiende de la clase Activity
public class Login extends Activity implements View.OnClickListener {
    private Button btnIngresar;//Declaración privada tipo botón
    private EditText txtusuario;//Declaración privada tipo editText
    private EditText txtpassword;
    private SQLiteDatabase db;//Declaración privada tipo DB
    private Usuario usuario;//Declaración privada tipo Usuario de la clase Usuario
    private UsuarioDAOImpl dao;//Declaración privada tipo UsuarioDAOimpl de la clase UsuarioDAOimpl
    private DBHelperUsuario dbHelperUsuario;//Declaración privada tipo DBHelperUsuario de la clase DBHelperUsuario
    private Bundle respuestaBundle;
    private Integer numero =0;//Declaración de nuero como entero inicializado en cero
    @Override
    public void onCreate(Bundle savedInstanceState) {//Método onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);//Da al contenido de la ventana el valor del layout
        initComponents();//Implementando método initComponents
    }
    public void initComponents() {//Método inicializar componentes
        txtusuario = (EditText) findViewById(R.id.txtusuario);//Inicialización tipo editText con id txtusuario
        txtpassword = (EditText) findViewById(R.id.txtpassword);
        btnIngresar = (Button) findViewById(R.id.ingresar);
        btnIngresar.setOnClickListener(this);

        //Nueva insatancia DBHelperUsuario con sus siguientes parámetros

        dbHelperUsuario = new DBHelperUsuario(this, DBHelperUsuario.DATABASE_NAME, null, DBHelperUsuario.DATABASE_VERSION);
        db = dbHelperUsuario.getWritableDatabase();
        dao = new UsuarioDAOImpl();//implementar UsuarioDAOImpl

    }

    @Override
    public void onClick(View v) {//Método onclick

        int exist = verificarId(db);//exist declarado como entero

        //Condición si existe en la BD
        if (exist==0){
            //Muestra mensaje si el usuario y contraseña no existen en la BD
            Toast toast = Toast.makeText(this, "Usuario o Contraseña inválidos", Toast.LENGTH_SHORT);
            toast.show();//Muestra el mensaje

            //Si lo es entonces
        }else {

                //Hacer el intento, redirecciona a la presentación
            Intent intento = new Intent(Login.this, PresentacionActivity.class);
            startActivity(intento);//Iniciar Actividad
            finish();//Finalizar Actividad
        }
    }

    public int verificarId( SQLiteDatabase db){//Método verificar ID en la BD
        String usuario =txtusuario.getText().toString();
        String pass = txtpassword.getText().toString();
        Cursor c = db.query("tbl_usuario",//Posición  del cursor en la tabla
                new String[]{"count(*)"},
                " usuario="+"'"+usuario+"'"+" and password="+"'"+pass+"'"
                        ,null, null, null,null);

        Log.d("Datos: ", " " + " usuario="+"'"+txtusuario.getText().toString()+"'"+" and password="+"'"+txtpassword.getText().toString());
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    numero = c.getInt(0);
                    Log.d("Obtuve respuesta exis", " " + numero);
                } while (c.moveToNext());
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;//retorna el número

    }//Cierre del método
}//Cierre de la clase
