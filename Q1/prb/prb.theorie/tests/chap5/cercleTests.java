package chap5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chap5.formes.Cercle;

class cercleTests {

	@Test
	void premietreAvecRayonValide() {
		assertEquals(62.8318, Cercle.perimetre(10), 0.0001);
	}

}
