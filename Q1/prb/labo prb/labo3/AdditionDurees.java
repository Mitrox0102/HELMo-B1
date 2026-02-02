package labo3;

import io.Console;

/** 
 * Ici, nous avons fait un programme dans lequel
 * nous sommes capables d'additionner 2 heures.
 * */

public class AdditionDurees {

	public static void main(String[] args) {

		String duree1EnString = Console.lireString("Ecrivez l'heure au format .h.min.s :");
		String duree2EnString = Console.lireString("Ecrivez l'heure au format .h.min.s :");

		// Déclaration des variables

		int hT, mT, sT;
		int h, m, s;
		int h1, m1, s1, h2, m2, s2;
		int d1, d2, dT;

		// Assignation des differents éléments

		h = duree1EnString.indexOf("h");
		m = duree1EnString.indexOf("min");
		s = duree1EnString.indexOf("s");

		h1 = Integer.parseInt(duree1EnString.substring(0, h).trim());

		m1 = Integer.parseInt(duree1EnString.substring(h + 1, m).trim());

		s1 = Integer.parseInt(duree1EnString.substring(m + 3, s).trim());

		h = duree2EnString.indexOf("h");
		m = duree2EnString.indexOf("min");
		s = duree2EnString.indexOf("s");

		h2 = Integer.parseInt(duree2EnString.substring(0, h).trim());

		m2 = Integer.parseInt(duree2EnString.substring(h + 1, m).trim());

		s2 = Integer.parseInt(duree2EnString.substring(m + 3, s).trim());

		// Conversion en secondes

		d1 = h1 * 3600 + m1 * 60 + s1;
		d2 = h2 * 3600 + m2 * 60 + s2;

		// Addition

		dT = d1 + d2;
		hT = dT / 3600;
		dT %= 3600;
		mT = dT / 60;
		sT = dT % 60;
		System.out.printf("%dh %dmin %ds\n", hT, mT, sT);
	}
}
