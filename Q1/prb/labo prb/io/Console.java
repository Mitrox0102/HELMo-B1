package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Cette classe propose différentes fonctions permettant de réaliser
 * l'acquisition d'une donnée au format approprié.
 *
 * @author Arnaud Comblin
 * @version 1.5
 */
public class Console {

	private static BufferedReader lecteur = new BufferedReader(new InputStreamReader(System.in));

	private static LinkedBlockingQueue<String> saisies = new LinkedBlockingQueue<String>();

	/**
	 * Récupère la saisie de l'utilisateur au format String.
	 * 
	 * @return La chaîne de caractères saisie.
	 * @throws InvalidInputException Si une erreur survient lors de la saisie.
	 * @since 1.4
	 */
	public static String lireString() {
		String resultat = null;
		try {
			if (saisies.isEmpty()) {
				resultat = lecteur.readLine();
			} else {
				resultat = saisies.remove();
				System.out.println(resultat);
			}
		} catch (IOException e) {
			throw new InvalidInputException("Erreur dans Console.lireString !", e);
		}
		return new String(resultat);
	}

	/**
	 * Récupère la saisie de l'utilisateur au format String.
	 * 
	 * @param message Le texte à afficher pour indiquer à l'utilisateur la donnée
	 *                attendue.
	 * @return La chaîne de caractères saisie.
	 * @throws InvalidInputException Si une erreur survient lors de la saisie.
	 * @since 1.3
	 */
	public static String lireString(String message) {
		System.out.print(message);
		return lireString();
	}

	/**
	 * Récupère la saisie de l'utilisateur au format char.
	 * 
	 * @return Le premier caractère de la saisie si elle en contient au moins un.
	 * @throws InvalidInputException Si aucun caractère n'est saisi par
	 *                               l'utilisateur.
	 * @since 1.0
	 */
	public static char lireChar() {
		char resultat;
		try {
			resultat = lireString().charAt(0);
		} catch (StringIndexOutOfBoundsException e) {
			throw new InvalidInputException("Erreur dans Console.lireChar : la saisie ne comporte aucun caractère !",
					e);
		}
		return resultat;
	}

	/**
	 * Récupère la saisie de l'utilisateur au format char.
	 * 
	 * @param message Le texte à afficher pour indiquer à l'utilisateur la donnée
	 *                attendue.
	 * @return Le premier caractère de la saisie si elle en contient au moins un.
	 * @throws InvalidInputException Si aucun caractère n'est saisi par
	 *                               l'utilisateur.
	 * @since 1.3
	 */
	public static char lireChar(String message) {
		System.out.print(message);
		return lireChar();
	}

	/**
	 * Récupère la saisie de l'utilisateur au format int.
	 * 
	 * @return Un entier si la valeur saisie représente un entier compris entre
	 *         -2^31 et 2^31-1.
	 * @throws InvalidInputException Si la valeur saisie ne représente pas un entier
	 *                               correctement formé.
	 * @since 1.0
	 */
	public static int lireInt() {
		int resultat;
		try {
			resultat = Integer.parseInt(lireString().trim());
		} catch (NumberFormatException e) {
			throw new InvalidInputException(
					"Erreur dans Console.lireInt : la saisie n'est pas un nombre entier valide !", e);
		}
		return resultat;
	}

	/**
	 * Récupère la saisie de l'utilisateur au format int.
	 * 
	 * @param message Le texte à afficher pour indiquer à l'utilisateur la donnée
	 *                attendue.
	 * @return Un entier si la valeur saisie représente un entier compris entre
	 *         -2^31 et 2^31-1.
	 * @throws InvalidInputException Si la valeur saisie ne représente pas un entier
	 *                               correctement formé.
	 * @since 1.3
	 */
	public static int lireInt(String message) {
		System.out.print(message);
		return lireInt();
	}

	/**
	 * Récupère la saisie de l'utilisateur au format long.
	 * 
	 * @return Un entier si la valeur saisie représente un entier compris entre
	 *         -2^63 et 2^63-1.
	 * @throws InvalidInputException Si la valeur saisie ne représente pas un entier
	 *                               correctement formé.
	 * @since 1.0
	 */
	public static long lireLong() {
		long resultat;
		try {
			resultat = Long.parseLong(lireString().trim());
		} catch (NumberFormatException e) {
			throw new InvalidInputException(
					"Erreur dans Console.lireLong : la saisie n'est pas un nombre entier valide !", e);
		}
		return resultat;
	}

	/**
	 * Récupère la saisie de l'utilisateur au format long.
	 * 
	 * @param message Le texte à afficher pour indiquer à l'utilisateur la donnée
	 *                attendue.
	 * @return Un entier si la valeur saisie représente un entier compris entre
	 *         -2^63 et 2^63-1.
	 * @throws InvalidInputException Si la valeur saisie ne représente pas un entier
	 *                               correctement formé.
	 * @since 1.3
	 */
	public static long lireLong(String message) {
		System.out.print(message);
		return lireLong();
	}

	/**
	 * Récupère la saisie de l'utilisateur au format float.
	 * 
	 * @return Un réel si la valeur saisie représente une valeur numérique.
	 * @throws InvalidInputException Si la valeur saisie ne représente pas un réel
	 *                               correctement formé.
	 * @since 1.0
	 */
	public static float lireFloat() {
		float resultat;
		try {
			resultat = Float.parseFloat(lireString().replaceAll(",", "."));
		} catch (NumberFormatException e) {
			throw new InvalidInputException(
					"Erreur dans Console.lireFloat : la saisie n'est pas un nombre réel valide !", e);
		}
		return resultat;
	}

	/**
	 * Récupère la saisie de l'utilisateur au format float.
	 * 
	 * @param message Le texte à afficher pour indiquer à l'utilisateur la donnée
	 *                attendue.
	 * @return Un réel si la valeur saisie représente une valeur numérique.
	 * @throws InvalidInputException Si la valeur saisie ne représente pas un réel
	 *                               correctement formé.
	 * @since 1.3
	 */
	public static float lireFloat(String message) {
		System.out.print(message);
		return lireFloat();
	}

	/**
	 * Récupère la saisie de l'utilisateur au format double.
	 * 
	 * @return Un réel si la valeur saisie représente une valeur numérique.
	 * @throws InvalidInputException Si la valeur saisie ne représente pas un réel
	 *                               correctement formé.
	 * @since 1.0
	 */
	public static double lireDouble() {
		double resultat;
		try {
			resultat = Double.parseDouble(lireString().replaceAll(",", "."));
		} catch (NumberFormatException e) {
			throw new InvalidInputException(
					"Erreur dans Console.lireDouble : la saisie n'est pas un nombre réel valide !", e);
		}
		return resultat;
	}

	/**
	 * Récupère la saisie de l'utilisateur au format double.
	 * 
	 * @param message Le texte à afficher pour indiquer à l'utilisateur la donnée
	 *                attendue.
	 * @return Un réel si la valeur saisie représente une valeur numérique.
	 * @throws InvalidInputException Si la valeur saisie ne représente pas un réel
	 *                               correctement formé.
	 * @since 1.3
	 */
	public static double lireDouble(String message) {
		System.out.print(message);
		return lireDouble();
	}

	/**
	 * Ajoute les chaînes de caractères à considérer comme les prochaines saisies de
	 * l'utilisateur. Lorsqu'une fonction de lecture de la classe Console est
	 * exécutée, elle consomme en priorité ces chaînes de caractères, et ce, par
	 * ordre d'ajout (FIFO).
	 * 
	 * @param saisies les chaînes de caractères se substituant aux saisies de
	 *                l'utilisateur.
	 * @throws IllegalArgumentException - si une référence null est fournie en tant
	 *                                  que saisie.
	 * @since 1.5
	 */
	public static void simulerSaisies(Object... saisies) {
		for (Object saisie : saisies) {
			if (saisie == null) {
				throw new IllegalArgumentException(
						"Erreur dans Console.simulerSaisies : une référence null n'est pas admise pour simuler une saisie !");
			}
			Console.saisies.add(String.valueOf(saisie));
		}
	}

	/**
	 * Supprime toutes les chaînes de caractères se substituant aux saisies de
	 * l'utilisateur.
	 * 
	 * @since 1.2
	 */
	public static void nettoyerSaisies() {
		saisies.clear();
	}

}

/**
 * Exception lancée pour indiquer qu'une saisie non conforme à ce qui était
 * attendu a été effectuée par l'utilisateur.
 *
 * @since 1.5
 */
class InvalidInputException extends RuntimeException {

	private static final long serialVersionUID = 8449071954662050456L;

	public InvalidInputException(String message, Throwable cause) {
		super(message, cause);
	}

}