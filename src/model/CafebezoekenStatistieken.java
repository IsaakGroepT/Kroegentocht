package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Autor: Isaak Malik, Michal Mitkowsky
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Gegevens extraheren van cafébezoek objecten uit cafébezoeken
 */
public class CafebezoekenStatistieken extends CafebezoekLijst {

	/**
	 * 
	 * @return
	 */
	public static int totaalAantal()
	{
		return Cafebezoeken.size();
	}
	
	/**
	 * 
	 * @return
	 */
	public Cafebezoek langsteCafebezoek()
	{
		Cafebezoek huidigeLangsteCafebezoek = null;
		
		for (int n = 0; n < cafebezoeken.size(); n++)
		{
			if (huidigeLangsteCafebezoek == null || 
					huidigeLangsteCafebezoek.getTotaleTijdVanBezoek() < 
					cafebezoeken.get(n).getTotaleTijdVanBezoek())
			{
				huidigeLangsteCafebezoek = cafebezoeken.get(n);
			}
		}
		return huidigeLangsteCafebezoek;
	}
	
	/**
	 * 
	 * @param cafe
	 * @return
	 */
	public int gemiddeldAantalConsumptiesPerCafe(Cafe cafe)
	{
		int aantalBezoeken = 0;
		int aantalConsumpties = 0;
		
		for (int n = 0; n < cafebezoeken.size(); n++)
		{
			if (cafe == cafebezoeken.get(n).getCafe())
			{
				aantalBezoeken++;
				aantalConsumpties += cafebezoeken.get(n).getAantalConsumpties();
			}
		}
		return aantalConsumpties / aantalBezoeken;
	}
	
	/**
	 * 
	 * @param minDatum
	 * @param maxDatum
	 * @return
	 */
	public int aantalConsumptiesPerPeriode(Date minDatum, Date maxDatum)
	{
		int aantalConsumpties = 0;
		
		for (int n = 0; n < cafebezoeken.size(); n++)
		{
			aantalConsumpties += cafebezoeken.get(n).getAantalConsumpties();
		}
		return aantalConsumpties;
	}
	
	/**
	 * 
	 * @param minDatum
	 * @param maxDatum
	 * @return
	 */
	public int aantalMinutenVolgensPeriode(Date minDatum, Date maxDatum)
	{
		int tijd = 0;
		
		for (int n = 0; n < cafebezoeken.size(); n++)
		{
			tijd += cafebezoeken.get(n).getTotaleTijdVanBezoek();
		}
		return (int) TimeUnit.MILLISECONDS.toMinutes(tijd);
	}
	
	/**
	 * 
	 * @param minDatum
	 * @param maxDatum
	 * @return
	 */
	public ArrayList<Cafebezoek> aantalCafebezoekenVolgensPeriode(Date minDatum, Date maxDatum)
	{
		ArrayList<Cafebezoek> gefilterdeCafebezoeken = new ArrayList<Cafebezoek>();
		
		for (int n = 0; n < cafebezoeken.size(); n++)
		{
			if (cafebezoeken.get(n).getBeginTijd().after(minDatum) && 
					cafebezoeken.get(n).getEindTijd().before(maxDatum))
			{
				gefilterdeCafebezoeken.add(cafebezoeken.get(n));
			}
		}
		
		return gefilterdeCafebezoeken;
	}
}
