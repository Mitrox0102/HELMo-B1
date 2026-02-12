package chap6;

import io.Console;

/**
 * Ce programme permet de déterminer le prix d'un ticket de train
 * Liège-Bruxelles selon l'âge de l'usager.
 */
public class TicketSNCB_1 {

	public static void main(String[] args) {
		// Constantes
		final double PRIX_DE_BASE = 25.80;
		final double TAUX_REDUC_JEUNE = 0.15;

		// Variable
		int age;

		// Acquisition
		age = Console.lireInt("Votre âge ? ");

		// Traitement
		// Si la personne est un "jeune" (0-25) alors le prix est diminué de 15%.
		// Si la personne est un "adulte" (26+) alors le prix reste inchangé.

		// Version 1 : le résultat est affiché directement
		if (age < 26) {
			System.out.printf("Prix à payer = %.2f EUR\n", PRIX_DE_BASE * (1 - TAUX_REDUC_JEUNE));
		} else {
			System.out.printf("Prix à payer = %.2f EUR\n", PRIX_DE_BASE);
		}

		// Version 2 : utilisation d'une variable
		double prixTicket;
		if (age < 26) {
			prixTicket = PRIX_DE_BASE * (1 - TAUX_REDUC_JEUNE);
		} else {
			prixTicket = PRIX_DE_BASE;
		}
		System.out.printf("Prix à payer = %.2f EUR\n", prixTicket);

		// Version 3 : initialiser "prixTicket" avec la valeur par défaut
		prixTicket = PRIX_DE_BASE;
		if (age < 26) {
			prixTicket = PRIX_DE_BASE * (1 - TAUX_REDUC_JEUNE);
		}
		System.out.printf("Prix à payer = %.2f EUR\n", prixTicket);

		// Version 4 : utilisation de l'opérateur ternaire ... ? ... : ...
		prixTicket = PRIX_DE_BASE * (1 - ((age < 26) ? TAUX_REDUC_JEUNE : 0));
		System.out.printf("Prix à payer = %.2f EUR\n", prixTicket);

		// Version 5 : utilisation d'une fonction
		afficherPrixTicket(age, PRIX_DE_BASE);
		System.out.printf("Prix à payer = %.2f EUR\n", calculerPrixTicket(age, PRIX_DE_BASE));
		System.out.printf("Prix à payer = %s\n", prixTicketEnString(age, PRIX_DE_BASE));
	}

	/**
	 * Calcule et affiche le prix à payer pour un ticket de train sur base de l'âge
	 * de l'usager et du prix de base.
	 * 
	 * @param age        L'âge de l'usager.
	 * @param prixDeBase Le prix de base du ticket de train.
	 */
	public static void afficherPrixTicket(int age, double prixDeBase) {
		final double TAUX_REDUC_JEUNE = 0.15;
		if (age < 26) {
			System.out.printf("Prix à payer = %.2f EUR\n", prixDeBase * (1 - TAUX_REDUC_JEUNE));
		} else {
			System.out.printf("Prix à payer = %.2f EUR\n", prixDeBase);
		}
	}

	/**
	 * Calcule et retourne le prix à payer pour un ticket de train sur base de l'âge
	 * de l'usager et du prix de base.
	 * 
	 * @param age        L'âge de l'usager.
	 * @param prixDeBase Le prix de base du ticket de train.
	 * @return Le prix à payer.
	 */
	public static double calculerPrixTicket(int age, double prixDeBase) {
		final double TAUX_REDUC_JEUNE = 0.15;
		if (age < 26) {
			return prixDeBase * (1 - TAUX_REDUC_JEUNE);
		}
		return prixDeBase;
	}

	/**
	 * Calcule le prix à payer pour un ticket de train sur base de l'âge de l'usager
	 * et du prix de base, et retourne une chaîne de caractères représentant le prix
	 * correspondant déjà formaté.
	 * 
	 * @param age        L'âge de l'usager.
	 * @param prixDeBase Le prix de base du ticket de train.
	 * @return Une chaîne de caractères réprésentant le prix à payer de la forme
	 *         "0.00 EUR".
	 */
	public static String prixTicketEnString(int age, double prixDeBase) {
		final double TAUX_REDUC_JEUNE = 0.15;
		double prixTicket = prixDeBase;
		if (age < 26) {
			prixTicket = prixTicket * (1 - TAUX_REDUC_JEUNE);
		}
		return String.format("%.2f EUR", prixTicket);
	}

}
