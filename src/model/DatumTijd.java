
package model;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
/**
 * @Autor: Isaak Malik, Michal Mytkowski
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Tijdregistratie van cafébezoeken
 */
public class DatumTijd {
    
	private DateTime beginTijd;
	private DateTime eindTijd;
    
	/**
	 * 
	 */
	public DatumTijd()
	{
		DateTimeZone.setDefault(DateTimeZone.forID("Europe/Brussels"));
		beginTijd = new DateTime();
	}
    
	/**
	 * 
	 */
	protected void eindeBezoek()
	{
		eindTijd = new DateTime();
	}
	
	/**
	 * 
	 * @return 
	 */
	public DateTime getBeginTijd()
	{
		return beginTijd;
	}
	
	/**
	 * 
	 * @return 
	 */
	public DateTime getEindTijd()
	{
		return eindTijd;
	}

	/**
	 * Totale tijd van bezoek in minuten
	 * @return 
	 */
	public long getTotaleTijdVanBezoek()
	{
		Duration duur = new Duration(beginTijd, eindTijd);
		return duur.getStandardMinutes();
	}
}
