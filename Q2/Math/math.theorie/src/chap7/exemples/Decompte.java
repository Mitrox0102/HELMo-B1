package chap7.exemples;

/**
 * Décompte de N à 0 : N, N-1, ..., 2, 1, 0
 * 
 */

public class Decompte {
	/*
	 * Solution itérative
	 */
	public static void decompteIteratif(int n) {
		
        if (n < 0) {
            throw new IllegalArgumentException("n doit être positif");
        }
        
		for (int i = n; i >= 0; i--) {
			System.out.print(i + " ");
		}
	}

	/*
	 * Solution récursive
	 */
	public static void decompteRecursif(int n) {
		
        if (n < 0) {
            throw new IllegalArgumentException("n doit être positif");
        }
        
		System.out.print(n + " ");
		if (n > 0) {
			decompteRecursif(n - 1);
		}
	}
	
	public static void decompteRecursifVariante(int n) {
		
        if (n < 0) {
            throw new IllegalArgumentException("n doit être positif");
        }
        
		if (n == 0) {  // Cas de base
			System.out.print(n + " ");
		}
		else {         // Cas de propagation
			System.out.print(n + " ");
			decompteRecursifVariante(n - 1);
		}
	}

	public static void main(String[] args) {
		
		System.out.println("--- decompteIteratif(10) ---");
		decompteIteratif(10);
		System.out.println("\n");

		System.out.println("--- decompteRecursif(10) ---");
		decompteRecursif(10);
		System.out.println("\n");
		
		System.out.println("--- decompteRecursifVariante(10) ---");
		decompteRecursifVariante(10);
		
	}
}
