package com.example.projetcoiffeur.view.compteResultat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.vaadin.data.collectioncontainer.CollectionContainer;

import com.example.projetcoiffeur.ConfirmationWindow;
import com.example.projetcoiffeur.MenuView;
import com.example.projetcoiffeur.EJB.interfaces.ClientEJBInterface;
import com.example.projetcoiffeur.EJB.interfaces.OperationEJBInterface;
import com.example.projetcoiffeur.entity.Client;
import com.example.projetcoiffeur.entity.Operation;
import com.example.projetcoiffeur.entity.enumeration.TypeCompte;
import com.example.projetcoiffeur.lib.ContextApplication;
import com.vaadin.cdi.CDIView;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;

@CDIView(value = "operationList")
public class OperationListView extends CustomComponent implements View {

	private static final long serialVersionUID = 1L;
	private Date debutDate, finDate;
	private Table tableDepense, tableRecette, tableResultat, tableOperation;
	private List<Operation> operations;

	@Inject
	public OperationListView(OperationEJBInterface ejbOperation,
			ClientEJBInterface ejbClient) {
		if (debutDate == null && finDate == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			debutDate = calendar.getTime();

			calendar.set(Calendar.DAY_OF_MONTH, 31);
			finDate = calendar.getTime();
		}

		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.setMargin(true);
		this.setCompositionRoot(mainLayout);

		MenuView sample = new MenuView();
		MenuBar menu = sample.getMenu();
		mainLayout.addComponent(menu);

		Label label = new Label("Compte de r�sultat");
		mainLayout.addComponent(label);

		HorizontalLayout layoutDate = new HorizontalLayout();
		mainLayout.addComponent(layoutDate);

		FormLayout layoutDateDebut = new FormLayout();
		layoutDate.addComponent(layoutDateDebut);

		PopupDateField datePickerDebut = new PopupDateField("Du ");
		datePickerDebut.setValue(debutDate);
		layoutDateDebut.addComponent(datePickerDebut);

		FormLayout layoutDateFin = new FormLayout();
		layoutDate.addComponent(layoutDateFin);

		PopupDateField datePickerFin = new PopupDateField(" au ");
		datePickerFin.setValue(finDate);
		layoutDateFin.addComponent(datePickerFin);

		FormLayout layoutBouton = new FormLayout();
		layoutDate.addComponent(layoutBouton);

		Button buttonGenerer = new Button("G�n�rer");
		buttonGenerer.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				debutDate = datePickerDebut.getValue();
				finDate = datePickerFin.getValue();

				updateTableauOngletRecap(ejbOperation);
				updateTableauOngletOperation(ejbOperation);

				getUI().getNavigator().navigateTo("operationList");
			}
		});
		layoutBouton.addComponent(buttonGenerer);

		Button buttonAjouter = new Button("Ajouter op�ration");
		buttonAjouter.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				OperationAddChangeWindow window = new OperationAddChangeWindow(ejbOperation,
						ejbClient,OperationListView.this, -1);
				getUI().addWindow(window);
				window.setVisible(true);
			}
		});
		mainLayout.addComponent(buttonAjouter);

		TabSheet tabSheet = new TabSheet();
		tabSheet.addStyleName(ValoTheme.TABSHEET_FRAMED);
		tabSheet.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);

		tabSheet.addTab(getCompteResultat(ejbOperation, debutDate, finDate),
				"R�cap");
		tabSheet.addTab(
				getTabOperation(ejbOperation, ejbClient, debutDate, finDate),
				"Les op�rations");

		mainLayout.addComponent(tabSheet);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

	private Layout getCompteResultat(OperationEJBInterface ejbOperation,
			Date debutDate, Date finDate) {
		VerticalLayout compteResultatLayout = new VerticalLayout();

		HorizontalLayout depenseRecetteLayout = new HorizontalLayout();

		// Un tableau contenant les types et sommes de toutes les d�penses sur
		// la p�riode donn�es
		tableDepense = new Table("D�penses");
		tableDepense.addContainerProperty("Compte", Integer.class, null);
		tableDepense.addContainerProperty("Intitul� du compte", String.class,
				null);
		tableDepense.addContainerProperty("Montant", Double.class, null);

		depenseRecetteLayout.addComponent(tableDepense);

		tableRecette = new Table("Recettes");
		tableRecette.addContainerProperty("Compte", Integer.class, null);
		tableRecette.addContainerProperty("Intitul� du compte", String.class,
				null);
		tableRecette.addContainerProperty("Montant", Double.class, null);

		depenseRecetteLayout.addComponent(tableRecette);

		compteResultatLayout.addComponent(depenseRecetteLayout);

		tableResultat = new Table("");
		tableResultat.addContainerProperty("Intitul�", String.class, null);
		tableResultat.addContainerProperty("Montant", Double.class, null);
		tableResultat.setHeight(155, Unit.PIXELS);

		compteResultatLayout.addComponent(tableResultat);

		updateTableauOngletRecap(ejbOperation);

		return compteResultatLayout;
	}

	private Component getTabOperation(OperationEJBInterface ejbOperation,
			ClientEJBInterface ejbClient, Date debutDate, Date finDate) {
		VerticalLayout operationLayout = new VerticalLayout();

		HorizontalLayout buttonLayout = new HorizontalLayout();

		Button buttonModifier = new Button("Modifier op�ration");
		buttonModifier.setEnabled(false);
		buttonModifier.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				int indexSelected = (int) tableOperation.getValue() - 1;
				long id = operations.get(indexSelected).getId();
				OperationAddChangeWindow window = new OperationAddChangeWindow(ejbOperation,
						ejbClient,OperationListView.this, id);
				getUI().addWindow(window);
				window.setVisible(true);
			}
		});
		buttonLayout.addComponent(buttonModifier);

		Button buttonSuppression = new Button("Supprimer op�ration");
		buttonSuppression.setEnabled(false);
		buttonSuppression.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				int indexSelected = (int) tableOperation.getValue() - 1;
				long id = operations.get(indexSelected).getId();
				ConfirmationWindow window = new ConfirmationWindow(
						"l'operation", ejbOperation, id);
				getUI().addWindow(window);
				window.setVisible(true);
			}
		});
		buttonLayout.addComponent(buttonSuppression);
		operationLayout.addComponent(buttonLayout);

		tableOperation = new Table();
		tableOperation.addContainerProperty("Code Compta", Integer.class, null);
		tableOperation.addContainerProperty("Date", String.class, null);
		tableOperation.addContainerProperty("Intitul�", String.class, null);
		tableOperation.addContainerProperty("Moyen de paiement", Enum.class,
				null);
		tableOperation.addContainerProperty("N� Facture", String.class, null);
		tableOperation.addContainerProperty("Client", Client.class, null);
		tableOperation.addContainerProperty("D�bit", Double.class, null);
		tableOperation.addContainerProperty("Cr�dit", Double.class, null);
		tableOperation.addValueChangeListener(new ValueChangeListener() {
			@Override
			public void valueChange(final ValueChangeEvent event) {
				if (tableOperation.getValue() != null) {
					buttonSuppression.setEnabled(true);
					buttonModifier.setEnabled(true);
				} else {
					buttonSuppression.setEnabled(false);
					buttonModifier.setEnabled(false);
				}
			}
		});
		tableOperation.setSelectable(true);

		operationLayout.addComponent(tableOperation);

		updateTableauOngletOperation(ejbOperation);

		return operationLayout;
	}
	
	public void refreshPage(OperationEJBInterface ejbOperation){
		updateTableauOngletRecap(ejbOperation);
		updateTableauOngletOperation(ejbOperation);		
	}

	private void updateTableauOngletRecap(OperationEJBInterface ejbOperation) {
		tableDepense.removeAllItems();
		tableRecette.removeAllItems();
		tableResultat.removeAllItems();

		double totalDepense = 0;

		for (TypeCompte tp : TypeCompte.getTypeDepenses()) {
			Object newItemId = tableDepense.addItem();
			Item row1 = tableDepense.getItem(newItemId);
			row1.getItemProperty("Compte").setValue(tp.getId_compte());
			row1.getItemProperty("Intitul� du compte").setValue(tp.toString());
			double depense = ejbOperation.getMontantByTypeAndPeriod(tp,
					debutDate, finDate);
			totalDepense += depense;

			row1.getItemProperty("Montant").setValue(depense);
		}

		double totalRecette = 0;

		for (TypeCompte tp : TypeCompte.getTypeRecettes()) {
			Object newItemId = tableRecette.addItem();
			Item row1 = tableRecette.getItem(newItemId);
			row1.getItemProperty("Compte").setValue(tp.getId_compte());
			row1.getItemProperty("Intitul� du compte").setValue(tp.toString());

			double recette = ejbOperation.getMontantByTypeAndPeriod(tp,
					debutDate, finDate);
			totalRecette += recette;

			row1.getItemProperty("Montant").setValue(recette);
		}

		Object newItemId = tableResultat.addItem();
		Item row1 = tableResultat.getItem(newItemId);
		row1.getItemProperty("Intitul�").setValue("Total des Charges");
		row1.getItemProperty("Montant").setValue(totalDepense);

		newItemId = tableResultat.addItem();
		row1 = tableResultat.getItem(newItemId);
		row1.getItemProperty("Intitul�").setValue("Total des Produits");
		row1.getItemProperty("Montant").setValue(totalRecette);

		newItemId = tableResultat.addItem();
		row1 = tableResultat.getItem(newItemId);
		row1.getItemProperty("Intitul�").setValue("R�sultat de L'exercice");
		row1.getItemProperty("Montant").setValue(totalRecette - totalDepense);
	}

	private void updateTableauOngletOperation(OperationEJBInterface ejbOperation) {
		System.out.println("Remove ALL "+tableOperation.removeAllItems());
		
		operations = ejbOperation.findAll(debutDate, finDate);

		for (Operation o : operations) {
			Object newItemId = tableOperation.addItem();
			Item row1 = tableOperation.getItem(newItemId);
			row1.getItemProperty("Code Compta").setValue(
					o.getType().getId_compte());
			row1.getItemProperty("Date").setValue(
					ContextApplication.formatDate(o.getDate()));
			row1.getItemProperty("Intitul�").setValue(o.getDescription());
			row1.getItemProperty("Moyen de paiement").setValue(o.getPaiement());
			row1.getItemProperty("N� Facture").setValue(o.getNumeroFacture());
			row1.getItemProperty("Client").setValue(o.getClient());
			if (!o.getType().isRecette()) {
				row1.getItemProperty("D�bit").setValue(o.getPrix());
			} else {
				row1.getItemProperty("Cr�dit").setValue(o.getPrix());
			}
		}
	}
}
