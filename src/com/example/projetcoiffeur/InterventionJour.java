package com.example.projetcoiffeur;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.vaadin.data.collectioncontainer.CollectionContainer;

import com.example.projetcoiffeur.EJB.interfaces.InterventionEJBInterface;
import com.example.projetcoiffeur.entity.Intervention;
import com.example.projetcoiffeur.lib.ContextApplication;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

@CDIView (value ="interventionJour")
public class InterventionJour extends CustomComponent implements View {

	private static final long serialVersionUID = 1L;

	@Inject
	public InterventionJour(InterventionEJBInterface ejbIntervention) {
		Date dateJour = new Date();		
		VerticalLayout mainLayout = new VerticalLayout();
		this.setCompositionRoot(mainLayout);
		MenuView sample = new MenuView();
		
		MenuBar menu = sample.getMenu();
		mainLayout.addComponent(menu);
		
		Label lab = new Label("Intervention du jour (" + ContextApplication.formatDate(dateJour) + ")");
		mainLayout.addComponent(lab);
		
		List<Intervention> interventions = ejbIntervention.findOfTheDay(dateJour);
		
		Table tableInterventionJour = new Table();
		tableInterventionJour.setContainerDataSource(CollectionContainer.fromBeans(interventions));
		mainLayout.addComponent(tableInterventionJour);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
