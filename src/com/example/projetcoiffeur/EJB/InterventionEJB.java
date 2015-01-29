package com.example.projetcoiffeur.EJB;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.example.projetcoiffeur.DAO.interfaces.InterventionDAOInterface;
import com.example.projetcoiffeur.EJB.interfaces.InterventionEJBInterface;
import com.example.projetcoiffeur.entity.Client;
import com.example.projetcoiffeur.entity.Intervention;
import com.example.projetcoiffeur.entity.enumeration.State_Intervention;

@Stateless
public class InterventionEJB implements InterventionEJBInterface{
	
	@Inject
	private InterventionDAOInterface interventionDAO;
	
	@Override
	public Intervention create(Intervention t) {
		// TODO Auto-generated method stub
		return interventionDAO.create(t);
	}

	@Override
	public Intervention find(long id) {
		// TODO Auto-generated method stub
		return interventionDAO.find(id);
	}
	
	@Override
	public Intervention update(Intervention t) {
		// TODO Auto-generated method stub
		return interventionDAO.update(t);
	}
	
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Intervention> findAll() {
		// TODO Auto-generated method stub
		return interventionDAO.findAllIntervention();
	}

	@Override
	public List<Intervention> findOfTheDay(Date date) {
		// TODO Auto-generated method stub
		return interventionDAO.findOfTheDay(date);
	}

	@Override
	public List<Intervention> findAllByClient(Client c) {
		// TODO Auto-generated method stub
		return interventionDAO.findAllByClient(c);
	}

	@Override
	public void setState(long id, State_Intervention state) {
		// TODO Auto-generated method stub
		
	}


}
