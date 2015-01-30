package com.example.projetcoiffeur;

import java.util.Date;

import javax.inject.Inject;

import com.example.projetcoiffeur.EJB.interfaces.ClientEJBInterface;
import com.example.projetcoiffeur.EJB.interfaces.OperationEJBInterface;
import com.example.projetcoiffeur.entity.Operation;
import com.example.projetcoiffeur.entity.enumeration.TypeCompte;
import com.example.projetcoiffeur.entity.enumeration.Type_Paiement;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@CDIView(value = "ajouterOperation")
public class OperationAddView extends CustomComponent implements View {

	private static final long serialVersionUID = 1L;

	@Inject
	public OperationAddView(OperationEJBInterface ejbOperation, ClientEJBInterface ejbClient) {
		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.setMargin(true);
		this.setCompositionRoot(mainLayout);

		Label title = new Label("Ajouter une opération");
		mainLayout.addComponent(title);
		
		PopupDateField datePicker = new PopupDateField("Date de l'opération");
		datePicker.setValue(new Date());
		mainLayout.addComponent(datePicker);

		ComboBox typeCombo = new ComboBox("Type de l'opération");
		for (TypeCompte tp : TypeCompte.values()) {
			typeCombo.addItem("" + tp.getId_compte() + " - " + tp.toString());
		}
		
		ComboBox clientCombo = new ComboBox("Client");
		clientCombo.addItems(ejbClient.findAllContact());
		mainLayout.addComponent(clientCombo);

		TextField descriptionTextField = new TextField("Description");
		mainLayout.addComponent(descriptionTextField);

		TextField montanTextFied = new TextField("Montant");
		mainLayout.addComponent(montanTextFied);
		
		ComboBox typePaimentCombo = new ComboBox("Type de paiment");
		typePaimentCombo.addItems(Type_Paiement.values());
		mainLayout.addComponent(typePaimentCombo);
		
		Button enregistrerButton = new Button("Enregistrer");
		enregistrerButton.setEnabled(false);
		enregistrerButton.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
				
				/*Operation operation = new Operation();
				operation.setDate(datePicker.getValue());
				operation.setDescription(descriptionTextField.getValue());
				operation.setPaiement();
				operation.setPrix(Double.parseDouble(montanTextFied.getValue()));
				operation.setType(type);
				operation.setNomBanque();
				operation.setClient();
					*/
								
				getUI().getNavigator().navigateTo("operationList");
			}
		});
		mainLayout.addComponent(enregistrerButton);
		
		Button annulerButton = new Button("Annuler");
		annulerButton.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo("operationList");
			}
		});
		mainLayout.addComponent(annulerButton);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
