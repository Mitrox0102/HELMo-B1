package labo5;

import io.*;

public class PuissancesDe2 {

	
	public static void main(String[] args) {
		
		int input, puis = 1, cpt = 0;
		
		input = Console.lireInt("Exposant maximum ? ");
		
		System.out.printf("Exp. Puissance\n");
		
		for(int i = 0; i <= input ; i ++) {
			
			cpt = 0;
			while (cpt != i) {
				puis *= 2;
				cpt ++;
			}
			
			System.out.printf("%2d\t%6d\n",i, puis);
			
			puis = 1;
		}
	}
}
