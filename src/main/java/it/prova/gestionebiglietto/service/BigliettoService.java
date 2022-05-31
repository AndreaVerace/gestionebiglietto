package it.prova.gestionebiglietto.service;

import java.util.List;

import it.prova.gestionebiglietto.dao.BigliettoDAO;
import it.prova.gestionebiglietto.model.Biglietto;



public interface BigliettoService {

	public void setBigliettoDao(BigliettoDAO bigliettoDAO);

	public List<Biglietto> listAll() throws Exception;

	public Biglietto caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Biglietto input) throws Exception;

	public void inserisciNuovo(Biglietto input) throws Exception;

	public void rimuovi(Biglietto input) throws Exception;

	public List<Biglietto> findByExample(Biglietto input) throws Exception;
}
