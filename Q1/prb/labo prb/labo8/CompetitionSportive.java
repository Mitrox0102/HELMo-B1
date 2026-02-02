package labo8;

import io.Console;
import util.TableauChaines;

public class CompetitionSportive {

	static String[] encoderNomsEquipes(int nbEquipes) {

		String[] roster = new String[nbEquipes];
		String temp;

		for (int i = 0; i < nbEquipes; i++) {
			do {
				temp = Console.lireString("Equipe " + (i + 1) + " ? ").trim();
			} while (temp.isEmpty() || TableauChaines.contient(roster, temp));

			roster[i] = temp;
		}

		return roster;
	}

	static void decalerADroite(String[] nomsEquipes) {

		String last = nomsEquipes[nomsEquipes.length - 1];

		for (int i = nomsEquipes.length - 1; i > 0; i--) {

			nomsEquipes[i] = nomsEquipes[i - 1];

		}

		nomsEquipes[0] = last;

	}

	static String[][] journeeSuivante(String[] nomsEquipes) {

		String[][] matchs = new String[nomsEquipes.length / 2][2];

		decalerADroite(nomsEquipes);

		TableauChaines.permuter(nomsEquipes, 0, 1);

		for (int i = 0; i < nomsEquipes.length / 2; i++) {

			matchs[i][0] = nomsEquipes[i];
			matchs[i][1] = nomsEquipes[nomsEquipes.length - 1 - i];

		}

		return matchs;
	}

	static String rencontreToString(String[] rencontre) {

		String rencontreAAfficher = "";

		rencontreAAfficher += rencontre[0] + " - " + rencontre[1];

		return rencontreAAfficher;
	}

	static String journeeToString(String[][] journee) {

		String journeeAffichee = "";

		for (int i = 0; i < journee.length; i++) {

			journeeAffichee += rencontreToString(journee[i]) + "\n";

		}

//		for (String[] rencontre : journee) {
//			journeeAffichee += rencontreToString(rencontre) + "\n";
//		}

		return journeeAffichee;
	}

	static String[] getRencontre(String[][] journee, String nomEquipe) {

		for (int i = 0; i < journee.length; i++) {

			if (TableauChaines.contient(journee[i], nomEquipe)) {

				return journee[i];

			}
		}

		return null;
	}

	static int choisirEquipe(String[] nomsEquipes) {

		for (int i = 0; i < nomsEquipes.length; i++) {

			System.out.printf("%d. %s\n", i + 1, nomsEquipes[i]);

		}

		int choix = Console.lireInt("Choix ? ") - 1;

		return choix;
	}

	static int afficher_menu(String[] roster) {

		System.out.println("Compétition de football");
		System.out.println("1. Encoder les équipes");

		if (roster != null) {
			System.out.println("2. Afficher le calendrier de la compétition");
			System.out.println("3. Afficher le calendrier d'une équipe");
		}
		System.out.println("4. Quitter");

		return Console.lireInt("Choix ? ");

	}

	static String[] encoder_equipes(String[] roster) {

		int nbEquipes = Console.lireInt("Rentrez le nombre d'équipes : ");

		roster = encoderNomsEquipes(nbEquipes);

		System.out.println();

		return roster;
	}

	static void afficher_calendrier_competition(String[] roster) {

		int nbJournee = roster.length - 1;

		String[][] journee;

		for (int i = 0; i < nbJournee; i++) {
			journee = journeeSuivante(roster);

			System.out.printf("Journée %d \n", i + 1);
			System.out.println(journeeToString(journee));

		}

	}

	static void afficher_calendrier_equipe(String[] roster) {

		int choix = choisirEquipe(roster);
		String equipe = roster[choix];
		int nbJournee = roster.length - 1;

		String[][] journee;

		for (int i = 0; i < nbJournee; i++) {

			journee = journeeSuivante(roster);

			System.out.printf("Journée %d \n", i + 1);
			System.out.println(rencontreToString(getRencontre(journee, equipe)));
		}

	}

	public static void main(String[] args) {

		String[] roster = null;
		boolean enCours = true;

		while (enCours) {
			int choix = afficher_menu(roster);
			System.out.println();

			switch (choix) {
			case 1 -> roster = encoder_equipes(roster);

			case 2 -> afficher_calendrier_competition(roster);

			case 3 -> afficher_calendrier_equipe(roster);

			case 4 -> enCours = false;

			default -> throw new IllegalArgumentException("Unexpected value: " + choix);
			}
		}
	}

}
