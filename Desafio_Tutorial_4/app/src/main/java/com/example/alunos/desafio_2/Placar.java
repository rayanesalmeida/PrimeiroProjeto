package com.example.alunos.desafio_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Placar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int highestScore = bundle.getInt(getResources().getString(R.string.highestScoreKey), 0);
        String hist[] = new String[5];
        for(int i = 0; i < 5; i++){
            String chave;
            chave = getResources().getString(R.string.historicoKey) + Integer.toString(i);
            hist[i] = bundle.getString(chave, "0");
        }
        TextView txtPlacar = (TextView) findViewById(R.id.txtPlacar);
        txtPlacar.setText(getResources().getString(R.string.lblHighest, (highestScore)));

        TextView h0 = findViewById(R.id.hist0);
        TextView h1 = findViewById(R.id.hist0);
        TextView h2 = findViewById(R.id.hist1);
        TextView h3 = findViewById(R.id.hist2);
        TextView h4 = findViewById(R.id.hist3);

        h0.setText(hist[0]);
        h1.setText(hist[1]);
        h2.setText(hist[2]);
        h3.setText(hist[3]);
        h4.setText(hist[4]);
    }
}
