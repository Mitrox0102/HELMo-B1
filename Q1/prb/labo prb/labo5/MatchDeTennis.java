package labo5;

import io.*;

public class MatchDeTennis {

	public static void main(String[] args) {
		
		String pointJ1 = "0", pointJ2 = "0";
		int win = 0;
		boolean statutWin = false;
		
		String j1 = Console.lireString("Joueur 1 ? ");
		String j2 = Console.lireString("Joueur 2 ? ");

		System.out.printf("%s \t %s\n", j1, pointJ1);
		System.out.printf("%s \t %s\n\n", j2, pointJ2);

		while(!statutWin) {
			win = Console.lireInt("Quel joueur gagne le point (1 ou 2) ? ");
			if (win == 1) {
				if(pointJ1.equals("0")) {
					pointJ1 = "15";
				} else if (pointJ1.equals("15")) {
					pointJ1 = "30";
				} else if (pointJ1.equals("30")){
					pointJ1 = "40";
				} else if  (pointJ1.equals("40") && pointJ2.equals("40")) {
					pointJ1 = "A";
				}else if (pointJ2.equals("A")){
					pointJ2 = "40";
				}else{
					statutWin = true;
					System.out.printf("%s remporte le jeu !\n", j1);
				}
			} else if (win == 2) {
				if(pointJ2.equals("0")) {
					pointJ2 = "15";
				} else if (pointJ2.equals("15")) {
					pointJ2 = "30";
				} else if (pointJ2.equals("30")){
					pointJ2 = "40";
				} else if  (pointJ1.equals("40") && pointJ2.equals("40")) {
					pointJ2 = "A";
				}else if (pointJ1.equals("A")){
					pointJ1 = "40";
				}else{
					statutWin = true;
					System.out.printf("%s remporte le jeu !\n", j2);
				}
			}
			if (!statutWin) {
				System.out.printf("%s \t %s\n", j1, pointJ1);
				System.out.printf("%s \t %s\n\n", j2, pointJ2);
			}
		
		}
		
	}
	
}
