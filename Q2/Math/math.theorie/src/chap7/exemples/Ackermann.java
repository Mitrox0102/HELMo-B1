package chap7.exemples;

/**
 * Fonction d'Ackermann.
 * 
 * @author François Schumacker
 */

public class Ackermann {
    /**
     * Calcule la valeur de la fonction d'Ackermann.
     *
     * @param m Premier paramètre
     * @param n Deuxième paramètre
     * @return ackermann(m, n)
     */
	public static int ackermann(int m, int n) {
		
		incrCpt(); // comptage du nombre d'appels récursifs
		
		if (m < 0 || n < 0) {
			throw new IllegalArgumentException("Arguments invalides");
		}
		
		if (m == 0) {
			return n + 1;
		} else if (n == 0) {
			return ackermann(m - 1, 1);
		} else {
			return ackermann(m - 1, ackermann(m, n - 1));
		}
	}

	public static void main(String[] args) {
		cpt = 0;
		System.out.println("ack(0,0) = " + ackermann(0, 0) + " [" + cpt + " appels récursifs]");
		cpt = 0;
		System.out.println("ack(0,2) = " + ackermann(0, 2) + " [" + cpt + " appels récursifs]");
		cpt = 0;
		System.out.println("ack(1,0) = " + ackermann(1, 0) + " [" + cpt + " appels récursifs]");
		cpt = 0;
		System.out.println("ack(1,1) = " + ackermann(1, 1) + " [" + cpt + " appels récursifs]");
		cpt = 0;
		System.out.println("ack(2,0) = " + ackermann(2, 0) + " [" + cpt + " appels récursifs]");
		cpt = 0;
		System.out.println("ack(4,0) = " + ackermann(4, 0) + " [" + cpt + " appels récursifs]");
		cpt = 0;
		System.out.println("ack(2,1) = " + ackermann(2, 1) + " [" + cpt + " appels récursifs]");
		cpt = 0;
		System.out.println("ack(3,1) = " + ackermann(3, 1) + " [" + cpt + " appels récursifs]");
		cpt = 0;
		System.out.println("ack(3,2) = " + ackermann(3, 2) + " [" + cpt + " appels récursifs]");
		cpt = 0;
		System.out.println("ack(3,5) = " + ackermann(3, 5) + " [" + cpt + " appels récursifs]");
		cpt = 0;
		System.out.println("ack(4,1) = " + ackermann(4, 1) + " [" + cpt + " appels récursifs]");
	}

	private static long cpt = 0;

	private static void incrCpt() {
		cpt++;
		if ((cpt & 0x3FFFFFFF) == 0) {           // affiche cpt lorsqu'il est multiple de 2^30 -> 1 073 741 824 incréments
			System.out.println("CPT = " + cpt);
		}
	}
}
