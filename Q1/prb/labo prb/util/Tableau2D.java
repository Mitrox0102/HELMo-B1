package util;

import java.util.Arrays;

import labo8.TableauReels;

public class Tableau2D {

	public static void afficher(char[][] t) {

		for (int i = 0; i < t.length; i++) {

			for (int j = 0; j < t[i].length; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();
	}

	public static char[][] remplir(char[][] t, char c) {

		for (int i = 0; i < t.length; i++) {

			for (int j = 0; j < t[i].length; j++) {

				t[i][j] = c;

			}
		}

		return t;

	}

	public static double[][] ajouterLigne(double[][] t, double[] ligne) {

		double[][] newTab = new double[t.length + 1][t[0].length];

		System.arraycopy(t, 0, newTab, 0, t.length);

		for (int j = 0; j < t[t.length - 1].length; j++) {
			newTab[newTab.length - 1][j] = ligne[j];
		}

		return newTab;
	}

	public static double[] moyennesParLigne(double[][] t) {

		double[] moyenne = new double[t.length];

		for (int i = 0; i < t.length; i++) {

			moyenne[i] = TableauReels.moyenne(t[i]);

		}

		return moyenne;

	}

	public static double[] extraireColonne(double[][] t, int j) {

		double[] colonne = new double[t.length];

		for (int i = 0; i < t.length; i++) {

			colonne[i] = t[i][j];

		}

		return colonne;

	}

	public static double[] moyennesParColonne(double[][] t) {

		double[] moyenne = new double[t[0].length];

		for(int i = 0; i <= t.length; i ++) {
			
			moyenne[i] = TableauReels.moyenne(extraireColonne(t, i));
			
		}
		
		return moyenne;
	}

	public static void main(String[] args) {

		double[][] t = { { 7, 2.5, 4. }, { 1., 8., 6. } };

		System.out.println(Arrays.toString(t[1]));

		System.out.println(Arrays.toString(moyennesParLigne(t)));

		System.out.println(Arrays.toString(extraireColonne(t, 2)));
		
		System.out.println(Arrays.toString(moyennesParColonne(t)));

	}

}
