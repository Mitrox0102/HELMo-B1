package chap7;

import io.Aleatoire;
import io.Console;

// feuille = 0, pierre 1, ciseaux = 2

public class Shifumi {

	public static int shifumi(int choix) {
		
		int rdm = Aleatoire.aleatoire(2);
		
		if (rdm == 0) {
			System.out.println("L'IA choisi feuille.");
		} else if  (rdm == 1) {
			System.out.println("L'IA choisi pierre.");
		} else {
			System.out.println("L'IA choisit ciseaux.");
		}
		
		if (rdm == choix) {
			return 0;
		} else  if (choix == 0 && rdm == 1 || choix == 1 && rdm == 2 || choix == 2 && rdm == 0){
			return 1;
		}else {
			return 2;
		}
	}
	
	public static void main(String[] args) {
		
		int choix = 0, pointJ1 = 0, pointIA = 0;;
		
		
		while(pointJ1 < 5 && pointIA < 5){
			
		String choixtxt = Console.lireString("Choisir pierre, feuille ou ciseaux ? ");
		int resultat = 0;
		
		if (choixtxt.trim().toLowerCase().compareTo("feuille") == 0) {
			choix = 0;
		} else if (choixtxt.trim().toLowerCase().compareTo("pierre") == 0) {
			choix = 1;
		}else if (choixtxt.trim().toLowerCase().compareTo("ciseaux") == 0) {
			choix = 2;
		}else {
			return;
		}
		
		resultat = shifumi(choix);
		
		if (resultat == 0) {
			System.out.println("Egalité");
		} else if (resultat == 1) {
			System.out.println("Point au joueur 1.");
			pointJ1++;
		} else if (resultat == 2) {
			System.out.println("Point à l'IA");
			pointIA++;
		}
		System.out.printf("Joueur %d - %d IA \n", pointJ1, pointIA);
		
	}
		if (pointIA == 5) {
			System.out.println("Victoire pour l'ia !");
		}else {
			System.out.println("Victoire pour le joueur 1 !");
		}
	}
	
}
