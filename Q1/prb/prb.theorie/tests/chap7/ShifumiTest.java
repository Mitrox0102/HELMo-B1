package chap7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShifumiTest {

	@Test
	void vainqueurManche() {
		assertEquals(1, ShifumiVersionProf.vainqueurManche("pierre", "ciseaux"));
		assertEquals(1, ShifumiVersionProf.vainqueurManche("papier", "pierre"));
		assertEquals(1, ShifumiVersionProf.vainqueurManche("ciseaux", "papier"));
	}

}
