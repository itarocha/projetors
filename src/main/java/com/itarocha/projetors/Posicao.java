package com.itarocha.projetors;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "posicao")
@XmlType(propOrder = { "planeta", "grau", "retrogrado", "signo", "grauNaCasa" })
public class Posicao {
	private String planeta;
	private String signo;
	private String grau;
	private String grauNaCasa;
	private boolean retrogrado;

	public Posicao(){}
	
	public Posicao(String planeta, String grau, String grauNaCasa, String signo, boolean retrogrado){
		this.planeta = planeta;
		this.grau = grau;
		this.grauNaCasa = grauNaCasa;
		this.signo = signo;
		this.retrogrado = retrogrado; 
	}
	
	public String getPlaneta() {
		return planeta;
	}
	public void setPlaneta(String planeta) {
		this.planeta = planeta;
	}
	public String getSigno() {
		return signo;
	}
	public void setSigno(String signo) {
		this.signo = signo;
	}
	public String getGrau() {
		return grau;
	}
	public void setGrau(String grau) {
		this.grau = grau;
	}
	@XmlElement(name="grau_casa")
	public String getGrauNaCasa() {
		return grauNaCasa;
	}
	public void setGrauNaCasa(String grauNaCasa) {
		this.grauNaCasa = grauNaCasa;
	}
	public boolean isRetrogrado() {
		return retrogrado;
	}
	public void setRetrogrado(boolean retrogrado) {
		this.retrogrado = retrogrado;
	}
}
