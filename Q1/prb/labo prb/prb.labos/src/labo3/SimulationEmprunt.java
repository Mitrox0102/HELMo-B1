package labo3;

import io.Console;

public class SimulationEmprunt {

	public static void afficherSimulationEmprunt(int duree, double taux, double capital, double tauxM) {
		
		double rembMens = Emprunt.calculerMensualite(tauxM / 100, capital, duree * 12); 
		double totRemb = rembMens * (12. * duree);
		double intPret = totRemb - capital;
		
		System.out.printf("\nSur %d ans : \n", duree);		
		System.out.printf("Nombre de paiements\t=\t%d\n", (duree * 12));
		System.out.printf("Remboursement mensuel\t=\t%.2f EUR\n", rembMens);
		System.out.printf("Total remboursé\t\t=\t%.2f EUR\n", totRemb);
		System.out.printf("Intérêts prêt\t\t=\t%.2f EUR\n", intPret);
		
	}
	
	public static void main(String[] args) {
		
		int duree1, duree2;
		double capital, tauxAnnuel, tauxMensuel;
		
		Console.simulerSaisies("25000", "3.04", "15", "20");
		
		capital = Console.lireDouble("Capital ? ");
		tauxAnnuel = Console.lireDouble("Taux Annuel en % ? ");
		duree1 = Console.lireInt("Durée 1 en années ? ");
		duree2 = Console.lireInt("Durée 2 en années ? ");
		
		tauxMensuel = Emprunt.calculerTauxMensuel((tauxAnnuel/100))*100;
		
		System.out.printf("\nCapital à emprunter\t= %.2f EUR\n", capital);
		System.out.printf("Taux d'intérêt mensuel\t= %.5f%% \n", tauxMensuel);
		
		afficherSimulationEmprunt(duree1, tauxAnnuel, capital, tauxMensuel);
		
		afficherSimulationEmprunt(duree2, tauxAnnuel, capital, tauxMensuel);
	}
	
}
