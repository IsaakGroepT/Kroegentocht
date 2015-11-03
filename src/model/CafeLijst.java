package model;

import java.util.ArrayList;

/**
 * @Autor: Isaak Malik, Michal Mytkowski
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Hier worden de cafébezoeken bijgehouden in een array
 */
public class CafeLijst {

	private static ArrayList<Cafe> cafes = new ArrayList<Cafe>();
	
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


	public static ArrayList<String> getCafeNamen() {
		ArrayList<String> cafeLijst = new ArrayList<>();

		if (cafes.size() != 0) {
			for(Cafe c : cafes){
				cafeLijst.add(c.getCafeNaam());
			}


		}

		return cafeLijst;


	}

	public static Cafe getCafeUitLijst(String cafeNaam){
		Cafe cafe = null;
		for (Cafe c : cafes){
			if (cafeNaam.equals(c.getCafeNaam())){
				cafe = c;

			}
		}
		return cafe;
	}
}
