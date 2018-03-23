package com.example.alunos.myapplication.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.alunos.listadinamica.R;
import com.example.alunos.listadinamica.model.Pessoa;
import com.example.alunos.myapplication.model.Pessoa;

import java.util.List;

public class PessoaAdapter extends BaseAdapter {
    private Activity atividade;
    private List<Pessoa> lista;

    public PessoaAdapter(Activity atividade, List<Pessoa> lista){
        this.atividade = atividade;
        this.lista = lista;
    }

}
