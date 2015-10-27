package model;

import java.util.Date;

/**
 * @Autor: Isaak Malik, Michal dinges
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Cafébezoeken bijhouden om een idee te krijgen van alcoholverslaving
 */
public class Cafebezoek {

	private Date datumBezoek;
	private int aantalConsumpties;
	private Cafe cafe;
	
	/**
	 * Constructor
	 */
	public Cafebezoek(Cafe cafe)
	{
		datumBezoek = new Date();
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
