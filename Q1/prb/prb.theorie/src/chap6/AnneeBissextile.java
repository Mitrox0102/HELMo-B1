package chap6;

import io.*;

public class AnneeBissextile {

	public static void main(String[] args) {
		
		int annee = Console.lireInt("Année ? ");
		
		System.out.print(annee);
		
		if (estBissextile(annee) == true) {
			System.out.println(" est bissextile.");
		} else {
			System.out.println(" n'est pas bissextile");
		}
		
	}

	private static boolean estBissextile(int annee) {

		if ((annee % 4 == 0) && (annee % 100 != 0) || (annee % 400 == 0)) {
			return true;
		}
		return false;
	}
	
}
