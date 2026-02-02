package chap3;

public class Cercle {
	
	public static void main(String args[]) {
		double pi = Math.PI;
		
		System.out.println("Bienvenue dans le calculateur de cercle");
		System.out.println("Veuillez nous donner un rayon afin qu'on puisse calculer :");
		
		double rayon = Console.lireDouble();
		
		System.out.print( "Le rayon est de " + rayon + "cm. Sa circonférence est de " + rayon * pi * 2 + " cm et l'aire est de " + Math.pow(rayon, 2) * pi + "cm ."); 
	
	}
	
}
	