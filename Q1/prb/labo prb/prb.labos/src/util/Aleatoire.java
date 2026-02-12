package util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Cette classe propose différentes fonctions permettant de générer des nombres
 * pseudo-aléatoires.
 *
 * @author Arnaud Comblin
 * @version 1.3
 */
public class Aleatoire {

	private static Random generateur = new Random();

	private static Queue<Integer> nombres = new LinkedList<Integer>();

	/**
	 * Dans le cadre de tests unitaires, cette fonction permet de déterminer les
	 * nombres qui doivent être retournés successivement par les fonctions
	 * {@code aleatoire()}, {@code aleatoire(int)} et {@code aleatoire(int, int)}.
	 * 
	 * @param nombres - un nombre quelconque de nombres entiers spécifiés dans
	 *                l'ordre dans lequel ils doivent être retournés
	 * @since 1.2
	 * @implSpec Les nombres spécifiés s'ajoutent à ceux précédemment ajoutés via
	 *           cette même fonction s'ils n'ont pas tous déjà été retournés par les
	 *           fonctions nommées {@code aleatoire}.
	 */
	public static void specifierNombres(int... nombres) {
		for (int nombre : nombres) {
			Aleatoire.nombres.add(nombre);
		}
	}

	/**
	 * Dans le cadre de tests unitaires, cette fonction permet de retirer les
	 * nombres précédemment ajoutés via la fonction {@code specifierNombres(int...)}
	 * qui n'ont pas encore été retournés par l'une des fonctions nommées
	 * {@code aleatoire}.
	 * 
	 * @since 1.2
	 */
	public static void effacerNombres() {
		nombres.clear();
	}

	/**
	 * Retourne un nombre pseudo-aléatoire compris entre 0 et
	 * {@code Integer.MAX_VALUE} inclus. Si des nombres entiers ont été
	 * préalablement spécifiés via la fonction {@code specifierNombres(int...)},
	 * ceux-ci sont retournés prioritairement.
	 * 
	 * @return un nombre entier compris dans l'intervalle [0 ;
	 *         {@code Integer.MAX_VALUE}]
	 * @throws IllegalArgumentException si un nombre fourni préalablement via la
	 *                                  fonction {@code specifierNombres(int...)}
	 *                                  est en-dehors de l'intervalle [0 ;
	 *                                  {@code Integer.MAX_VALUE}].
	 * @since 1.0
	 */
	public static int aleatoire() {
		return aleatoire(Integer.MAX_VALUE);
	}

	/**
	 * Retourne un nombre pseudo-aléatoire compris entre 0 et une borne supérieure
	 * inclusive. Si des nombres entiers ont été préalablement spécifiés via la
	 * fonction {@code specifierNombres(int...)}, ceux-ci sont retournés
	 * prioritairement.
	 * 
	 * @param sup - la borne supérieure inclusive
	 * @return un nombre entier compris dans l'intervalle [0 ; {@code sup}]
	 * @throws IllegalArgumentException si la borne supérieure {@code sup} n'est pas
	 *                                  plus grande ou égale à 0 ; si un nombre
	 *                                  fourni préalablement via la fonction
	 *                                  {@code specifierNombres(int...)} est
	 *                                  en-dehors de l'intervalle [0 ; {@code sup}].
	 * @since 1.0
	 */
	public static int aleatoire(int sup) {
		return aleatoire(0, sup);
	}

	/**
	 * Retourne un nombre pseudo-aléatoire compris entre une borne inférieure et une
	 * borne supérieure inclusives. Si des nombres entiers ont été préalablement
	 * spécifiés via la fonction {@code specifierNombres(int...)}, ceux-ci sont
	 * retournés prioritairement.
	 * 
	 * @param inf - la borne inférieure inclusive
	 * @param sup - la borne supérieure inclusive
	 * @return un nombre entier compris dans l'intervalle [{@code inf} ;
	 *         {@code sup}]
	 * @throws IllegalArgumentException si la borne supérieure {@code sup} n'est pas
	 *                                  plus grande ou égale à la borne inférieure
	 *                                  {@code inf} ; si un nombre fourni
	 *                                  préalablement via la fonction
	 *                                  {@code specifierNombres(int...)} est
	 *                                  en-dehors de l'intervalle [{@code inf} ;
	 *                                  {@code sup}].
	 * @since 1.3
	 */
	public static int aleatoire(int inf, int sup) {
		if (inf > sup) {
			throw new IllegalArgumentException(String
					.format("Le borne inférieure %d doit être plus petite que la borne supérieure %d.", inf, sup));
		}

		Integer nombre = nombres.poll();
		if (nombre != null) {
			if (nombre < inf || nombre > sup) {
				throw new IllegalArgumentException(
						String.format("Le nombre %d spécifié n'est pas compris entre %d et %d.", nombre, inf, sup));
			}
			return nombre;
		}
		
		return (int) (inf + Math.abs(generateur.nextLong()) % (1L + sup - inf));
	}

}
