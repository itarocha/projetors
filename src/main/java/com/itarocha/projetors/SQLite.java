package com.itarocha.projetors;


//http://sqlite.org/download.html

import java.sql.*;
import java.util.Vector;
 
public class SQLite {
    private Connection conn;
    private Statement stm;
 
    public SQLite(String arquivo) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:" + arquivo);
        this.stm = this.conn.createStatement();
    }
 
    public void initDB() {
        try {
            //Remove e cria a tabela a cada execução. Mero exemplo
            this.stm.executeUpdate("DROP TABLE IF EXISTS pessoas");
            this.stm.executeUpdate("CREATE TABLE pessoas ("
            + "nome varchar(70) PRIMARY KEY NOT NULL,"
            + "idade integer);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void insert(Pessoa pessoa) {
        try {
            this.stm = this.conn.createStatement();
            this.stm.executeUpdate("INSERT INTO pessoas VALUES ("+ pessoa.getNome() + ""+pessoa.getIdade() + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void removePessoa(String nome) {
        try {
            this.stm = this.conn.createStatement();
            this.stm.executeUpdate("DELETE FROM pessoas WHERE nome = \"" + nome + "\"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public Vector getAll() {
        Vector lista = new Vector();
        ResultSet rs;
        try {
            rs = this.stm.executeQuery("SELECT * FROM pessoas ORDER BY idade");
 
            while (rs.next()) {
                lista.add(new Pessoa(rs.getString("nome"), rs.getInt("idade")));
            }
            rs.close();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}