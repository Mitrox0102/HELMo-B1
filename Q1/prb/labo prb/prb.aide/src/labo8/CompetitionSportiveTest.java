package labo8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CompetitionSportiveTest {

	@Test
	void testNbEquipes3() {
		String[] attendu = {"Aische", "FC Huy", "RES Durbuy"};
		String[] resultat = CompetitionSportive.encoderNomsEquipes(3);
		assertArrayEquals(attendu, resultat);
	}

}
