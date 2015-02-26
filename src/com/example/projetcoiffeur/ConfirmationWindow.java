package com.example.projetcoiffeur;

import com.example.projetcoiffeur.EJB.interfaces.GenericEJBInterface;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public class ConfirmationWindow extends Window {
	
	private static final long serialVersionUID = 1L;

	public ConfirmationWindow(String custom, GenericEJBInterface<?> ejb, long id) {
		setWidth(450.0f, Unit.PIXELS);
		setModal(true);
		setResizable(false);
		
		final FormLayout content = new FormLayout();
		HorizontalLayout buttonLayout = new HorizontalLayout();
		
		Label label = new Label("Etes-vous sur de vouloir supprimer " + custom + " ?");
		content.addComponent(label);
		
		Button buttonOui = new Button("Oui");
		buttonOui.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				ejb.delete(id);				
				close();
			}
		});
		Button buttonNon = new Button("Non");
		buttonNon.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				close();
			}
		});
		
		buttonLayout.addComponent(buttonOui);
		buttonLayout.addComponent(buttonNon);		
		
		content.addComponent(buttonLayout);
		setContent(content);
		
		setVisible(true);
	}
}
