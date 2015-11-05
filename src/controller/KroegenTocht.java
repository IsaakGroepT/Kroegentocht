package controller;

import model.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import view.StartGUI;

/**
 * @Autor: Isaak Malik, Michal Mytkowski
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Cafébezoeken bijhouden om een idee te krijgen van alcoholverslaving
 */
public class KroegenTocht {

	private static final Logger logger = LogManager.getLogger("Kroegentocht");
	
	public static void main(String[] args)
	{
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
		
		setVoorbeelden();
		
		// Lanceer de JavaFX GUI
		logger.info("De GUI is opgestart");
		StartGUI.launch(StartGUI.class, args);
		logger.info("Het programma is beëindigd");
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
