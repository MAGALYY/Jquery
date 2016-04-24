package mx.edu.utng.avance.controller;

/**
 * Created by EquipoHome on 26/03/2016.
 */


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.keyes.youtube.OpenYouTubePlayerActivity;

import mx.edu.utng.avance.R;


public class VideoUtilitariosActivity extends Activity {


    Button viewVideoButton = null;
    public String videoId = "yHSFYQ-T3u8";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_utilitarios_layout);

        //videoIdTextView = (TextView) findViewById(R.id.youtubeIdText);
        viewVideoButton = (Button)findViewById(R.id.viewVideoButton);

        viewVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pV) {

                //String videoId = videoIdTextView.getText().toString();


                if (videoId == null || videoId.trim().equals("")) {

                    return;
                }

                Intent lVideoIntent = new Intent(null, Uri.parse("ytv://" + videoId), VideoUtilitariosActivity.this, OpenYouTubePlayerActivity.class);
                startActivity(lVideoIntent);

            }
        });
    }



}

