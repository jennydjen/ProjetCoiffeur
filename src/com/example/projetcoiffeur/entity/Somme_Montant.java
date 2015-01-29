package com.example.projetcoiffeur.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Somme_Montant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "id_intervention")
	private Intervention intervention;

	@Column(name = "id_service")
	private Service service;

	private double prix;

	public Somme_Montant() {
	}

	public long getId() {
		return id;
	}

	public Intervention getIntervention() {
		return intervention;
	}

	public double getPrix() {
		return prix;
	}

	public Service getService() {
		return service;
	}

	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public void setService(Service service) {
		this.service = service;
	}
}