package labo3;

import io.*;

public class HeuresPrestees {
	
	public static int lireHeures(String hhmm) {
		
		int hh= hhmm.indexOf(":");
		hh = Integer.parseInt(hhmm.substring(0,hh));
		
		return hh;
	}
	
	public static int lireMinutes(String hhmm) {
		
		int mm= hhmm.indexOf(":");
		mm = Integer.parseInt(hhmm.substring(mm + 1));
		
		return mm;
	}
	
	public static int convertirEnMinutes(String hhmm) {
		
		int minutes = 0;
		
		minutes += lireHeures(hhmm) * 60;
		minutes += lireMinutes(hhmm);
		
		return minutes;
	}
    
    public static void main(String[] args){

        double TARIF_PAR_HEURE = 128.5;
        int minutesTotales = 0, heuresTotales = 0;
        double montantTotal;
        String lundi, mardi, mercredi, jeudi, vendredi;
        
        Console.simulerSaisies("7:5", "06:45", "3:30", "10:00", "5:15");

        for (int i = 0 ; i < 5 ; i ++){

            switch (i) {
                case 0:
                    lundi = Console.lireString("Lundi ? ");

                    minutesTotales += convertirEnMinutes(lundi);

                    break;

                case 1:
                    mardi = Console.lireString("Mardi ? ");
                    
                    minutesTotales += convertirEnMinutes(mardi);

                    break;

                case 2:
                    mercredi = Console.lireString("Mercredi ? ");
                    
                    minutesTotales += convertirEnMinutes(mercredi);

                    break;

                case 3:
                    jeudi = Console.lireString("Jeudi ? ");
                    
                    minutesTotales += convertirEnMinutes(jeudi);

                    break;

                case 4:
                    vendredi = Console.lireString("Vendredi ? ");
                    
                    minutesTotales += convertirEnMinutes(vendredi);

                    break;
            
                default:
                    break;

            }
        }

        montantTotal = TARIF_PAR_HEURE * (double) minutesTotales / 60.;

        heuresTotales = minutesTotales / 60;
        minutesTotales = minutesTotales % 60;

        System.out.println("Durée Hebdomadaire = " + heuresTotales + "h " + minutesTotales + "min");

        System.out.printf("Montant à facturer = %.2f EUR", montantTotal);

    }

}
