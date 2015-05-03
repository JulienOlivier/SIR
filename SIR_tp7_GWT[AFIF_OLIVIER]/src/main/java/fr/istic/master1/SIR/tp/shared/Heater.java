package fr.istic.master1.SIR.tp.shared;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Heater extends SmartDevice implements Serializable{
	private String name;
	@Id
	@GeneratedValue
	public Long getId(){
		return super.getId();
	}
	public void setId(Long id){
		super.setId(id);
	}
	public Heater(){
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}