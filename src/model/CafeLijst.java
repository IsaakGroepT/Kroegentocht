package model;

import java.util.ArrayList;

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
}
