package com.example.projetcoiffeur;

import javax.inject.Inject;

import com.example.projetcoiffeur.EJB.interfaces.ClientEJBInterface;
import com.example.projetcoiffeur.entity.Client;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@CDIView(value="clientAdd")
public class ClientAdd extends CustomComponent implements View{

	@Inject
	public ClientAdd(ClientEJBInterface clientService){
		
		FormLayout layout = new FormLayout();
	
		layout.setMargin(true);
		setCompositionRoot(layout);
		Label lab = new Label("<h2>Ajout d'un client</h2>", ContentMode.HTML);
		layout.addComponent(lab);
		
		
		TextField textName = new TextField("Nom");
		layout.addComponent(textName);
		
		TextField textPrenom = new TextField("Prenom");
		layout.addComponent(textPrenom);
		
		TextArea textAdresse = new TextArea("Adresse");
		layout.addComponent(textAdresse);
		
		TextField textPhone = new TextField("Telephone");
		layout.addComponent(textPhone);
		
		Button button = new Button("Ajouter");
		layout.addComponent(button);
		
		button.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				try {
					Client client = new Client();
					client.setName(textName.getValue());
					client.setPrenom(textPrenom.getValue());
					client.setAdresse(textAdresse.getValue());
					client.setTelephone(textPhone.getValue());
					client.setInactif(false);
					
					
					clientService.create(client);
					
					Notification.show("Client Ajouté Correctement !", Type.TRAY_NOTIFICATION);
					
					UI.getCurrent().getNavigator().navigateTo("clientList");
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		Button buttonAnnule = new Button("Annuler");
		layout.addComponent(buttonAnnule);
		
		buttonAnnule.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				UI.getCurrent().getNavigator().navigateTo("clientList");
			}
		});
		
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
