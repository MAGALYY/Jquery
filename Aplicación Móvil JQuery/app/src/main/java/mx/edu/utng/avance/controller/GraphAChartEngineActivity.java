package mx.edu.utng.avance.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import mx.edu.utng.avance.R;

public class GraphAChartEngineActivity extends Activity implements View.OnClickListener {

    private ImageButton btnRegresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
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


    /**
     * Called when the activity is first created.
     */

    public void pieGraphHandler(View view) {
        PieGraph pie = new PieGraph();
        Intent lineIntent = pie.getIntent(this);
        startActivity(lineIntent);
    }

}