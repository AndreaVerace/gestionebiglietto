package it.prova.gestionebiglietto.service;

import it.prova.gestionebiglietto.dao.BigliettoDAO;
import it.prova.gestionebiglietto.dao.BigliettoDAOImpl;

public class MyServiceFactory {

	// implementiamo il singleton in modo da evitare
	// proliferazione di riferimenti
	private static BigliettoService BIGLIETTO_SERVICE_INSTANCE = null;
	private static BigliettoDAO BIGLIETTO_DAO_INSTANCE = null;

	public static BigliettoService getBigliettoServiceInstance() {
		if (BIGLIETTO_SERVICE_INSTANCE == null)
			BIGLIETTO_SERVICE_INSTANCE = new BigliettoServiceImpl();

		if (BIGLIETTO_DAO_INSTANCE == null)
			BIGLIETTO_DAO_INSTANCE = new BigliettoDAOImpl();

		BIGLIETTO_SERVICE_INSTANCE.setBigliettoDao(BIGLIETTO_DAO_INSTANCE);

		return BIGLIETTO_SERVICE_INSTANCE;
	}

}
