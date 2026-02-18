package chap7.exemples;

/**
 * Test de parité par récursivité indirecte.
 * 
 */

public class PairImpair {
	/**
	 * Détermine si un nombre naturel est pair.
	 * 
	 * @param n Un nombre naturel
	 * @return true si le nombre est pair
	 */
	public static boolean pair(int n) {
		
		if (n < 0)
			throw new IllegalArgumentException("n doit être positif");
		
//		else if (n == 0)
//			return true;
//		else
//			return impair(n - 1);
		
		return (n == 0) ? true : impair(n - 1);
	}

	/**
	 * Détermine si un nombre naturel est impair.
	 * 
	 * @param n Un nombre naturel
	 * @return true si le nombre est impair
	 */
	public static boolean impair(int n) {
		
		if (n < 0)
			throw new IllegalArgumentException("n doit être positif");
		
//		else if (n == 0)
//			return false;
//		else
//			return pair(n - 1);
		
		return (n == 0) ? false : pair(n - 1);

	}
	

	public static void main(String[] args) {
		
		System.out.println("pair(12) -> " + pair(12));
		System.out.println("pair(15) -> " + pair(15));
		System.out.println("impair(12) -> " + impair(12));
		System.out.println("impair(15) -> " + impair(15));
	}
}
