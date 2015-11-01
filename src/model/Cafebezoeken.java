package model;

import java.util.ArrayList;

/**
 * @Autor: Isaak Malik, Michal Mitkowsky
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Lijst van cafébezoeken met alle gegevens
 */
public class Cafebezoeken {

	protected static ArrayList<Cafebezoek> cafebezoeken = new ArrayList<Cafebezoek>();
	
	/**
	 * 
	 * @param cafebezoek
	 */
	public static void toevoegen(Cafebezoek cafebezoek)
	{
		cafebezoeken.add(cafebezoek);
	}
}
