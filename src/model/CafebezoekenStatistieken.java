package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * @Autor: Isaak Malik, Michal Mitkowsky
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Gegevens extraheren van cafébezoek objecten uit cafébezoeken
 */
public class CafebezoekenStatistieken extends Cafebezoeken {

	/**
	 * 
	 * @return
	 */
	public static int totaalAantal()
	{
		return cafebezoeken.size();
	}
	
	/**
	 * 
	 * @return Object van langste cafébezoek
	 */
	public Cafebezoek toonLangsteBezoek()
	{
		Cafebezoek langsteCafeBezoek = null;
		long tijdLangsteBezoek = 0;
		long verschilInTijd;
		
		for (int n = 0; n < cafebezoeken.size(); n++)
		{
			verschilInTijd = cafebezoeken.get(n).getTotaleTijdVanBezoek();
			
			if (langsteCafeBezoek != null || tijdLangsteBezoek < verschilInTijd)
			{
				langsteCafeBezoek = cafebezoeken.get(n);
				tijdLangsteBezoek = verschilInTijd;
			}
		}
		return langsteCafeBezoek;
	}
	
	/**
	 * 
	 * @param datum1
	 * @param datum2 
	 */
	public void laadCafebezoekenVolgensPeriode(Date minDatum, Date maxDatum)
	{
		ArrayList gefilterdeCafebezoeken = new ArrayList();
		DatumTijd huidigeTijd;
		
		for (int n = 0; n < cafebezoeken.size(); n++)
		{
			if (cafebezoeken.get(n).getBeginTijd().after(minDatum) && 
					cafebezoeken.get(n).getEindTijd().before(maxDatum))
			{
				gefilterdeCafebezoeken.add(cafebezoeken.get(n));
			}
		}
	}
}
