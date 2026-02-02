package util;

import java.util.Arrays;

public class TableauChaines {

	public static void permuter(String[] tableau, int i, int j) {
		String temp = tableau[i];
		tableau[i] = tableau[j];
		tableau[j] = temp;
	}

	public static void melanger(String[] tableau) {
		for (int i = 0; i < tableau.length; i++) {
			permuter(tableau, i, Aleatoire.aleatoire(tableau.length - 1));
		}
	}

	public static String toString(String[] tableau, int nbElements) {
		String output = "";
		for (int i = 0; i < nbElements; i++) {
			output += tableau[i];
			if (i < nbElements - 1) {
				output += ", ";
			}
		}
		return output;
	}

	public static boolean contient(String[] t, String chaine) {

		boolean output = false;

		chaine = chaine.trim().toLowerCase();

		for (int i = 0; i < t.length; i++) {

			if (t[i] != null && t[i].toLowerCase().trim().equals(chaine))
				output = true;
		}
		return output;

	}

	public static String[] ajouterElement(String[] t, String element) {

		String[] newTab = new String[t.length + 1];

		System.arraycopy(t, 0, newTab, 0, t.length);

		newTab[t.length] = element;

		return newTab;

	}

	public static void main(String[] args) {

		String[] tab = { "1", "2" };

		tab = ajouterElement(tab, "3");

		System.out.println(Arrays.toString(tab));

	}

}
