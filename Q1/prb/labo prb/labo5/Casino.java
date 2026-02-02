package labo5;

import io.*;

public class Casino {

	public static void main(String[] args) {
		
	double rdm;
	int somme, souhaites, reussis = 0, paris = 0, obj;
	
	somme = Console.lireInt("Argent de départ ? ");
	
	if (somme <= 0) {
		System.out.println("Revenez quand vous avez plus d'argent.");
		return;
	}
	
	souhaites = Console.lireInt("Gains souhaités ? ");
	
	obj = somme + souhaites;
	
	while (somme != 0 && somme != obj) {
		
		rdm = Math.random();
		
		if (rdm < 0.5) {
			reussis ++;
			somme ++;
		}else{
			somme --;
		}
		
		paris ++;
	
	}
	
	if (somme == 0) {
		System.out.printf("Vous avez réussi %d paris sur %d \n", reussis, paris);
		System.out.println("Vous n'avez plus d'argent, fallait pas faire le con.");
		return;
	}
	
	System.out.printf("Vous avez réussi %d paris sur %d \n", reussis, paris);
	System.out.printf("Vous repartez avec %d EUR de plus", souhaites);
	
	
	}
	
}
