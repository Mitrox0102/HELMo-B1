package eval3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CompteurBinaireTest {

	@Test
	void testBinaire1() {
		int[] resultat = { 1, 0, 0 };
		int[] input = { 0, 1, 1 };

		CompteurBinaire.ajouterUn(input);

		assertArrayEquals(resultat, input);
		
	}
	
	/*

	@Test
	void testBinaire2() {
		int[] resultat = { 0, 0, 0 };
		int[] input = { 1, 1, 1 };

		CompteurBinaire.ajouterUn(input);

		assertArrayEquals(resultat, input);
	}

	@Test
	void testBinaire1_taille4() {
		int[] resultat = { 1, 0, 1, 1 };
		int[] input = { 1, 0, 1, 0 };

		CompteurBinaire.ajouterUn(input);

		assertArrayEquals(resultat, input);
	}

	@Test
	void testBinaire2_taille4() {
		int[] resultat = { 0, 0, 0, 0 };
		int[] input = { 1, 1, 1, 1 };

		CompteurBinaire.ajouterUn(input);

		assertArrayEquals(resultat, input);
	}
	*/
}
