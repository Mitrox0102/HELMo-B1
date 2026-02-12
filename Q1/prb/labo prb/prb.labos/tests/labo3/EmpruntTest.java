package labo3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
class EmpruntTest {

	// Constante
	
	private static final double MARGE_ERREUR_TAUX_MENSUEL = 1e-9;
	private static final double MARGE_ERREUR_MENSUALITE = 1e-3;
	private static final double MARGE_ERREUR_SOLDE_CAPITAL = 1e-3;

	// public static double calculerTauxMensuel(double tauxAnnuel)
	
	@Test
	@Order(1)
	void calculerTauxMensuel_test1() {
		assertEquals(0.0024987063, Emprunt.calculerTauxMensuel(0.0304), MARGE_ERREUR_TAUX_MENSUEL);
	}
	
	@Test
	@Order(2)
	void calculerTauxMensuel_test2() {
		assertEquals(0.04521125295294337, Emprunt.calculerTauxMensuel(0.7), MARGE_ERREUR_TAUX_MENSUEL);
	}
	
	@Test
	@Order(3)
	void calculerTauxMensuel_test3() {
		assertEquals(0.09887124196570296, Emprunt.calculerTauxMensuel(2.1), MARGE_ERREUR_TAUX_MENSUEL);
	}

	// public static double calculerMensualite(double capital, int nbMois, double tauxMensuel)

	@Test
	@Order(4)
	void calculerMensualite_test1() {
		assertEquals(138.62997, Emprunt.calculerMensualite(Emprunt.calculerTauxMensuel(0.0304),25000,240), MARGE_ERREUR_MENSUALITE);
	}

	@Test
	@Order(5)
	void calculerMensualite_test2() {
		assertEquals(1042.7003624734443, Emprunt.calculerMensualite(Emprunt.calculerTauxMensuel(0.2), 39022, 56), MARGE_ERREUR_MENSUALITE);
	}

	@Test
	@Order(6)
	void calculerMensualite_test3() {
		assertEquals(2913.8992274789675, Emprunt.calculerMensualite(Emprunt.calculerTauxMensuel(2.1), 25000, 20), MARGE_ERREUR_MENSUALITE);
	}
	
	// public static double calculerSoldeCapital(double mensualite, int nbMoisRestants, double tauxMensuel)

	@Test
	@Order(7)
	void calculerSoldeCapital_test1() {
//		assertEquals(?, Emprunt.calculerSoldeCapital(?), MARGE_ERREUR_SOLDE_CAPITAL);
	}
	
	@Test
	@Order(8)
	void calculerSoldeCapital_test2() {
//		assertEquals(?, Emprunt.calculerSoldeCapital(?), MARGE_ERREUR_SOLDE_CAPITAL);
	}
	
	@Test
	@Order(9)
	void calculerSoldeCapital_test3() {
//		assertEquals(?, Emprunt.calculerSoldeCapital(?), MARGE_ERREUR_SOLDE_CAPITAL);
	}
	
}
