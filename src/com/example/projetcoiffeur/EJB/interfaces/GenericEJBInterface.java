package com.example.projetcoiffeur.EJB.interfaces;

/**
 * Interface avec les méthodes communes à tous les EJB
 * @author Jenny
 *
 * @param <T>
 */
public interface GenericEJBInterface<T> {

	/**
	 * Créer une instance de type T
	 * @param object T : L'instance T qu'on veut créer
	 * @return T
	 */
	public T create(T object);

	/**
	 * Mettre à jour une instance de type T
	 * @param object T : l'instance de type T qu'on veut mettre à jour
	 * @return T
	 */
	public T update(T object);

	/**
	 * Trouver une instance de type T selon son ID
	 * @param id long : id de l'instance de type T
	 * @return T
	 */
	public T find(long id);

	/**
	 * Supprimer une instance de type T
	 * @param id long : id de l'instance de type T
	 */
	public void delete(long id);
	
}
