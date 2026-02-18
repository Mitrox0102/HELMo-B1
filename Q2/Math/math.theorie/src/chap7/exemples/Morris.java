package chap7.exemples;

/**
 * Fonction de Morris.
 * 
 * @author François Schumacker
 */

public class Morris {
    /**
     * Calcule la valeur de la fonction de Morris.
     *
     * @param m Premier paramètre
     * @param n Deuxième paramètre
     * @return morris(m, n)
     */
	public static int morris(int m, int n) {
		
		if (m < 0 || n < 0) {
			throw new IllegalArgumentException("Arguments invalides");
		}
		
		if (m == 0) {
			return 1;
		} else {
			return morris(m - 1, morris(m, n));
		}
	}

	public static void main(String[] args) {
		System.out.println("morris(0, 1) = " + morris(0, 1));
		System.out.println("morris(0, 2) = " + morris(0, 2));
		System.out.println("morris(0, 123) = " + morris(0, 123));
		System.out.println("morris(1, 0) = " + morris(1, 0));   // StackOverflowError - Récursion infinie !
	}
}
