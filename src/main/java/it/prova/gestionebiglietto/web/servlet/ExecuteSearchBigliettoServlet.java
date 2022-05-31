package it.prova.gestionebiglietto.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebiglietto.model.Biglietto;
import it.prova.gestionebiglietto.service.MyServiceFactory;
import it.prova.gestionebiglietto.utility.UtilityBigliettoForm;


@WebServlet("/ExecuteSearchBigliettoServlet")
public class ExecuteSearchBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String provenienzaInput = request.getParameter("provenienza");
		String destinazioneInput = request.getParameter("destinazione");
		String prezzoInput = request.getParameter("prezzo");
		String dataInput = request.getParameter("data");
		
		Biglietto bigliettoInstance = UtilityBigliettoForm
				.createBigliettoFromParams(provenienzaInput, destinazioneInput, prezzoInput, dataInput);
		
		try {
			request.setAttribute("listaBigliettiAttribute", MyServiceFactory.getBigliettoServiceInstance()
					.findByExample(bigliettoInstance));
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
