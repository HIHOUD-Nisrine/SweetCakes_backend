package com.example.demo.model;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name= "cakes_demands")
public class cakes_demands {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_demand;

	@OneToMany(targetEntity = Articles.class, mappedBy = "demand",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Articles> articles;
	
	
	
	public cakes_demands() {
		super();
	}
	@Column(name = "nom")
	private String nom;
	@Column(name = "telephone")
	private String telephone;
	@Column(name = "address")
	private String address;
	@Column(name = "ville")
	private String ville;
	@Column(name = "notes")
	private String notes;
	@Column(name = "date_livraison")
	private Date date_livraison;
	@Column(name = "date_creation")
	private Date date_creation;
	@Column(name = "date_modification")
	private Date date_modification;
	@Column(name = "prix")
	private int prix;
	@Column(name = "statut")
	private String statut;
	
	public cakes_demands(long id_demand, String nom, String telephone, String address, String ville, String notes,
			Date date_livraison, Date date_creation, Date date_modification, int prix, String statut) {
		super();
		this.id_demand = id_demand;
		this.nom = nom;
		this.telephone = telephone;
		this.address = address;
		this.ville = ville;
		this.notes = notes;
		this.date_livraison = date_livraison;
		this.date_creation = date_creation;
		this.date_modification = date_modification;
		this.prix = prix;
		this.statut = statut;
	}
	public long getId_demand() {
		return id_demand;
	}
	public void setId_demand(long id_demand) {
		this.id_demand = id_demand;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Date getDate_livraison() {
		return date_livraison;
	}
	public void setDate_livraison(Date date_livraison) {
		this.date_livraison = date_livraison;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	public Date getDate_modification() {
		return date_modification;
	}
	public void setDate_modification(Date date_modification) {
		this.date_modification = date_modification;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	
	
	

}
