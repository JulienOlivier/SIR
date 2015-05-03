package fr.istic.master1.SIR.tp.shared;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address implements Serializable{
	private String addr;
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	/*
	 * G�n�ration de l'ID
	 */
	private Long id;
	@Id
	@GeneratedValue
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}

	public Address(){
		this.addr = "";
	}
}
