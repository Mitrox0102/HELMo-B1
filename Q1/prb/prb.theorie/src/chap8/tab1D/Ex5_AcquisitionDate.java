package chap8.tab1D;

import io.*;

public class Ex5_AcquisitionDate {

	public static void main(String[] args) {
		// Acquérir la date de naissance
		String ddn = Console.lireString("Date de naissance (j/m/a) ? ").trim();

		// Extraire les valeurs des jour, mois et année
		int[] jma = extraireDate(ddn);

		// TODO: Afficher le jour de la semaine correspondant à la date de naissance à
		// l'aide des fonctions de la classe "Date".

		String nomJour = Date.nomJourSemaine(jma).toLowerCase();
		System.out.println("Vous êtes né un " + nomJour + ".");
		
	}

	public static int[] extraireDate(String date) {
		// TODO: Extraire les différentes parties avec la fonction "split" de la classe
		// String
		
		String[] jmaEnStr = date.split("/");

		// TODO: Créer un tableau permettant d'enregistrer les valeurs entières

		int[] jma = new int[jmaEnStr.length];
		
		// TODO: Placer dans le tableau les entiers obtenus à partir des chaines
		// extraites
		
		for(int i = 0; i< jmaEnStr.length; i ++) {
			
			jma[i] = Integer.parseInt((jmaEnStr[i]));
			
		}

		// TODO: Retourner la référence du tableau
		return jma;
	}

}
