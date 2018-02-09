package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

public class FirmOffer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double cijena;
	private Date rokIzvrsavanja;
	
	public double getCijena() {
		return cijena;
	}
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	public Date getRokIzvrsavanja() {
		return rokIzvrsavanja;
	}
	public void setRokIzvrsavanja(Date rokIzvrsavanja) {
		this.rokIzvrsavanja = rokIzvrsavanja;
	}
	
}
