package chap6;

import io.Console;

public class NumerosInternationaux {

	public static void main(String[] args) {
		
		// Variable
		String  numTel;
		String paysOrigine;
		
		// Acquisition
		numTel = Console.lireString("Numéro international ? ").trim();
		
		// Traitement
		// Déterminer le pays d'origine du numéro
		// +31 ou 0031 -> Pays-Bas
		// +32 ou 0032 -> Belgique
		// +33 ou 0033 -> France
		// +34 ou 0034 -> Espagne
		
		
		switch (numTel.substring(0, 3)) {
		case "+31" -> paysOrigine = "Pays-Bas";
		case "+32" -> paysOrigine = "Belgique";
		case "+33" -> paysOrigine = "France";
		case "+34" -> paysOrigine = "Espagne";

		default -> paysOrigine = "Inconnu";
		}
		
		System.out.println("Pays d'origine = " + paysOrigine);
		
	}
	
}
