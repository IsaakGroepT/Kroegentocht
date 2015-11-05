package model;

import java.util.ArrayList;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @Autor: Isaak Malik, Michal Mytkowski
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Lijst van cafébezoeken met alle gegevens
 */
public class CafebezoekLijst {

	protected static ArrayList<Cafebezoek> cafebezoeken = new ArrayList<>();
	private static final Logger logger = LogManager.getLogger("Kroegentocht");
	
	/**
	 * 
	 * @param cafebezoek
	 */
	public static void toevoegen(Cafebezoek cafebezoek)
	{
		cafebezoeken.add(cafebezoek);
		logger.debug("Er is nog een cafebezoek toegevoegd aan de lijst");
	}
	
	/**
	 * Onder anderen voor de JUnit testen
	 * 
	 * @return
	 */
	public static ArrayList<Cafebezoek> getCafebezoeken()
	{
		return cafebezoeken;
	}
}
