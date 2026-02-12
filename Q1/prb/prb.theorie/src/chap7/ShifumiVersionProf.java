package chap7;

import io.*;


public class ShifumiVersionProf {

	public static void main(String[] args) {
		//acquisition 
		String choixJoueur, choixIA; 
		
		choixJoueur = Console.lireString("Pierre, papier ou ciseaux ? ").trim().toLowerCase();
		
		
		while(!(choixJoueur.equals("pierre") || choixJoueur.equals("papier") || choixJoueur.equals("ciseaux"))) {
			System.out.println("Choix incorrect ! Recommence... ");
			choixJoueur = Console.lireString("Pierre, papier ou ciseaux ? ").trim().toLowerCase();
		}
		
		// choix aléatoire de l'IA
		choixIA = choixAleatoire();
		
		
		
		System.out.println("Fin de l'application.");
	}

	/**
	 * Détermine le vainqueur de cette manche.
	 * @param choix1 Le choix de l'utilisateur parmi pierre, papier, ciseaux.
	 * @param choix2 le choix de l'IA parmi pierre, papier, ciseaux.
	 * @return 0 en cas d'égalité, 1 si c'est le premier choix qui l'emporte, 2
	 * 		   si c'est le second choix qui l'emporte.
	 */
	public static int vainqueurManche(String choix1, String choix2) {
		
		int resultat =  0;
		
		// Déterminer qui gagne la manche ou s'il y a égalité
				if (choix1.equals(choix2)) {
					resultat = 0;
				} else if ((choix1.equals("pierre") && choix2.equals("ciseaux")) ||
						(choix1.equals("papier") && choix2.equals("pierre")) ||
						(choix1.equals("ciseaux") && choix2.equals("papier"))) {
					resultat = 1;
				} else {
					resultat = 2;
				}
		return resultat;
	}
	
	public static String choixAleatoire() {
		return switch (Aleatoire.aleatoire(1,3)) {
		case 1 -> "pierre";
		case 2 -> "papier";
		default -> "ciseaux";
		} ;
			
	}
}