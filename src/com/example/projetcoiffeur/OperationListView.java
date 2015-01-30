package com.example.projetcoiffeur;

import javax.inject.Inject;

import com.example.projetcoiffeur.EJB.interfaces.OperationEJBInterface;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.VerticalLayout;

@CDIView (value ="operationList")
public class OperationListView extends CustomComponent implements View{

	private static final long serialVersionUID = 1L;

	@Inject
	public OperationListView(OperationEJBInterface ejbOperation) {
		VerticalLayout mainLayout = new VerticalLayout();
		this.setCompositionRoot(mainLayout);
		
		Label label = new Label("Compte de résultat");
		mainLayout.addComponent(label);
		
		HorizontalLayout layoutDate = new HorizontalLayout();
		mainLayout.addComponent(layoutDate);
		
		Label labelDu = new Label(" Du ");
		layoutDate.addComponent(labelDu);
		
		PopupDateField datePickerDebut = new PopupDateField();
		layoutDate.addComponent(datePickerDebut);
		
		Label labelAu = new Label(" au ");
		layoutDate.addComponent(labelAu);
		
		PopupDateField datePickerFin = new PopupDateField();
		layoutDate.addComponent(datePickerFin);
		
		Button buttonGenerer = new Button("Générer");
		layoutDate.addComponent(buttonGenerer);
		
		
		/*Table tableInterventionJour = new Table();
		tableInterventionJour.setContainerDataSource(CollectionContainer.fromBeans(interventions));
		mainLayout.addComponent(tableInterventionJour);*/
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
