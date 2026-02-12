package tcg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RestoreTest {

   //TODO: définir des cas de test
	
	@Test
	void deck_0_HP() {
		TCGCard golem = TCGCardSample.makeStoneGolemCard();
		TCGCard knight = TCGCardSample.makeRoyalKnightCard();
		
		golem.setHealthPoints(0);
		knight.setHealthPoints(0);
		
		TCGCard[] deck = {golem, knight};
		
		int[] tab = TCGCardApp.restore(deck, 2);
		
		
		assertEquals(golem.getMaxHealthPoints(), golem.getHealthPoints());
		assertEquals(knight.getMaxHealthPoints(), knight.getHealthPoints());
		assertEquals(2, tab[0]);
		assertEquals(0, tab[1]);
	}
	
	@Test
	void deck_0_MP() {
		TCGCard golem = TCGCardSample.makeStoneGolemCard();
		TCGCard knight = TCGCardSample.makeRoyalKnightCard();
		
		golem.setManaPoints(0);
		knight.setManaPoints(0);
		
		TCGCard[] deck = {golem, knight};
		
		int[] tab =  TCGCardApp.restore(deck, 2);
		
		
		assertEquals(golem.getMaxManaPoints(), golem.getManaPoints());
		assertEquals(knight.getMaxManaPoints(), knight.getManaPoints());
		assertEquals(0, tab[0]);
		assertEquals(2, tab[1]);
	}
	
	@Test
	void deck_0_MP_AND_HP() {
		TCGCard golem = TCGCardSample.makeStoneGolemCard();
		TCGCard knight = TCGCardSample.makeRoyalKnightCard();
		
		golem.setHealthPoints(0);
		knight.setHealthPoints(0);
		golem.setManaPoints(0);
		knight.setManaPoints(0);
		
		TCGCard[] deck = {golem, knight};
		
		int[] tab =  TCGCardApp.restore(deck, 2);
		
		assertEquals(golem.getMaxHealthPoints(), golem.getHealthPoints());
		assertEquals(knight.getMaxHealthPoints(), knight.getHealthPoints());
		assertEquals(golem.getMaxManaPoints(), golem.getManaPoints());
		assertEquals(knight.getMaxManaPoints(), knight.getManaPoints());
		assertEquals(2, tab[0]);
		assertEquals(2, tab[1]);
	}
	
}

