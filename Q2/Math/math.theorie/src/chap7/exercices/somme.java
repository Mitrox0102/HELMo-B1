package chap7.exercices;

import java.util.Arrays;

public class somme {

	
	public static double somme_f(double[] tab) {
		
		return somme_f(tab, 0);
		
	}
	
	private static double somme_f(double[] tab, int i) {
		
		if (i == tab.length)
			return 0;
		
		return tab[i] + somme_f(tab, i + 1);
	}
	
	public static void main(String[] args) {
		
		double[] somme = {1,2,3};
		
		System.out.println(somme_f(somme));
	}
	
}
