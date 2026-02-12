package chap5;

public class AdresseIPEnBase10 {
	
	
	/**
	 * Cette fonction a pour but de de transformer une adresse en base 2 (IPV4) en base 10.
	 * 
	 * @param ip est une chaine de caractère contenant l'adresse ip en base 2 (0,1).
	 */
	
	
	public static void calculeBase10ToBinaire(String ip) {
		
		//Déclaration des variables
		int octet2 = 0;
		int position = 0;
		
		//Première boucle, celle-ci va "Diviser" la chaine de caractère en
		//plusieurs groupes qu'on va manipuler
		
		for (int j = 0 ; j < 4; j ++) {
			
			//Cette boucle nous permet de naviguer de la première position de la
			//chaine à la dernière
			
			for (int i = 0 ; i < 8; i ++) {
				
				//Nous permet d'accéder à tel caractère.
				position = j*8 + i + j;
				
				octet2 += (int) (ip.charAt(position) - '0') * Math.pow(2, 7-i);
				
			}
			
			System.out.printf("%d", octet2);
			if (j != 3) {
				System.out.printf(".");
			}
			octet2 = 0;
		}
	}
	
	
	public static void main(String[] main) {
		// Variable pour l'entrée
		String ip = "11000000.10101000.00000001.00000101";
		//           01234567890123456789012345678901234
		//           0         1         2         3
		
		calculeBase10ToBinaire(ip);
		
	}
	
}