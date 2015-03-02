package fr.istic.master1.SIR_tp3_SERVLET;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Maison")
public class Home {
	/*
	 * Variables globales
	 */
	private String adresse;
	private int superficie;
	private String IP;
	private Person personne;
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
	 * Génération de l'ID
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
	/*
	 * Constructeurs de la classe
	 */
	public Home(){
		this.SmartDevice = new ArrayList<SmartDevice>();
	}
	@ManyToOne
	public Person getPersonne(){
		return personne;
	}
	public void setPersonne (Person personne){
		this.personne = personne;
	}
}