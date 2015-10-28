package model;

import java.util.ArrayList;

/**
 * @Autor: Isaak Malik, Michal Mitkowsky
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Cafébezoeken met alle gegevens bijhouden in een array
 */
public class Cafebezoeken {

	protected static ArrayList<Cafebezoek> cafebezoeken;
	
	/**
	 * 
	 * @param cafebezoek
	 */
	public static void toevoegen(Cafebezoek cafebezoek)
	{
		cafebezoeken.add(cafebezoek);
	}
}
