package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Adres;
import model.Cafe;
import model.CafeSoort;
import model.Cafebezoek;

import model.CafebezoekenStatistieken;

/**
 * @Autor: Isaak Malik, Michal Mitkowsky
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Cafebezoek, Cafebezoeken en CafebezoekenStatistieken testen
 */
public class CafebezoekTest {
	private static Cafebezoek cafebezoek1;
	private static Cafebezoek cafebezoek2;
	private static Cafebezoek cafebezoek3;
	private static Cafe cafe1;
	private static Cafe cafe2;
	private static Cafe cafe3;
	private static boolean setUpGedaan = false;

	@Before
	public void setUp()
	{
		if (!setUpGedaan)
		{
			// Cafés aanmaken, zelfde adres want maakt in deze tests niet uit
			Adres adres = new Adres();
			adres.setCity("Brussel");
			adres.setNumber("1A");
			adres.setStreet("Nieuwstraat");
			adres.setPostcode("1000");
			
			cafe1 = new Cafe("Cafe 1", adres, CafeSoort.BRUINE_KROEG);
			cafe2 = new Cafe("Cafe 2", adres, CafeSoort.STUDENTENCAFE);
			cafe3 = new Cafe("Cafe 3", adres, CafeSoort.CLUB);
			
			cafebezoek1 = new Cafebezoek(cafe1);
			cafebezoek2 = new Cafebezoek(cafe2);
			cafebezoek3 = new Cafebezoek(cafe3);
		}
		// Om te voorkomen dat setUp() voor elke test wordt uitgevoerd
		setUpGedaan = true;
	}
	
	@Test
	public void test_CafebezoekConsumpties_GeeftZelfdeAantalTerug()
	{
		cafebezoek1.verhoogAantalConsumpties();
		
		cafebezoek2.verhoogAantalConsumpties();
		cafebezoek2.verhoogAantalConsumpties();
		cafebezoek2.verhoogAantalConsumpties();
		
		cafebezoek3.verhoogAantalConsumpties();
		cafebezoek3.verhoogAantalConsumpties();
		cafebezoek3.verhoogAantalConsumpties();
		cafebezoek3.verhoogAantalConsumpties();
		cafebezoek3.verhoogAantalConsumpties();
		
		assertEquals(1, cafebezoek1.getAantalConsumpties());
		assertEquals(3, cafebezoek2.getAantalConsumpties());
		assertEquals(5, cafebezoek3.getAantalConsumpties());
	}
	
	@Test
	public void test_CafebezoekCafeObject_GeeftZelfdeTerug()
	{
		assertEquals(cafe1, cafebezoek1.getCafe());
		assertEquals(cafe2, cafebezoek2.getCafe());
		assertEquals(cafe3, cafebezoek3.getCafe());
	}
	
	@Test
	public void test_CafebezoekEnCafebezoekenArray_GeeftZelfdeTerug()
	{
		assertEquals(cafebezoek1, Cafebezoeken.getCafebezoeken().get(0));
		assertEquals(cafebezoek2, Cafebezoeken.getCafebezoeken().get(1));
		assertEquals(cafebezoek3, Cafebezoeken.getCafebezoeken().get(2));
	}
	
	@Test
	public void test_CafebezoekZijnWeOpCafe_GeeftTrue()
	{
		assertTrue(cafebezoek1.zijnWeOpCafe());
		assertTrue(cafebezoek2.zijnWeOpCafe());
		assertTrue(cafebezoek3.zijnWeOpCafe());
	}
	
	@Test
	public void test_CafebezoekEindeZijnWeOpCafeManipulatieMetEindeVanBezoek_GeeftFalse()
	{
		cafebezoek1.eindeVanCafebezoek();
		assertFalse(cafebezoek1.zijnWeOpCafe());
		assertTrue(cafebezoek2.zijnWeOpCafe());
		cafebezoek3.eindeVanCafebezoek();
		assertFalse(cafebezoek3.zijnWeOpCafe());
	}
	
	@Test
	public void test_CafebezoekenStatistiekenTotaalAantal_GeeftAantalTerug()
	{
		assertEquals(3, CafebezoekenStatistieken.totaalAantal());
	}
	
	// TODO: CafebezoekenStatistieken methoden testen
}
