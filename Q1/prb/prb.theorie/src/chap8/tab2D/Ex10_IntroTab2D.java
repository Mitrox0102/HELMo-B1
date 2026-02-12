package chap8.tab2D;

import java.util.Arrays;

import io.Console;

public class Ex10_IntroTab2D {

	public static void main(String[] args) {
		char[][] grille = new char[3][3]; // [nbLignes] [nbColonnes]
		
		/*
		 * 
		 * Exemple d'affichage:
		 *   	 1   2   3
		 *      (0) (1) (2)
		 * A (0) X   -   -
		 * B (1) -   O   O
		 * C (2) -   -   -
		 * 
		 */
		
		String position = Console.lireString("Position (LigneColonne) ? ").trim().toUpperCase();
		int indiceLigne = position.charAt(0) - 'A';
		int indiceColonne = position.charAt(1) - '0' - 1;
		
		grille[indiceLigne][indiceColonne] = 'X';
		
		System.out.println(Arrays.deepToString(grille));
		
	}
	
}
