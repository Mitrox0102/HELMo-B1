package labo4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
class DroitesTest {

	private static final double MARGE_ERREUR = 5e-9; 
	
	// public static double lireCoordX(String coordPoint)
	
	@Test
	@Order(1)
	void lireCoordX() {
		assertEquals(1.0, Droites.lireCoordX("1 -4"), MARGE_ERREUR);
		assertEquals(-1.0, Droites.lireCoordX("-1 4.3"), MARGE_ERREUR);
		assertEquals(-1.1, Droites.lireCoordX("-1.1 4"), MARGE_ERREUR);
		assertEquals(1.1, Droites.lireCoordX("1.1 -4.3"), MARGE_ERREUR);
	}

	// public static double lireCoordY(String coordPoint)
	
	@Test
	@Order(2)
	void lireCoordY() {
		assertEquals(-4.0, Droites.lireCoordY("1 -4"), MARGE_ERREUR);
		assertEquals(4.3, Droites.lireCoordY("-1 4.3"), MARGE_ERREUR);
		assertEquals(4.0, Droites.lireCoordY("-1.1 4"), MARGE_ERREUR);
		assertEquals(-4.3, Droites.lireCoordY("1.1 -4.3"), MARGE_ERREUR);
	}

	// public static double coefficientDirecteur(double xA, double yA, double xB, double yB)
	
	@Test
	@Order(3)
	void coefficientDirecteur_droiteOblique() {
		assertEquals(2.0, Droites.coefficientDirecteur(1.0, 0.0, 3.0, 4.0), MARGE_ERREUR);
		assertEquals(-0.5, Droites.coefficientDirecteur(0.0, 0.0, 4.0, -2.0), MARGE_ERREUR);
	}
	
	@Test
	@Order(4)
	void coefficientDirecteur_droiteVerticale() {
		assertEquals(Double.POSITIVE_INFINITY, Droites.coefficientDirecteur(4.2, 0.0, 4.2, -2.0), MARGE_ERREUR);
		assertEquals(Double.POSITIVE_INFINITY, Droites.coefficientDirecteur(-1.0, 99.0, -1.0, -9.0), MARGE_ERREUR);
	}

}
