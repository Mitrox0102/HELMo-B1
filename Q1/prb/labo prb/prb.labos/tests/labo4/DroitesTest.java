package labo4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class DroitesTest {

	@Test
	@Order(1)
	void lireCoordX_test1() {
		assertEquals(1, Droites.lireCoordX("1 0"));
	}
	
	@Test
	@Order(2)
	void lireCoordX_test2() {
		assertEquals(-2, Droites.lireCoordX("-2 0"));
	}
	
	@Test
	@Order(3)
	void lireCoordX_test3() {
		assertEquals(0, Droites.lireCoordX("0 0"));
	}
	
	@Test
	@Order(4)
	void lireCoordY_test1() {
		assertEquals(4, Droites.lireCoordY("0 4"));
	}
	
	@Test
	@Order(5)
	void lireCoordY_test2() {
		assertEquals(-8, Droites.lireCoordY("0 -8"));
	}
	
	@Test
	@Order(6)
	void lireCoordY_test3() {
		assertEquals(0, Droites.lireCoordY("0 0"));
	}
	
	@Test
	@Order(7)
	void coefficientDir_test1() {
		assertEquals(-1, Droites.coefficientDirecteur(1, 0, 0, 1));
	}
	
	@Test
	@Order(8)
	void coefficientDir_test2() {
		assertEquals(-1, Droites.coefficientDirecteur(-3., 4., 2., -1.));
	}
	
	@Test
	@Order(9)
	void coefficientDir_test3() {
		assertEquals(1.6666666666666667, Droites.coefficientDirecteur(-2, 3, 1, 8));
	}

}
