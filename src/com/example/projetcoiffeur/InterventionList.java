package com.example.projetcoiffeur;

import java.util.List;

import javax.inject.Inject;

import org.vaadin.data.collectioncontainer.CollectionContainer;

import com.example.projetcoiffeur.EJB.interfaces.InterventionEJBInterface;
import com.example.projetcoiffeur.entity.Intervention;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;


@CDIView(value="interventionList")
public class InterventionList extends CustomComponent implements View{
	
	private static final long serialVersionUID = 1L;
	
	private InterventionTable interventionTable;
	
	@Inject
	public InterventionList(InterventionEJBInterface ejbIntervention){
		VerticalLayout mainLayout = new VerticalLayout();
		this.setCompositionRoot(mainLayout);
		MenuView sample = new MenuView();
		MenuBar menu = sample.getMenu();
		mainLayout.addComponent(menu);
		Label lab = new Label("Ecran des Interventions");
		mainLayout.addComponent(lab);
		
		List<Intervention> interventions = ejbIntervention.findAll();
		
		interventionTable = new InterventionTable(CollectionContainer.fromBeans(interventions));
		mainLayout.addComponent(interventionTable);
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	

}
