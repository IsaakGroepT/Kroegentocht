package controller;

import model.Adres;
import model.Cafe;
import model.CafeSoort;
import model.Cafebezoek;
import model.CafebezoekenStatistieken;
import view.StartGUI;

/**
 * @Autor: Isaak Malik, Michal Mytkowski
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Cafébezoeken bijhouden om een idee te krijgen van alcoholverslaving
 */
public class KroegenTocht {

	public void KroegenTocht(){setVoorbeelden();}



	
	/**
	 * Stel enkele gegevens van adressen en cafes in om te beginnen
	 */
	public static void setVoorbeelden()
	{
		Adres adres1 = new Adres();
		adres1.setStreet("lolstraat");
		adres1.setNumber("4");
		adres1.setCity("Leuven");
		
		Adres adres2 = new Adres();
		adres1.setStreet("brolstraat");
		adres1.setNumber("1");
		adres1.setCity("Leuven");
		
		Adres adres3 = new Adres();
		adres1.setStreet("lrolstraat");
		adres1.setNumber("94");
		adres1.setCity("Leuven");
		
		Adres adres4 = new Adres();
		adres1.setStreet("krolstraat");
		adres1.setNumber("40");
		adres1.setCity("Leuven");
		
		Adres adres5 = new Adres();
		adres1.setStreet("trolstraat");
		adres1.setNumber("100");
		adres1.setCity("Leuven");
		
		Cafe cafe1 = new Cafe("Brasserie kweeni", adres1, CafeSoort.BRASSERIE);
		Cafe cafe2 = new Cafe("Kroeg zuip", adres2, CafeSoort.BRUINE_KROEG);
		Cafe cafe3 = new Cafe("Cafe dumbo", adres3, CafeSoort.STUDENTENCAFE);
		Cafe cafe4 = new Cafe("Club mama", adres4, CafeSoort.CLUB);
		Cafe cafe5 = new Cafe("Club dodo", adres5, CafeSoort.CLUB);

		/*
		Wanneer deze constructor wordt opgeroepen, start er ook een timer, wat niet de bedoeling is.

		Constructor van Cafebezoek=
		Cafebezoek(cafe){

		new DatumTijd();
		this.cafe = cafe;
		isInCafe = true; -->  in dit geval niet, want het werd pas aangemaakt.

		CafebezoekLijst.toevoegen(this);  ---> moet deze cafe pas niet toegevoegd worden wanneer het ook zijn einddatum weet?
		}

		 */

		Cafebezoek cafebezoek1 = new Cafebezoek(cafe1);


	}
	
	public void toonAantalMinutenBezoekInPeriode()
	{
		
	}
	
	public int toonTotaalBezoeken()
	{
		return CafebezoekenStatistieken.totaalAantal();
	}
	
	public void toonGemiddeldeConsumpties()
	{
		
	}
	
	public void toonLangsteBezoek()
	{
		
	}
}
