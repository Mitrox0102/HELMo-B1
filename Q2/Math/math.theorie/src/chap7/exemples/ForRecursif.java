package chap7.exemples;

/**
 * Simulation récursive d'une boucle for.
 * 
 */

public class ForRecursif {
	/**
	 * Affiche les valeurs entières à partir de {@code i} jusqu'à {@code stop} (exclus), 
	 * en incrémentant de {@code incr} à chaque appel récursif.
	 *<p>
	 * Le comportement est similaire à la boucle {@code for} :<br>
	 *<pre>
	 * for (int j = i; j < stop; j += incr) {
	 *     System.out.println(j);
	 * }
	 * </pre>
	 * @param i Valeur initiale
	 * @param stop Borne supérieure (exclusive)
	 * @param incr Valeur de l'incrément (doit être strictement positive pour garantir la terminaison)
	 */
	
	public static void forRecursif(int i, int stop, int incr) {
		
	  if (i < stop) {
	    System.out.print(i + " ");
	    i = i + incr;
	    forRecursif(i, stop, incr);
	  }
	} 
	
	

	public static void main(String[] args) {
		
		System.out.println("Boucle for :"); 
		int start = 1, stop = 100, incr = 1;
		
		for (int i = start; i < stop; i = i + incr) {
		    System.out.print(i + " "); 
		}
		
		System.out.println("\n"); 
		System.out.println("Boucle for simulée de manière récursive :");
		forRecursif(1, 100, 1);	
		
	}
}
