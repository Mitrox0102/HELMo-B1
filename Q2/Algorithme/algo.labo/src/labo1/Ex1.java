package labo1;

import java.lang.reflect.Array;
import java.util.Arrays;

import util.Contract;

public class Ex1 {

	
	public static int[] decalageCircDroite(int[] valeurs) {
		
		Contract.require(valeurs != null, "");
		
		int[] newValeurs = new int[valeurs.length];
		
		newValeurs[0] = valeurs[valeurs.length - 1];
		
		for (int i = 1; i < newValeurs.length; i++) {
			newValeurs[i] = valeurs[i-1];
		}
		
		return newValeurs;
		
	}
	
	
	public static void main(String[] args) {
		
		int[] tab = {1,2,3,4};
		
		tab = decalageCircDroite(tab);
		
		System.out.println(Arrays.toString(tab));
		
	}
	
}
