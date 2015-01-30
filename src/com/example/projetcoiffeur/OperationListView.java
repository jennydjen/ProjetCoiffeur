package com.example.projetcoiffeur;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import com.example.projetcoiffeur.EJB.interfaces.OperationEJBInterface;
import com.example.projetcoiffeur.entity.enumeration.TypeCompte;
import com.vaadin.cdi.CDIView;
import com.vaadin.data.Item;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

@CDIView(value = "operationList")
public class OperationListView extends CustomComponent implements View {

	private static final long serialVersionUID = 1L;

	@Inject
	public OperationListView(OperationEJBInterface ejbOperation) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date debutDate = calendar.getTime();
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		Date finDate = calendar.getTime();

		VerticalLayout mainLayout = new VerticalLayout();
		this.setCompositionRoot(mainLayout);

		MenuView sample = new MenuView();
		MenuBar menu = sample.getMenu();
		mainLayout.addComponent(menu);

		Label label = new Label("Compte de résultat");
		mainLayout.addComponent(label);

		HorizontalLayout layoutDate = new HorizontalLayout();
		mainLayout.addComponent(layoutDate);

		Label labelDu = new Label(" Du ");
		layoutDate.addComponent(labelDu);

		PopupDateField datePickerDebut = new PopupDateField();
		datePickerDebut.setValue(debutDate);
		layoutDate.addComponent(datePickerDebut);

		Label labelAu = new Label(" au ");
		layoutDate.addComponent(labelAu);

		PopupDateField datePickerFin = new PopupDateField();
		datePickerFin.setValue(finDate);
		layoutDate.addComponent(datePickerFin);

		Button buttonGenerer = new Button("Générer");
		layoutDate.addComponent(buttonGenerer);

		// Un tableau contenant les types et sommes de toutes les dépenses sur
		// la période données
		Table tableDepense = new Table();
		tableDepense.addContainerProperty("Compte", Integer.class, null);
		tableDepense.addContainerProperty("Intitulé du compte", String.class,
				null);
		tableDepense.addContainerProperty("Montant", Double.class, null);

		for (TypeCompte tp : TypeCompte.getTypeDepenses()) {
			Object newItemId = tableDepense.addItem();
			Item row1 = tableDepense.getItem(newItemId);
			row1.getItemProperty("Compte").setValue(tp.getId_compte());
			row1.getItemProperty("Intitulé du compte").setValue(tp.toString());
			row1.getItemProperty("Montant").setValue(
					ejbOperation.getMontantByTypeAndPeriod(tp, debutDate,
							finDate));
		}

		mainLayout.addComponent(tableDepense);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
