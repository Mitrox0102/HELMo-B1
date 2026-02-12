package chap7;

import io.*;

public class DistributeurBillets {
	
	public static void main(String[] args) {
		
		// Variables
		String montantSaisi, choixContinuer;
		boolean choix;
		int montant;
		int qte200, qte100, qte50, qte20, qte10;
		
		do {
			
			do {
				do {
					
					montantSaisi = Console.lireString("Montant en euro ? ");
					
					//Répéter l'acquisition tant que la valeur saisie
					//ne correspond pas à un entier de 1 à 3 chiffres.
					
				} while (montantSaisi.matches("\\d{1,3}") == false);
				montant = Integer.parseInt(montantSaisi);
				
				}while(montant < 0 || montant % 10 != 0);
				
	
			
			// Traitement
			// 1. Déterminer le nombre de billets de 200
			qte200 = montant / 200;
			montant = montant % 200;
			
			// 2. Déterminer le nombre de billets de 100
			qte100 = montant / 100;
			montant = montant % 100;
			
			// 3. Déterminer le nombre de billets de 50
			qte50 = montant / 50;
			montant = montant % 50;
			
			// 4. Déterminer le nombre de billets de 20
			qte20 = montant / 20;
			montant = montant % 20;
			
			// 5. Déterminer le nombre de billets de 10
			qte10 = montant / 10;
			montant = montant % 10;
			
			// Affichage des résultats
			
			System.out.printf("%d fois 200\n", qte200);
			System.out.printf("%d fois 100\n", qte100);
			System.out.printf("%d fois  50\n", qte50);
			System.out.printf("%d fois  20\n", qte20);
			System.out.printf("%d fois  10\n", qte10);
			
			do {
			choixContinuer = Console.lireString ("Retirer un autre montant (oui/non) ? ").toLowerCase().trim();
			
			} while (!choixContinuer.equalsIgnoreCase("oui") && !choixContinuer.equalsIgnoreCase("non"));
			
		} while (choixContinuer.equalsIgnoreCase("oui"));
		
		System.out.printf("Fin de l'application.");
		
	}
		
	
}