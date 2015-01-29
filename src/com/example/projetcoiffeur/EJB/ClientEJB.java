package com.example.projetcoiffeur.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.example.projetcoiffeur.DAO.interfaces.ClientDAOInteface;
import com.example.projetcoiffeur.EJB.interfaces.ClientEJBInterface;
import com.example.projetcoiffeur.entity.Client;

@Stateless
public class ClientEJB implements ClientEJBInterface {
	@Inject
	private ClientDAOInteface clientDAO;

	@Override
	public Client create(Client t) {
		// TODO Auto-generated method stub
		return clientDAO.create(t);
	}

	@Override
	public Client find(long id) {
		// TODO Auto-generated method stub
		return clientDAO.find(id);
	}

	@Override
	public Client update(Client t) {
		// TODO Auto-generated method stub
		return clientDAO.update(t);
	}
	
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changementEtatClient(long id) {
		// TODO Auto-generated method stub
		clientDAO.changementEtatClient(id);
	}

	@Override
	public List<Client> findAllContact() {
		// TODO Auto-generated method stub
		return clientDAO.findAllContact();
	}

	

}
