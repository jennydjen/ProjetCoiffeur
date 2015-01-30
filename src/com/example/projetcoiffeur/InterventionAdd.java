package com.example.projetcoiffeur;

import javax.inject.Inject;

import com.example.projetcoiffeur.EJB.interfaces.ClientEJBInterface;
import com.example.projetcoiffeur.EJB.interfaces.InterventionEJBInterface;
import com.example.projetcoiffeur.entity.Intervention;
import com.example.projetcoiffeur.entity.enumeration.State_Intervention;
import com.example.projetcoiffeur.entity.enumeration.Type_Paiement;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

@CDIView(value="InterventionAdd")
public class InterventionAdd extends CustomComponent implements View {
	
	@Inject
	public InterventionAdd(InterventionEJBInterface ejbIntervention, ClientEJBInterface clientejb ){
		
		FormLayout layout = new FormLayout();
		layout.setMargin(true);
		setCompositionRoot(layout);
		Label lab = new Label("<h2>Ajout d'une intervention</h2>", ContentMode.HTML);
		layout.addComponent(lab);	
		
		TextField textCommentaire = new TextField("Commentaire");
		layout.addComponent(textCommentaire);
		
		Label labelDu = new Label("Date Intervention:");
		layout.addComponent(labelDu);
		
		PopupDateField dateintervention = new PopupDateField("Date :");
		layout.addComponent(dateintervention);
		
		ComboBox comboetat = new ComboBox();
		comboetat.addItem(State_Intervention.A_FAIRE);
		comboetat.addItem(State_Intervention.ANNULE);
		comboetat.addItem(State_Intervention.FAIT);
		layout.addComponent(comboetat);
		
		ComboBox comboTypePai = new ComboBox();
		comboTypePai.addItem(Type_Paiement.CARTE_BANCAIRE);
		comboTypePai.addItem(Type_Paiement.CHEQUE);
		comboTypePai.addItem(Type_Paiement.LIQUIDE);
		layout.addComponent(comboTypePai);
		
		ComboBox comboClient = new ComboBox();
		comboClient.addItems(clientejb.findAllContact());
		layout.addComponent(comboClient);
		
		Button buttonAdd = new Button("Ajouter");
		layout.addComponent(buttonAdd);
		
		buttonAdd.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					Intervention intervention = new Intervention();
					intervention.setCommentaire(textCommentaire.getValue());
					intervention.setDate_intervention(dateintervention.getValue());
					intervention.setEtat((State_Intervention) comboetat.getValue());
					intervention.setPaiement((Type_Paiement) comboTypePai.getValue());

					ejbIntervention.create(intervention);
					Notification.show("Intervention Ajouté Correctement !", Type.TRAY_NOTIFICATION);
					UI.getCurrent().getNavigator().navigateTo("InterventionList");
					
				}catch (Exception e) {
					
				}
			}		
			
		});
		
		Button buttonAnnule = new Button("Annuler");
		layout.addComponent(buttonAnnule);
		
		buttonAnnule.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				UI.getCurrent().getNavigator().navigateTo("interventionList");
			}
		});
		
		
		
		
		
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
