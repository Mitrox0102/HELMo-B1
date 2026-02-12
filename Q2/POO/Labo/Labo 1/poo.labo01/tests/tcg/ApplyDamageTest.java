package tcg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ApplyDamageTest {

	
	@Test
	void should_pass_the_happy_path_1() {
		TCGCard golem = TCGCardSample.makeStoneGolemCard();
		TCGCard knight = TCGCardSample.makeRoyalKnightCard();
		
		final int expectedDamage = 8;
		final int expectedManaConsumed = 3;		
		final int expectedHp = golem.getHealthPoints() - expectedDamage;
		final int expectedMp = knight.getManaPoints() - expectedManaConsumed;
		
		int actualDamage = TCGCardApp.applyDamage(knight, golem);
		
		assertEquals(expectedDamage, actualDamage);
		assertEquals(expectedHp, golem.getHealthPoints());
		assertEquals(expectedMp, knight.getManaPoints());
	}
	
	// TODO écrire un second cas de test simple
	
	@Test
	void should_pass_the_happy_path_2() {
		TCGCard golem = TCGCardSample.makeDragonCard();
		TCGCard knight = TCGCardSample.makeRoyalKnightCard();
		
		final int expectedDamage = 14;
		final int expectedManaConsumed = 3;		
		final int expectedHp = golem.getHealthPoints() - expectedDamage;
		final int expectedMp = knight.getManaPoints() - expectedManaConsumed;
		
		int actualDamage = TCGCardApp.applyDamage(knight, golem);
		
		assertEquals(expectedDamage, actualDamage);
		assertEquals(expectedHp, golem.getHealthPoints());
		assertEquals(expectedMp, knight.getManaPoints());
	}
	
	// TODO écrire des cas de test pour des cas particuliers
	
	@Test
	void should_pass_the_happy_path_not_enough() {
		TCGCard Dragon = TCGCardSample.makeDragonCard();
		TCGCard knight = TCGCardSample.makeRoyalKnightCard();
		
		knight.setManaPoints(0);
		
		final int expectedDamage = -1;
		final int expectedHp = Dragon.getHealthPoints();
		final int expectedMp = knight.getManaPoints();
		
		int actualDamage = TCGCardApp.applyDamage(knight, Dragon);
		
		assertEquals(expectedDamage, actualDamage);
		assertEquals(expectedHp, Dragon.getHealthPoints());
		assertEquals(expectedMp, knight.getManaPoints());
	}
	
	@Test
	void should_pass_the_happy_path_kill() {
		TCGCard Dragon = TCGCardSample.makeDragonCard();
		TCGCard knight = TCGCardSample.makeRoyalKnightCard();
		
		Dragon.setHealthPoints(1);
		
		final int expectedDamage = 14;
		final int expectedManaConsumed = 3;		
		final int expectedHp = 0;
		final int expectedMp = knight.getManaPoints() - expectedManaConsumed;
		
		int actualDamage = TCGCardApp.applyDamage(knight, Dragon);
		
		assertEquals(expectedDamage, actualDamage);
		assertEquals(expectedHp, Dragon.getHealthPoints());
		assertEquals(expectedMp, knight.getManaPoints());
	}


	@Test
	void should_pass_the_happy_phoenix_golem() {
		TCGCard golem = TCGCardSample.makeStoneGolemCard();
		TCGCard phoenix = TCGCardSample.makePhoenixCard();
		
		final int expectedHp = golem.getHealthPoints();
		
		//int actualDamage = TCGCardApp.applyDamage(phoenix, golem);
		
		assertEquals(expectedHp, golem.getHealthPoints());
	}
}
