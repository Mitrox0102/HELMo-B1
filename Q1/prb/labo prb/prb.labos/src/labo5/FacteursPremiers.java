package labo5;

import io.*;
import util.*;

public class FacteursPremiers {
	
	public static void DivisionPremiere(int nb) {
		
		System.out.printf("Décomposition de 4312 en produit de facteurs premiers = ");
		
		int diviseur = 2;
		
		while (nb != 1) {
			
			if (nb % diviseur == 0) {
				nb /= diviseur;
				System.out.printf("%d ", diviseur);
			} else {
				diviseur ++;
			}
			
			
		}
		
	}

	public static void main(String[] args) {
		
		int nb = Console.lireInt("Entier >= 2 ? ");
		
		if (nb < 2) {
			System.out.println("Entier pas pris en compte (inférieur à 2)");
			return;
		}
		
		DivisionPremiere(nb);
		
	}
	
}
