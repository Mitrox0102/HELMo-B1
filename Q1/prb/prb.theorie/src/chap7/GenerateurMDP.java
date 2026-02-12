package chap7;

import io.*;

public class GenerateurMDP {
	
	public static String genererMotDePasse (int lgMdp) {
		// VERSION 1 : travailler avec les codes des caractères
		String mdp ="";
		char car = '.';
		int compteur = 1;
		

		while (compteur <= lgMdp) {
			
			int choix = Aleatoire.aleatoire(2);
			
			car = switch (choix) {
			case 0 -> (char) ('A' + Aleatoire.aleatoire(25));
			
			case 1 -> (char) ('a' + Aleatoire.aleatoire(25));
			
			case 2 -> (char) ('0' + Aleatoire.aleatoire(9));
			
			default ->
			throw new IllegalArgumentException("Unexpected value: " + choix);
			};
			
			mdp += car;
			
			compteur ++;
		}
		
		// VERSION 2 : la même chose avec une boucle for
		
		/*
		mdp = "";
		for(compteur = 1;compteur <= lgMdp; compteur++) {
			
			int choix = Aleatoire.aleatoire(2);
			
			car = switch (choix) {
			case 0 -> (char) ('A' + Aleatoire.aleatoire(25));
			
			case 1 -> (char) ('a' + Aleatoire.aleatoire(25));
			
			case 2 -> (char) ('0' + Aleatoire.aleatoire(9));
			
			default ->
			throw new IllegalArgumentException("Unexpected value: " + choix);
			};
			
			mdp += car;
			
		};
		*/
		
		/*
		// VERSION 3 : autre approche, toujours avec la boucle for
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		mdp = "";
		for(int i = 1; i <= lgMdp; i++) {
			
			car = caracteres.charAt(Aleatoire.aleatoire(caracteres.length() - 1));
			// 1 chance sur 2 de transformer le caractere en minuscule
			
			int choix = Aleatoire.aleatoire(1);
			
			if (choix == 0) {
				Character.toLowerCase(car);
			}

			};

			mdp += car;
		};
		*/
		return mdp;
	}


	public static void main(String[] args) {
		
		int longueurMdp = Console.lireInt("Longueur du mot de passe ? ");
		int nbMdp = Console.lireInt("Combien de mots de passe ? ");
		
		for(int i = 0; i < nbMdp;i++) {
			
			String mdp = genererMotDePasse(longueurMdp);
			
			System.out.println(mdp);
			
		}
		
		
		
	}
	
	
}
