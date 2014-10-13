package com.itarocha.projetors;

import java.util.Iterator;

public class Exemplo {
    public static void main(String[] args) {
        try {
            SQLite dbCon = new SQLite("pessoas.db");
 
            dbCon.initDB();
            dbCon.insert(new Pessoa("Jonnas", 19));
            dbCon.insert(new Pessoa("Fulano", 20));
            dbCon.insert(new Pessoa("Beltrano", 10));
 
            Exemplo.listaTodos(dbCon);
 
            System.out.println("Removemos a pessoa com o nome Fulano e listamos novamenten");
            dbCon.removePessoa("Fulano");
 
            Exemplo.listaTodos(dbCon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public static void listaTodos(SQLite dbCon) {
        Iterator it = dbCon.getAll().iterator();
        Pessoa hs;
        while (it.hasNext()) {
            hs = (Pessoa) it.next();
            System.out.println("Nome:" + hs.getNome());
            System.out.println("Idade:" + hs.getIdade() + "n");
        }
    }
}