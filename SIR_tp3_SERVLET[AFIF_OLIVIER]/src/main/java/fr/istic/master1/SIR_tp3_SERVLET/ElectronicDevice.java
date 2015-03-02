package fr.istic.master1.SIR_tp3_SERVLET;

import javax.persistence.Entity;
@Entity
public class ElectronicDevice extends SmartDevice{
	private String name;
	public ElectronicDevice(){
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}