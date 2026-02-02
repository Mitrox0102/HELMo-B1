package labo3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class TemperaturesSystemeSolaireTest {

	// Constantes
	
	private static final double MARGE_ERREUR = 1e-3;
	
	private static final double DIST_MERCURE = 0.38, ALBEDO_MERCURE = 0.068;
	private static final double DIST_VENUS = 0.72, ALBEDO_VENUS = 0.770;
	private static final double DIST_TERRE = 1.00, ALBEDO_TERRE = 0.294;
	private static final double DIST_MARS = 1.52, ALBEDO_MARS = 0.250;
	private static final double DIST_JUPITER = 5.21, ALBEDO_JUPITER = 0.343;
	private static final double DIST_SATURNE = 9.54, ALBEDO_SATURNE = 0.342;
	private static final double DIST_URANUS = 19.18, ALBEDO_URANUS = 0.300;
	private static final double DIST_NEPTUNE = 30.11, ALBEDO_NEPTUNE = 0.290;
	
	// public static double enCelsius(double tKelvin)
	
	@Test
	@Order(1)
	void enCelsius_0DegreKelvin() {
		assertEquals(-273.15, TemperaturesSystemeSolaire.enCelsius(0));
	}
	
	@Test
	@Order(2)
	void enCelsius_15DegresKelvin() {
		assertEquals(-258.15, TemperaturesSystemeSolaire.enCelsius(15));
	}
	
	@Test
	@Order(3)
	void enCelsius_273_15DegresKelvin() {
		assertEquals(0, TemperaturesSystemeSolaire.enCelsius(273.15));
	}
	
	@Test
	@Order(4)
	void enCelsius_288_15DegresKelvin() {
		assertEquals(15, TemperaturesSystemeSolaire.enCelsius(288.15));
	}
	
	// public static double temperatureTheorique(double distanceAU, double albedo)

	@Test
	@Order(5)
	void temperatureTheorique_Mercure() {
		assertEquals(446.293, TemperaturesSystemeSolaire.temperatureTheorique(DIST_MERCURE, ALBEDO_MERCURE), MARGE_ERREUR);
	}

	@Test
	@Order(6)
	void temperatureTheorique_Venus() {
		assertEquals(228.520, TemperaturesSystemeSolaire.temperatureTheorique(DIST_VENUS, ALBEDO_VENUS), MARGE_ERREUR);
	}

	@Test
	@Order(7)
	void temperatureTheorique_Terre() {
		assertEquals(256.661, TemperaturesSystemeSolaire.temperatureTheorique(DIST_TERRE, ALBEDO_TERRE), MARGE_ERREUR);
	}

	@Test
	@Order(8)
	void temperatureTheorique_Mars() {
		assertEquals(211.350, TemperaturesSystemeSolaire.temperatureTheorique(DIST_MARS, ALBEDO_MARS), MARGE_ERREUR);
	}

	@Test
	@Order(9)
	void temperatureTheorique_Jupiter() {
		assertEquals(110.441, TemperaturesSystemeSolaire.temperatureTheorique(DIST_JUPITER, ALBEDO_JUPITER), MARGE_ERREUR);
	}

	@Test
	@Order(10)
	void temperatureTheorique_Saturne() {
		assertEquals(81.647, TemperaturesSystemeSolaire.temperatureTheorique(DIST_SATURNE, ALBEDO_SATURNE), MARGE_ERREUR);
	}

	@Test
	@Order(11)
	void temperatureTheorique_Uranus() {
		assertEquals(58.480, TemperaturesSystemeSolaire.temperatureTheorique(DIST_URANUS, ALBEDO_URANUS), MARGE_ERREUR);
	}

	@Test
	@Order(12)
	void temperatureTheorique_Neptune() {
		assertEquals(46.840, TemperaturesSystemeSolaire.temperatureTheorique(DIST_NEPTUNE, ALBEDO_NEPTUNE), MARGE_ERREUR);
	}
}
