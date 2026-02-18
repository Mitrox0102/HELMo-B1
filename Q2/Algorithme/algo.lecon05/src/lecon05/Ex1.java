package lecon05;

import util.Contract;

public class Ex1 {

	/*
	 * INIT : 2 op
	 * GARDIEN : 3 op
	 * CORPS : 3/4 op
	 * FIN : 1 op
	 */
	
	public static int recherche(int[] entiers, int v) {
		
		Contract.require(entiers != null, "");
		
		int r = -1;
		
		for (int i = 0; i < entiers.length; i++) {
			if (entiers[i] == r)
					r = i;
		}
		
		return r;
	}
	
}
