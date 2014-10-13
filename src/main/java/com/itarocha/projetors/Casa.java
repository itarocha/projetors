package com.itarocha.projetors;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "cuspide")
@XmlType(propOrder = { "numero", "signo", "grau", "grauNaCasa" })
public class Casa {

	private int numero;
	private String grau;
	
	
	private String grauNaCasa;
	private String signo;
	
	public Casa(){}
	
	public Casa(int numero, String grau, String grauNaCasa, String signo){
		this.numero = numero;
		this.grau = grau;
		this.grauNaCasa = grauNaCasa;
		this.signo = signo;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getGrau() {
		return grau;
	}
	public void setGrau(String grau) {
		this.grau = grau;
	}
	@XmlElement(name = "grau_casa")
	public String getGrauNaCasa() {
		return grauNaCasa;
	}
	public void setGrauNaCasa(String grauNaCasa) {
		this.grauNaCasa = grauNaCasa;
	}
	public String getSigno() {
		return signo;
	}
	public void setSigno(String signo) {
		this.signo = signo;
	} 
}
