/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Adres;
import model.Cafe;
import model.CafeSoort;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Isaak
 */
public class KroegenTochtFactory {
	
	private static final Logger logger = LogManager.getLogger("Kroegentocht");
	
	public Cafe aanmaken(String cafe)
	{
		Cafe typeCafe = null;
		
		switch (cafe)
		{
			case "kroeg":
				//typeCafe = new BruineKroeg();
				break;
			case "studentencafe":
				//typeCafe = new StudentenCafe();
				break;
			case "brasserie":
				//typeCafe = new Brasserie();
				break;
			case "club":
				//typeCafe = new Club();
				break;
		}
		return typeCafe;
	}
	
	/**
	 * Stel enkele gegevens van adressen en cafes in om te beginnen
	 */
	public static void setVoorbeelden()
	{
		Adres adres1 = new Adres();
		adres1.setStreet("lolstraat");
		adres1.setNumber("4");
		adres1.setCity("Leuven");
		
		Adres adres2 = new Adres();
		adres2.setStreet("brolstraat");
		adres2.setNumber("1");
		adres2.setCity("Leuven");
		
		Adres adres3 = new Adres();
		adres3.setStreet("lrolstraat");
		adres3.setNumber("94");
		adres3.setCity("Leuven");
		
		Adres adres4 = new Adres();
		adres4.setStreet("krolstraat");
		adres4.setNumber("40");
		adres4.setCity("Leuven");
		
		Adres adres5 = new Adres();
		adres5.setStreet("trolstraat");
		adres5.setNumber("100");
		adres5.setCity("Leuven");
		
		Cafe cafe1 = new Cafe("Brasserie kweeni", adres1, CafeSoort.BRASSERIE);
		Cafe cafe2 = new Cafe("Kroeg zuip", adres2, CafeSoort.BRUINE_KROEG);
		Cafe cafe3 = new Cafe("Cafe dumbo", adres3, CafeSoort.STUDENTENCAFE);
		Cafe cafe4 = new Cafe("Club mama", adres4, CafeSoort.CLUB);
		Cafe cafe5 = new Cafe("Club dodo", adres5, CafeSoort.CLUB);
		
		logger.info("De voorbeelden zijn ingesteld");
	}
}
