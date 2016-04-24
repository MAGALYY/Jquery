package mx.edu.utng.avance.controller;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import mx.edu.utng.avance.R;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

public class MyMenu extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_registro:
                //Intent i= new Intent(this, PreferenciasActivity.class);
        //startActivity(i);
                Intent intento= new Intent(this, VentanaRegistrarActivity.class);
                startActivity(intento);


                break;


            case R.id.menu_contenido:
                //Toast.makeText(getApplicationContext(), "Contenido Tematico", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MyMenu.this, SpinnerExampleActivity.class));
                break;



            case R.id.menu_acerca:

                startActivity(new Intent(MyMenu.this, AcercaActivity.class));

                break;

            case R.id.menu_juego:
                //Toast.makeText(getApplicationContext(), "Contenido Tematico", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MyMenu.this, Juego1.class));
                break;

            case R.id.menu_configuracion:
                //Toast.makeText(getApplicationContext(), "Contenido Tematico", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MyMenu.this, CambioContrasena.class));
                break;


            default:
                break;



        }
        return  super.onOptionsItemSelected(item);

    }

    public void presionaAudio(View v) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.musica);
        mp.start();
    }
}
