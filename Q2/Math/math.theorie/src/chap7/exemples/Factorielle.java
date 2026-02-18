package chap7.exemples;

/**
 * Calcul de la factorielle d'un nombre.
 * 
 * Rappel:
 * 
 * 0! = 1  et  ∀𝑛 > 0 : 𝑛! = 1.2. … .(𝑛−1).𝑛
 * 
 */

public class Factorielle {
	
	/**
     * Calcule la factorielle d'un nombre de manière itérative.
     *
     * @param n nombre dont on souhaite calculer la factorielle
     * @return n!
     */
	public static long factorielleIteratif(long n) {
		
		if (n < 0) {
			throw new IllegalArgumentException("n doit être positif");
		}
		
		long fact = 1;
		for (long i = 2; i <= n; i++) {
			fact = fact * i;
		}
		return fact;
	}
	
    /**
     * Calcule la factorielle d'un nombre de manière récursive.
     *
     * @param n nombre dont on souhaite calculer la factorielle
     * @return n!
     */
	public static long factorielleRecursif(long n) {
		
		if (n < 0) {
			throw new IllegalArgumentException("n doit être positif");
		} 
		
/*		else if (n == 0) {
			return 1;
		} 
		else {
			return n * factorielleRecursif(n - 1);
		}
*/		
		return((n == 0) ? 1 : n * factorielleRecursif(n - 1));
	}

	
	public static void main(String[] args) {
		
		long n = 15, ans;
		
		ans = factorielleIteratif(n);
		System.out.println("factorielle itératif de " + n + " : " + ans);
		
		ans = factorielleRecursif(n);
		System.out.println("factorielle récursif de " + n + " : " + ans);

	}
}
