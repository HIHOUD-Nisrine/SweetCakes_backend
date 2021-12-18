package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "articles")
public class Articles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_article;

	@ManyToOne
	@JoinColumn(name = "id_demand", nullable = false)
	private cakes_demands demand;


	@ManyToOne
	@JoinColumn(name = "id_post", nullable = true)
	private Posts posts;

	private String categorie;
	private String evenement;
	private String poid_ou_parts;
	private int quantite;
	private int nombre_etages;
	private int nombre_pieces;
	private String gout;
	private String coleur;
	@Lob
	@Column( length = 1000000 )
	private String image;
	private int prix;
	private String description;
	@Column(name = "date_creation")
	private Timestamp date_creation;
	@Column(name = "date_modification")
	private Timestamp date_modification;
	private String pack_ou_unite;


	
	
	

	public Articles( cakes_demands demand, String categorie, String evenement,
			String poid_ou_parts, int quantite, int nombre_etages, int nombre_pieces, String gout, String coleur,
			String image, int prix, String description, Timestamp date_creation, Timestamp date_modification,
			String pack_ou_unite) {
		super();
		
		this.demand = demand;
		
		this.categorie = categorie;
		this.evenement = evenement;
		this.poid_ou_parts = poid_ou_parts;
		this.quantite = quantite;
		this.nombre_etages = nombre_etages;
		this.nombre_pieces = nombre_pieces;
		this.gout = gout;
		this.coleur = coleur;
		this.image = image;
		this.prix = prix;
		this.description = description;
		this.date_creation = date_creation;
		this.date_modification = date_modification;
		this.pack_ou_unite = pack_ou_unite;
	}

	public Long getId_article() {
		return id_article;
	}

	public void setId_article(Long id_article) {
		this.id_article = id_article;
	}

	public Articles() {
		super();
	}

	// public Long getId_demand() {
	// 	return this.id_demand;
	// }

	// public void setId_demand(Long id_demand) {
	// 	this.id_demand = id_demand;
	// }

	// public Long getId_post() {
	// 	return this.id_post;
	// }

	// public void setId_post(Long id_post) {
	// 	this.id_post = id_post;
	// }

	public cakes_demands getDemand() {
		return demand;
	}

	public void setDemand(cakes_demands demand) {
		this.demand = demand;
	}

	

	public int getNombre_etages() {
		return nombre_etages;
	}

	public void setNombre_etages(int nombre_etages) {
		this.nombre_etages = nombre_etages;
	}

	public void setId_article(long id_article) {
		this.id_article = id_article;
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

	public String getPoid_ou_parts() {
		return poid_ou_parts;
	}

	public void setPoid_ou_parts(String poid_ou_parts) {
		this.poid_ou_parts = poid_ou_parts;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getNombre_etage() {
		return nombre_etages;
	}

	public void setNombre_etage(int nombre_etage) {
		this.nombre_etages = nombre_etage;
	}

	public int getNombre_pieces() {
		return nombre_pieces;
	}

	public void setNombre_pieces(int nombre_pieces) {
		this.nombre_pieces = nombre_pieces;
	}

	public String getGout() {
		return gout;
	}

	public void setGout(String gout) {
		this.gout = gout;
	}

	public String getColeur() {
		return coleur;
	}

	public void setColeur(String coleur) {
		this.coleur = coleur;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
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

	public String getPack_ou_unite() {
		return pack_ou_unite;
	}

	public void setPack_ou_unite(String pack_ou_unite) {
		this.pack_ou_unite = pack_ou_unite;
	}

	public Posts getPosts() {
		return posts;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
	}
	

}
