package util;

/**
 * Cette classe propose les fonctionnalités de base d'un chronomètre.
 *
 * @author Arnaud Comblin
 * @version 1.0
 */
public class Chronometre {
	
	final static long NANO_VERS_MILLI = 1000000L;
	
	private static long debut = System.nanoTime();
	
	/**
	 * Démarre (ou redémarre) le chronomètre.
	 *
	 * @since 1.0
	 */
	public static void demarrer() {
		debut = System.nanoTime();
	}
	
	/**
	 * Détermine le nombre de millisecondes écoulées depuis le démarrage
	 * du chronomètre.
	 * 
	 * @return la durée écoulée en millisecondes.
	 * @since 1.0
	 */
	public static long dureeEcoulee() {
		return (System.nanoTime() - debut) / NANO_VERS_MILLI;
	}
}
