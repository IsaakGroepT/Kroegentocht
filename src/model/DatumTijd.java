
package model;

import java.util.Date;

/**
 * @Autor: Isaak Malik, Michal Mytkowski
 * @Team: Team29
 * @Date: 25/10/2015
 * @Project: KroegenTocht
 * @Purpose: Tijdregistratie van cafébezoeken
 */
public class DatumTijd {
    
	private Date beginTijd;
	private Date eindTijd;
    
	/**
	 * 
	 */
	public DatumTijd()
	{
		beginTijd = new Date();
	}
    
	/**
	 * 
	 */
	protected void eindeBezoek()
	{
		eindTijd = new Date();
	}
	
	/**
	 * 
	 * @return 
	 */
	public Date getBeginTijd()
	{
		return beginTijd;
	}
	
	/**
	 * 
	 * @return 
	 */
	public Date getEindTijd()
	{
		return eindTijd;
	}

	/**
	 * 
	 * @return 
	 */
	public long getTotaleTijdVanBezoek()
	{
		return eindTijd.getTime() - beginTijd.getTime();
	}
}
