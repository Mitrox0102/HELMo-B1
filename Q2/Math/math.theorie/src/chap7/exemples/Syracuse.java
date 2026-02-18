package chap7.exemples;

/**
 * Fonction de Syracuse.
 * 
 * @author François Schumacker
 */

public class Syracuse {
    /**
     * Calcule la valeur de la fonction de Syracuse.
     *
     * @param n Un nombre naturel
     * @return syracuse(n) -> toujours égal à 1
     */
	public static int syracuse(int n) {
		
		cpt++; // comptage du nombre d'appels récursifs
		
		if (n < 0) {
			throw new IllegalArgumentException("n doit être positif");
		}
		if ((n == 0) || (n == 1)) {
			return 1;
		} else if (n % 2 == 0) {
			return syracuse(n / 2);
		} else {
			return syracuse(3 * n + 1);
		}
	}
	

	private static long cpt = 0;

	public static void main(String[] args) {
		
		for (int i = 0; i < 100; i++) {
			cpt = 0;
			System.out.println("syracuse(" + i + ") = " + syracuse(i) + " [" + cpt + " appels récursifs]");
		}
	}
}
