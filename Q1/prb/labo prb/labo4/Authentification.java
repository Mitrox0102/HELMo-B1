package labo4;

import io.*;

public class Authentification {

	public static void VerificationNom (String nom, String mdp) {
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		final String DIR = "data/authentification.txt";
		
		String nom, mdp;
		
		Console.simulerSaisies("Thor", "marteau83");
		
		nom = Console.lireString("Nom utilisateur ? ");
		mdp = Console.lireString("Mot de passe ? ");
		
		nom = nom.trim().toLowerCase();
		
		if(!Fichier.contientCle(DIR, nom)) {
			System.out.printf("Données incorrectes ! Veuillez réessayer");
			return;
		}
		
		else if (!Fichier.lireString(DIR, nom).equals(mdp)){
			System.out.printf("Mot de passe incorrectes ! Veuillez réessayer");
			return;
			
		} else {
			System.out.printf("Bienvenue %s ! Vous êtes maintenant connecté.", nom);
		} 
		
	}
	
}
