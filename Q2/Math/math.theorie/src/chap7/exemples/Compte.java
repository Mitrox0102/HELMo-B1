package chap7.exemples;

/**
 * Compte de 0 à N : 0, 1, 2, ..., N-1, N
 * 
 */

public class Compte {
	/*
	 * Solution itérative
	 */
	public static void compteIteratif(int n) {
		
        if (n < 0) {
            throw new IllegalArgumentException("n doit être positif");
        }
        
		for (int i = 0; i <= n; i++) {
			System.out.print(i + " ");
		}
	}

	/*
	 * Solution récursive 1 - Simuler la boucle for
	 */
	public static void compteRecursif1(int n) {
		
        if (n < 0) {
            throw new IllegalArgumentException("n doit être positif");
        }
        
		compte(0, n); // appel à la fonction auxilliaire en donnant à i la valeur initiale
	}

	private static void compte(int i, int n) {  // fonction auxilliaire
		
		if (i <= n) {
			System.out.print(i + " ");
			compte(i + 1, n);
		}
	}

	/*
	 * Solution récursive 2 - 100% récursive
	 */
	public static void compteRecursif2(int n) {
		
        if (n < 0) {
            throw new IllegalArgumentException("n doit être positif");
        }
        
        if (n > 0) {
			compteRecursif2(n - 1);
		}
		System.out.print(n + " ");
	}
	
	/*
	 * Solution récursive 3 - 100% récursive
	 */
	public static void compteRecursif3(int n) {
		
		if (n < 0) {
            throw new IllegalArgumentException("n doit être positif");
        }
		
		if (n == 0) System.out.print(n + " ");  // Cas de base
		else {
			compteRecursif3(n - 1);             // Cas de propagation
			System.out.print(n + " ");	
		}
	}
	

	public static void main(String[] args) {
		
		System.out.println("--- compteIteratif(10) ---");
		compteIteratif(10);
		System.out.println("\n");

		System.out.println("--- compteRec1(10) --- Simulation boucle ---");
		compteRecursif1(10);
		System.out.println("\n");

		System.out.println("--- compteRec2(10) --- 100% récursif ---");
		compteRecursif2(10);
		System.out.println("\n");
		
		System.out.println("--- compteRec3(10) --- 100% récursif ---");
		compteRecursif3(10);
		
	}
}
