package com.itarocha.projetors;

public class Pessoa {
    private int idade;
    private String nome;
 
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
 
    public String getNome() {
        return this.nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public int getIdade() {
        return this.idade;
    }
 
    public void setIdade(int idade) {
        this.idade = idade;
    }
}