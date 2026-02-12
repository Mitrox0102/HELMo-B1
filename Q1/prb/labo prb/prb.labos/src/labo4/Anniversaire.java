package labo4;

import io.*;

import util.*;

public class Anniversaire {

	public static void main(String[] args) {
		
		int difJour;
		
		String anni = Console.lireString("La date de votre anniversaire (j/m) ? ");
		int index = anni.indexOf('/');
		int jourAnni = Integer.parseInt(anni.substring(0, index));
		int moisAnni = Integer.parseInt(anni.substring(index +1));
		
		
		int numAuj = Date.numeroJour();
		
		int annif = Date.numeroJour(30, 1, 2028);
		
		difJour = annif - numAuj;
		
		System.out.println(difJour);
		
		/*
		30 déc -> 364 ou 365
		30 janv -> 30
		*/
		
		if(difJour == 0) {
			System.out.println("Joyeux anniversaire !");
		} else if ((difJour > 0 && difJour <= 31) || (difJour >= -365 && difJour <= -334)) {
			System.out.println("Super ! C'est bientôt votre anniversaire.");
		} else {
			System.out.println("Dommage ! Votre anniversaire est encore loin.");
		}
	}
	
}
