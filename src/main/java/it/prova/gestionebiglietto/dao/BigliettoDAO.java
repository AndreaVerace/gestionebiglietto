package it.prova.gestionebiglietto.dao;

import java.util.List;

import it.prova.gestionebiglietto.model.Biglietto;

public interface BigliettoDAO extends IBaseDAO<Biglietto> {

	public List<Biglietto> findByExample(Biglietto input) throws Exception;
	
}
