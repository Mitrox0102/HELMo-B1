package labo1;

import util.Contract;

public class enonce_c {

	
	public static void displayCharString (String chaine) {
		
		int cmpt;
		
		Contract.require(chaine != null, "");
		
		for (int i = 0; i < chaine.length(); i++) {
			
			if(!Character.isDigit(chaine.charAt(i))) {
				return ;
			}
			
			if(chaine.charAt(i) == '0') {
				
				if(i + 1 >= chaine.length() || !Character.isDigit(chaine.charAt(i+1))){
					return ;
				}else {
					System.out.println();
					i = i+1;
				}
			}
			
			cmpt = Character.getNumericValue(chaine.charAt(i));
			i = i + 1;
			
			for (int j = 0; j < cmpt; j++) {
				System.out.print(chaine.charAt(i));
			}
			
		}
		
		
	}
	
	public static void main(String[] args) {
		
		String chaine = "5 1█1 1█04 1█1 1█08 02 6█02 8█02 6█2 1█02 6█3 1█02 6█2 1█02 8█02 6█";
		
		
		displayCharString(chaine);
		
		
	}
	
}
