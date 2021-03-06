package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

public class TenderRequest implements Serializable{
	
	private Category category;
	private String opisPosla;
	private double procjenaVrijednosti;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date rokZaPrimanjePonuda;
	private int maksimalniBrojPonuda;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date rokZaIzvrsavanjeUsluge;
	
	public Date getRokZaIzvrsavanjeUsluge() {
		return rokZaIzvrsavanjeUsluge;
	}
	public void setRokZaIzvrsavanjeUsluge(Date rokZaIzvrsavanjeUsluge) {
		this.rokZaIzvrsavanjeUsluge = rokZaIzvrsavanjeUsluge;
	}
	public int getMaksimalniBrojPonuda() {
		return maksimalniBrojPonuda;
	}
	public void setMaksimalniBrojPonuda(int maksimalniBrojPonuda) {
		this.maksimalniBrojPonuda = maksimalniBrojPonuda;
	}
	public Date getRokZaPrimanjePonuda() {
		return rokZaPrimanjePonuda;
	}
	public void setRokZaPrimanjePonuda(Date rokZaPrimanjePonuda) {
		this.rokZaPrimanjePonuda = rokZaPrimanjePonuda;
	}
	public String getOpisPosla() {
		return opisPosla;
	}
	public void setOpisPosla(String opisPosla) {
		this.opisPosla = opisPosla;
	}
	public double getProcjenaVrijednosti() {
		return procjenaVrijednosti;
	}
	public void setProcjenaVrijednosti(double procjenaVrijednosti) {
		this.procjenaVrijednosti = procjenaVrijednosti;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

}
