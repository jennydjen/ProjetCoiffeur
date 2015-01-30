package com.example.projetcoiffeur;

import java.util.Iterator;

import com.example.projetcoiffeur.entity.Client;
import com.vaadin.data.Container;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Table;

public class ClientTable extends Table {

	public ClientTable(Container container){
		/*this.addContainerProperty("Actions", Button.class, null);
		for(Client client: ){
			Integer itemId = i;
			
			Button detail = new Button("Détail");
			detail.setData(itemId);
			
			this.addItem(new Object[]{detail}, itemId);
		}
		container.*/
		this.setContainerDataSource(container);
		/*
		for(Iterator i = this.getItemIds().iterator();i.hasNext();){
			int iid =(Integer) i.next();
			
			Client client = (Client) this.getItem(iid);
		
			
		}*/
		
		
	}
}
