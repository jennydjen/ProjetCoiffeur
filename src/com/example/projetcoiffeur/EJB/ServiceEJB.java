package com.example.projetcoiffeur.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.example.projetcoiffeur.DAO.interfaces.ServiceDAOInterface;
import com.example.projetcoiffeur.EJB.interfaces.ServiceEJBInterface;
import com.example.projetcoiffeur.entity.Service;


@Stateless
public class ServiceEJB implements ServiceEJBInterface{
	@Inject
	private ServiceDAOInterface serviceDAO;
	
	@Override
	public Service create(Service t) {
		// TODO Auto-generated method stub
		return serviceDAO.create(t);
	}

	@Override
	public Service update(Service t) {
		// TODO Auto-generated method stub
		return serviceDAO.update(t);
	}

	@Override
	public Service find(long id) {
		// TODO Auto-generated method stub
		return serviceDAO.find(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ChangementEtatService(Long id) {
		// TODO Auto-generated method stub
		serviceDAO.ChangementEtatService(id);
	}

	@Override
	public List<Service> findAllService() {
		// TODO Auto-generated method stub
		return serviceDAO.findAllService();
	}

}
