package labo5;

import io.*;

public class FizzBuzz {
	
	public static void main(String[] args) {
		
		int nbr = 0;
		
		nbr = Console.lireInt("Dernier nombre ? ");
		
		for (int i = 1 ; i <= nbr ; i++) {
			
			if(i % 3 == 0) {
				System.out.print("fizz");
			}
			if(i % 5 == 0) {
				System.out.printf("buzz");
			}
			
			if (i % 3 != 0 && i % 5 != 0) {
				System.out.print(i);
			}
			
			if(i != nbr) {
				System.out.print(",");
			}
			
		};
		
	}

}
