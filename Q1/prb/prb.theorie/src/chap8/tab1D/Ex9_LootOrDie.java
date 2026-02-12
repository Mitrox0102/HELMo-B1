package chap8.tab1D;

import java.util.Objects;
import io.*;

import io.Console;

public class Ex9_LootOrDie {

	public static void main(String[] args) throws InterruptedException {

		// Constantes
		final String PIEGE = "Piège";
		final String KIT = "Kit de déminage";
		final String CHOIX_1 = "Creuser";
		final String CHOIX_2 = "Partir";
		final int CREUSER = 1;
		final int PARTIR = 2;
		final int ATTENTE_EN_SEC = 3;
		final int UNE_SECONDE = 1000;

		// Tableaux
		final String[] NOMS_TRESORS = { KIT, PIEGE, "Or", "Rubis", "Émeraude", "Relique ancienne" };
		final int[] VALEURS_TRESORS = { 0, 0, 10, 200, 300, 500 };
		final double[] TAUX_APPARITION = { 0.10, 0.20, 0.45, 0.10, 0.10, 0.05 };

		// Variables
		int choixJoueur, scoreJoueur = 0, kits_joueur = 0;
		String tresorAlea = null;
		String[] tresors_joueur = {};
		boolean kit_utilise = false;

		// Traitement
		do {
			choixJoueur = lireChoix(CHOIX_1, CHOIX_2);
			kit_utilise = false;

			if (choixJoueur == CREUSER) {

				tresorAlea = tresorAleatoire(NOMS_TRESORS, TAUX_APPARITION);

				// Affichage du trésor trouvé
				System.out.print("Vous creusez ");
				for (int i = 1; i <= ATTENTE_EN_SEC; i++) {
					System.out.print(".");
					Thread.sleep(UNE_SECONDE);
				}
				System.out.printf(" %s\n\n", tresorAlea);

				if (Objects.equals(tresorAlea, KIT)) {
					kits_joueur++;
				} else if (Objects.equals(tresorAlea, PIEGE) && kits_joueur != 0) {

					System.out.printf("Vous êtiez censé mourrir mais vous avez \nutilisé votre kit de déminage contre le piège.\n");
					kits_joueur--;
					kit_utilise = true;
					
					
				} else {
					scoreJoueur += VALEURS_TRESORS[positionDe(NOMS_TRESORS, tresorAlea)];

					tresors_joueur = ajouterTresor(tresors_joueur, tresorAlea);
				}

			}

		} while (choixJoueur != PARTIR && (!Objects.equals(tresorAlea, PIEGE) || kit_utilise == true));

		// Affichage du score final
		System.out.println();

		if (Objects.equals(tresorAlea, PIEGE) && kits_joueur == 0) {
			System.out.println("Vous mourez dans d'atroces souffrances 💀");
		} else if (scoreJoueur == 0) {
			System.out.println("Vous repartez les mains vides 😢");
		} else {
			System.out.println("Vour repartez avec vos trésors :");
			// TODO: afficher les trésors récupérés par le joueur

			System.out.println(TableauChaines.toString(tresors_joueur, tresors_joueur.length));

			System.out.printf("Score total = %d 😊\n", scoreJoueur);
		}
	}

	public static String tresorAleatoire(String[] nomsTresors, double[] tauxApparition) {

		double sum = 0;
		double alea = Math.random();
		for (int i = 0; i < tauxApparition.length; i++) {

			sum += tauxApparition[i];

			if (sum > alea) {
				return nomsTresors[i];
			}
		}

		return null;
	}

	public static int positionDe(String[] chaines, String valeur) {

		for (int i = 0; i < chaines.length; i++) {

			if (Objects.equals(chaines[i], valeur)) {
				return i;
			}
		}

		return -1;
	}

	public static String[] ajouterTresor(String[] tresors, String nouveauTresor) {
		// TODO: compléter la fonction

		String[] new_tresor = new String[tresors.length + 1];

		System.arraycopy(tresors, 0, new_tresor, 0, tresors.length);

		new_tresor[tresors.length] = nouveauTresor;

		return new_tresor;
	}

	private static int lireChoix(String choix1, String choix2) {
		final String DEMANDE_CHOIX = String.format("%s, %s ? ", formaterChoix(choix1),
				formaterChoix(choix2).toLowerCase());
		int numeroChoix = 0;
		String choixSaisi;
		do {
			choixSaisi = Console.lireString(DEMANDE_CHOIX).trim().toLowerCase();
			numeroChoix = (choix1.toLowerCase().startsWith(choixSaisi)) ? 1 : numeroChoix;
			numeroChoix = (choix2.toLowerCase().startsWith(choixSaisi)) ? 2 : numeroChoix;
		} while (numeroChoix == 0);
		return numeroChoix;
	}

	private static String formaterChoix(String choix) {
		return String.format("(%c)%s", Character.toUpperCase(choix.charAt(0)), choix.substring(1).toLowerCase());
	}

}
