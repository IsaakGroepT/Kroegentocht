package model;

import java.util.ArrayList;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @Autor: Isaak Malik, Michal Mytkowski
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Hier worden de cafébezoeken bijgehouden in een array
 */
public class CafeLijst {

	private static ArrayList<Cafe> cafes = new ArrayList<>();
	private static final Logger logger = LogManager.getLogger("Kroegentocht");
	
	/**
	 * 
	 * @param cafe
	 */
	public static void toevoegen(Cafe cafe)
	{
		cafes.add(cafe);
	}
	
	/**
	 * 
	 * @return
	 */
	public static ArrayList<Cafe> getCafes()
	{
		return cafes;
	}
	
	/**
	 * 
	 * @return 
	 */
	public static ArrayList<String> getCafeNamen()
	{
		ArrayList<String> cafeLijst = new ArrayList<>();
		
		if (cafes.size() < 0)
		{
			logger.warn("methode CafeLijst.getCafeNamen(): variabele cafes is leeg");
		}

		for(Cafe c : cafes)
		{
			cafeLijst.add(c.getCafeNaam());
		}

		return cafeLijst;
	}

	/**
	 * 
	 * @param cafeNaam
	 * @return 
	 */
	public static Cafe getCafeUitLijst(String cafeNaam)
	{
		Cafe cafe = null;
		
		if (cafes.size() < 0)
		{
			logger.warn("methode CafeLijst.getCafeUitLijst(): variabele cafes is leeg");
		}
		
		for (Cafe c : cafes)
		{
			if (cafeNaam.equals(c.getCafeNaam()))
			{
				cafe = c;
			}
		}
		return cafe;
	}
}