package chap8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chap8.tab1D.Ex8_LightsOut;
import io.Aleatoire;

class Ex8_LightsOutTest {

	@Test
	void lumiereAleatoire_longueur7() {
		boolean[] obtenu = Ex8_LightsOut.lumieresAleatoires(7);
		assertEquals(7, obtenu.length);
	}
	
	@Test
	void lumiereAleatoire_longueur1() {
		boolean[] obtenu = Ex8_LightsOut.lumieresAleatoires(1);
		assertEquals(1, obtenu.length);
	}

	@Test
	void lumiereAleatoire_longueur0() {
		boolean[] obtenu = Ex8_LightsOut.lumieresAleatoires(0);
		assertEquals(0, obtenu.length);
	}
	
	@Test
	void lumiereAleatoire_longueur7AvecControleAleatoire() {
		Aleatoire.specifierNombres(0,1,1,0,1,0,0);
		final boolean[] ATTENDU = {false,true,true,false,true,false,false};
		boolean[] obtenu = Ex8_LightsOut.lumieresAleatoires(7);
		assertArrayEquals(ATTENDU, obtenu);
		Aleatoire.effacerNombres();
	}
}
