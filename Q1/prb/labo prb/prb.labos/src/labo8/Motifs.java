package labo8;

import util.Tableau2D;

public class Motifs {

	private static char[][] creerMotifCarre(int taille) {
		char[][] carre = new char[taille][taille];

		for (int i = 0; i < carre.length; i++) {

			for (int j = 0; j < carre[i].length; j++) {

				carre[i][j] = '*';

			}

		}

		return carre;
	}

	private static char[][] creerMotifTriangles(int taille) {

		char[][] triangle = new char[taille][taille];
		
		triangle = Tableau2D.remplir(triangle, '.');

		for (int i = 0; i < triangle.length; i++) {

			for (int j = i; j < triangle[i].length; j++) {

				triangle[i][j] = '*';

			}

		}

		return triangle;
	}

	private static char[][] creerMotifX(int taille) {

		char[][] x = new char[taille][taille];
		
		x = Tableau2D.remplir(x, '.');

		
		for (int i = 0; i < x.length; i++) {
			
				x[i][i] = '*';
				x[x.length - 1 - i][i] = '*';
		}

		return x;
	}

	public static void main(String[] args) {

		Tableau2D.afficher(creerMotifCarre(7));

		Tableau2D.afficher(creerMotifTriangles(7));
		
		Tableau2D.afficher(creerMotifX(7));
	}

}
