package it.prova.gestionebiglietto.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebiglietto.model.Biglietto;



public class UtilityBigliettoForm {

	public static Biglietto createBigliettoFromParams(String provenienzaInputParam, String destinazioneInputParam,
			String prezzoInputStringParam, String dataStringParam) {

		Biglietto result = new Biglietto(provenienzaInputParam, destinazioneInputParam);

		if (NumberUtils.isCreatable(prezzoInputStringParam)) {
			result.setPrezzo(Integer.parseInt(prezzoInputStringParam));
		}
		result.setData(parseDateFromString(dataStringParam));

		return result;
	}

	public static boolean validateBigliettooBean(Biglietto articoloToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(articoloToBeValidated.getProvenienza())
				|| StringUtils.isBlank(articoloToBeValidated.getDestinazione())
				|| articoloToBeValidated.getPrezzo() == null 
				|| articoloToBeValidated.getPrezzo() < 1
				|| articoloToBeValidated.getData() == null) {
			return false;
		}
		return true;
	}

	public static Date parseDateFromString(String dataStringParam) {
		if (StringUtils.isBlank(dataStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataStringParam);
		} catch (ParseException e) {
			return null;
		}
	}
}
