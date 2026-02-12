package chap7;

import io.Console;

public class Floyd {

	public static void main(String[] args) {
		int nbLignes = Console.lireInt("Combien de lignes ? ");
		System.out.println(triangleEnChaine(nbLignes));
	}
	
	public static String triangleEnChaine(int nbLignes) {
		// Par exemple, si nbLignes = 4, alors la fonction affiche
		// 1
		// 2 3
		// 4 5 6
		// 7 8 9 10
		
//		int numeroFin = 1, inc = 2;
//		for (int i = 1; i <= nbLignes * (nbLignes + 1) / 2; i++) {
//			System.out.print(i + " ");
//			if (i == numeroFin) {
//				System.out.println();
//				numeroFin += inc;
//				inc++;
//			}
//		}
		
		String resultat = "";
		int nombre = 1;
		// Boucle qui compte les lignes
		for (int i = 1; i <= nbLignes; i++) {
			// Boucle qui compte les nombres de la ligne actuelle
			for (int j = 1; j <= i; j++) {
				resultat += nombre + " ";
				nombre++;
			}
			resultat += "\n";
		}
		return resultat;
	}

}








