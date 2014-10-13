package com.itarocha.projetors;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "carta")
@XmlType(propOrder = { "planetaA", "aspecto", "planetaB" })
public class Aspecto {
	private String planetaA;
	private String planetaB;
	private String aspecto;
	
	public Aspecto(){}
	
	public Aspecto(String planetaA, String planetaB, String aspecto){
		this.planetaA = planetaA;
		this.planetaB = planetaB;
		this.aspecto = aspecto;
	}
	
	@XmlElement(name = "planeta_a")
	public String getPlanetaA() {
		return planetaA;
	}
	public void setPlanetaA(String planetaA) {
		this.planetaA = planetaA;
	}
	@XmlElement(name = "planeta_b")
	public String getPlanetaB() {
		return planetaB;
	}
	public void setPlanetaB(String planetaB) {
		this.planetaB = planetaB;
	}
	public String getAspecto() {
		return aspecto;
	}
	public void setAspecto(String aspecto) {
		this.aspecto = aspecto;
	}
}
