package com.example.projetcoiffeur;

import com.example.projetcoiffeur.EJB.interfaces.ClientEJBInterface;
import com.example.projetcoiffeur.EJB.interfaces.InterventionEJBInterface;
import com.example.projetcoiffeur.entity.Intervention;
import com.example.projetcoiffeur.entity.enumeration.State_Intervention;
import com.example.projetcoiffeur.entity.enumeration.Type_Paiement;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;


public class InterventionUpdate extends CustomComponent implements View {

public InterventionUpdate (InterventionEJBInterface ejbIntervention,long id){
	
	FormLayout layout = new FormLayout();
	Intervention intervention = ejbIntervention.find(id);
	
	layout.setMargin(true);
	setCompositionRoot(layout);
	Label lab = new Label("<h2>Modification intervention</h2>", ContentMode.HTML);
	layout.addComponent(lab);	
	
	TextField textCommentaire = new TextField("Commentaire",intervention.getCommentaire());
	layout.addComponent(textCommentaire);
	
	PopupDateField dateintervention = new PopupDateField("Date",intervention.getDate_intervention());
	layout.addComponent(dateintervention);
	
	ComboBox comboetat = new ComboBox("Etat");
	comboetat.addItems(State_Intervention.values());
//	comboetat.addItem(State_Intervention.ANNULE);
//	comboetat.addItem(State_Intervention.FAIT);
	comboetat.setValue(intervention.getEtat());
	layout.addComponent(comboetat);
	
	ComboBox comboTypePai = new ComboBox("Moyen de Paiement");
	comboTypePai.addItem(Type_Paiement.CARTE_BANCAIRE);
	comboTypePai.addItem(Type_Paiement.CHEQUE);
	comboTypePai.addItem(Type_Paiement.LIQUIDE);
	comboTypePai.setValue(intervention.getPaiement());
	
	layout.addComponent(comboTypePai);
	
	
	Button buttonModif = new Button("Modifier");
	layout.addComponent(buttonModif);
	
	buttonModif.addClickListener(new Button.ClickListener() {
		@Override
		public void buttonClick(ClickEvent event) {
			try {
				intervention.setCommentaire(textCommentaire.getValue());
				intervention.setDate_intervention(dateintervention.getValue());
				intervention.setEtat((State_Intervention) comboetat.getValue());
				intervention.setPaiement((Type_Paiement) comboTypePai.getValue());

				ejbIntervention.update(intervention);
				Notification.show("Intervention modifié Correctement !", Type.TRAY_NOTIFICATION);
				UI.getCurrent().getNavigator().navigateTo("interventionList");
				
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

