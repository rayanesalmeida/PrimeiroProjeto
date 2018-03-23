package com.example.alunos.myapplication.model;

/**
 * Created by alunos on 23/03/18.
 */

public class Pessoa {

    private String nome;
    private String telefone;
    private int imagem;

    public Pessoa(String nome, String telefone, int idImagem) {
        this.nome = nome;
        this.telefone = telefone;
        this.imagem = idImagem
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public int getImagem(){
        return imagem;
    }

    public void setImagem(int id){
        this.imagem = id;
    }

}
