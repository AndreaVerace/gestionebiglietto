package it.prova.gestionebiglietto.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;


import it.prova.gestionebiglietto.model.Biglietto;
import it.prova.gestionebiglietto.service.MyServiceFactory;
import it.prova.gestionebiglietto.utility.UtilityBigliettoForm;

/**
 * Servlet implementation class ExecuteDeleteBigliettoServlet
 */
@WebServlet("/ExecuteDeleteBigliettoServlet")
public class ExecuteDeleteBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idBigliettoParam = request.getParameter("idBiglietto");

		if (!NumberUtils.isCreatable(idBigliettoParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			Biglietto result = MyServiceFactory.getBigliettoServiceInstance().caricaSingoloElemento(Long.parseLong(idBigliettoParam));
			MyServiceFactory.getBigliettoServiceInstance().rimuovi(result);
			request.setAttribute("listaBigliettiAttribute", MyServiceFactory.getBigliettoServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/biglietto/results.jsp").forward(request, response);
		
	}

}
