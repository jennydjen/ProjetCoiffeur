package com.example.projetcoiffeur.DAO.interfaces;

import java.util.Date;
import java.util.List;

import com.example.projetcoiffeur.entity.Operation;
import com.example.projetcoiffeur.entity.enumeration.TypeCompte;

public interface OperationDAOInterface extends GenericDAO<Operation>{
	
	public List<Operation> findAll(Date dateDebut, Date dateFin);
	
	public double getMontantByTypeAndPeriod(TypeCompte type, Date dateDebut, Date dateFin);
}
