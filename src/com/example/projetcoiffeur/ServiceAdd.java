package com.example.projetcoiffeur;

import javax.inject.Inject;

import com.example.projetcoiffeur.EJB.interfaces.ServiceEJBInterface;
import com.example.projetcoiffeur.entity.Service;
import com.example.projetcoiffeur.entity.enumeration.TypeCompte;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@CDIView(value="serviceAdd")
public class ServiceAdd extends CustomComponent implements View{
	
	@Inject
	public ServiceAdd(ServiceEJBInterface serviceAjout){
		
		FormLayout layout = new FormLayout();
		
		layout.setMargin(true);
		setCompositionRoot(layout);
		Label lab = new Label("<h2>Ajout d'un service</h2>", ContentMode.HTML);
		layout.addComponent(lab);
		
		TextField textDescription = new TextField("Description");
		layout.addComponent(textDescription);
		
		TextField textPrix = new TextField("Prix");
		textPrix.setConverter(Double.class);
		layout.addComponent(textPrix);
		
		ComboBox typeService = new ComboBox("Type de service");
		typeService.addItem(TypeCompte.VENTE_MARCHANDISES);
		typeService.addItem(TypeCompte.VENTE_PRESTATION_SERVICE);
		layout.addComponent(typeService);
		
		
		Button button =new Button("Ajouter");
		layout.addComponent(button);
		
		button.addClickListener(new Button.ClickListener(){
			
			@Override
			public void buttonClick(ClickEvent event){
				
			try{
					Service service = new Service();
					service.setDescription(textDescription.getValue());
					service.setPrix((Double)textPrix.getConvertedValue());
					service.setType_service((TypeCompte) typeService.getValue());
					service.setEtat(false);
					
					serviceAjout.create(service);
					
					Notification.show("Service ajouté correctement!", Type.TRAY_NOTIFICATION);
					
					UI.getCurrent().getNavigator().navigateTo("serviceList");
			} catch (Exception e){
			}
			}	
		});
		
		Button buttonAnnule = new Button("Annuler");
		layout.addComponent(buttonAnnule);
		
		buttonAnnule.addClickListener(new Button.ClickListener(){
			
			@Override
			public void buttonClick(ClickEvent event){
				UI.getCurrent().getNavigator().navigateTo("serviceList");
			}
		});
	}
	
	@Override
	public void enter(ViewChangeEvent event){
		
	}
}
