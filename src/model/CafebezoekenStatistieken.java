package model;

/**
 * @Autor: Isaak Malik, Michal Mitkowsky
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Gegevens extraheren van caf�bezoek objecten uit caf�bezoeken
 */
public class CafebezoekenStatistieken extends Cafebezoeken {

	/**
	 * 
	 * @return
	 */
	public static int totaalAantal()
	{
		return cafebezoeken.size();
	}
	
	/**
	 * 
	 * @return Object van langste caf�bezoek
	 */
	public Cafebezoek toonLangsteBezoek()
	{
		Cafebezoek langsteCafeBezoek = null;
		long tijdLangsteBezoek = 0;
		long verschilInTijd;
		
		for (int n = 0; n < cafebezoeken.size(); n++)
		{
			verschilInTijd = cafebezoeken.get(n).getTotaleTijdVanBezoek();
			
			if (langsteCafeBezoek != null || tijdLangsteBezoek < verschilInTijd)
			{
				langsteCafeBezoek = cafebezoeken.get(n);
				tijdLangsteBezoek = verschilInTijd;
			}
		}
		return langsteCafeBezoek;
	}
	
	
}
