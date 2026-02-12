package chap8.tab2D;

import java.util.Arrays;

import io.Aleatoire;

public class Ex5_DecorerSapin {

	public static void main(String[] args) {
		char[][] sapin = sapin();
		
		// Placer une étoile au sommet du sapin (dernière case de la 1ère ligne)
		sapin[0][sapin[0].length - 1] = '*';
		
		// Agrandir le sapin en doublant les lignes 2 et 3
		char[][] sapinPlusGrand = new char[sapin.length + 2][];
		sapinPlusGrand[0] = sapin[0];
		sapinPlusGrand[1] = sapin[1];
		sapinPlusGrand[2] = sapin[2];
		sapinPlusGrand[3] = Arrays.copyOf(sapin[2], sapin[2].length);
		sapinPlusGrand[4] = sapin[3];
		sapinPlusGrand[5] = Arrays.copyOf(sapin[3], sapin[3].length);
		sapinPlusGrand[6] = sapin[4];
		sapinPlusGrand[7] = sapin[5];
		
		// Placer aléatoirement une boule de Noël 'o' par ligne en remplaçant un '.'
		
		sapinPlusGrand = afficherBoule(sapinPlusGrand);
		
		afficher(sapinPlusGrand);
	}
	
	public static char[][] afficherBoule(char[][] sapin) {

		int index = 0;

		for (int i = 1; i < sapin.length - 1; i++) {

			for (int j = 0; j < sapin[i].length; j++) {

				if (sapin[i][j] == '/') {
					index = j;
				}

			}

			sapin[i][Aleatoire.aleatoire(index + 1, sapin[i].length - 2)] = 'o';

		}

		return sapin;
	}
	
	
	public static char[][] sapin() {
		return new char[][] {
		    "    ^".toCharArray(),
		    "   /.\\".toCharArray(),
		    "  /...\\".toCharArray(),
		    " /.....\\".toCharArray(),
		    "/.......\\".toCharArray(),
		    "^^^[_]^^^".toCharArray()
		};
	}
	
	public static void afficher(char[][] image) {
		for (char[] ligne : image) {
			for (char car : ligne) {
				System.out.print(car);
			}
			System.out.println();
		}
	}
}
