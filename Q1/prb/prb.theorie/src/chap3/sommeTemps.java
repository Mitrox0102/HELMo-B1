package chap3;

public class sommeTemps{
	public static void main(String args[]) {
		
		// Déclaration des variables
		
		int h1 = 6, m1 = 21, s1 = 30;
		int h2 = 3, m2 = 38, s2 = 45;
		
		int h3 = 0, m3 = 0, s3 = 0;
		
		// Traitement des résultats
		
		s3 = s1 + s2;
		
		if (s3 >= 60){
			s3 = s3 % 60;
			m3 = m3 + 1;
		}
		
		m3 = m1 + m2 + m3;
		
		if (m3 >= 60){
			m3 = m3 % 60;
			h3 = h3 + 1;
		}
		
		
		h3 = h1 + h2 + h3;
		
		//sans If
		
		//int rS, rM;
		
		//s3 = s1 + s2
		//rS = s3 / 60
		//s3 = s3 % 60
		
		//m3 = m1 + m2 + rS
		//rM = m3 / 60
		//m3 = m3 % 60
		
		//h3 = h1 + h2 + rM
		
		//Affichage des résultats
		
		System.out.print("Le temps total est de " + h3 + " heures " + m3 + " minutes " + s3 + " secondes.");
		
	}
}

