package labo4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class DateTest {

	@Test
	@Order(1)
	void getAnnee_test1() {
		assertEquals(2029, DateEx.getAnnee("2/12/2029"));
	}
	
	@Test
	@Order(2)
	void getAnnee_test2() {
		assertEquals(1900, DateEx.getAnnee("2/12/1900"));
	}
	
	@Test
	@Order(3)
	void getAnnee_test3() {
		assertEquals(2, DateEx.getAnnee("2/12/2"));
	}
	
	@Test
	@Order(4)
	void getMois_test1() {
		assertEquals(12, DateEx.getMois("2/12/2029"));
	}
	
	@Test
	@Order(5)
	void getMois_test2() {
		assertEquals(2, DateEx.getMois("2/02/1900"));
	}
	
	@Test
	@Order(6)
	void getMois_test3() {
		assertEquals(2, DateEx.getMois("2/2/2"));
	}
	
	@Test
	@Order(7)
	void getJour_test1() {
		assertEquals(2, DateEx.getJour("2/12/2029"));
	}
	
	@Test
	@Order(8)
	void getJour_test2() {
		assertEquals(2, DateEx.getJour("02/02/1900"));
	}
	
	@Test
	@Order(9)
	void getJour_test3() {
		assertEquals(29, DateEx.getJour("29/2/2"));
	}
	
	@Test
	@Order(10)
	void estBissextile_test1() {
		assertEquals(true, DateEx.estBissextile(2024));
	}
	
	@Test
	@Order(11)
	void estBissextile_test2() {
		assertEquals(false, DateEx.estBissextile(2022));
	}
	
	@Test
	@Order(12)
	void estBissextile_test3() {
		assertEquals(false, DateEx.estBissextile(1000));
	}
	
	@Test
	@Order(13)
	void formaterDate_test1() {
		assertEquals("02/02/1900", DateEx.formaterDate(2, 2, 1900));
	}
	
	@Test
	@Order(14)
	void formaterDate_test2() {
		assertEquals("12/02/0200", DateEx.formaterDate(12,2,200));
	}
	
	@Test
	@Order(15)
	void formaterDate_test3() {
		assertEquals("00/00/0000", DateEx.formaterDate(0, 0, 0));
	}

}
