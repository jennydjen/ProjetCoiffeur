package com.example.projetcoiffeur;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

import com.example.projetcoiffeur.lib.ContextApplication;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("projetcoiffeur")
@CDIUI("")
public class AccueilUI extends UI {
	
	@Inject
    private CDIViewProvider viewProvider;
	/*@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = AccueilUI.class)
	public static class Servlet extends VaadinServlet {
	}*/

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		layout.addComponent(horizontalLayout);
		
		//Navigation entre vues
		Navigator navigator = new Navigator(this, horizontalLayout);
		navigator.addProvider(viewProvider);
		
		layout.setMargin(true);
		setContent(layout);

		Label labelLogin = new Label("Login");
		layout.addComponent(labelLogin);
		
		TextField textLogin = new TextField();
		layout.addComponent(textLogin);
		
		Label labelPassword = new Label("Mot de passe");
		layout.addComponent(labelPassword);
		
		PasswordField textPassword = new PasswordField();
		layout.addComponent(textPassword);
				
		Button button = new Button("Se connecter");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				if(textLogin.getValue().equals(ContextApplication.LOGIN) 
						&& textPassword.getValue().equals(ContextApplication.PASSWORD)){
					layout.addComponent(new Label("Login / Password correct"));
					
					
					
					
				}else{
					layout.addComponent(new Label("Login / Password incorrect"));
				}
			}
		});
		layout.addComponent(button);
		navigator.navigateTo("clientList");
	}

}