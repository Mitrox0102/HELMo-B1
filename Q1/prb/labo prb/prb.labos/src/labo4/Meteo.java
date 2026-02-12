package labo4;

import io.*;

public class Meteo {

	public static void main(String[] args) {

		int temperature;
		String outil;

		temperature = Console.lireInt("Température en °C ? ");

		if (temperature < 16 && temperature >= -30) {
			outil = Console.lireString("Est-il en train de pleuvoir (o/n) ? ");
		} else if (temperature >= 16 && temperature <= 40) {
			outil = Console.lireString("Fait-il ensoleillé (o/n) ? ");
		} else {
			System.out.println("Cette température est incorrecte.");
			return;
		}

//		if (temperature < -30 || temperature > 40) {
//			System.out.println("Cette température est incorrecte.");
//			return;
//		} else if (temperature >= 16) {
//			outil = Console.lireString("Fait-il ensoleillé (o/n) ? ");
//		} else {
//			outil = Console.lireString("Est-il en train de pleuvoir (o/n) ? ");
//		}
		
		outil = outil.trim().toLowerCase();

		if (outil.compareTo("o") != 0 && outil.compareTo("n") != 0) {
			System.out.println("Cette réponse est incorrecte !");
			return;
		}

		String msg = switch (outil) {
		case "o" -> (temperature < 16) ? "Vous devriez prendre un parapluie." : "Vous devriez porter un t-shirt";
		default -> (temperature < 16) ? "Vous devriez prendre un manteau." : "Vous devriez porter un pull";
		};
		
		System.out.println(msg);
	}
}
