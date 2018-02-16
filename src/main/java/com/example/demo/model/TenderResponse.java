package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

public class TenderResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firmId;
	private boolean pristanak;
	private double cijena;
	private Date datum;
	public String getFirmId() {
		return firmId;
	}
	public void setFirmId(String firmId) {
		this.firmId = firmId;
	}
	public boolean isPristanak() {
		return pristanak;
	}
	public void setPristanak(boolean pristanak) {
		this.pristanak = pristanak;
	}
	public double getCijena() {
		return cijena;
	}
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
}
