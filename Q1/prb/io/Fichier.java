package io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Cette classe propose différentes fonctions permettant de réaliser des
 * opérations simples de lecture et d'écriture sur un fichier.
 * <p>
 * Notez que ces fonctions n'ont pas été prévues pour effectuer des opérations
 * sur des fichiers volumineux.
 *
 * @author Arnaud Comblin
 * @version 1.4
 */
public class Fichier {

	private final static Charset ENCODAGE = StandardCharsets.UTF_8;

	private final static String SEPARATEUR = "=";
	private final static String REMPLACEMENT_SEPARATEUR = "&#" + (int) SEPARATEUR.charAt(0) + ";";

	private final static String LF = "\n";
	private final static String REMPLACEMENT_LF = "&#" + (int) '\n' + ";";

	private final static String CRLF = "\r\n";
	private final static String REMPLACEMENT_CRLF = "&#" + (int) '\r' + ";" + REMPLACEMENT_LF;

	/**
	 * Écrit des lignes de texte dans un fichier. Chaque ligne écrite est ponctuée
	 * d'un saut de ligne. L'encodage utilisé est l'UTF-8.
	 * <p>
	 * Si le fichier et les dossiers spécifiés n'existent pas, alors la fonction
	 * essaie de les créer.
	 * 
	 * @param cheminFichier Le chemin d'accès au fichier.
	 * @param lignes        Les lignes à écrire dans le fichier.
	 * @return {@code true} si l'opération a réussi, {@code false} dans le cas
	 *         contraire.
	 */
	public static boolean ecrireLignes(String cheminFichier, String... lignes) {
		return ecrireLignes(cheminFichier, ENCODAGE, List.of(lignes));
	}

	/**
	 * Lit toutes les lignes de texte d'un fichier. L'encodage utilisé est l'UTF-8.
	 * 
	 * @param cheminFichier Le chemin d'accès au fichier.
	 * @return L'ensemble des lignes de texte lues dans le fichier, ou {@code null}
	 *         si le fichier n'existe pas.
	 */
	public static String[] lireLignes(String cheminFichier) {
		List<String> lignes = lireLignes(cheminFichier, ENCODAGE);
		return (lignes != null) ? (String[]) lignes.toArray(String[]::new) : null;
	}

	/**
	 * Ajoute une association clé-valeur dans le fichier spécifié. Si le fichier
	 * contient déjà une association pour cette clé, la valeur actuelle est
	 * remplacée par la nouvelle.
	 * <p>
	 * Si le fichier et les dossiers spécifiés n'existent pas, alors la fonction
	 * essaie de les créer.
	 * 
	 * @param cheminFichier Le chemin d'accès au fichier.
	 * @param cle           La clé à laquelle la valeur doit être associée.
	 * @param valeur        La valeur à associer à la clé.
	 * @return La valeur précédemment associée à la clé, ou {@code null} si le
	 *         fichier ne peut être créé ou s'il ne contient pas d'association pour
	 *         cette clé.
	 */
	public static String ecrireValeur(String cheminFichier, String cle, Object valeur) {
		Map<String, String> map;
		if (existe(cheminFichier)) {
			map = chargerMap(cheminFichier);
		} else if (!creer(cheminFichier)) {
			return null;
		} else {
			map = new HashMap<>();
		}
		String ancienneValeur = map.put(cle, valeur.toString());
		enregistrerMap(cheminFichier, map);
		return ancienneValeur;
	}

	/**
	 * Renvoie {@code true} si le fichier contient une association avec la clé
	 * spécifiée.
	 * 
	 * @param cheminFichier Le chemin d'accès au fichier.
	 * @param cle           La clé dont la présence doit être vérifiée.
	 * @return {@code true} si le fichier contient la clé spécifiée, ou
	 *         {@code false} si le fichier ou la clé n'existe pas.
	 */
	public static boolean contientCle(String cheminFichier, String cle) {
		Map<String, String> map = chargerMap(cheminFichier);
		return map.containsKey(cle);
	}

	/**
	 * Renvoie l'ensemble des clés utilisées dans le fichier spécifié.
	 * 
	 * @param cheminFichier Le chemin d'accès au fichier.
	 * @return un tableau contenant toutes les clés.
	 */
	public static String[] cles(String cheminFichier) {
		Map<String, String> map = chargerMap(cheminFichier);
		return map.keySet().toArray(String[]::new);
	}

	/**
	 * Récupère la valeur associée à une clé sous la forme d'une valeur de type
	 * {@link String}.
	 * 
	 * @param cheminFichier Le chemin d'accès au fichier.
	 * @param cle           La clé dont la valeur associée doit être renvoyée.
	 * @return le texte associé à une clé, ou {@code null} si le fichier n'existe
	 *         pas ou ne contient pas d'association pour cette clé.
	 */
	public static String lireString(String cheminFichier, String cle) {
		Map<String, String> map = chargerMap(cheminFichier);
		return map.get(cle);
	}

	/**
	 * Récupère la valeur associée à une clé sous la forme d'un nombre entier.
	 * 
	 * @param cheminFichier Le chemin d'accès au fichier.
	 * @param cle           La clé dont la valeur associée doit être renvoyée.
	 * @return l'entier associé à la clé spécifiée, ou {@code null} si le fichier
	 *         n'existe pas ou ne contient pas d'association pour cette clé, ou si
	 *         la valeur associée ne forme pas un nombre représentable au format
	 *         {@code int}.
	 */
	public static Integer lireInt(String cheminFichier, String cle) {
		String valeur = lireString(cheminFichier, cle);
		return (valeur != null) ? convertirEnInteger(valeur) : null;
	}

	/**
	 * Récupère la valeur associée à une clé sous la forme d'un nombre réel.
	 * 
	 * @param cheminFichier Le chemin d'accès au fichier.
	 * @param cle           La clé dont la valeur associée doit être renvoyée.
	 * @return le réel associé à la clé spécifiée, ou {@code null} si le fichier
	 *         n'existe pas ou ne contient pas d'association pour cette clé, ou si
	 *         la valeur associée ne forme pas un nombre représentable au format
	 *         {@code double}.
	 */
	public static Double lireDouble(String cheminFichier, String cle) {
		String valeur = lireString(cheminFichier, cle);
		return (valeur != null) ? convertirEnDouble(valeur) : null;
	}

	/**
	 * Supprime une association clé-valeur dans le fichier spécifié.
	 * 
	 * @param cheminFichier Le chemin d'accès au fichier.
	 * @param cle           La clé dont l'association doit être supprimée du
	 *                      fichier.
	 * @return la valeur associée à la clé au moment de la suppression, ou
	 *         {@code null} si le fichier n'existe pas ou ne contient pas
	 *         d'association pour la clé spécifiée.
	 */
	public static String supprimerValeur(String cheminFichier, String cle) {
		Map<String, String> map = chargerMap(cheminFichier);
		String ancienneValeur = map.remove(cle);
		enregistrerMap(cheminFichier, map);
		return ancienneValeur;
	}

	/**
	 * Vérifie l'existence d'un fichier.
	 * 
	 * @param cheminFichier Le chemin d'accès au fichier.
	 * @return {@code true} si le fichier existte, {@code false} dans le cas
	 *         contraire.
	 */
	public static boolean existe(String cheminFichier) {
		return Files.exists(Paths.get(cheminFichier));
	}

	private static boolean creer(String cheminFichier) {
		int posSep = Math.max(Math.max(cheminFichier.lastIndexOf('/'), cheminFichier.lastIndexOf('\\')), 0);
		String cheminSeul = cheminFichier.substring(0, posSep);
		File dossiers = new File(cheminSeul);
		if (dossiers.mkdirs() || dossiers.exists()) {
			try {
				return new File(cheminFichier).createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	private static boolean ecrireLignes(String cheminFichier, Charset encodage, List<String> lignes) {
		if (existe(cheminFichier) || creer(cheminFichier)) {
			try {
				Files.write(Paths.get(cheminFichier), lignes, encodage);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	private static List<String> lireLignes(String cheminFichier, Charset encodage) {
		List<String> lignes = null;
		Path chemin = Paths.get(cheminFichier);
		try {
			lignes = Files.readAllLines(chemin, encodage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lignes;
	}

	private static Map<String, String> chargerMap(String cheminFichier) {
		Map<String, String> map = new HashMap<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(SEPARATEUR, 2);
				if (parts.length == 2) {
					map.put(decoder(parts[0]), decoder(parts[1]));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	private static void enregistrerMap(String cheminFichier, Map<String, String> map) {
		if (existe(cheminFichier) || creer(cheminFichier)) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {
				for (Map.Entry<String, String> entry : map.entrySet()) {
					writer.write(encoder(entry.getKey()) + SEPARATEUR + encoder(entry.getValue()));
					writer.newLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String encoder(String ch) {
		return ch.replace(SEPARATEUR, REMPLACEMENT_SEPARATEUR).replace(CRLF, REMPLACEMENT_CRLF).replace(LF,
				REMPLACEMENT_LF);
	}

	private static String decoder(String ch) {
		return ch.replace(REMPLACEMENT_SEPARATEUR, SEPARATEUR).replace(REMPLACEMENT_CRLF, CRLF).replace(REMPLACEMENT_LF,
				LF);
	}

	private static Integer convertirEnInteger(String ch) {
		try {
			return Integer.parseInt(ch);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	private static Double convertirEnDouble(String ch) {
		try {
			return Double.parseDouble(ch);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
