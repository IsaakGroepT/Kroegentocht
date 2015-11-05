package model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @Autor: Isaak Malik, Michal Mytkowski
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Café gegevens
 */
public class Cafe {

	private Adres cafeAdres;
	private CafeSoort cafeSoort;
	private String cafeNaam;
	private static final Logger logger = LogManager.getLogger("Kroegentocht");
	
	/**
	 * Constructor
	 * 
	 * @param cafeNaam
	 * @param cafeAdres
	 * @param cafeSoort
	 */
	public Cafe(String cafeNaam, Adres cafeAdres, CafeSoort cafeSoort)
	{
		this.cafeAdres = cafeAdres;
		this.cafeSoort = cafeSoort;
		this.cafeNaam = cafeNaam;
		
		//Toevoegen aan lijst
		CafeLijst.toevoegen(this);
		logger.debug("Café toegevoegd: \033[1m" + cafeNaam + "\033[0m met adres:" +
			"\033[1m" + this.toString() + "\033[0m");
	}
	
	/**
	 * 
	 * @return
	 */
	public Adres getCafeAdres()
	{
		return cafeAdres;
	}
	
	/**
	 * 
	 * @param cafeAdres
	 */
	public void setCafeAdres(Adres cafeAdres)
	{
		this.cafeAdres = cafeAdres;
	}
	
	/**
	 * 
	 * @return
	 */
	public CafeSoort getCafeSoort()
	{
		return cafeSoort;
	}
	
	/**
	 * 
	 * @param cafeSoort
	 */
	public void setCafeSoort(CafeSoort cafeSoort)
	{
		this.cafeSoort = cafeSoort;
	}
        
	/**
	 * 
	 * @return 
	 */
	public String getCafeNaam()
	{
		return cafeNaam;
	}
	
	/**
         * 
         * @param cafeNaam 
         */
	public void setCafeNaam(String cafeNaam)
	{
		this.cafeNaam = cafeNaam;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %s, %s", cafeAdres.getStreet(), 
			cafeAdres.getNumber(), cafeAdres.getCity());
	}
}