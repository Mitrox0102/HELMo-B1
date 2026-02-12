package eval3;

import java.util.Arrays;

import io.*;

public class CompteurBinaire {

	/**
	 * Cette fonction nous sert à afficher le menu utilisateur
	 * 
	 * @return cette fonction nous retourne la taille du tableau
	 */
	public static int afficherMenu() {

		// On affiche le menu et on demande la taille du tableau à l'utilisateur
		System.out.println("Bienvenue dans le compteur binaire :-) ,");
		int temp;
		do {
			temp = Console.lireInt("Nombre de bits ? ");
		} while (temp <= 0);

		return temp;
	}

	/**
	 * Ce tableau va nous permettre de remplir le tableau de 0 afin de pouvoir
	 * commencer à le remplir.
	 * 
	 * @param t c'est le tablaeu à initialiser à 0
	 * @return On retourne le tableau rempli de 0
	 */

	public static int[] remplissage(int[] t) {

		// On remplit le tableau de 0.
		for (int i = 0; i < t.length; i++) {
			t[i] = 0;
		}
		return t;
	}

	/**
	 * Ce tableau va incrémenter notre tableau d'origine de 1.
	 * 
	 * @param binaire c'est notre tableau dans lequel on va ajouter 1
	 */
	public static void ajouterUn(int[] binaire) {

		// On va remplir le tableau par la gauche étant donné qu'on est en bits.
		for (int i = binaire.length - 1; i >= 0; i--) {
			if (binaire[i] == 0) {
				binaire[i] = 1;
				return;
			} else {
				binaire[i] = 0;
			}
		}

	}

	public static void main(String[] args) {

		// On affiche le menu et on initialise notre tableau
		int[] binaire = new int[afficherMenu()];
		binaire = remplissage(binaire);

		// On affiche toutes les valeurs possibles en fonction de la taille
		for (int i = 0; i < Math.pow(2, binaire.length); i++) {
			System.out.println(Arrays.toString(binaire));
			ajouterUn(binaire);
		}

	}

}
