package com.example.projetcoiffeur;

import java.util.List;

import javax.inject.Inject;

import org.vaadin.data.collectioncontainer.CollectionContainer;

import com.example.projetcoiffeur.EJB.ClientEJB;
import com.example.projetcoiffeur.EJB.interfaces.ClientEJBInterface;
import com.example.projetcoiffeur.entity.Client;
import com.vaadin.cdi.CDIView;
import com.vaadin.data.Container;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@CDIView ( value ="clientList")
public class ClientList extends CustomComponent implements View{
	
	private static final long serialVersionUID = 1L;

	private ClientTable clientTable;
	
	@Inject
	public ClientList(ClientEJBInterface clientService) {
		VerticalLayout mainLayout = new VerticalLayout();
		this.setCompositionRoot(mainLayout);
		Label lab = new Label("Ecran des clients");
		mainLayout.addComponent(lab);
		
		List<Client> clients = clientService.findAllContact();
		clientTable = new ClientTable(CollectionContainer.fromBeans(clients));
		mainLayout.addComponent(clientTable);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	

}
