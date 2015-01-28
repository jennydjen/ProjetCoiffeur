package com.example.projetcoiffeur.DAO;

public interface GenericDAO<T> {
	/**
	 * Créer une valeur dans la table
	 * @param t
	 * @return
	 */
	public T create(T t);
	/**
	 * Mettre à jour la valeur dans la table 
	 * @param t
	 * @return
	 */
	public T update(T t);
	/**
	 * Trouver un champ dans la table
	 * @param id
	 * @return
	 */
	public T find(long id);
	/**
	 * Supprimer un champ dans la table
	 * @param id
	 * @return
	 */
	public void delete(long id);
	
	

}
