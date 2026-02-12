package labo8;

import io.Console;

public class CompetitionSportive {
	public static void main(String[] args) {
		int nbEquipes = Console.lireInt("Combien d'équipes ? ");
		encoderNomsEquipes(nbEquipes);
	}

	/**
	 * Permet d'obtenir un tableau contenant les noms des équipes saisis par
	 * l'utilisateur
	 * 
	 * @param nbEquipes indique le nombre de noms d'équipes à encoder
	 * @return un tableau String 1D contenant les noms des équipes
	 */
	static String[] encoderNomsEquipes(int nbEquipes) {
		//Acquisitions pour la fonction
		String nomsEquipes[] = new String[nbEquipes];
		int numEquipe = 1;
		String nomTemp;
		//Boucle index qui va parcourir le tableau
		for (int i = 0; i < nomsEquipes.length; i++) {
			//Boucle pour vérifier si le nom rentré ne l'a pas déjà été
			do {
				nomTemp = Console.lireString("Equipe " + numEquipe + " ? ");
			} while (TableauChaines.contient(nomsEquipes, nomTemp));
			
			nomsEquipes[i] = nomTemp;
			numEquipe++;
		}
		return nomsEquipes;

	}

}
