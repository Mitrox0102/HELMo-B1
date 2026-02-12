package chap6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegistreNationalTest {

	@Test
	void estNumeroValide_avecNumeroValideApdAnnee2000() {
		assertEquals(true, RegistreNational.estNumeroValide("06.10.21-171-06"));
		assertTrue(RegistreNational.estNumeroValide("36.10.21-171.54"));
	}

	@Test
	void estNumeroValide_avecNumeroNonValideApdAnnee2000() {
		assertEquals(false, RegistreNational.estNumeroValide("06.10.21-170-06"));
		assertFalse(RegistreNational.estNumeroValide("36.10.21-171"));
	}
	
}
