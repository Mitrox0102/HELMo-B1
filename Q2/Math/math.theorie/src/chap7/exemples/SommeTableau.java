package chap7.exemples;

import java.util.Arrays;

/**
 * Calcul de la somme des éléments d'un tableau à 1 et 2 dimensions.
 * 
 */

public class SommeTableau {
	
	/*
	 * SOMME TABLEAU 1D 
	 */
	
	/*
	 * Tableau 1D - Solution itérative
	 */
	public static double sommeIteratif(double[] tab) {
		double somme = 0.0;
		for (int i = 0; i < tab.length; i++) {
			somme += tab[i];
		}
		return somme;
	}

	
	/*
	 * Tableau 1D - Solution récursive 1 : simuler la boucle 'for'
	 * -> Fonction interne avec 1 paramètre supplémentaire pour 'i'
	 */
	public static double sommeRecursif1(double[] tab) {
		return sommeRecursif1(tab, 0);
	}

	// On calcule la somme du reste du tableau à partir de la position i
	private static double sommeRecursif1(double[] tab, int i) {
		if (i < tab.length) {
			return tab[i] + sommeRecursif1(tab, i + 1);
		} else {
			return 0;
		}
	}	

	
	/*
	 * Tableau 1D - Solution récursive 2 : simuler la boucle 'for'
	 * -> Fonction interne avec 2 paramètres supplémentaires pour 'i' et 'somme'
	 */
	public static double sommeRecursif2(double[] tab) {
		return sommeRecursif2(tab, 0, 0);
	}

	// On accumule les valeurs successives dans 'somme' comme dans la version itérative
	private static double sommeRecursif2(double[] tab, int i, double somme) {
		if (i < tab.length) {
			return sommeRecursif2(tab, i + 1, somme + tab[i]);
		} else {
			return somme;
		}
	}
	
	
	/*
	 * Tableau 1D - Solution récursive 3 : 100% récursive -> réduction progressive du tableau
	 */
	public static double sommeRecursif3(double[] tab) {
		
		if (tab.length == 0) {
			// Le tableau est vide
			return 0;
		} else {
			// Somme 1ère case + somme du reste du tableau
			return tab[0] + sommeRecursif3(Arrays.copyOfRange(tab, 1, tab.length));
		}
	}

	
	/*
	 * Tableau 2D - Solution itérative
	 */
	public static double sommeIteratif(double[][] tab) {
		double somme = 0;
		for (int ligne = 0; ligne < tab.length; ligne++) {
			for (int colonne = 0; colonne < tab[ligne].length; colonne++) {
				somme += tab[ligne][colonne];
			}
		}
		return somme;
	}


	
	/*
	 * SOMME TABLEAU 2D 
	 */
	
	/*
	 * Tableau 2D - Solution récursive 1 : simuler les 2 boucles 'for' imbriquées
	 * -> Fonction interne avec 3 paramètres supplémentaires
	 *    pour 'ligne', 'colonne' et 'somme'
	 */
	public static double sommeRecursif1(double[][] tab) {
		return sommeRecursif1(tab, 0, 0, 0);
	}

	// On accumule les valeurs successives dans 'somme' comme dans la version itérative
	private static double sommeRecursif1(double[][] tab, int ligne, int colonne, double somme) {
		if (ligne < tab.length) {
			if (colonne < tab[ligne].length) {
				return sommeRecursif1(tab, ligne, colonne + 1, somme + tab[ligne][colonne]);
			} else {
				return sommeRecursif1(tab, ligne + 1, 0, somme);
			}
		} else {
			return somme;
		}
	}
	
	/*
	 * Tableau 2D - Solution récursive 2 : simuler les 2 boucles 'for' imbriquées
	 * -> Fonction interne avec seulement 2 paramètres supplémentaires pour 'ligne' et 'colonne'
	 */
	public static double sommeRecursif2(double[][] tab) {
		return sommeRecursif2(tab, 0, 0);
	}

	// On calcule la somme du reste du tableau à partir de la position (ligne, colonne)
	private static double sommeRecursif2(double[][] tab, int ligne, int colonne) {
		if (ligne < tab.length) {
			if (colonne < tab[ligne].length) {
				// On ajoute à la case courante la somme à partir de la colonne suivante
				return tab[ligne][colonne] + sommeRecursif2(tab, ligne, colonne + 1);
			} else {
				// On passe au début de la ligne suivante
				return sommeRecursif2(tab, ligne + 1, 0);
			}
		} else {
			return 0;
		}
	}
	
	/*
	 * Tableau 2D - Solution récursive 3 : réduction progressive du tableau
	 */
	public static double sommeRecursif3(double[][] tab) {
		
		if (tab.length == 0) { // Le tableau est vide
			return 0;
		} else if (tab[0].length != 0) { // La première ligne n'est pas vide
			double value = tab[0][0];
			tab[0] = Arrays.copyOfRange(tab[0], 1, tab[0].length); // On réduit la 1ère ligne d'une case
			return value + sommeRecursif3(tab);
		} else { // La première ligne est vide
			tab = Arrays.copyOfRange(tab, 1, tab.length); // On enlève la 1ère ligne
			return sommeRecursif3(tab);
		}
	}
	
	
	/*
	 * SOMME TABLEAU 2D PAR LIGNES
	 */
	
	/*
	 * Solution itérative
	 */
	public static double sommeParLignesIteratif(double [][] tab) {
		double somme = 0;
		for (int ligne = 0; ligne < tab.length; ligne++) {
			somme += sommeIteratif(tab[ligne]);
		}
		return somme;
	}
	
	/*
	 * Solution récursive 1 : simuler la boucle 'for' sur les lignes
	 * -> Fonction interne avec 2 paramètres supplémentaires pour 'ligne' et 'somme'
	 */
	public static double sommeParLignesRecursif1(double[][] tab) {
		return sommeParLignesRecursif1(tab, 0, 0);
	}

	// On accumule les valeurs successives dans 'somme' comme dans la version itérative
	private static double sommeParLignesRecursif1(double[][] tab, int ligne, double somme) {
		if (ligne < tab.length) {
			return sommeParLignesRecursif1(tab, ligne + 1, somme + sommeRecursif1(tab[ligne]));
		} else {
			return somme;
		}
	}

	/*
	 * Solution récursive 2 : simuler la boucle 'for' sur les lignes
	 * -> Fonction interne avec 2 paramètre supplémentaire pour 'ligne'
	 */
	public static double sommeParLignesRecursif2(double[][] tab) {
		return sommeParLignesRecursif2(tab, 0);
	}

	// On calcule la somme du reste du tableau à partir de la ligne 'ligne'
	private static double sommeParLignesRecursif2(double[][] tab, int ligne) {
		if (ligne < tab.length) {
			return sommeRecursif2(tab[ligne]) + sommeParLignesRecursif2(tab, ligne + 1);
		} else {
			return 0;
		}
	}

	/*
	 * Solution récursive 3 : réduction progressive des lignes du tableau
	 */
	public static double sommeParLignesRecursif3(double[][] tab) {
		if (tab.length == 0) {
			return 0;
		} else {
			// Somme 1ère ligne + somme du reste du tableau
			return sommeRecursif3(tab[0]) + sommeParLignesRecursif3(Arrays.copyOfRange(tab, 1, tab.length));
		}
	}

	
	
	public static void main(String[] args) {
		// Tableaux 1D
		System.out.println("Tableaux 1D");
		System.out.println("--- sommeIteratif(new double[] {1,2,3,4,5,6,7,8,9}) ---");
		System.out.println(sommeIteratif(new double[] {1,2,3,4,5,6,7,8,9}));
		System.out.println("--- sommeRecursif1(new double[] {1,2,3,4,5,6,7,8,9}) ---");
		System.out.println(sommeRecursif1(new double[] {1,2,3,4,5,6,7,8,9}));
		System.out.println("--- sommeRecursif2(new double[] {1,2,3,4,5,6,7,8,9}) ---");
		System.out.println(sommeRecursif2(new double[] {1,2,3,4,5,6,7,8,9}));
		System.out.println("--- sommeRecursif3(new double[] {1,2,3,4,5,6,7,8,9}) ---");
		System.out.println(sommeRecursif3(new double[] {1,2,3,4,5,6,7,8,9}));
		System.out.println();
		
		// Tableaux 2D
		System.out.println("Tableaux 2D");
		System.out.println("--- sommeIteratif(new double[][] {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}}) -----");
		System.out.println(sommeIteratif(new double[][] {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}}));
		System.out.println("--- sommeRecursif1(new double[][] {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}}) -----");
		System.out.println(sommeRecursif1(new double[][] {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}}));
		System.out.println("--- sommeRecursif2(new double[][] {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}}) -----");
		System.out.println(sommeRecursif2(new double[][] {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}}));
		System.out.println("--- sommeRecursif3(new double[][] {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}}) -----");
		System.out.println(sommeRecursif3(new double[][] {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}}));
		System.out.println();
		
		// Tableaux 2D par lignes
		System.out.println("Tableaux 2D par lignes");
		System.out.println("--- sommeParLignesIteratif(new double[][] {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}}) -----");
		System.out.println(sommeParLignesIteratif(new double[][] {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}}));
		System.out.println("--- sommeParLignesRecursif1(new double[][] {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}}) -----");
		System.out.println(sommeParLignesRecursif1(new double[][] {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}}));
		System.out.println("--- sommeParLignesRecursif2(new double[][] {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}}) -----");
		System.out.println(sommeParLignesRecursif2(new double[][] {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}}));
		System.out.println("--- sommeParLignesRecursif3(new double[][] {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}}) -----");
		System.out.println(sommeParLignesRecursif3(new double[][] {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}}));
		System.out.println();
	}
}
