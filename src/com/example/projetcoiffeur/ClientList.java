package com.example.projetcoiffeur;

import java.util.List;

import javax.inject.Inject;

import org.vaadin.data.collectioncontainer.CollectionContainer;

import com.example.projetcoiffeur.EJB.ClientEJB;
import com.example.projetcoiffeur.EJB.interfaces.ClientEJBInterface;
import com.example.projetcoiffeur.entity.Client;
import com.google.gwt.user.client.ui.Grid;
import com.vaadin.cdi.CDIView;
import com.vaadin.data.Container;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ClientConnector;
import com.vaadin.server.ClientConnector.AttachEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.themes.ValoTheme;

@CDIView ( value ="clientList")
public class ClientList extends CustomComponent implements View{
	
	private static final long serialVersionUID = 1L;

	private ClientTable clientTable;

	
	@Inject
	public ClientList(ClientEJBInterface clientService) {
		VerticalLayout mainLayout = new VerticalLayout();
		this.setCompositionRoot(mainLayout);
		MenuView sample = new MenuView();
		
		MenuBar menu = sample.getMenu();
		mainLayout.addComponent(menu);
		
		
	    Label lab = new Label("Ecran des clients");
		mainLayout.addComponent(lab);
		
		Button button = new Button("Ajouter Nouveau Client");		
		mainLayout.addComponent(button);
		
		button.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				UI.getCurrent().getNavigator().navigateTo("clientAdd");
			}
		});
		
		List<Client> clients = clientService.findAllContact();
		clientTable = new ClientTable(CollectionContainer.fromBeans(clients));
	
		/*for(int i=0; i<clientTable.size(); i++){
			Button detail = new Button("Détail");
			
			detail.addClickListener(new Button.ClickListener() {
				
				@Override
				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					Client client = clientService.find(i);
					
					Notification.show(caption);
				}
			});
		}*/
		mainLayout.addComponent(clientTable);
		
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	public ClientTable getTable( ClientEJBInterface clientService){
		VerticalLayout layoutList = new VerticalLayout();
		
		
		return clientTable;
		
	}
	
	

}
