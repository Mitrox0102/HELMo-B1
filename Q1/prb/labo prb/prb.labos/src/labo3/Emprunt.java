package labo3;

public class Emprunt {
	
	public static double calculerTauxMensuel(double taux) {
		
		double tauxMensuel = 0;
		double douxieme = 0;
		
		douxieme = 1./12.;
		
		tauxMensuel = Math.pow((1. + taux), douxieme) - 1.;
		
		return tauxMensuel;
	}
	
	public static double calculerMensualite(double tauxMensuel, double C, int N) {
		double montantMensualite = 0;
		
		montantMensualite = C * (tauxMensuel)/(1. - Math.pow((1 + tauxMensuel), -(N)));
		
		return montantMensualite;
	}
	
	

	public static void main(String[] args) {
		
		System.out.println(calculerTauxMensuel(0.0304));
		System.out.println(calculerMensualite(calculerTauxMensuel(3.04),25000,240));
		
	}
	
	
	
}
