package labo7;

import util.*;
import io.*;

public class Blackjack {

	private static String[] getJeuDeCartes() {
		// Constantes
		final String[] COULEURS = { "coeur", "carreau", "trèfle", "pique" };
		final String[] CARTES = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As" };
		// Variable pour le résultat
		String[] jeuDeCartes;
		// Créer un jeu de cartes
		jeuDeCartes = new String[COULEURS.length * CARTES.length];
		for (int i = 0; i < COULEURS.length; i++) {
			for (int j = 0; j < CARTES.length; j++) {
				jeuDeCartes[CARTES.length * i + j] = CARTES[j] + " de " + COULEURS[i];
			}
		}
		// Retourner le jeu de cartes
		return jeuDeCartes;
	}

	public static int getValeurCarte(String carte) {
		return switch (carte.trim().substring(0, 2)) {
		case "As" -> 11;
		case "2 " -> 2;
		case "3 " -> 3;
		case "4 " -> 4;
		case "5 " -> 5;
		case "6 " -> 6;
		case "7 " -> 7;
		case "8 " -> 8;
		case "9 " -> 9;
		case "10", "Va", "Da", "Ro" -> 10;
		default -> 0;
		};
	}

	public static int getValeurCartes(String[] cartes, int nbCartes) {
		int somme = 0;
		for (int i = 0; i < nbCartes; i++) {
			somme += getValeurCarte(cartes[i]);
		}
		return somme;
	}

	public static boolean verifierJeu(int scoreJ1, int scoreCroupier, String[] cartesCroupier, int nbCroupier,
			String[] cartesJ1, int nbJ1) {
		if (scoreJ1 == 21 && scoreCroupier == 21) {
			System.out.println("Egalité !");
			return true;
		} else if (scoreJ1 > 21) {
			System.out.println("Vous perdez !");
			return true;
		} else if (scoreCroupier == 21) {
			System.out.println("Le croupier a " + getValeurCartes(cartesCroupier, nbCroupier) + " points :");
			System.out.println(TableauChaines.toString(cartesCroupier, nbCroupier));
			System.out.println();
			System.out.println("Vous perdez !");
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String[] jeu = getJeuDeCartes();
		TableauChaines.melanger(jeu);
		boolean mainJ1 = true;

		int nbJ1 = 0, nbCroupier = 0, i = 0;

		String[] cartesJ1 = new String[10];
		String[] cartesCroupier = new String[10];

		cartesJ1[nbJ1++] = jeu[i++];
		cartesCroupier[nbCroupier++] = jeu[i++];
		cartesJ1[nbJ1++] = jeu[i++];
		cartesCroupier[nbCroupier++] = jeu[i++];

		int scoreJ1 = getValeurCartes(cartesJ1, nbJ1);
		System.out.println("Vous avez " + scoreJ1 + " points :");
		System.out.println(TableauChaines.toString(cartesJ1, nbJ1));
		System.out.println();

		if (getValeurCartes(cartesJ1, nbJ1) == 21) {
			System.out.println("Vous gagnez !");
			return;
		}

		int scoreVisibleCroupier = getValeurCarte(cartesCroupier[1]);
		System.out.println("Le croupier a " + scoreVisibleCroupier + " points :");
		System.out.println(cartesCroupier[1]);
		System.out.println();

		if (verifierJeu(getValeurCartes(cartesJ1, nbJ1), getValeurCartes(cartesCroupier, nbCroupier), cartesCroupier,
				nbCroupier, cartesJ1, nbJ1)) {
			return;
		}

		String choix = Console.lireString("Tirer une carte : (O)ui/(N)on ? ");

		if (choix.equalsIgnoreCase("o")) {
			mainJ1 = true;
		} else {
			mainJ1 = false;
		}

		while (mainJ1) {
			cartesJ1[nbJ1++] = jeu[i++];
			scoreJ1 = getValeurCartes(cartesJ1, nbJ1);
			System.out.println("Vous avez " + scoreJ1 + " points :");
			System.out.println(TableauChaines.toString(cartesJ1, nbJ1));
			System.out.println();

			if (verifierJeu(scoreJ1, getValeurCartes(cartesCroupier, nbCroupier), cartesCroupier, nbCroupier, cartesJ1,
					nbJ1))
				return;

			if (scoreJ1 == 21) {
				mainJ1 = false;
			}

			if (scoreJ1 < 21) {
				choix = Console.lireString("Tirer une carte : (O)ui/(N)on ? ");
				if (choix.equalsIgnoreCase("o")) {
					mainJ1 = true;
				} else {
					mainJ1 = false;
				}
			}
		}

		while (getValeurCartes(cartesCroupier, nbCroupier) < 17) {
			cartesCroupier[nbCroupier++] = jeu[i++];
		}

		if (getValeurCartes(cartesJ1, nbJ1) > getValeurCartes(cartesCroupier, nbCroupier)
				|| getValeurCartes(cartesCroupier, nbCroupier) > 21) {
			System.out.println("Le croupier a " + getValeurCartes(cartesCroupier, nbCroupier) + " points :");
			System.out.println(TableauChaines.toString(cartesCroupier, nbCroupier));
			System.out.println();
			System.out.println("Vous avez " + getValeurCartes(cartesJ1, nbJ1) + " points :");
			System.out.println(TableauChaines.toString(cartesJ1, nbJ1));
			System.out.println();
			System.out.println("Vous gagnez !");

		} else if (getValeurCartes(cartesJ1, nbJ1) < getValeurCartes(cartesCroupier, nbCroupier)) {

			System.out.println("Le croupier a " + getValeurCartes(cartesCroupier, nbCroupier) + " points :");
			System.out.println(TableauChaines.toString(cartesCroupier, nbCroupier));
			System.out.println();
			System.out.println("Vous avez " + getValeurCartes(cartesJ1, nbJ1) + " points :");
			System.out.println(TableauChaines.toString(cartesJ1, nbJ1));
			System.out.println();
			System.out.println("Vous perdez !");

		} else {
			System.out.println("Egalité");

		}

	}

}
