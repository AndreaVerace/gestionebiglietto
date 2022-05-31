package it.prova.gestionebiglietto.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionebiglietto.dao.BigliettoDAO;
import it.prova.gestionebiglietto.model.Biglietto;
import it.prova.gestionebiglietto.web.listener.LocalEntityManagerFactoryListener;

public class BigliettoServiceImpl implements BigliettoService {

	private BigliettoDAO bigliettoDAO;

	public void setBigliettoDao(BigliettoDAO bigliettoDAO) {
		this.bigliettoDAO = bigliettoDAO;

	}

	public List<Biglietto> listAll() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			bigliettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return bigliettoDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	public Biglietto caricaSingoloElemento(Long idInput) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			bigliettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return bigliettoDAO.findOne(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	public void aggiorna(Biglietto input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			bigliettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			bigliettoDAO.update(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	public void inserisciNuovo(Biglietto input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			bigliettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			bigliettoDAO.insert(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	public void rimuovi(Biglietto input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			bigliettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			bigliettoDAO.delete(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	public List<Biglietto> findByExample(Biglietto input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			bigliettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return bigliettoDAO.findByExample(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

}
