package com.itarocha.projetors;

import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "carta")
@XmlType(propOrder = { "posicoes", "cuspides", "aspectos" })
public class Carta {
	private List<Posicao> posicoes = new ArrayList<Posicao>();
	private List<Casa> cuspides = new ArrayList<Casa>();
	private List<Aspecto> aspectos = new ArrayList<Aspecto>();

	public Carta(){}
	
	public List<Posicao> getPosicoes() {
		return posicoes;
	}

	public void setPosicoes(List<Posicao> posicoes) {
		this.posicoes = posicoes;
	}

	public List<Casa> getCuspides() {
		return cuspides;
	}

	public void setCuspides(List<Casa> cuspides) {
		this.cuspides = cuspides;
	}

	public List<Aspecto> getAspectos() {
		return aspectos;
	}

	public void setAspectos(List<Aspecto> aspectos) {
		this.aspectos = aspectos;
	}

}
