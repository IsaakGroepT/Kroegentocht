package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Adres;
import model.Cafe;
import model.CafeSoort;

/**
 * @Autor: Isaak Malik, Michal Mytkowski
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Cafe testen
 */
public class CafeTest {

	private Cafe cafe;
	private Adres adres;
	
	@Before
	public void setUp()
	{
		Adres adres = new Adres();
		adres.setCity("Brussel");
		adres.setNumber("1A");
		adres.setStreet("Nieuwstraat");
		adres.setPostcode("1000");
		
		cafe = new Cafe("Test cafe", adres, CafeSoort.BRUINE_KROEG);
	}
	
	@Test
	public void test_CafeAdresVergelijking_GeeftZelfdeTerug()
	{
		assertEquals("Brussel", cafe.getCafeAdres().getCity());
		assertEquals("1000", cafe.getCafeAdres().getPostcode());
		assertEquals("Nieuwstraat", cafe.getCafeAdres().getStreet());
		assertEquals("1A", cafe.getCafeAdres().getNumber());
	}
	
	@Test
	public void test_CafeNaamVergelijking_GeeftZelfdeTerug()
	{
		assertEquals("Test cafe", cafe.getCafeNaam());
		assertNotEquals("Test andere", cafe.getCafeNaam());
	}
	
	@Test
	public void test_CafeSoortVergelijking_GeeftZelfdeTerug()
	{
		assertEquals(CafeSoort.BRUINE_KROEG, cafe.getCafeSoort());
	}
}
