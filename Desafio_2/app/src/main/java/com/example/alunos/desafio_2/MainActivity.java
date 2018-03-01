package com.example.alunos.desafio_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jogar(View v){
        Random r = new Random();
        int num = r.nextInt(10) + 1;
        int tentativas = 0;

        EditText userInput = findViewById(R.id.editText);
        TextView resposta = (TextView) findViewById(R.id.str_resp);
        String teste = userInput.getText().toString();

        while(tentativas < 3){
            if (num == userInput){
                resposta.setText(getResources().getString(R.string.str_resp1));
            }
            else{
                resposta.setText(getResources().getString(R.string.str_resp2));
                tentativas++;
            }
        }
    }
}
