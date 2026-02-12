package chap6;

import io.Console;

public class ComparaisonString {

	public static void main(String[] args) {
		String indicatif = Console.lireString("Indicatif ? ");
		
		//Comparer comme après le ||,c'est faux ca ne fonctionnera pas, il faut utiliser equals
		
		if (indicatif.equals("+32") || indicatif == "0032") {
			System.out.println("Belgique");
		} else {
			System.out.println("Inconnu");
		}
	}
	
}
