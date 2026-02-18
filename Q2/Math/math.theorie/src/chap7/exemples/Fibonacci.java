package chap7.exemples;

/**
 * Calcul des termes de la suite de Fibonacci  // avec compteur du nombre d'appels récursifs.
 *
 * @author François Schumacker
 */

public class Fibonacci {
	
    /**
     * Renvoie le terme fib(n) de la suite de Fibonacci.<br>
     * Version récursive (définition mathématique).
     *
     * @param n indice du terme à générer (le premier terme est à 1)
     * @return terme fib(n) de la suite de Fibonacci ( fib(1) = 0; fib(2) = 1; ... )
     */
	public static long fibonacciRecursif(int n) {
		
		cpt++; // comptage du nombre d'appels récursifs

		if (n <= 0) {
			throw new IllegalArgumentException("n doit être strictement positif");
			
		} else if (n <= 2) {
			return n - 1;
		} else {
			return fibonacciRecursif(n - 1) + fibonacciRecursif(n - 2);
		}
	}
    
    /**
     * Renvoie le terme fib(n) de la suite de Fibonacci.<br>
     * Version itérative qui n'utilise pas de tableau.
     *
     * @param n indice du terme à générer (le premier terme est à 1)
     * @return terme fib(n) de la suite de Fibonacci ( fib(1) = 0; fib(2) = 1; ... )
     */
    public static long fibonacciIteratif(int n) {
    	
        long fib = 0;
        
        if (n <= 0) {
            throw new IllegalArgumentException("n doit être strictement positif");
            
        } else if (n <= 2) {
            fib = n - 1;
            
        } else {
        	long fibMoins2 = 0;
        	long fibMoins1 = 1;
	        for (int i = 3; i <= n; i++) {
	            fib = fibMoins1 + fibMoins2;
	            fibMoins2 = fibMoins1;
	            fibMoins1 = fib;
	        }
        }
        
        return fib;
    }

    /**
     * Renvoie le terme fib(n) de la suite de Fibonacci.<br>
     * Version itérative qui utilise un tableau d'entiers
     * comme espace de travail en interne.
     *
     * @param n indice du terme à générer (le premier terme est à 1)
     * @return terme fib(n) de la suite de Fibonacci ( fib(1) = 0; fib(2) = 1; ... )
     */
    public static long fibonacciIteratifAvecTableau(int n) {
    	
    	long fib = 0;
    	
        if (n <= 0) {
            throw new IllegalArgumentException("n doit être strictement positif");
        }
        
        else if (n <= 2) {
            fib = n - 1;
            
        } else {
	        long suite[] = new long[n + 1];
	        suite[0] = 0;
	        suite[1] = 1;
	
	        int i;
	        for (i = 2; i <= n; i++) {
	            suite[i] = suite[i - 1] + suite[i - 2];
	        }
	        fib = suite[n];
        }

        return fib;
    }
       
    /**
     * Renvoie le terme fib(n) de la suite de Fibonacci.<br>
     * Version récursive avec mémorisation.
     *
     * @param n indice du terme à générer (le premier terme est à 1)
     * @return terme fib(n) de la suite de Fibonacci ( fib(1) = 0; fib(2) = 1; ... )
     */
	public static long fibonacciRecursifMemoire(long n, long fib1, long fib2) {
		
		cpt++; // comptage du nombre d'appels récursifs

		if (n <= 0) {
			throw new IllegalArgumentException("n doit être strictement positif");
			
		} else if (n == 1) {
			return fib1;
		} else {
			return fibonacciRecursifMemoire(n - 1, fib2, fib1 + fib2);
		}
	}
    
   

	private static long cpt = 0; 

	public static void main(String[] args) {
		
		long time;
		
		System.out.println("--- Fibonacci Récursif ---");
		for (int i = 1; i <= 45 ; i++) {
			time = System.currentTimeMillis();
			cpt = 0;
			System.out.println("fib("+i+") = " + fibonacciRecursif(i) + " [" + cpt + " appels récursifs]" + " [" + (System.currentTimeMillis()-time) + " ms]");
		}
		System.out.println();
		
		System.out.println("--- Fibonacci Itératif ---");
		time = System.currentTimeMillis();
		System.out.println("fib(1000) = " + fibonacciIteratif(1000) + " [" + (System.currentTimeMillis() - time) + " ms]");
		
		System.out.println();
		
		System.out.println("--- Fibonacci Récursif Mémoire ---");
		for (int i = 1; i <= 45 ; i++) {
			time = System.currentTimeMillis();
			cpt = 0;
			System.out.println("fib("+i+") = " + fibonacciRecursifMemoire(i, 0, 1) + " [" + cpt + " appels récursifs]" + " [" + (System.currentTimeMillis() - time) + " ms]");
		}
		System.out.println();
		time = System.currentTimeMillis();
		System.out.println("fib(1000) = " + fibonacciRecursifMemoire(1000, 0, 1) + " [" + (System.currentTimeMillis() - time) + " ms]");
		
	}
}
