package com.example.projetcoiffeur;

import javax.inject.Inject;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
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
				
		//Navigation entre vues
		Navigator navigator = new Navigator(this, layout);
		navigator.addProvider(viewProvider);
		
		layout.setMargin(true);
		setContent(layout);

		navigator.navigateTo("login");
	}
}