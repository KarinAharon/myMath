package myMath;


 /**
  * The class implement Comparator of Monom
  * @author Mor and Karin
  */

import java.util.Comparator;

public class Monom_Comperator implements Comparator<Monom> {

	/**
	 * This function compare between 2 Monom, if the first Monom smaller then the second Monom return -1, if it bigger return 1, else they equal - return 0
	 * @param arg0 the first Monom
	 * @param arg1 the second Monom
	 */
	
	@Override
	public int compare(Monom arg0, Monom arg1) {

		return arg0.get_power()-arg1.get_power();
	}

}
