package model;

/**
 * @Autor: Isaak Malik, Michal Mytkowski
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Cafébezoeken bijhouden om een idee te krijgen van alcoholverslaving
 */
public class Cafebezoek extends DatumTijd {

	private int aantalConsumpties;
	private Cafe cafe;
	private boolean isInCafe = false;

	public  void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	/**
	 * 
	 * @param cafe 
	 */
	public Cafebezoek(Cafe cafe)
	{
		// Tijd registreren
		new DatumTijd();
		this.cafe = cafe;
		isInCafe = true;

		CafebezoekLijst.toevoegen(this);

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
	
	/**
	 * Geeft de cafe terug die bezocht is
	 * @return
	 */
	public Cafe getCafe()
	{
		return cafe;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean zijnWeOpCafe()
	{
		return isInCafe;
	}
	
	/**
	 * 
	 */
	public void eindeVanCafebezoek()
	{
		eindeBezoek();
		isInCafe = false;
	}
}
