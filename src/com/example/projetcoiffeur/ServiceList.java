package com.example.projetcoiffeur;

import java.util.List;

import javax.inject.Inject;

import org.vaadin.data.collectioncontainer.CollectionContainer;

import com.example.projetcoiffeur.EJB.interfaces.ServiceEJBInterface;
import com.example.projetcoiffeur.entity.Service;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;

@CDIView (value="serviceList")
public class ServiceList extends CustomComponent implements View {
	private static final long SerialVersionUID = 1L;
	
	private ServiceTable serviceTable;
	
	@Inject
	public ServiceList(ServiceEJBInterface serviceListe) {
		VerticalLayout mainLayout = new VerticalLayout();
		this.setCompositionRoot(mainLayout);
		MenuView sample = new MenuView();
		MenuBar menu = sample.getMenu();
		mainLayout.addComponent(menu);
		Label lab = new Label("Ecran des services");
		mainLayout.addComponent(lab);
		
		List<Service> services = serviceListe.findAllService();
		serviceTable = new ServiceTable(CollectionContainer.fromBeans(services));
		mainLayout.addComponent(serviceTable);
	}
	@Override
	public void enter (ViewChangeEvent event){
		
	}
}
