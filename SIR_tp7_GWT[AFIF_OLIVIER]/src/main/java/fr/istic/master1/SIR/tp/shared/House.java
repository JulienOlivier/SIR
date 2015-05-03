package fr.istic.master1.SIR.tp.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="House")
public class House implements Serializable{
	/*
	 * Variables globales
	 */
	private Address adresse;
	private int superficie;
	private String IP;
	private Person personne;
	public Address getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse.setAddr(adresse);
	}
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
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
	/*
	 * Jointures
	 */
	private List<SmartDevice> SmartDevice;
	@OneToMany
	public List<SmartDevice> getSmartDevice() {
		return SmartDevice;
	}
	public void setSmartDevice(List<SmartDevice> SmartDevice) {
		this.SmartDevice = SmartDevice;
	}
	public void addSmartDevice(SmartDevice s){
		this.SmartDevice.add(s);
	}
	public void removeSmartDevice(SmartDevice s){
		this.SmartDevice.remove(s);
	}
	/*
	 * Constructeurs de la classe
	 */
	public House(){
		this.SmartDevice = new ArrayList<SmartDevice>();
	}
	@ManyToOne
	public Person getPersonne(){
		return this.personne;
	}
	public void setPersonne (Person personne){
		this.personne = personne;
	}
}