package labo4;

import io.*;

public class DateEx {

	
	public static int getJour(String date) {
		
		int index = date.indexOf('/');
		int jour = Integer.parseInt(date.substring(0, index));
		
		return jour;
	}
	
	public static int getMois(String date) {
		
		int index = date.indexOf('/');
		date = date.substring(index + 1);
		index = date.indexOf('/');
		int mois = Integer.parseInt(date.substring(0, index));
		
		return mois;
		
	}
	
	public static int getAnnee(String date) {
		
		int index = date.indexOf('/');
		date = date.substring(index + 1);
		index = date.indexOf('/');
		date = date.substring(index + 1);
		int annee = Integer.parseInt(date.substring(0));
		
		return annee;
		
	}
	
	
	public static boolean estBissextile(int annee) {
		
		if ((annee % 4 == 0) && (annee % 100 != 0) || (annee % 400 == 0)) {
			return true;
		}else{
			return false;
			}
		}
	
	
	public static int joursParMois(int mois, int annee) {
		
		return switch (mois) {
	    case 1, 3, 5, 7, 8, 10, 12 -> 31;
	    case 4, 6, 9, 11 -> 30;
	    case 2 -> (estBissextile(annee)) ? 29 : 28;
	    default -> throw new IllegalArgumentException("Mois invalide");
	    
	};

	}
	
	
	public static String formaterDate(int jour, int mois, int annee) {
		
		String nvDate = String.format("%02d/%02d/%04d", jour, mois, annee);
		
		return nvDate;
	}
	
	
	public static void main(String[] args) {
		
		String date = Console.lireString("Date au format j/m/aaaa ? ");
		
		int jour = getJour(date);
		int mois = getMois(date);
		int annee = getAnnee(date);
		
		jour += 1;
		
		if (jour - 1 == joursParMois(mois, annee)) {
			jour = 1;
			mois += 1;
		}
		if(mois == 13) {
			mois = 1;
			annee += 1;
		}
		
		System.out.println("Date du lendemain = " + formaterDate(jour, mois, annee));
	}
	
}
