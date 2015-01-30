package com.example.projetcoiffeur;

import com.vaadin.data.Container;
import com.vaadin.ui.Table;

public class InterventionTable extends Table{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InterventionTable(Container container){
		this.setContainerDataSource(container);
	}
	

}
