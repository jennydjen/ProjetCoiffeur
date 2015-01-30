package com.example.projetcoiffeur;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.UI;

@CDIView(value="Menu")
public class MenuView extends CustomComponent implements View {

	public MenuBar getMenu(){
		MenuBar sample = new MenuBar();
		MenuBar.Command commandList = new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				// TODO Auto-generated method stub
				UI.getCurrent().getNavigator().navigateTo("clientList");
			}
		};
		MenuBar.Command commandService = new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				// TODO Auto-generated method stub
				UI.getCurrent().getNavigator().navigateTo("serviceList");
			}
		};
		MenuBar.Command InterventionJour = new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				// TODO Auto-generated method stub
				UI.getCurrent().getNavigator().navigateTo("interventionJour");
			}
		};
		
		MenuBar.Command compta = new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				// TODO Auto-generated method stub
				UI.getCurrent().getNavigator().navigateTo("operationList");
			}
		};
		
		MenuBar.Command interventionList = new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				// TODO Auto-generated method stub
				UI.getCurrent().getNavigator().navigateTo("interventionList");
			}
		};
		
		sample.addItem("Interventions du jour", InterventionJour);
		sample.addItem("Liste Interventions", interventionList);
		sample.addItem("Liste Utilisateurs", commandList);
		sample.addItem("Liste Services", commandService);
		sample.addItem("Compte de résultat", compta);	
		
		return sample;
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
