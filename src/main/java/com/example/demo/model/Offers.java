package com.example.demo.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "offers")
public class Offers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_offer;

	@Column(name = "image")
	private String image;

	@Column(name = "description")
	private String description;

	@Column(name = "date_debut")
	private Date date_debut;

	@Column(name = "date_fin")
	private Date date_fin;

	@Column(name = "prix_initial")
	private int prix_initial;

	@Column(name = "prix_final")
	private int prix_final;

	public long getId_offer() {
		return id_offer;
	}

	public void setId_offer(long id_offer) {
		this.id_offer = id_offer;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public int getPrix_initial() {
		return prix_initial;
	}

	public void setPrix_initial(int prix_initial) {
		this.prix_initial = prix_initial;
	}

	public int getPrix_final() {
		return prix_final;
	}

	public void setPrix_final(int prix_final) {
		this.prix_final = prix_final;
	}

	public Offers() {

	};

	public Offers(String image, String description, Date date_debut, Date date_fin, int prix_initial, int prix_final) {
		super();
		this.image = image;
		this.description = description;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.prix_initial = prix_initial;
		this.prix_final = prix_final;
	}

	@Override
	public String toString() {
		return "{" +
				" id_offer='" + getId_offer() + "'" +
				", image='" + getImage() + "'" +
				", description='" + getDescription() + "'" +
				", date_debut='" + getDate_debut() + "'" +
				", date_fin='" + getDate_fin() + "'" +
				", prix_initial='" + getPrix_initial() + "'" +
				", prix_final='" + getPrix_final() + "'" +
				"}";
	}
}
