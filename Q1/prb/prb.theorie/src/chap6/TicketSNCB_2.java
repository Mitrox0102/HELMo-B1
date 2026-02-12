package chap6;

import io.Console;

/**
 * Ce programme permet de déterminer le prix d'un ticket de train
 * Liège-Bruxelles selon l'âge de l'usager.
 */
public class TicketSNCB_2 {

	public static void main(String[] args) {
		// Constantes
		final double PRIX_DE_BASE = 25.80;

		// Variable
		int age;

		// Acquisition
		age = Console.lireInt("Votre âge ? ");

		
		System.out.printf("Prix à payer = %.2f EUR\n", calculerPrixTicket(age, PRIX_DE_BASE));
	}
	
	
	public static double calculerPrixTicket(int age, double prixDeBase) {
		final double TAUX_REDUC_JEUNE_SENIOR = 0.15;
		double prixFinal = prixDeBase;
		
		if (age < 0 || age > 121) {
			return Double.NaN;
		}
		
		else if (age < 12) {
			prixFinal = 0.;
		}
		else if (age < 26 || age > 66) {
			prixFinal =  prixDeBase * (1. - TAUX_REDUC_JEUNE_SENIOR);
		}
		
		return prixFinal;
		
	}
		
		
	}

