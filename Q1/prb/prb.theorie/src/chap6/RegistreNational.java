package chap6;

import io.Console;

public class RegistreNational {
	public static void main(String[]args) {
		
		//variables 
		String numeroRegNat;
		
		//acquisition
		Console.simulerSaisies("36.10.21-171.54");

		numeroRegNat = Console.lireString("Numero de registre nationnal (XX.XX.XX-XXX.XX) ? ");
		
		//traitement
		System.out.printf("Le numéro nationnal est : %b", estNumeroValide(numeroRegNat));
	}
	
	public static boolean estNumeroValide(String numeroRegNat) {
		//eliminer les caractères '.' et '-'
		numeroRegNat = numeroRegNat.replaceAll("[.-]", "");//expression regulière qui dit que dès que le programme trouve un point ou un trait d'union, il remplace ça par rien
		
		// Vérifier la présence des 11 chiffre uniquement
		
		if(numeroRegNat.matches("\\d{11}") == false) { // Rchercher signification et utilisation
			return false;
		}
		
		//extraire les 9 premiers chiffres 
		
		int premiersChiffres= Integer.parseInt(numeroRegNat.substring(0,9));
		
		//extraire les 2 derniers chiffres 
		
		int chiffreControle= Integer.parseInt(numeroRegNat.substring(9));
		
		
		//verifier l'égalité avec le chiffre de controle 
		if (97 - premiersChiffres % 97 == chiffreControle) {
			return true;
		}
		
		// Vérifier pour une personne née à partir du 1er janvier 2000
		premiersChiffres += 2e9;
		if (97 - premiersChiffres % 97 == chiffreControle) {
			return true;
		}
		
		return false; 
		}

}
