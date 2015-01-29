package com.example.projetcoiffeur;

import com.vaadin.data.Container;
import com.vaadin.ui.Table;

public class ClientTable extends Table {

	public ClientTable(Container container){
		this.setContainerDataSource(container);
	}
}
