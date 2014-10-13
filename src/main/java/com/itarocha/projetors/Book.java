package com.itarocha.projetors;

import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "book")
@XmlType(propOrder = { "id", "descricao", "coordenada", "lista" })
public class Book {
	private int id;
	private String descricao;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCoordenada(){
		return "-12.25.14";
	}
	
	public void setCoordenada(String z){
		
	}
	
	public List<String> getLista(){
		List<String> retorno = new ArrayList<String>();
		retorno.add("aleph");
		retorno.add("beth");
		retorno.add("guimel");
		
		return retorno;
	}
	
	public void setLista(List<String> entrada){}
}
