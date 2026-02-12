package chap5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chap5.formes.Rectangle;

class rectangleTests {

	@Test
	void perimetreAvecDimensionsValides() {
		assertEquals(13, Rectangle.perimetre(2.5, 4));
		assertEquals(29, Rectangle.perimetre(10, 4.5));
	}

}
