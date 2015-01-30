package com.example.projetcoiffeur.EJB;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.example.projetcoiffeur.DAO.interfaces.OperationDAOInterface;
import com.example.projetcoiffeur.EJB.interfaces.OperationEJBInterface;
import com.example.projetcoiffeur.entity.Operation;
import com.example.projetcoiffeur.entity.enumeration.TypeCompte;

@Stateless
public class OperationEJB implements OperationEJBInterface{

	@Inject
	private OperationDAOInterface daoOperation;
	
	@Override
	public Operation create(Operation object) {
		return daoOperation.create(object);
	}

	@Override
	public Operation update(Operation object) {		
		return daoOperation.update(object);
	}

	@Override
	public Operation find(long id) {
		return daoOperation.find(id);
	}

	@Override
	public void delete(long id) {
		daoOperation.delete(id);
	}

	@Override
	public List<Operation> findAll(Date dateDebut, Date dateFin) {
		return daoOperation.findAll(dateDebut, dateFin);
	}

	@Override
	public double getMontantByTypeAndPeriod(TypeCompte type, Date dateDebut,
			Date dateFin) {
		return daoOperation.getMontantByTypeAndPeriod(type, dateDebut, dateFin);
	}	
}