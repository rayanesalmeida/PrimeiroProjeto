package com.example.alunos.desafio_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
import android.widget.Toast;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;


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
        num = r.nextInt(1000) + 1;
    }

    public void jogar(View v){
        EditText userInput = findViewById(R.id.editText);
        String teste = userInput.getText().toString();
        int n = Integer.parseInt(teste);

        TextView resposta = (TextView) findViewById(R.id.str_resp);

        while(num != n) {
            if (n < num) {
                tentativas++;
                Toast toast = Toast.makeText(MainActivity.this,
                        "Seu palpite foi MENOR que o número sorteado!", Toast.LENGTH_SHORT);
                toast.show();
                userInput.setText("");
                return;
            } else if (n > num) {
                tentativas++;
                Toast toast = Toast.makeText(MainActivity.this,
                        "Seu palpite foi MAIOR que o número sorteado!", Toast.LENGTH_SHORT);
                toast.show();
                return;
                //userInput.setText("");
            }
        }
        //Salvando placar
        int placar = 1000 - tentativas;
        String strPlacar = Integer.toString(placar);
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = arquivo.edit();
        editor.putString("placar", strPlacar);
        editor.commit();

        //Mandando para outra Activity

        Intent i = new Intent(MainActivity.this, Placar.class);

        Bundle bundle = new Bundle();
        bundle.putString("placar", strPlacar);
        i.putExtras(bundle);
        startActivity(i);
    }
}
