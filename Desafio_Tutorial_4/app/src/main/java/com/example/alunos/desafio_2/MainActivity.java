package com.example.alunos.desafio_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;

import org.apache.commons.collections4.queue.CircularFifoQueue;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int num;
    int tentativas;
    int highestScore;
    CircularFifoQueue <String> hist;
    final int Idle = 0;
    final int Reset = 1;
    int estado;
    Random r = new Random();
    private EditText userInput;
    private TextView resposta;
    private Button btnAdiv;
    private SharedPreferences arquivo;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //num = r.nextInt(1000) + 1;
        num = 10;

        userInput = (EditText) findViewById(R.id.editText);
        resposta = (TextView) findViewById(R.id.str_resp);
        btnAdiv = (Button) findViewById(R.id.btnAdiv);
        estado = Idle;
        hist = new CircularFifoQueue<>(5);
        arquivo = getPreferences(Context.MODE_PRIVATE);
        highestScore = arquivo.getInt(getResources().getString(R.string.highestScoreKey), 0);
        for (int i = 0; i < 5; i++){
            String chave, valor;
            chave = getResources().getString(R.string.historicoKey) + Integer.toString(i);
            valor = arquivo.getString(chave, "0");
            Log.d(chave, valor);
            hist.add(valor);
        }
    }

    public void jogar(View v) {
        int n;
        String teste = userInput.getText().toString();
        if (teste.matches("") && estado != Reset){
            Toast toast = Toast.makeText(MainActivity.this,
                    "Digite um número!", Toast.LENGTH_SHORT);
            toast.show();
        } else{
            switch (estado){
                case Idle:
                    n = Integer.parseInt(teste);
                    tentativas++;
                    if( n == num){
                        verificaHigh(tentativas);
                        hist.add(Integer.toString(tentativas));
                        editor = arquivo.edit();
                        editor.putInt(getResources().getString(R.string.highestScoreKey),highestScore);
                        for(int i = 0; i < hist.size(); i++){
                            String chave, valor;
                            chave = getResources().getString(R.string.historicoKey) + Integer.toString(i);
                            valor = hist.get(i);
                            editor.putString(chave, valor);
                            Log.d(chave, valor);
                        }
                        editor.commit();
                        resposta.setText(getResources().getString(R.string.msgWin));
                        btnAdiv.setText(getResources().getString(R.string.lblButtonJogado));
                        estado = Reset;
                    } else if (n > num) {
                        estado = Idle;
                        Toast toast = Toast.makeText(MainActivity.this,
                                "Seu palpite foi MAIOR que o número sorteado!", Toast.LENGTH_SHORT);
                        toast.show();
                        return;
                    } else{
                        estado = Idle;
                        Toast toast = Toast.makeText(MainActivity.this,
                            "Seu palpite foi MENOR que o número sorteado!", Toast.LENGTH_SHORT);
                        toast.show();
                        return;
                    }
                break;
                case Reset:
                    //num = r.nextInt(10) +1;
                    num = 10;
                    tentativas = 0;
                    resposta.setText("");
                    btnAdiv.setText(getResources().getString(R.string.lblButton));
                    estado = Idle;
                    break;
                default:
            }
        }
        userInput.setText("");
    }

    public void placar(View v){
        Intent intent = new Intent(getApplicationContext(), Placar.class);
        Bundle bundle = new Bundle();
        bundle.putInt(getResources().getString(R.string.highestScoreKey), highestScore);
        for(int i = 0; i < 5; ++i){
            String chave, valor;
            chave = getResources().getString(R.string.historicoKey) + Integer.toString(i);
            valor = hist.get(i);
            bundle.putString(chave, valor);
            Log.d(chave, valor);
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void verificaHigh(int valor){
        if (highestScore == 0){
            highestScore = valor;
        }else{
            highestScore = valor < highestScore ? valor : highestScore;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle estadoASalvar){
        super.onSaveInstanceState(estadoASalvar);
        estadoASalvar.putInt("num", num);
        estadoASalvar.putInt("tentativas", tentativas);
        estadoASalvar.putInt("estado", estado);
    }

    @Override
    protected void onRestoreInstanceState(Bundle estadoSalvo){
        super.onRestoreInstanceState(estadoSalvo);
        estado = estadoSalvo.getInt("estado", Idle);
        tentativas = estadoSalvo.getInt("tentativas", 0);
        num = estadoSalvo.getInt("num", r.nextInt(10) + 1);
    }
}
