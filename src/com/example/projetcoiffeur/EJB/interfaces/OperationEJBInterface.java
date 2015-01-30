package com.example.projetcoiffeur.EJB.interfaces;

import java.util.Date;
import java.util.List;

import com.example.projetcoiffeur.entity.Operation;
import com.example.projetcoiffeur.entity.enumeration.TypeCompte;

public interface OperationEJBInterface extends GenericEJBInterface<Operation>{

	public List<Operation> findAll(Date dateDebut, Date dateFin);
	
	public double getMontantByTypeAndPeriod(TypeCompte type, Date dateDebut, Date dateFin);
}
