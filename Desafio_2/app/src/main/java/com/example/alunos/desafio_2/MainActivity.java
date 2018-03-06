package com.example.alunos.desafio_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int num;
    int tentativas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sorteia();
    }

    public void sorteia(){
        Random r = new Random();
        num = r.nextInt(10) + 1;
    }

    public void jogar(View v){
        EditText userInput = findViewById(R.id.editText);
        String teste = userInput.getText().toString();
        int n = Integer.parseInt(teste);

        TextView resposta = (TextView) findViewById(R.id.str_resp);

        if (num == n){
            resposta.setText(getResources().getString(R.string.str_resp1).toString());
            userInput.setText("");
            //Log.i("Debug: ",getResources().getString(R.string.str_resp1).toString());
        }
        else if(tentativas == 3){
            resposta.setText(getResources().getString(R.string.str_resp3).toString());
            userInput.setText("");
            sorteia();
            tentativas = 0;
        }
        else{
            resposta.setText(getResources().getString(R.string.str_resp2).toString());
            userInput.setText("");
            //Log.i("Debug: ", getResources().getString(R.string.str_resp2).toString());
            tentativas++;
        }
    }
}
