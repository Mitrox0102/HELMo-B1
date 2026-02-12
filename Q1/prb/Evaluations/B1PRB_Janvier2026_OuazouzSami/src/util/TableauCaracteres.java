package util;

import java.util.Iterator;

public class TableauCaracteres {

	/**
	 * Cette fonction nous permet de compter le nombre d'occurence du même caractère c dans le tableau t
	 * @param t c'est le tableau en entrée de l'utilisateur, une dimension
	 * @param c C'est le caractère qu'on souhaite rechercher dans le tableau
	 * @return On nous renvoie le nombre d'occurence du caractère c dans t
	 */
	public static int compter(char[] t, char c) {

		if (t == null)
			return -1;

		int cmp = 0;

		for (int i = 0; i < t.length; i++) {

			if (c == t[i]) {

				cmp++;

			}

		}

		return cmp;
	}

	/**
	 * Cette fonction nous permet d'extraire une colonne et de la transofrmer en tableau ç une dimension
	 * @param t C'est le tableau rentrée en donnée par l'utilisateur
	 * @param j C'est l'indice de la colonne qu'on souhaite extraire
	 * @return on nous renvoie la colonne j sous forme d'un tableau à une dimension
	 */
	public static char[] extraireColonne(char[][] t, int j) {

		if (t == null || j >= t[0].length || j < 0)
			return null;

		int indiceSousTableau = 0;
		char[] nvTab = new char[t.length];

		for (int i = 0; i < t.length; i++) {
			for (int k = 0; k < t[i].length; k++) {

				if (k == j) {
					nvTab[indiceSousTableau] = t[i][k];
					indiceSousTableau++;
				}
			}
		}
		return nvTab;

	}

	/**
	 * Cette fonction nous indique s'il y a plus de 3 occurence du même caractère dans le tableau t
	 * @param t C'est le tableau en entre de l'utilisateur
	 * @param c C'est le caractère qu'on recherche dans le tableau
	 * @return on nous indique par vrai ou faux si il y a un série de 3 fois le caractère recherché
	 */
	public static boolean troisConsecutifs(char[] t, char c) {

		if (t == null)
			return false;

		for (int i = 0; i < t.length - 2; i++) {
			if (t[i] == c && t[i + 1] == c && t[i + 2] == c) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Cette fonction nous indique s'il y a bien au moins une fois le caractère c
	 * @param t C'est le tableau en entré de l'utilisateur
	 * @param c C'est le caractère recherché
	 * @return on nous indique par vrai ou faux si le caractère est present dans le tableau
	 */
	public static boolean contient(char[][] t, char c) {

		if (t == null)
			return false;

		int cmp = 0;

		for (int i = 0; i < t.length; i++) {

			cmp += compter(t[i], c);

		}
		if (cmp >= 1)
			return true;

		return false;
	}

}
