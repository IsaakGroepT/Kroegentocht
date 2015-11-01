package testing;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import model.Adres;
import model.Cafe;
import model.CafeSoort;
import model.Cafebezoek;

public class CafebezoekTest {
	private Cafebezoek cafebezoek1;
	private Cafebezoek cafebezoek2;
	private Cafebezoek cafebezoek3;
	private Date cafebezoekDatumOngeveer1;
	private Date cafebezoekDatumOngeveer2;
	private Date cafebezoekDatumOngeveer3;
	private Cafe cafe1;
	private Cafe cafe2;
	private Cafe cafe3;

	@Before
	public void setUp()
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
		cafebezoekDatumOngeveer1 = new Date();
		
		cafebezoek2 = new Cafebezoek(cafe2);
		cafebezoekDatumOngeveer2 = new Date();
		
		cafebezoek3 = new Cafebezoek(cafe3);
		cafebezoekDatumOngeveer3 = new Date();
	}
	
	@Test
	public void test_CafebezoekConsumpties_GeeftAantalTerug()
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
}
