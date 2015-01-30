package com.example.projetcoiffeur;

import com.vaadin.data.Container;
import com.vaadin.ui.Table;

public class ServiceTable extends Table{
	
	public ServiceTable(Container container){
		this.setContainerDataSource(container);
	}
}
