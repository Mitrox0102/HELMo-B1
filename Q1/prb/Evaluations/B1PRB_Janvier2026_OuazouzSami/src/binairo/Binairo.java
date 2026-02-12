package binairo;

import java.util.Iterator;

import io.Console;
import util.Caractere;
import util.TableauCaracteres;

public class Binairo {

	/**
	 * Cette fonction nous permet de print une ligne de séparation dans la grille
	 * @param ligne Il nous permet de connaitre la taille d'une ligne de la grille
	 */
	public static void afficherLigneSeparation(char[] ligne) {

		switch (ligne.length) {
		case 4 -> System.out.println("  +---+---+---+---+");
		case 6 -> System.out.println("  +---+---+---+---+---+---+");
		case 8 -> System.out.println("  +---+---+---+---+---+---+---+---+");

		default -> throw new IllegalArgumentException("Unexpected value: " + ligne.length);
		}

	}

	/**
	 * Cette fonction est l'affichage complet de la grille dans la console
	 * @param grille c'est la grille de base de l'utilisateur, elle est initialisée dans la fonction appelante
	 */
	public static void afficherGrille(char[][] grille) {

		if (grille == null || (grille.length != 4 && grille.length != 6 && grille.length != 8)) {
			System.out.println("Grille de taille non adéquate !");
			return;
		}

		char y = 'A';

		System.out.print("  ");

		for (int i = 0; i < grille.length; i++) {
			System.out.printf("  %d ", i + 1);
		}
		System.out.println();
		afficherLigneSeparation(grille[0]);

		for (int i = 0; i < grille.length; i++) {
			System.out.print(y + " ");
			y++;
			for (int j = 0; j < grille.length; j++) {
				System.out.printf("| %c ", grille[i][j]);
				if (j == grille.length - 1)
					System.out.println("|");
			}
			afficherLigneSeparation(grille[0]);

		}

	}

	/**
	 * Cette fonction nous permet de lire les coordonnées que l'utilisateur nous met en entrée
	 * @param question C'est la question qu'on va proposer à l'utilisateur
	 * @return on retourne un tableau de 2 entiers ou en premier indice on a la ligne, et en deuxième on a la colonne.
	 */
	public static int[] lireCoord(String question) {

		if (question == null)
			return null;

		String reponse;
		do {
			System.out.print(question);
			reponse = Console.lireString(" ");
			reponse = reponse.trim();
		} while (reponse.isEmpty() || reponse.length() < 2 || reponse.length() > 2
				|| !Caractere.estAlpha(reponse.charAt(0)) || !Caractere.estChiffre(reponse.charAt(1)));

		return Caractere.convertirCoord(reponse);
	}

	/**
	 * Cette fonction nous permet de vérifier et d'obtenir les coordonnées rentrée par l'utilisateur.
	 * @param question C'est la question qu'on va proposer à l'utilisateur
	 * @param symbolesAdmis C'est la liste de tous les symboles qu'on autorise à l'utilisateur
	 * @return On retourne le caractère valide de façon à ce qu'il soit placé dans le tableau.
	 */
	public static char lireSymbole(String question, String symbolesAdmis) {

		if (question == null) {
			System.out.println("Question invalide");
			return ' ';
		}

		String reponse;
		boolean valide = false;

		do {
			System.out.print(question);
			reponse = Console.lireString(" ");
			reponse = reponse.trim().toUpperCase();

			for (int i = 0; i < symbolesAdmis.length(); i++) {
				if (reponse.charAt(0) == symbolesAdmis.charAt(i)) {
					valide = true;
					break;
				}
			}

		} while (reponse.isEmpty() || reponse.length() < 1 || reponse.length() > 1 || !valide);

		return reponse.charAt(0);

	}

	public static void main(String[] args) {

		char[][] grille = { { 'O', '\0', '\0', '\0', '\0', '\0' }, { '\0', 'O', 'X', '\0', 'X', '\0' },
				{ '\0', '\0', 'X', '\0', '\0', '\0' }, { '\0', 'O', '\0', '\0', 'O', '\0' },
				{ '\0', '\0', '\0', '\0', '\0', '\0' }, { 'O', '\0', 'O', 'O', '\0', '\0' } };
		afficherGrille(grille);

		do {
			int[] coord = lireCoord("Coordonnées ?");
			char symbole = lireSymbole("O/X ?", "OoXx");
			
			if(TableauCaracteres.troisConsecutifs(grille[coord[0]], symbole) || TableauCaracteres.troisConsecutifs(TableauCaracteres.extraireColonne(grille, coord[1]), symbole)) {
				System.out.println("Il y a plus de 2 symboles identiques consécutifs !");
			}else if (TableauCaracteres.compter(grille[coord[0]], symbole) > 3 || TableauCaracteres.compter(TableauCaracteres.extraireColonne(grille, coord[1]), symbole) > 3) {
				System.out.printf("Il y a trop de symbole %c dans cette ligne !", symbole);
			}else if (grille[coord[0]][coord[1]] != symbole ) {
				grille[coord[0]][coord[1]] = '\0';
			}else if(grille[coord[0]][coord[1]] == symbole ){
				grille[coord[0]][coord[1]] = symbole;
			}
			afficherGrille(grille);
		} while (TableauCaracteres.contient(grille, '\0'));

		System.out.println("Bravo ! Vous avez réussi à compléter la grille.");

	}

}
