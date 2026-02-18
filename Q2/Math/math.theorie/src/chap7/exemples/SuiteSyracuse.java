package chap7.exemples;

import java.util.Scanner;

/**
 * Suite de Syracuse.
 * 
 */

public class SuiteSyracuse {
    /**
     * Calcule et affiche les t premiers termes de la suite de Syracuse.<br>
     * Versdion itérative.
     *
     * @param n un nombre naturel
     * @param t numéro du dernier terme de la suite de Syracuse à afficher
     * @return syracuse(n)
     */
	// Permet de mettre en évidence la présence du "1" et du cycle trivial
    public static void afficherSyracuseIteratif(long n, int t) {
    	
        for (int i = 0; i < t; i++) {
            System.out.print(n + " ");
            n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
        }
    }
    
    /**
     * Calcule et affiche les t premiers termes de la suite de Syracuse.<br>
     * Version récursive.
     *
     * @param n un nombre naturel
     * @param t numéro du dernier terme de la suite de Syracuse à afficher
     * @return syracuse(n)
     */
    public static void afficherSyracuseRecursif(long n, int t) {
        
        if (t == 0) return;
        
        System.out.print(n + " ");

        long termeSuivant;
        if (n % 2 == 0) {
        	termeSuivant = n / 2;
        } else {
        	termeSuivant = 3 * n + 1;
        }
        afficherSyracuseRecursif(termeSuivant, t - 1);
    }
    

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nSuite de Syracuse\n");

        System.out.print("Entrez la valeur initiale : ");
        long n = scanner.nextLong();

        System.out.print("Entrez le nombre de termes : ");
        int t = scanner.nextInt();

        afficherSyracuseIteratif(n, t);
//        System.out.println();
//        afficherSyracuseRecursif(n, t);
     
        scanner.close();
    }
		
}
