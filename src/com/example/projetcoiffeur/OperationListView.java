package com.example.projetcoiffeur;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.vaadin.data.collectioncontainer.CollectionContainer;

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
	private Table tableDepense,tableRecette, tableResultat, tableOperation;
	private List<Operation> operations;
	
	@Inject
	public OperationListView(OperationEJBInterface ejbOperation) {
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

		Label label = new Label("Compte de résultat");
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

		Button buttonGenerer = new Button("Générer");
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

		Button buttonAjouter = new Button("Ajouter opération");
		buttonAjouter.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo("ajouterOperation");
			}
		});
		mainLayout.addComponent(buttonAjouter);

		TabSheet tabSheet = new TabSheet();
		tabSheet.addStyleName(ValoTheme.TABSHEET_FRAMED);
		tabSheet.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);

		tabSheet.addTab(getCompteResultat(ejbOperation, debutDate, finDate),
				"Récap");
		tabSheet.addTab(getTabOperation(ejbOperation, debutDate, finDate),
				"Les opérations");

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

		// Un tableau contenant les types et sommes de toutes les dépenses sur
		// la période données
		tableDepense = new Table("Dépenses");
		tableDepense.addContainerProperty("Compte", Integer.class, null);
		tableDepense.addContainerProperty("Intitulé du compte", String.class,
				null);
		tableDepense.addContainerProperty("Montant", Double.class, null);

		depenseRecetteLayout.addComponent(tableDepense);

		tableRecette = new Table("Recettes");
		tableRecette.addContainerProperty("Compte", Integer.class, null);
		tableRecette.addContainerProperty("Intitulé du compte", String.class,
				null);
		tableRecette.addContainerProperty("Montant", Double.class, null);

		depenseRecetteLayout.addComponent(tableRecette);

		compteResultatLayout.addComponent(depenseRecetteLayout);

		tableResultat = new Table("");
		tableResultat.addContainerProperty("Intitulé", String.class, null);
		tableResultat.addContainerProperty("Montant", Double.class, null);
		tableResultat.setHeight(155, Unit.PIXELS);

		compteResultatLayout.addComponent(tableResultat);

		updateTableauOngletRecap(ejbOperation);
		
		return compteResultatLayout;
	}

	private Component getTabOperation(OperationEJBInterface ejbOperation,
			Date debutDate, Date finDate) {
		VerticalLayout operationLayout = new VerticalLayout();

		Button buttonSuppression = new Button("Supprimer opération");
		buttonSuppression.setEnabled(false);
		buttonSuppression.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				int indexSelected = (int) tableOperation.getValue() - 1;
				long id = operations.get(indexSelected).getId();
				ConfirmationWindow window = new ConfirmationWindow("l'operation", ejbOperation, id);
				getUI().addWindow(window);				
				window.setVisible(true);
			}
		});
		operationLayout.addComponent(buttonSuppression);
		
		tableOperation = new Table();
		tableOperation.addContainerProperty("Code Compta", Integer.class, null);
		tableOperation.addContainerProperty("Date", String.class,
				null);
		tableOperation.addContainerProperty("Intitulé", String.class, null);
		tableOperation.addContainerProperty("Moyen de paiement", Enum.class, null);
		tableOperation.addContainerProperty("N° Facture", String.class, null);
		tableOperation.addContainerProperty("Client", Client.class, null);
		tableOperation.addContainerProperty("Débit", Double.class, null);
		tableOperation.addContainerProperty("Crédit", Double.class, null);
		tableOperation.addValueChangeListener(new ValueChangeListener() {
			@Override
			public void valueChange(final ValueChangeEvent event) {
				if(tableOperation.getValue() != null){
					buttonSuppression.setEnabled(true);
				}else{
					buttonSuppression.setEnabled(false);
				}				
			}
			});
		tableOperation.setSelectable(true);

		operationLayout.addComponent(tableOperation);

		updateTableauOngletOperation(ejbOperation);
		
		return operationLayout;
	}

	private void updateTableauOngletRecap(OperationEJBInterface ejbOperation){
		tableDepense.removeAllItems();
		tableRecette.removeAllItems();
		tableResultat.removeAllItems();
		
		double totalDepense = 0;

		for (TypeCompte tp : TypeCompte.getTypeDepenses()) {
			Object newItemId = tableDepense.addItem();
			Item row1 = tableDepense.getItem(newItemId);
			row1.getItemProperty("Compte").setValue(tp.getId_compte());
			row1.getItemProperty("Intitulé du compte").setValue(tp.toString());
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
			row1.getItemProperty("Intitulé du compte").setValue(tp.toString());

			double recette = ejbOperation.getMontantByTypeAndPeriod(tp,
					debutDate, finDate);
			totalRecette += recette;

			row1.getItemProperty("Montant").setValue(recette);
		}
		
		Object newItemId = tableResultat.addItem();
		Item row1 = tableResultat.getItem(newItemId);
		row1.getItemProperty("Intitulé").setValue("Total des Charges");
		row1.getItemProperty("Montant").setValue(totalDepense);

		newItemId = tableResultat.addItem();
		row1 = tableResultat.getItem(newItemId);
		row1.getItemProperty("Intitulé").setValue("Total des Produits");
		row1.getItemProperty("Montant").setValue(totalRecette);

		newItemId = tableResultat.addItem();
		row1 = tableResultat.getItem(newItemId);
		row1.getItemProperty("Intitulé").setValue("Résultat de L'exercice");
		row1.getItemProperty("Montant").setValue(totalRecette - totalDepense);
	}
	
	private void updateTableauOngletOperation(OperationEJBInterface ejbOperation){
		operations = ejbOperation.findAll(debutDate, finDate);
				
		for (Operation o : operations) {
			Object newItemId = tableOperation.addItem();
			Item row1 = tableOperation.getItem(newItemId);
			row1.getItemProperty("Code Compta").setValue(o.getType().getId_compte());
			row1.getItemProperty("Date").setValue(ContextApplication.formatDate(o.getDate()));
			row1.getItemProperty("Intitulé").setValue(o.getDescription());
			row1.getItemProperty("Moyen de paiement").setValue(o.getPaiement());
			row1.getItemProperty("N° Facture").setValue(o.getNumeroFacture());
			row1.getItemProperty("Client").setValue(o.getClient());
			if(!o.getType().isRecette()){
				row1.getItemProperty("Débit").setValue(o.getPrix());
			}else{
				row1.getItemProperty("Crédit").setValue(o.getPrix());
			}
		}
	}
}
