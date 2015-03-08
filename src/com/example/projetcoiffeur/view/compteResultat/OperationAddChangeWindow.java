package com.example.projetcoiffeur.view.compteResultat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.projetcoiffeur.EJB.interfaces.ClientEJBInterface;
import com.example.projetcoiffeur.EJB.interfaces.OperationEJBInterface;
import com.example.projetcoiffeur.entity.Client;
import com.example.projetcoiffeur.entity.Operation;
import com.example.projetcoiffeur.entity.enumeration.TypeCompte;
import com.example.projetcoiffeur.entity.enumeration.Type_Paiement;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification.Type;

public class OperationAddChangeWindow extends Window {

	private static final long serialVersionUID = 1L;
	private Operation myOperation = null;
	private Map<Long, Client> mapClient = new HashMap<Long, Client>();

	public OperationAddChangeWindow(OperationEJBInterface ejbOperation,
			ClientEJBInterface ejbClient, long id) {
		createClientMap(ejbClient);
		
		setWidth(450.0f, Unit.PIXELS);
		setModal(true);

		FormLayout mainLayout = new FormLayout();
		mainLayout.setMargin(true);
		this.setContent(mainLayout);

		Label title = new Label("Ajouter une opération");
		mainLayout.addComponent(title);

		PopupDateField datePicker = new PopupDateField("Date de l'opération");
		datePicker.setRequired(true);
		datePicker.setValue(new Date());
		mainLayout.addComponent(datePicker);

		ComboBox typeCombo = new ComboBox("Type de l'opération");
		typeCombo.setRequired(true);
		typeCombo.addItems(TypeCompte.values());
		mainLayout.addComponent(typeCombo);

		ComboBox clientCombo = new ComboBox("Client");
		clientCombo.setRequired(true);
		clientCombo.addItems(mapClient.values());
		mainLayout.addComponent(clientCombo);

		TextField descriptionTextField = new TextField("Description");
		descriptionTextField.setRequired(true);
		mainLayout.addComponent(descriptionTextField);

		TextField montanTextFied = new TextField("Montant");
		montanTextFied.setRequired(true);
		mainLayout.addComponent(montanTextFied);

		TextField nomBanqueTextField = new TextField("Nom de la banque");
		nomBanqueTextField.setRequired(true);
		nomBanqueTextField.setVisible(false);

		TextField numeroChequeTextField = new TextField("Numéro du chèque");
		numeroChequeTextField.setVisible(false);
		numeroChequeTextField.setRequired(true);

		ComboBox typePaimentCombo = new ComboBox("Type de paiment");
		typePaimentCombo.setRequired(true);
		typePaimentCombo.addItems(Type_Paiement.values());
		typePaimentCombo.addValueChangeListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				if (typePaimentCombo.getValue() == Type_Paiement.CHEQUE) {
					nomBanqueTextField.setVisible(true);
					numeroChequeTextField.setVisible(true);
				} else {
					nomBanqueTextField.setVisible(false);
					numeroChequeTextField.setVisible(false);

				}
			}
		});
		mainLayout.addComponent(typePaimentCombo);

		mainLayout.addComponent(nomBanqueTextField);
		mainLayout.addComponent(numeroChequeTextField);

		HorizontalLayout layoutButton = new HorizontalLayout();

		Button enregistrerButton = new Button("Enregistrer");
		// /enregistrerButton.setEnabled(false);
		enregistrerButton.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				boolean isComplet = true;
				if (datePicker.getValue() == null) {
					isComplet = false;
					datePicker.setInputPrompt("La date est incorrect.");
					datePicker.setComponentError(new UserError(
							"La date est incorrect."));
				} else {
					datePicker.setInputPrompt(null);
					datePicker.setComponentError(null);
				}
				if (descriptionTextField.getValue() == null
						|| descriptionTextField.getValue().replace(" ", "")
								.isEmpty()) {
					isComplet = false;
					descriptionTextField
							.setInputPrompt("La description est incorrecte.");
					descriptionTextField.setComponentError(new UserError(
							"La description est incorrecte."));
				} else {
					descriptionTextField.setInputPrompt(null);
					descriptionTextField.setComponentError(null);
				}
				if (typePaimentCombo.getValue() == null) {
					isComplet = false;
					typePaimentCombo
							.setInputPrompt("Le type de paiment est incorrect.");
					typePaimentCombo.setComponentError(new UserError(
							"Le type de paiment est incorrect."));
				} else {
					typePaimentCombo.setInputPrompt(null);
					typePaimentCombo.setComponentError(null);
					if (typePaimentCombo.getValue() == Type_Paiement.CHEQUE) {
						if (nomBanqueTextField.getValue() == null
								|| nomBanqueTextField.getValue().isEmpty()) {
							isComplet = false;
							nomBanqueTextField
									.setInputPrompt("Le nom de la banque est incorrect.");
							nomBanqueTextField.setComponentError(new UserError(
									"Le nom de la banque est incorrect."));
						} else {
							nomBanqueTextField.setInputPrompt(null);
							nomBanqueTextField.setComponentError(null);
						}
						if (numeroChequeTextField.getValue() == null
								|| numeroChequeTextField.getValue().isEmpty()) {
							isComplet = false;
							numeroChequeTextField
									.setInputPrompt("Le numéro du chèque est incorrect.");
							numeroChequeTextField
									.setComponentError(new UserError(
											"Le numéro du chèque est incorrect."));
						} else {
							numeroChequeTextField.setInputPrompt(null);
							numeroChequeTextField.setComponentError(null);
						}
					} else {
						nomBanqueTextField.setInputPrompt(null);
						nomBanqueTextField.setComponentError(null);
						numeroChequeTextField.setInputPrompt(null);
						numeroChequeTextField.setComponentError(null);
					}
				}
				if (montanTextFied.getValue() == null
						|| montanTextFied.getValue().isEmpty()) {
					isComplet = false;
					montanTextFied.setInputPrompt("Le montant est incorrect.");
					montanTextFied.setComponentError(new UserError(
							"Le montant est incorrect."));
				} else {
					try {
						Double.parseDouble(montanTextFied.getValue());
						montanTextFied.setInputPrompt(null);
						montanTextFied.setComponentError(null);
					} catch (Exception ex) {
						isComplet = false;
						montanTextFied
								.setInputPrompt("Le montant est incorrect.");
						montanTextFied.setComponentError(new UserError(
								"Le montant est incorrect."));
					}
				}
				if (typeCombo.getValue() == null) {
					isComplet = false;
					typeCombo
							.setInputPrompt("Le type de l'opération est incorrect.");
					typeCombo.setComponentError(new UserError(
							"Le type de l'opération est incorrect."));
				} else {
					typeCombo.setInputPrompt(null);
					typeCombo.setComponentError(null);
				}
				if (clientCombo.getValue() == null) {
					isComplet = false;
					clientCombo.setInputPrompt("Le client est incorrect.");
					clientCombo.setComponentError(new UserError(
							"Le client est incorrect."));
				} else {
					clientCombo.setInputPrompt(null);
					clientCombo.setComponentError(null);
				}

				if (isComplet) {
					double montant = Double.parseDouble(montanTextFied
							.getValue());

					if (myOperation == null) {
						Operation operation = new Operation();
						operation.setDate(datePicker.getValue());
						operation.setDescription(descriptionTextField
								.getValue());
						operation.setPaiement((Type_Paiement) typePaimentCombo
								.getValue());
						operation.setPrix(montant);
						operation.setType((TypeCompte) typeCombo.getValue());
						operation.setNomBanque(nomBanqueTextField.getValue());
						operation.setNumeroCheque(numeroChequeTextField
								.getValue());
						operation.setClient((Client) clientCombo.getValue());
						ejbOperation.create(operation);
						Notification.show("Opération correctement ajouté !",
								Type.TRAY_NOTIFICATION);
					} else {
						myOperation.setDate(datePicker.getValue());
						myOperation.setDescription(descriptionTextField
								.getValue());
						myOperation
								.setPaiement((Type_Paiement) typePaimentCombo
										.getValue());
						myOperation.setPrix(montant);
						myOperation.setType((TypeCompte) typeCombo.getValue());
						myOperation.setNomBanque(nomBanqueTextField.getValue());
						myOperation.setNumeroCheque(numeroChequeTextField
								.getValue());
						myOperation.setClient((Client) clientCombo.getValue());
						ejbOperation.update(myOperation);
						Notification.show("Opération correctement modifié !",
								Type.TRAY_NOTIFICATION);
					}
					
					getUI().getNavigator().navigateTo("operationList");
					close();
				}

			}
		});
		layoutButton.addComponent(enregistrerButton);

		Button annulerButton = new Button("Annuler");
		annulerButton.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				close();
			}
		});
		layoutButton.addComponent(annulerButton);

		mainLayout.addComponent(layoutButton);

		if (id > 0) {
			myOperation = ejbOperation.find(id);
			datePicker.setValue(myOperation.getDate());
			descriptionTextField.setValue(myOperation.getDescription());
			typePaimentCombo.setValue(myOperation.getPaiement());
			montanTextFied.setValue("" + myOperation.getPrix());
			typeCombo.setValue(myOperation.getType());
			nomBanqueTextField.setValue(myOperation.getNomBanque());
			numeroChequeTextField.setValue(myOperation.getNumeroCheque());
			clientCombo.setValue(mapClient.get(myOperation.getClient().getId()));
		}
	}
	
	private void createClientMap(ClientEJBInterface ejbClient){
		for(Client client : ejbClient.findAllContact()){
			mapClient.put(client.getId(), client);
		}
	}
}
