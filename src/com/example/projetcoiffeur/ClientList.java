package com.example.projetcoiffeur;

import java.util.List;

import javax.inject.Inject;

import org.vaadin.data.collectioncontainer.CollectionContainer;

import com.example.projetcoiffeur.EJB.ClientEJB;
import com.example.projetcoiffeur.EJB.interfaces.ClientEJBInterface;
import com.example.projetcoiffeur.entity.Client;
import com.google.gwt.i18n.client.Messages.Example;
import com.google.gwt.user.client.ui.Grid;
import com.vaadin.cdi.CDIView;
import com.vaadin.data.Container;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ClientConnector;
import com.vaadin.server.ClientConnector.AttachEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
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
		HorizontalLayout HLayout = new HorizontalLayout();
		this.setCompositionRoot(mainLayout);
		MenuView sample = new MenuView();
		
		MenuBar menu = sample.getMenu();
		mainLayout.addComponent(menu);
		
		
	    Label lab = new Label("Ecran des clients");
		mainLayout.addComponent(lab);
		
		Button button = new Button("Ajouter Nouveau Client");		
		HLayout.addComponent(button);
		
		button.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				
				UI.getCurrent().getNavigator().navigateTo("clientAdd");
			}
		});
		Button buttonSuppr = new Button("Activer/Désactiver client");		
		HLayout.addComponent(buttonSuppr);
		
		buttonSuppr.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				long idTable = ((Client) clientTable.getValue()).getId();
				//System.out.println(idTable);
				ConfirmationWindow window = new ConfirmationWindow("L'utilisateur", clientService, idTable);
				getUI().addWindow(window);
				window.setVisible(true);
				
			}
		});
		buttonSuppr.setEnabled(false);
		
		Button ModifButton = new Button("Modifier Client");		
		HLayout.addComponent(ModifButton);
		ModifButton.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				long idTable = ((Client) clientTable.getValue()).getId();
				//System.out.println(idTable);
				ClientUpdate update = new ClientUpdate( clientService, idTable);
				getUI().addWindow(update);
				update.setVisible(true);
				
				
			}
		});
		ModifButton.setEnabled(false);
		
		mainLayout.addComponent(HLayout);
		List<Client> clients = clientService.findAllContact();
		
		clientTable = new ClientTable(CollectionContainer.fromBeans(clients));
		clientTable.setSelectable(true);

		clientTable.addValueChangeListener(new ValueChangeListener() {
			@Override
			public void valueChange(final ValueChangeEvent event) {
				if(clientTable.getValue() != null){
					buttonSuppr.setEnabled(true);
					ModifButton.setEnabled(true);
				}else{
					buttonSuppr.setEnabled(false);
					ModifButton.setEnabled(false);
				}
			}
			});
		//selection des colonnes visibles
		clientTable.setVisibleColumns(new Object[]{"name","prenom","adresse","telephone"});
		clientTable.setColumnHeaders(new String[]{"Nom","Prenom","Adresse","Telephone"});
		
		
		for (Component client : clientTable) {
			System.out.println(client.isVisible());
			if(((Client) client).isInactif()){
				
				//System.out.println(((Client) client).isInactif());
				client.setVisible(false);
				
			}else{
				client.setVisible(true);
			}
		}
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
