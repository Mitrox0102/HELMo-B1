package lecon04;

import java.util.Arrays;

/**
 * @author Adapté de Christiane Mathy
 */
public class GrilleLottoV2 {
	private final int nbBoules;
	private final int tailleGrille;
	private int[] grille; // numéros tirés
	private int nbreTiragesEffectues;
	private boolean[] déjàTiré; // numéros tirés
		
	public GrilleLottoV2(int nbBoules, int tailleGrille) {
		this.nbBoules = Math.max(2, nbBoules);
		this.tailleGrille = Math.max(1, tailleGrille);
		this.grille = new int[tailleGrille];
		this.nbreTiragesEffectues = 0;
		this.déjàTiré = new boolean[nbBoules + 1]; // la position [0] sera inutilisée
	}
	
	public void tirageGrille() {
		
		/*
		 * INIT = 1 op
		 * GARDIEN = 3 ops
		 * CORPS : 
		 * FIN : 0 op
		 */
		
		
		this.nbreTiragesEffectues = 0;
		for(int i = 0; i < tailleGrille; i++) {
			tirageBoule(); 
		}
	}
	
	public int[] getGrille() {
		return Arrays.copyOf(grille, tailleGrille);
	}

	private boolean numéroUnique (int numéro) {
		if (déjàTiré[numéro]) {
			return false;
		}
		else {
			déjàTiré[numéro] = true;
			return  true;
		}
	}

	private int tirageBoule() { // utilise numéro_unique()
		
		/*
		 * INIT : 1 op
		 * CORPS : 6 ops
		 * GARDIEN : 
		 * FIN : 7 ops
		 */
		
		int n;
		do {
			n = 1 + ((int)(Math.random() * nbBoules)); // n dans [1,42] 
		} while (!numéroUnique(n)) ;

		// mise à jour de la grille
		this.grille[nbreTiragesEffectues] = n;
		nbreTiragesEffectues += 1;

		return n;
	}
}