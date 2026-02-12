package chap7;

import io.*;

/**
 * Ce programme permet de convertir un entier compris entre 0 et 255
 * en binaire.
 */
public class EnBinaire {

	public static void main(String[] args) {
		// Variable pour la donnée saisie
		String base2;
		int base10;
		
		// Variables pour le résultat
		int bit0, bit1, bit2, bit3, bit4, bit5, bit6, bit7;
		
		// Acquisition de nombre entier
		base10 = Console.lireInt("Entier entre 0 et 255 ? ");
		
		base2 = ""; // chaine vide comme valeur initiale
		
		do {
			base2 = base10 % 2 + base2;
			bit0 = base10 % 2;
			base10 = base10 / 2;
		} while (base10 != 0);
		
	}

}