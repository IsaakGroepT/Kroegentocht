package model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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
	private static final Logger logger = LogManager.getLogger("Kroegentocht");
	
	/**
	 * 
	 * @param cafe 
	 */
	public Cafebezoek(Cafe cafe)
	{
		// Tijd registreren
		new DatumTijd();
		logger.debug("Tijd begin bezoek: " + getBeginTijd());
		this.cafe = cafe;
		isInCafe = true;
		logger.info("We zijn nu in een café");

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
		logger.info("We hebben het café verlaten");
		logger.debug("Tijd einde bezoek: " + getEindTijd());
	}
}
