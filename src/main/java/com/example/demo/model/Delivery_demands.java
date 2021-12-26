package com.example.demo.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name= "delivery_demands")

public class Delivery_demands {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_demand;
	@Column(name = "nom_emetteur")
	private String nom_emetteur;
	@Column(name = "nom_destinataire")
	private String nom_destinataire;
	@Column(name = "address_emetteur")
	private String address_emetteur;
	@Column(name = "address_destinataire")
	private String address_destinataire;
	@Column(name = "ville_emetteur")
	private String ville_emetteur;
	@Column(name = "ville_destinataire")
	private String ville_destinataire;
	@Column(name = "telephone_emetteur")
	private String telephone_emetteur;
	@Column(name = "telephone_destinataire")
	private String telephone_destinataire;
	@Column(name = "date_livraison")
	private Date date_livraison;
	@Column(name = "heure_livraison")
	private Time heure_livraison;
	@Column(name = "marge")
	private Time marge;
	@Column(name = "description")
	private String description;
	@Column(name = "date_creation")
	private Timestamp date_creation;
	@Column(name = "date_modification")
	private Timestamp date_modification;
	@Column(name = "notes")
	private String notes;
	@Column(name = "statut")
	private String statut;
	@Column(name = "prix")
	private int prix;

	public Delivery_demands() {
		super();
	}

	public long getId_demand() {
		return id_demand;
	}
	public void setId_demand(long id_demand) {
		this.id_demand = id_demand;
	}
	public String getNom_emetteur() {
		return nom_emetteur;
	}
	public void setNom_emetteur(String nom_emetteur) {
		this.nom_emetteur = nom_emetteur;
	}
	public String getNom_destinataire() {
		return nom_destinataire;
	}
	public void setNom_destinataire(String nom_destinataire) {
		this.nom_destinataire = nom_destinataire;
	}
	public String getAddress_emetteur() {
		return address_emetteur;
	}
	public void setAddress_emetteur(String address_emetteur) {
		this.address_emetteur = address_emetteur;
	}
	public String getAddress_destinataire() {
		return address_destinataire;
	}
	public void setAddress_destinataire(String address_destinataire) {
		this.address_destinataire = address_destinataire;
	}
	public String getVille_emetteur() {
		return ville_emetteur;
	}
	public void setVille_emetteur(String ville_emetteur) {
		this.ville_emetteur = ville_emetteur;
	}
	public String getVille_destinataire() {
		return ville_destinataire;
	}
	public void setVille_destinataire(String ville_destinataire) {
		this.ville_destinataire = ville_destinataire;
	}
	public String getTelephone_emetteur() {
		return telephone_emetteur;
	}
	public void setTelephone_emetteur(String telephone_emetteur) {
		this.telephone_emetteur = telephone_emetteur;
	}
	public String getTelephone_destinataire() {
		return telephone_destinataire;
	}
	public void setTelephone_destinataire(String telephone_destinataire) {
		this.telephone_destinataire = telephone_destinataire;
	}
	public Date getDate_livraison() {
		return date_livraison;
	}
	public void setDate_livraison(Date date_livraison) {
		this.date_livraison = date_livraison;
	}
	public Time getHeure_livraison() {
		return heure_livraison;
	}
	public void setHeure_livraison(Time heure_livraison) {
		this.heure_livraison = heure_livraison;
	}
	public Time getMarge() {
		return marge;
	}
	public void setMarge(Time marge) {
		this.marge = marge;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Timestamp date_creation) {
		this.date_creation = date_creation;
	}
	public Timestamp getDate_modification() {
		return date_modification;
	}
	public void setDate_modification(Timestamp date_modification) {
		this.date_modification = date_modification;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public Delivery_demands(String nom_emetteur, String nom_destinataire, String address_emetteur,
			String address_destinataire, String ville_emetteur, String ville_destinataire, String telephone_emetteur,
			String telephone_destinataire, Date date_livraison, Time heure_livraison, Time marge, String description,
			Timestamp date_creation, Timestamp date_modification, String notes, String statut, int prix) {
		super();
		this.nom_emetteur = nom_emetteur;
		this.nom_destinataire = nom_destinataire;
		this.address_emetteur = address_emetteur;
		this.address_destinataire = address_destinataire;
		this.ville_emetteur = ville_emetteur;
		this.ville_destinataire = ville_destinataire;
		this.telephone_emetteur = telephone_emetteur;
		this.telephone_destinataire = telephone_destinataire;
		this.date_livraison = date_livraison;
		this.heure_livraison = heure_livraison;
		this.marge = marge;
		this.description = description;
		this.date_creation = date_creation;
		this.date_modification = date_modification;
		this.notes = notes;
		this.statut = statut;
		this.prix = prix;
	}

    public static java.util.List<Delivery_demands> findAll() {
        return null;
    }
	
}
