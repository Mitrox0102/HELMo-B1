package labo3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
class HeuresPresteesTest {

	// Constante

	

	// public static double calculerTauxMensuel(double tauxAnnuel)
	
	@Test
	@Order(1)
	void testHeures02h() {
		assertEquals(2, HeuresPrestees.lireHeures("02:34"));
	}
	
	@Test
	@Order(2)
	void testHeures2h() {
		assertEquals(2, HeuresPrestees.lireHeures("2:34"));
	}
	
	@Test
	@Order(3)
	void testHeures22h() {
		assertEquals(22, HeuresPrestees.lireHeures("22:03"));
	}
	
	@Test
	@Order(4)
	void testMinutes23m() {
		assertEquals(23, HeuresPrestees.lireMinutes("23:23"));
	}
	
	@Test
	@Order(5)
	void testMinutes2m() {
		assertEquals(2, HeuresPrestees.lireMinutes("23:2"));
	}
	
	@Test
	@Order(6)
	void testMinutes02m() {
		assertEquals(2, HeuresPrestees.lireMinutes("23:02"));
	}
	
	@Test
	@Order(7)
	void testConcertions7h15() {
		assertEquals(435, HeuresPrestees.convertirEnMinutes("7:15"));
	}
	
	@Test
	@Order(8)
	void testConcertions22h01() {
		assertEquals(1321, HeuresPrestees.convertirEnMinutes("22:01"));
	}
	
	@Test
	@Order(9)
	void testConcertions03h1() {
		assertEquals(181, HeuresPrestees.convertirEnMinutes("03:1"));
	}
	
}
