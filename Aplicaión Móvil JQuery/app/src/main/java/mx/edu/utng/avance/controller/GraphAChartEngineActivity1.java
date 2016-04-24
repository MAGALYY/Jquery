package mx.edu.utng.avance.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import mx.edu.utng.avance.R;

public class GraphAChartEngineActivity1 extends Activity implements View.OnClickListener {
    /** Called when the activity is first created. */
    private ImageButton btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
        initComponents();
    }

    private void initComponents() {
        btnRegresar = (ImageButton) findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        Intent i = new Intent(this, SpinnerExampleActivity.class);
        startActivity(i);
        finish();



    }


    public void pieGraphHandler1 (View view)
    {
        PieGraph1 pie = new PieGraph1();
        Intent lineIntent = pie.getIntent(this);
        startActivity(lineIntent);
    }

   }