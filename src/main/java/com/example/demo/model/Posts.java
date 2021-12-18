package com.example.demo.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Posts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_post;

	@OneToMany(targetEntity = Articles.class, mappedBy = "posts", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Articles> articles;

	@Column(name = "categorie")
	private String categorie;

	@Column(name = "evenement", nullable = true)
	private String evenement;

	@Column(name = "prix")
	private int prix;

	@Column(name = "poids", nullable = true)
	private float poids;

	@Column(name = "nombre_part", nullable = true)
	private int nombre_part;

	@Column(name = "image")
	private String image;

	@Column(name = "gout", nullable = true)
	private String gout;

	@Column(name = "pack_ou_unite", nullable = true)
	private String pack_ou_unite;

	@Column(name = "nombre_unite_dispo")
	private int nombre_unite_dispo;

	@Column(name = "description", nullable = true)
	private String description;

	@Column(name = "type_pate", nullable = true)
	private String type_pate;

	@Column(columnDefinition = "TINYINT(1)")
	private boolean dispo;

	@Column(name = "date_creation", nullable = true)
	private Date date_creation;

	@Column(name = "date_modification", nullable = true)
	private Date date_modification;

	public Posts(String categorie, String evenement, int prix, float poids, int nombre_part, String image,
			String gout, String pack_ou_unite, int nombre_unite_dispo, boolean dispo, String description, String type_pate) {

		this.categorie = categorie;
		this.evenement = evenement;
		this.prix = prix;
		this.poids = poids;
		this.nombre_part = nombre_part;
		this.image = image;
		this.gout = gout;
		this.pack_ou_unite = pack_ou_unite;
		this.nombre_unite_dispo = nombre_unite_dispo;
		this.dispo = dispo;
		this.description = description;
		this.type_pate = type_pate;
	}

	public Posts(long id_post, String categorie, String evenement, int prix, float poids, int nombre_part, String image,
			String gout, String pack_ou_unite, int nombre_unite_dispo, boolean dispo, Timestamp date_creation,
			Timestamp date_modification) {
		super();
		this.id_post = id_post;
		this.categorie = categorie;
		this.evenement = evenement;
		this.prix = prix;
		this.poids = poids;
		this.nombre_part = nombre_part;
		this.image = image;
		this.gout = gout;
		this.pack_ou_unite = pack_ou_unite;
		this.nombre_unite_dispo = nombre_unite_dispo;
		this.dispo = dispo;
		this.date_creation = date_creation;
		this.date_modification = date_modification;
	}

	@PrePersist
	private void onCreate() {
		date_creation = new Date();
		date_modification = new Date();
	}

	public long getId_post() {
		return id_post;
	}

	public void setId_post(long id_post) {
		this.id_post = id_post;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getEvenement() {
		return evenement;
	}

	public void setEvenement(String evenement) {
		this.evenement = evenement;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public int getNombre_part() {
		return nombre_part;
	}

	public void setNombre_part(int nombre_part) {
		this.nombre_part = nombre_part;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGout() {
		return gout;
	}

	public void setGout(String gout) {
		this.gout = gout;
	}

	public String getPack_ou_unite() {
		return pack_ou_unite;
	}

	public void setPack_ou_unite(String pack_ou_unite) {
		this.pack_ou_unite = pack_ou_unite;
	}

	public int getNombre_unite_dispo() {
		return nombre_unite_dispo;
	}

	public void setNombre_unite_dispo(int nombre_unite_dispo) {
		this.nombre_unite_dispo = nombre_unite_dispo;
	}

	public boolean isDispo() {
		return dispo;
	}

	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Timestamp date_creation) {
		this.date_creation = date_creation;
	}

	public Date getDate_modification() {
		return date_modification;
	}

	public void setDate_modification(Timestamp date_modification) {
		this.date_modification = date_modification;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType_pate() {
		return this.type_pate;
	}

	public void setType_pate(String type_pate) {
		this.type_pate = type_pate;
	}

	public boolean getDispo() {
		return this.dispo;
	}

	public Posts() {
		super();
	}

}
