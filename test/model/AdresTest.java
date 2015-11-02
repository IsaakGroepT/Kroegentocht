package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @Autor: Isaak Malik, Michal Mytkowski
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Adres object testen
 */
public class AdresTest {
	
	private Adres adres;
	
	@Before
	public void setUp()
	{
		adres = new Adres();
	}

	@Test
	public void test_AdresMethoden_GeeftZelfdeTerug()
	{
		adres.setCity("Leuven");
		assertEquals("Leuven", adres.getCity());
		adres.setCity("bxl");
		assertEquals("bxl", adres.getCity());
		
		adres.setStreet("Bondgenotenlaand");
		adres.setNumber("2");
		assertEquals("Bondgenotenlaand", adres.getStreet());
		assertEquals("2", adres.getNumber());
	}
}
