package algo.lecon01;

import io.Console;

public class ExemplesAlgorithmes {

	public static void main(String[] args) {

		int[] tableauEntiers = {17, 3, 4, 23, 10, 10, 18, 25};

		System.out.println(
				switch(Console.lireInt("Choix de fonction ? ")) {
				case 1 -> fonction1(tableauEntiers);
				case 2 -> fonction2(tableauEntiers);
				case 3 -> fonction3(tableauEntiers);
				default -> 0;}
				);
	}

	public static int fonction1(int[] t) {
		int a = Integer.MIN_VALUE;
		
		for (int i : t) {
			for (int j = 0; j < t.length; j++) {
				if (t[j] > i) {
					a = Math.max(t[j], a);
				}
			}
		}
		return a;
	}

	public static int fonction2(int[] valeurs) {
		int resultat = valeurs[0];
		int i = 1;
		while (i < valeurs.length) {
			if (valeurs[i] > resultat) {
				resultat = valeurs[i];
			}
		}
		return resultat;
	}

	/**
	 * Retourne la valeur maximum du tableau <code>valeurs</code>.
	 * @param valeurs un tableau d'entiers non vide.
	 * @return le maximum du tableau ou la valeur minimale entière si un tel
	 *         maximum n'existe pas.
	 */
	public static int fonction3(int[] valeurs) {
		if (valeurs == null || valeurs.length < 1) {
			return Integer.MIN_VALUE;
		}
		
		int max = valeurs[0];
		for(int i = 1; i < valeurs.length - 1; ++i) {
			max = valeurs[i] > max ? valeurs[i] : max;
		}
		return max;
	}
}
