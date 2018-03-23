package com.example.alunos.desafio_2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Context;

public class Placar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placar);

        Intent intencao = getIntent();
        Bundle pacote = intencao.getExtras();

        String strPlacar = pacote.getString("placar");
        TextView txtPlacar = (TextView) findViewById(R.id.txtPlacar);
        txtPlacar.setText(strPlacar);
    }
}
