package com.example.projetcoiffeur.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.projetcoiffeur.entity.enumeration.State_Intervention;
import com.example.projetcoiffeur.entity.enumeration.Type_Paiement;

@Entity
@NamedQueries(value = {
		@NamedQuery(name="Intervention.findAll", query="Select c from Intervention c"),
		@NamedQuery(name="Intervention.findAllbyDate", query = "Select c from Intervention c where c.date_intervention between ?1 and ?2"),
		@NamedQuery(name="Intervention.findAllByClient", query ="Select c from Intervention c where c.client = ?1")
		
})
public class Intervention {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String commentaire;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_intervention;

	@Enumerated(EnumType.ORDINAL)
	private Type_Paiement paiement;

	@JoinColumn(name = "id_client")
	private Client client;

	@Enumerated(EnumType.ORDINAL)
	private State_Intervention etat;

	@OneToMany(mappedBy = "intervention")
	private List<Somme_Montant> services;

	public Intervention() {
	}

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

	public State_Intervention getEtat() {
		return etat;
	}

	public void setEtat(State_Intervention etat) {
		this.etat = etat;
	}

	public List<Somme_Montant> getServices() {
		return services;
	}
}