package chap8.tab1D;

import io.Console;

public class Ex3_JoursParMois {

	public static void main(String[] args) {
		
		int mois  = Console.lireInt("Mois (de 1 à 12) ? ");
		int annee = Console.lireInt("Année ? ");

		System.out.printf("Il y a %d jours dans le mois %d/%d.\n", joursParMois(mois, annee), mois, annee);
	}
	
	public static boolean estBissextile(int annee) {
		return (annee % 4 == 0 && annee % 100 != 0) || annee % 400 == 0; 
	}
	
	public static int joursParMois(int mois, int annee) {
		//TODO: Utiliser un tableau qui répertorie le nombe de jours dans chaque mois
		//      à la place du switch.
		if (mois < 1 || mois > 12) {
			return 0;
		}
		
		
		final int[]JOURS_PAR_MOIS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(estBissextile(annee)) {
			JOURS_PAR_MOIS[1] = 29;
		}
		
		return JOURS_PAR_MOIS[mois - 1];
		
		
	}

}
