package chap8.tab1D;

import io.Console;
import java.util.Arrays;

/**
 * Ce programme permet de calculer et afficher les premiers termes de la suite de
 * Fibonacci : F_n = F_n-1 + F_n-2.
 * 
 * Les premiers termes sont : 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233,
 * 377, 610...
 */
public class Ex2_SuiteFibonacci {

	public static void main(String[] args) {
		//TODO: Acquérir le nombre de termes de la suite à afficher
		int nb = 0;
		while (nb < 2) {
			nb = Console.lireInt("Nombre de termes : ");
		}
		
		//TODO: Créer un tableau permettant d'enregistrer les termes
		int[] t = new int[nb];
		
		//TODO: Calculer les termes et les enregistrer dans le tableau
		t[0] = 0;
		t[1] = 1;
		for (int i = 2; i < t.length; i++) {
			t[i] = t[i - 1] + t[i - 2];
		}
		
		// Afficher le contenu du tableau
		System.out.println(Arrays.toString(t));
	}

}
