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
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
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
		
		/*MenuBar sample = new MenuBar();
		mainLayout.addComponent(sample);
		MenuBar.Command commandList = new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				// TODO Auto-generated method stub
				getUI().getNavigator().navigateTo("clientList");
			}
		};
		MenuBar.Command commandService = new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				// TODO Auto-generated method stub
				getUI().getNavigator().navigateTo("login");
			}
		};
		sample.addItem("Liste Utilisateur", commandList);
		sample.addItem("Login", commandService);*/
		
		
		
		
		/*sample = new TabSheet();
		mainLayout.addComponent(sample);
		sample.setHeight(100.0f, Unit.PERCENTAGE);
		sample.addStyleName(ValoTheme.TABSHEET_FRAMED);
		sample.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
		
	    for (int i = 1; i < 4; i++){
	    	VerticalLayout mainLayoutVert = new VerticalLayout(getTable( clientService));
	    	mainLayoutVert.setMargin(true);
	    	sample.addTab(mainLayoutVert, "Tab des clients"+i);
	    	
	    }*/
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
	
	public ClientTable getTable( ClientEJBInterface clientService){
		VerticalLayout layoutList = new VerticalLayout();
		
		
		return clientTable;
		
	}
	
	

}
