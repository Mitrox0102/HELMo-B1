package labo5;

import io.Fichier;

/**
 * Cette classe permet d'extraire des mots provenant du fichier
 * "dictionnaire.txt" placé dans le répertoire "data" de votre projet.
 *
 * @author Arnaud Comblin
 * @version 1.1
 */
public class Dictionnaire {

	private final static String CHEMIN_FICHIER = "data/dictionnaire.txt";

	private static String[] mots = Fichier.lireLignes(CHEMIN_FICHIER);

	/**
	 * Retourne un mot du fichier "data/dictionnaire.txt" sur base d'un numéro.
	 *
	 * @param numero le numéro du mot (les mots sont numérotées à partir de 0).
	 * @return le mot correspondant au numero spécifié s'il existe, null dans le cas
	 *         contraire.
	 */
	static String getMot(int numero) {
		String mot = null;
		if (numero >= 0 && numero < nombreMots()) {
			mot = mots[numero];
		}
		return mot;
	}

	/**
	 * Retourne le nombre de mots présents dans le fichier "data/dictionnaire.txt".
	 *
	 * @return le nombre de mots.
	 */
	static int nombreMots() {
		return mots.length;
	}

}
