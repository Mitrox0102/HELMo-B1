package labo4;

import io.*;

public class Droites {
	
	public static double lireCoordX (String coordPoint){
		int espaceIndex = coordPoint.indexOf(" ");
		return Double.parseDouble(coordPoint.substring(0, espaceIndex));
	}	
	
public static double lireCoordY (String coordPoint){
		int espaceIndex = coordPoint.indexOf(" ");
		return Double.parseDouble(coordPoint.substring(espaceIndex + 1));
	}	

public static double coefficientDirecteur(double xA, double yA, double xB, double yB) {
	double coeffDir = Double.POSITIVE_INFINITY;
	
	if(xA == xB && yA == yB) {
		coeffDir = Double.NaN;
	} else if (xA != xB) {
		coeffDir = (yB-yA)/(xB - xA);
	}
	return coeffDir;
}

	public static void main(String[] args) {
		
		String pointA, pointB, pointC, pointD;
		
		pointA = Console.lireString("Coordonnées du point A ? ");
		
		pointB = Console.lireString("Coordonnées du point B ? ");
		
		pointC = Console.lireString("Coordonnées du point C ? ");
		
		pointD = Console.lireString("Coordonnées du point D ? ");
		
		double coeffAB = coefficientDirecteur(lireCoordX(pointA), lireCoordY(pointA), lireCoordX(pointB), lireCoordY(pointB));
		
		double coeffCD = coefficientDirecteur(lireCoordX(pointC), lireCoordY(pointC), lireCoordX(pointD), lireCoordY(pointD));
		
		System.out.printf("Coefficient directeur de la droite AB = %+.3f \n", coeffAB);
		
		System.out.printf("Coefficient directeur de la droite CD = %+.3f \n", coeffCD);
		
		if (coeffAB == coeffCD) {
			System.out.println("Les droites sont parallèles.");
		} else if ((coeffAB * coeffCD) == -1) {
			System.out.println("Les droites sont perpendiculaires.");
		} else {
			System.out.println("Les droites sont sécantes.");
		}
		
	}
	
}
