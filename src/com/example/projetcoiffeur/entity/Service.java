package com.example.projetcoiffeur.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.projetcoiffeur.entity.enumeration.TypeCompte;

@Entity
public class Service {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String description;
	private double prix;
	private boolean etat;
	
	@Enumerated(EnumType.ORDINAL)
	private TypeCompte type_service;
	
	public Long getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public TypeCompte getType_service() {
		return type_service;
	}
	public void setType_service(TypeCompte type_service) {
		this.type_service = type_service;
	}
	
}
