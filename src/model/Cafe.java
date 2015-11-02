package model;

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
	 * @return 
	 */
	public void setCafeNaam(String cafeNaam)
	{
		this.cafeNaam = cafeNaam;
	}
}
