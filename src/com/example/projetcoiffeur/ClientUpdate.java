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
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Window;

public class ClientUpdate  extends Window{

		
	public ClientUpdate(ClientEJBInterface clientService,long id){
		setModal(true);
		setResizable(false);
		FormLayout layout = new FormLayout();
		Client client =clientService.find(id);
		
		layout.setMargin(true);
		
		Label lab = new Label("<h2>Modification client</h2>", ContentMode.HTML);
		layout.addComponent(lab);
		
		
		TextField textName = new TextField("Nom",client.getName());
		layout.addComponent(textName);
		
		TextField textPrenom = new TextField("Prenom",client.getPrenom());
		layout.addComponent(textPrenom);
		
		TextArea textAdresse = new TextArea("Adresse",client.getAdresse());
		layout.addComponent(textAdresse);
		
		TextField textPhone = new TextField("Telephone",client.getTelephone());
		textPhone.setMaxLength(17);
		layout.addComponent(textPhone);
		
		Button button = new Button("Modifier");
		layout.addComponent(button);
		
		button.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				try {
					
					client.setName(textName.getValue());
					client.setPrenom(textPrenom.getValue());
					client.setAdresse(textAdresse.getValue());
					client.setTelephone(textPhone.getValue());
				
					
					clientService.update(client);
					
					Notification.show("Client modifié correctement !", Type.TRAY_NOTIFICATION);
					
					close();
					
					
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
			
				close();
			//	UI.getCurrent().getNavigator().navigateTo("clientList");
			}
		});
		
		
		setContent(layout);
		
		setVisible(true);
		
	}
	
	
	
	
	
}
