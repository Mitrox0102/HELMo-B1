package chap8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chap8.tab1D.Ex5_AcquisitionDate;

class ex5_AcquisitionDateTest {

	@Test
	void extraireDAte() {
		assertArrayEquals(new int[] {23, 11, 2025}, Ex5_AcquisitionDate.extraireDate("23/11/2025"));
	}

}
