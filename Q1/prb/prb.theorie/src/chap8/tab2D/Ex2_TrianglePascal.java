package chap8.tab2D;

import java.util.Arrays;

import io.Console;

public class Ex2_TrianglePascal {

	public static void afficherTriangle(int[][] triangle) {

		for (int i = 0; i < triangle.length; i++) {
			for (int j = 0; j < triangle.length; j++) {
				System.out.printf("%d ", triangle[i][j]);
			}
			System.out.println();
		}

	}

	public static int[][] trianglePascal(int nbLignes) {

		// Créer le tableau 2D
		int[][] triangle = new int[nbLignes][];

		// Remplir le tableau 2D

		// Boucle pour parcourir les lignes du tableau 2D

		for (int i = 0; i < triangle.length; i++) {
			triangle[i] = new int[i + 1];
			// Placer les 1
			triangle[i][0] = 1;
			triangle[i][i] = 1;

			// Placer les valeurs intermédiaires

			for (int j = 1; j < i; j++) {
				triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
			}

		}
		return triangle;
	}

	public static void main(String[] args) {

		// Acquisition du nombre de lignes pour le triangle à former
		int nbLignes = Console.lireInt("Nombre de lignes ? ");

		// Créer le tableau 2D
		int[][] triangle = trianglePascal(nbLignes);

		// Afficher le tableau 2D
		afficherTriangle(triangle);

	}

}
