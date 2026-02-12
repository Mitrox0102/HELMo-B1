package labo7;

import java.util.Arrays;
import io.*;

import util.*;

public class Lotto {

	static int[] genererTirage(int nbTirages, int max) {

		int[] tirages = new int[max];
		for (int i = 0; i < max; i++) {
			tirages[i] = i + 1;
		}

		int[] sousTableau = new int[nbTirages];
		int j = max - 1;

		for (int i = 0; i < nbTirages; i++) {
			int p = Aleatoire.aleatoire(0, j);
			sousTableau[i] = tirages[p];
			TableauEntiers.permuter(tirages, p, j);
			j--;

		}

		Arrays.sort(sousTableau, 0, nbTirages - 1);

		return sousTableau;
	}

	static int[] encoderGrille(int nbNumeros, int max) {
		int[] numeros = new int[nbNumeros];
		for (int i = 0; i < nbNumeros; i++) {

			int temp;

			do {
				temp = Console.lireInt("Entrer numero " + (i + 1) + " ? ");
			} while (temp > max || temp <= 0 || (TableauEntiers.contient(numeros, temp)));

			numeros[i] = temp;
		}
		return numeros;
	}

	static int[] compterNumerosGagnants(int[] tirage, int[] grille) {

		int gagnant = 0, bonus = 0;
		int[] resultat = new int[2];

		for (int i = 0; i < tirage.length - 1; i++) {
			if (TableauEntiers.contient(grille, tirage[i]))
				gagnant++;
		}

		if (TableauEntiers.contient(grille, tirage[tirage.length - 1])) {
			bonus = 1;
		}

		resultat[0] = gagnant;
		resultat[1] = bonus;

		return resultat;
	}

	static int determinerRang(int[] numerosGagnants) {
		int n = numerosGagnants[0];
		int bonus = numerosGagnants[1];

		int rang = (7 - n) * 2 - 1;

		return rang - bonus;
	}

	static double obtenirGain(int rang) {

		return switch (rang) {
		case 1 -> 500000.;
		case 2 -> 75000.;
		case 3 -> 1500.;
		case 4 -> 250.;
		case 5 -> 30.;
		case 6 -> 10.;
		case 7 -> 5.;
		case 8 -> 3.;

		default -> 0;
		};

	}

	static int afficherMenu(int[] joueur) {
		System.out.println("Loterie Nationale");
		if (joueur == null)
			System.out.println("1. Remplir une grille de Lotto");
		else
			System.out.println("1. Modifier ma grille de Lotto");
		System.out.println("2. Consulter mon gain pour le dernier tirage");
		System.out.println("3. Quitter");

		return Console.lireInt("Choix ? ");
	}

	static int[] afficher_remplissage_grille() {

		int[] grille_joueur = encoderGrille(6, 45);

		System.out.println("Votre grille est " + TableauEntiers.toString(grille_joueur));
		System.out.println();

		return grille_joueur;
	}

	static void consulter_dernier_tirage(int[] tirage, int[] grille_joueur) {

		tirage = genererTirage(7, 45);
		System.out.println("Le tirage est " + TableauEntiers.toString(tirage));

		if (grille_joueur == null) {
			System.out.println("Vous n'avez pas rempli de grille");
		} else {
			double euros = obtenirGain(determinerRang(compterNumerosGagnants(tirage, grille_joueur)));

			System.out.println("Vous avez " + compterNumerosGagnants(tirage, grille_joueur)[0] + " numéros gagnants");

			System.out.println("Vous gagnez " + euros + " euros");
		}

		System.out.println();

	}

	public static void main(String[] args) {
		int[] tirage = null;
		int[] joueur = null;

		boolean enCours = true;

		while (enCours) {
			int choix = afficherMenu(joueur);

			System.out.println();

			switch (choix) {
			case 1 -> joueur = afficher_remplissage_grille();

			case 2 -> consulter_dernier_tirage(tirage, joueur);

			case 3 -> enCours = false;

			default -> throw new IllegalArgumentException("Unexpected value: " + choix);
			}

		}

	}

}