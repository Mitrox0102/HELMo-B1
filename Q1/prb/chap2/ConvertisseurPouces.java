package chap2;

public class ConvertisseurPouces {

	public static void main(String[] args) {
		// Déclaration d'une variable
		double lgEnPouces;
		
		System.out.println("Mon Convertisseur");
		lgEnPouces = Console.lireDouble("Longueur en pouce ? ");
		System.out.println(	lgEnPouces * 2.54 + " cm");
	}
}