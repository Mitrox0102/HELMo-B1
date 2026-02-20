package labo1;

import java.util.Arrays;

import util.Contract;

public class enonce_b {

	/**
	 * Dans un tableau de caractères, déplacer toutes les pierres à l’extrêmité gauche/droite
	 * @param tab Une référence non null vers un tableau de caractères
	 * @param versLaDroite Un booléen déterminant dans quel sens aller (vrai : gauche , faux : droite)
	 * @return On a déplacé les pierres vers la gauche ou la droite en fonction du choix
	 */
	public static char[] slideRocks(char[] tab, boolean versLaGauche) {

		Contract.require(tab != null, "Tableau null trouvé");

		for (char c : tab) {

			Contract.require(c == ' ' || c == 'O' || c == '#', "Caractère invalide trouvé");

		}

		int indexMur = 0;
//		int indexMur = (versLaDroite) ? tab.length : -1;

		for (int i = 0; i < tab.length; i++) {

//			if (tab[i] == '#') {
//				indexMur = i;
//			}
			
			if (indexMur >= tab.length) {
				break;
			}

			int indexMin = indexMur;

			for (int j = indexMur; j < tab.length; j++) {
				if (tab[j] == '#') {
					indexMur = j;
					break;
				}
				if (j == tab.length - 1) {
					indexMur = tab.length;
				}
			}

			if (versLaGauche) {
				for (int j = indexMin; j < indexMur; j++) {
					if (tab[j] == 'O') {
						tab[j] = ' ';
						tab[indexMin] = 'O';
						indexMin++;
					}
				}
			} else {
				int indexMax = indexMur - 1;
				for (int j = indexMur - 1; j >= indexMin; j--) {
					if (tab[j] == 'O') {
						tab[j] = ' ';
						tab[indexMax] = 'O';
						indexMax--;
					}
				}
			}

			indexMur++;
		}

		return tab;
	}

	public static void main(String[] args) {

		char tab[] = { 'O', ' ', 'O', '#', ' ', ' ', 'O', ' ', 'O' };

		System.out.println(Arrays.toString(tab));

		tab = slideRocks(tab, false);

		System.out.println(Arrays.toString(tab));

	}

}
