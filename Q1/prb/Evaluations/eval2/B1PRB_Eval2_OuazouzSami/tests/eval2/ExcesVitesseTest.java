package eval2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExcesVitesseTest {

	@Test
	void test_amande_annif_1() {
		assertEquals(53, ExcesVitesse.montantAmende(10, true));
	}
	
	@Test
	void test_amande_annif_2() {
		assertEquals(0, ExcesVitesse.montantAmende(5, true));
	}
	
	@Test
	void test_amande_annif_3() {
		assertEquals(53, ExcesVitesse.montantAmende(15, true));
	}

	@Test
	void test_amande_annif_4() {
		assertEquals(233, ExcesVitesse.montantAmende(45, true));
	}
	
	@Test
	void test_amande_annif_5() {
		assertEquals(300, ExcesVitesse.montantAmende(47, true));
	}
	
	@Test
	void test_amande_1() {
		assertEquals(0, ExcesVitesse.montantAmende(0, false));
	}
	
	@Test
	void test_amande_2() {
		assertEquals(53, ExcesVitesse.montantAmende(1, false));
	}
	
	@Test
	void test_amande_3() {
		assertEquals(59, ExcesVitesse.montantAmende(11, false));
	}
	
	@Test
	void test_amande_4() {
		assertEquals(300, ExcesVitesse.montantAmende(41, false));
	}
	
}
