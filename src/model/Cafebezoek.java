package model;

/**
 * @Autor: Isaak Malik, Michal Mitkowsky
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Cafébezoeken bijhouden om een idee te krijgen van alcoholverslaving
 */
public class Cafebezoek extends DatumTijd {

	private int aantalConsumpties;
	private Cafe cafe;
	
	/**
	 * 
	 * @param cafe 
	 */
	public Cafebezoek(Cafe cafe)
	{
		// Tijd registreren
		new DatumTijd();
		this.cafe = cafe;

		Cafebezoeken.toevoegen(this);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getAantalConsumpties()
	{
		return aantalConsumpties;
	}
	
	/**
	 * 
	 */
	public void verhoogAantalConsumpties()
	{
		aantalConsumpties++;
	}
}
