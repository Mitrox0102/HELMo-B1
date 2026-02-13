package lecon04;

import java.util.Arrays;

/**
 * @author Adapté de Christiane Mathy
 */
public class GrilleLotto {
	private final int nbBoules;
	private final int tailleGrille;
	private int[] grille; // numéros tirés
	private int nbreTiragesEffectues;

	public GrilleLotto(int nbBoules, int tailleGrille) {
		this.nbBoules = Math.max(2, nbBoules);
		this.tailleGrille = Math.max(1, tailleGrille);
		this.grille = new int[tailleGrille];
		this.nbreTiragesEffectues = 0;
	}
	
	public void tirageGrille() {
		this.nbreTiragesEffectues = 0;
		for(int i = 0; i < tailleGrille; i++) {
			tirageBoule(); 
		}
	}
	
	public int[] getGrille() {
		return Arrays.copyOf(grille, tailleGrille);
	}
	
	private boolean numéroUnique (int numéro) {
		for (int indiceTirage=0; indiceTirage < nbreTiragesEffectues; indiceTirage++)
			if (this.grille[indiceTirage] == numéro) {
				return false;
			}

		/*
		 * INIT : init + decl = 2 ops
		 * GARDIEN : 3 ops (2 lectures + '<')
		 * CORPS : cond (4) + 2 (branche else) -> 6 ops
		 * FIN : 1 op
		 * nb_tours : (tte les boules sont != à numéro) : nbreTiragesEffectues
		 * 2 + 1 + 3 +  nbreTiragesEffectues * (6 + 3) =
		 * 6 + 9 * nbreTiragesEffectues => O(nbreTiragesEffectues)
		 */
		
		
		return true;
	}
	
	/**
	 * Complexité saptiale : 
	 * Var ? n, nbBoules, nb
	 * @return
	 */
	
	private int tirageBoule() { // utilise numéro_unique()
		int n;  // 1 op
		do {
			/*
			 * accès à nbBoules, multiplication, appel Math.random, cast, addition, affectationn
			 * => 6 opérations élémentaires.
			 */
			n = 1 + ((int)(Math.random() * nbBoules)); // n dans[1,42] 
		} while (!numéroUnique(n)) ;
		/*
		 * INIT : 1 op
		 * GARDIEN : 2 (! + lecture n) + nbreTiragesEffectues
		 * CORPS : 6 op
		 * FIN : 4 + 2 + 1 = 7 ops
		 * nb_tours : on supposera que nbBoules << tailleGrille de sorte que les
		 * collisions pue fréquentes. Par conséquents, numeroUnique renvoie vrai et 
		 * la boucle ne fait qu'un tour
		 * 
		 * Concl : 1 + 2 + nbtirageEffectués + 7 + 1 * (6 + nbTirageEffectues)
		 * = 10 + nbTirageEffectués + 6 * nbTirageEffectués = 10 + 7 * nbTiragesEffectués -> O(nbTirageEffectués)
		 */
		
		
		// mise à jour de la grille
		// lecture n, lecture nbTE, accés tableau grille et l'affectation
		// => 4 opérations élémentaires
		this.grille[nbreTiragesEffectues] = n;
		// => 2 opérations
		nbreTiragesEffectues += 1;

		// => 1 opération
		return n;
	}
}

