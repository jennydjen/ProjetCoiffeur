package com.example.projetcoiffeur;

import com.example.projetcoiffeur.lib.ContextApplication;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@CDIView (value ="login")
public class LoginView extends CustomComponent implements View{

	public LoginView() {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setCompositionRoot(layout);

		Label labelLogin = new Label("Login");
		layout.addComponent(labelLogin);
		
		TextField textLogin = new TextField();
		layout.addComponent(textLogin);
		
		Label labelPassword = new Label("Mot de passe");
		layout.addComponent(labelPassword);
		
		PasswordField textPassword = new PasswordField();
		layout.addComponent(textPassword);
				
		Button button = new Button("Se connecter");		
		layout.addComponent(button);
		
		Label labelLoginPasswordIncorrect = new Label("Login / Password incorrect");
		labelLoginPasswordIncorrect.setVisible(false);
		layout.addComponent(labelLoginPasswordIncorrect);
		
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				if(textLogin.getValue().equals(ContextApplication.LOGIN) 
						&& textPassword.getValue().equals(ContextApplication.PASSWORD)){
					getUI().getNavigator().navigateTo("clientList");
				} else {
					labelLoginPasswordIncorrect.setVisible(true);
				}
			}
		});
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
