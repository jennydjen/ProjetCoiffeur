package com.example.projetcoiffeur.DAO;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.example.projetcoiffeur.DAO.interfaces.OperationDAOInterface;
import com.example.projetcoiffeur.entity.Operation;
import com.example.projetcoiffeur.entity.enumeration.TypeCompte;

public class OperationDAO implements OperationDAOInterface {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Operation create(Operation t) {
		em.persist(t);
		return t;
	}

	@Override
	public Operation update(Operation t) {
		return em.merge(t);
	}

	@Override
	public Operation find(long id) {
		return em.find(Operation.class, id);
	}

	@Override
	public void delete(long id) {
		em.remove(find(id));
	}

	@Override
	public List<Operation> findAll(Date dateDebut, Date dateFin) {
		TypedQuery<Operation> query = em.createNamedQuery("operation.findAll",
				Operation.class);
		query.setParameter(1, dateDebut);
		query.setParameter(2, dateFin);
		return query.getResultList();
	}

	@Override
	public double getMontantByTypeAndPeriod(TypeCompte type, Date dateDebut,
			Date dateFin) {
		double result = 0;

		TypedQuery<Operation> query = em.createNamedQuery(
				"operation.findByType", Operation.class);
		query.setParameter(1, type);
		query.setParameter(2, dateDebut);
		query.setParameter(3, dateFin);

		List<Operation> operations = query.getResultList();

		for (Operation o : operations) {
			result += o.getPrix();
		}

		return result;
	}
}
