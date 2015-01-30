package com.example.projetcoiffeur.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.projetcoiffeur.entity.enumeration.TypeCompte;
import com.example.projetcoiffeur.entity.enumeration.Type_Paiement;

@Entity
@NamedQueries(value={
		@NamedQuery(name="operation.findAll", query="SELECT O FROM Operation O WHERE O.date_operation BETWEEN ?1 AND ?2 ORDER BY O.date_operation"),
		@NamedQuery(name="operation.findByType", query="SELECT O FROM Operation O WHERE O.type_operation = ?1 AND O.date_operation BETWEEN ?2 AND ?3")
})
public class Operation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.ORDINAL)
	private TypeCompte type_operation;
	
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_operation;
	
	@Enumerated(EnumType.ORDINAL)
	private Type_Paiement type_paiment;
	
	private String numeroFacture;
	
	@JoinColumn(name="id_client")
	private Client client;
	
	private double prix;
	
	private String numeroCheque;
	
	private String nomBanque;

	public Operation() {
	}
	
	public TypeCompte getType() {
		return type_operation;
	}

	public void setType(TypeCompte type) {
		this.type_operation = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date_operation;
	}

	public void setDate(Date date) {
		this.date_operation = date;
	}

	public Type_Paiement getPaiement() {
		return type_paiment;
	}

	public void setPaiement(Type_Paiement paiement) {
		this.type_paiment = paiement;
	}

	public String getNumeroFacture() {
		return numeroFacture;
	}

	public void setNumeroFacture(String numeroFacture) {
		this.numeroFacture = numeroFacture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getNumeroCheque() {
		return numeroCheque;
	}

	public void setNumeroCheque(String numeroCheque) {
		this.numeroCheque = numeroCheque;
	}

	public String getNomBanque() {
		return nomBanque;
	}

	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}

	public long getId() {
		return id;
	}	
}
