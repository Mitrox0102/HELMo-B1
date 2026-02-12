package labo5;

import util.*;

import java.util.Iterator;

import io.*;

public class De {

	public static void main(String[] args) {
		
		int i = 0, lances, cmpt = 0;
		
		lances = Console.lireInt("Nombre de 1 à 6 ? ");
		
		/*
		do {
			i = Aleatoire.aleatoire() % 6 + 1;
//			i = Aleatoire.aleatoire(1, 6);
			System.out.println(i);
			cmpt ++;
		} while (i != lances);
		*/
		
		/*
		while (i != lances) {
			
			i = Aleatoire.aleatoire() % 6 + 1;
			System.out.println(i);
			cmpt ++;
		}
		*/
		
		for (; i != lances ; cmpt ++) {
			
			i = Aleatoire.aleatoire() % 6 + 1;
			System.out.println(i);
		}
		
		
		System.out.println("Nombre de lancés = " + cmpt);
		
	}
	
}
