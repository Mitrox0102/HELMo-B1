package eval2;

import io.Console;

public class ExcesVitesse {

	/**
	 * Cette fonction va nous permettre de calculer l'amende à une personne en excès de vitesse.
	 * @param exces nous indique l'excès de vitesse de la personne dans l'illégalité.
	 * @param annif nous indique si c'est l'anniversaire de la personne.
	 * @return nous retourne le montant à payer.
	 */
	public static int montantAmende(int exces , boolean annif) {
		
		int mult = 0;
		
		if (exces < 1 || (annif && exces < 6)) {
			
			return 0;
			
		}
		
		if (exces <= 10 || (annif && exces < 16)) {
			
			return 53;
			
		} else if (exces <= 40 || (annif && exces < 46)) {
			
			if (annif) {
				
				mult = exces - 5 - 10;
				
			} else {
				
				mult = exces - 10;
			}
			
			return 53 + 6 * mult;
			
			
		} else {
			
			return 300;
			
			}
			
		}
	
	public static void main(String[] args) {
		
		
		int limite, vitesse;
		
		
		limite = Console.lireInt("Limitation de vitesse (en km/h) ? ");
		
		vitesse = Console.lireInt("Vitesse du véhicule (en km/h) ? ");
		
		int exces = vitesse - limite;
		
		int montant_normal = montantAmende(exces, false);
		int montant_annif = montantAmende(exces , true);
		
		System.out.printf("Amende normale = %d EUR\n" , montant_normal);
		
		System.out.printf("Amende le jour de l'anniversaire = %d EUR" , montant_annif);
		
		
		
	}
	
}
