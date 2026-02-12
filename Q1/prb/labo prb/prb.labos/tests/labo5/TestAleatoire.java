package labo5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import util.Aleatoire;

class TestAleatoire {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {

		// Déclaration du tableau des valeurs
		String[] t = { "Neque", "Porro" };

		// Copie du tableau pour vérifications
		final String[] COPIE = t.clone();

		// Déclaration des valeurs aléatoires
		final int[] POSITIONS_ALEATOIRES = { 1, 0, 0, 1 };

		// On efface la file de la classe
		Aleatoire.effacerNombres();

		// On remplace la file de la classe par des valeurs qu'on a prédéfinies
		Aleatoire.specifierNombres(POSITIONS_ALEATOIRES);

		for (int i = 0; i < POSITIONS_ALEATOIRES.length; i++) {
 
			// On prend en donnée la supposée valeur aléatoire
			int posAleat = POSITIONS_ALEATOIRES[i];

			// On compare les résultats pour vérifier si notre fonction utilise bien la
			// classe aléatoire
			assertEquals(t[posAleat], TableauChaines.valeurAleatoire(t));

			// On vérifie que la fonction laisse nos tableaux intactes
			assertArrayEquals(COPIE, t);

		}

	}

}
