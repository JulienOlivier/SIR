package fr.istic.master1.SIR_tp3_SERVLET;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Personne")
public class Person {
	/*
	 * Variables globales
	 */
	private String nom;
	private String prenom;
	private boolean genre; // true = homme ; false = femme
	private String mail;
	private Date dateNaissance;
	private String profilFacebook;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public boolean isGenre() {
		return genre;
	}
	public void setGenre(boolean genre) {
		this.genre = genre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getProfilFacebook() {
		return profilFacebook;
	}
	public void setProfilFacebook(String profilFacebook) {
		this.profilFacebook = profilFacebook;
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
	private List<Home> homes;
	private List<Person> listAmis;
	@OneToMany(mappedBy="personne")
	public List<Home> getHomes() {
		return homes;
	}
	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}
	@ManyToMany
	public List<Person> getListAmis() {
		return listAmis;
	}
	public void setListAmis(List<Person> listAmis) {
		this.listAmis = listAmis;
	}
	/*
	 * Constructeurs de la classe
	 */
	public Person(){
		this.homes = new ArrayList<Home>();
	}
}