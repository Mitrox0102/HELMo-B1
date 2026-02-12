package util;

public class Caractere {

	/**
	 * Convertit en indices de ligne et de colonne une chaîne de caractères
	 * représentant les coordonnées d'une case située dans une grille.
	 * <p>
	 * Les coordonnées doivent être fournies sous la forme d'une lettre alphabétique
	 * suivie d'un nombre entier exprimé en base 10 (par exemple {@code "A1"}). La
	 * lettre correspond à la ligne (en commençant par {@code 'A'}) et le chiffre
	 * correspond à la colonne (en commençant par {@code '1'}).
	 * </p>
	 *
	 * <p>
	 * Par exemple :
	 * <ul>
	 * <li>{@code "A1"} ⟶ {@code [0, 0]}</li>
	 * <li>{@code "C2"} ⟶ {@code [2, 1]}</li>
	 * </ul>
	 * </p>
	 *
	 * @param coord - Une chaîne de caractères représentant les coordonnées à
	 *              convertir (ne doit pas être {@code null} et doit respecter le
	 *              format {@code LettreChiffres})
	 * @return un tableau {@code [i, j]} où {@code i} est l'indice de la ligne et
	 *         {@code j} est l'indice de la colonne.
	 */
	public static int[] convertirCoord(String coord) {
		return new int[] { Character.toUpperCase(coord.charAt(0)) - 'A', Integer.parseInt(coord.substring(1)) - 1 };
	}

	/**
	 * Détermine si le caractère spécifié est une lettre alphabétique non accentuée,
	 * minuscule ou majuscule.
	 * 
	 * @param c - Le caractère à vérifier.
	 * @return {@code true} si le caractère une lettre alphabétique, {@code false}
	 *         dans le cas contraire.
	 */
	public static boolean estAlpha(char c) {
		return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
	}

	/**
	 * Détermine si le caractère spécifié est un chiffre de la base 10.
	 * 
	 * @param c - Le caractère à vérifier.
	 * @return {@code true} si le caractère un chiffre, {@code false} dans le cas
	 *         contraire.
	 */
	public static boolean estChiffre(char c) {
		return (c >= '0' && c <= '9');
	}

}
