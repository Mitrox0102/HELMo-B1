package chap8.tab1D;

import io.*;

/**
 * Ce programme permet de jouer au jeu LightsOut. Dans ce dernier, il y a 7
 * lumières, certaines étant initialement éteintes et d'autres allumées.
 * 
 * Voici à quoi ressemble l'affichage des lumières (● = éteinte, ○ = allumée) :
 * ● ○ ○ ● ○ ● ○
 * 1 2 3 4 5 6 7
 * 
 * Le but du jeu est de parvenir à les allumer toutes, tout en sachant que le
 * fait d'allumer ou éteindre une lumière inversera également l'état de ses
 * voisines.
 */
public class Ex8_LightsOut {

	public static void main(String[] args) {

		// Constante
		final int NB_LUMIERES = 7;
		
		// Tableau
		boolean[] lumieres;

		// Affichage des informations relatives au jeu
		System.out.println("*** LIGHTS OUT ! ***");
		System.out.println("Objectif : allumer toutes les lumières.");
		System.out.println("Règle    : inverser une lumière inverse également ses deux voisines.");
		System.out.println("Légende  : ● = éteinte / ○ = allumée.\n");

		//TODO: Créer et initialiser le tableau "lumieres" (fonction "lumieresAleatoires")
		
		lumieres = lumieresAleatoires(NB_LUMIERES);
		
		//TODO: Afficher l'état des lumières (fonction "toString")
		
		System.out.println(toString(lumieres));
		
		//TODO: Acquérir le numéro de la lumière à inverser

		
		//TODO: Inverser la lumière spécifiée ainsi que ses voisines (fonction "inverser")
		
		
		//TODO: Répéter les 3 étapes précédentes tant que toutes les lumières ne sont pas toutes allumées (fonction "toutesAllumees")
		

		// Affichage du message de fin de partie
		System.out.println("\nBravo ! Vous avez réussi à tout allumer.");
	}

	/**
	 * Crée un tableau initialisé avec des valeurs booléennes choisies aléatoirement
	 * pour représenter l'état initial des lumières ({@code false} pour éteinte,
	 * {@code true} pour allumée).
	 * 
	 * @param longueur - la longueur du tableau à créer.
	 * @return le tableau créé.
	 */
	public static boolean[] lumieresAleatoires(int longueur) {
		//TODO: compléter la fonction
		
		boolean[] lumieres = new boolean[longueur];
		for (int i = 0; i < longueur; i++) {
			if(Aleatoire.aleatoire(1) == 1) {
				lumieres[i] = true;
			}
		}
		return lumieres;
	}

	/**
	 * Crée une chaîne de caractère représentant l'état des lumières, en utilisant
	 * les symboles ● (lumière éteinte) et ○ (lumière allumée), ainsi que le numéro
	 * associé chacune d'elles.
	 * 
	 * Par exemple,
	 * ● ○ ○ ● ○ ● ○
	 * 1 2 3 4 5 6 7
	 * 
	 * @param lumieres - le tableau contenant l'état des lumières.
	 * 
	 * @return une chaîne de caractères contenant les informations des lumières.
	 */
	public static String toString(boolean[] lumieres) {
		//TODO: compléter la fonction
		
		String resultatStr = "";
		String numeroStr = "";
		
		
		for (int i = 0; i < lumieres.length; i++) {
			if(lumieres[i]) {
				resultatStr += "○ ";
			}else {
				resultatStr += "● ";
			}
			numeroStr += i + 1 + " ";
			if (i < lumieres.length - 1) {
				resultatStr = " ";
				numeroStr = " ";
			}
		}
		return resultatStr + "\n" + numeroStr + "\n";
	}

	/**
	 * Inverse l'état de la lumière située à la position spécifiée et des deux
	 * lumières situées aux positions voisines.
	 * 
	 * @param lumieres - le tableau contenant l'état des lumières.
	 * @param i        - la position de la lumière dont l'état doit être inversé.
	 */
	public static void inverser(boolean[] lumieres, int i) {
		//TODO: compléter la fonction
	}

	/**
	 * Détermine si toutes les lumières sont allumées.
	 * 
	 * @param lumieres - le tableau contenant l'état des lumières.
	 * @return {@code true} si toutes les lumières sont allumées, {@code false} dans
	 *         le cas contraire.
	 */
	public static boolean toutesAllumees(boolean[] lumieres) {
		//TODO: compléter la fonction
		return false;
	}
	
}