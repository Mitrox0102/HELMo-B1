package eval1;

import io.Console;

public class PourcentageMoyen {

	public static void main(String[] args) {
		
		//Déclaration des variables en entrée
		
		double nA, nM, nG;
		double hA, hM, hG;
		
		
		//Décalration des variables intermédiares
		
		double hTot;
		double fM, fG, fA;
		
		
		//Déclaration de la note finale
		
		double nFinale;
		
		
		//On simule les données en entrée pour perdre moins de temps
		
		Console.simulerSaisies("12.5", "4", "16", "2", "10", "6");
		
		
		//On récolte les données entrées par l'utilisateur
		
		nA = Console.lireDouble("Note d'anglais (sur 20) ? ");
		hA = Console.lireDouble("Heures d'anglais par semaine ? ");
		
		nG = Console.lireDouble("Note de gym (sur 20) ? ");
		hG = Console.lireDouble("Heures de gym par semaine ? ");
		
		nM = Console.lireDouble("Note de math (sur 20) ? ");
		hM = Console.lireDouble("Heures de math par semaine ? ");
		
		
		//On calcule le total des heures de l'étudiant
		
		hTot = hA + hG + hM;
		
		
		//On calcule le pourcentage que vaudra chaque cours
		
		fA = (1. / (hTot / hA)) * 10.;
		
		fG = (1. / (hTot / hG)) * 10.;
		
		fM = (1. / (hTot / hM)) * 10.;
		
		
		//On recherche la note totale pondérée et on la met en sortie
		
		nFinale = (nA/2. * fA) + (nG/2. * fG) + (nM/2. * fM);
		
		System.out.println("Pourcentage moyen = " + nFinale + " %");
		
	}
	
	
	
}
