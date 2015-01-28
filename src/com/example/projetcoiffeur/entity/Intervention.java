package com.example.projetcoiffeur.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.projetcoiffeur.entity.enumeration.Type_Paiement;

@Entity
public class Intervention {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String commentaire;
	private Date date_intervention;
	
	@Enumerated(EnumType.ORDINAL)
	private Type_Paiement paiement;
	
	@Column(name="id_client")
	private Client client;
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Type_Paiement getPaiement() {
		return paiement;
	}
	public void setPaiement(Type_Paiement paiement) {
		this.paiement = paiement;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Date getDate_intervention() {
		return date_intervention;
	}
	public void setDate_intervention(Date date_intervention) {
		this.date_intervention = date_intervention;
	}
	
}
