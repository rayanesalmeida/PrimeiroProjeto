package com.example.alunos.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alunos.myapplication.model.Pessoa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editNome;
    EditText editTelefone;

    ArrayList<Pessoa> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = (EditText)findViewById(R.id.editName);
        editTelefone = (EditText)findViewById(R.id.editTelefone);
    }

    public void salvar(View V){
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        String name = editNome.getText().toString();
        String telefone  = editTelefone.getText().toString();
        if(name.matches("") && telefone.matches("") ){
            Toast toast = Toast.makeText(MainActivity.this,
                    "Digite algo...", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        SharedPreferences.Editor editor = arquivo.edit();
        editor.putString("nome", name);
        editor.putString("telefone", telefone);
        editor.commit();
        editNome.setText("");
        editTelefone.setText("");

        lista.add(new Pessoa(name, telefone,
                R.mipmap.ic_launcher_round));
    }

    public void mostrarLista(View v){
        Intent it = new Intent(this, mostraListaDinamica.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("contatos", lista);
        it.putExtras(bundle);
        startActivity(it);
    }
}
