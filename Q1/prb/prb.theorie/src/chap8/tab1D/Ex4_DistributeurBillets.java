package chap8.tab1D;

import java.util.Arrays;
import java.util.Iterator;

import io.Console;

public class Ex4_DistributeurBillets {

	public static void main(String[] args) {
		// Tableaux
		final int[] VALEURS_BILLETS = { 200, 100, 50, 20, 10 };
		int[] qtesBillets = new int[VALEURS_BILLETS.length];

		// Variables
		int montant;

		// TODO: Trier les valeurs de billets par ordre croissant
		Arrays.sort(VALEURS_BILLETS);

		// TODO: Inverser l'ordre des valeurs
		
		// Acquisition du montant
		montant = Console.lireInt("Montant en euros ? ");

		// TODO: Répétition de l'acquisition si le montant n'est pas valide :
		// - si montant < 0
		// - si montant n'est pas divisible par la plus petite valeur de billet

		// Traitement
		for (int i = 0; i < VALEURS_BILLETS.length; i++) {
			qtesBillets[i] = montant / VALEURS_BILLETS[i];
			montant = montant % VALEURS_BILLETS[i];
		}

		// Affichage des résultats
		for (int i = 0; i < VALEURS_BILLETS.length; i++) {
			if (qtesBillets[i] > 0) {
				System.out.printf("%d fois %d\n", qtesBillets[i], VALEURS_BILLETS[i]);
			}
		}
	}

}