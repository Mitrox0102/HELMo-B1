# Solution labo 1

## Exo 1

```java
public static String format(TCGCard card) {
	Contract.require(card != null, "Argument card indéfini");

	// Calculer les rapports et les multiplier par 10 et 5, respectivement
	int hpRatio = 10 * card.getHealthPoints() / card.getMaxHealthPoints();
	int mpRatio = 5 * card.getManaPoints() / card.getMaxManaPoints();

	String nameLabel = "Carte : %s%n".formatted(card.getName());
	String textLabel = "%s%n".formatted(card.getText());
	// Ajouter deux marqueurs le premier pour ▮ et le second pour ▯
	String hpLabel = "PV : %s%s %d/%d%n".formatted(
			"▮".repeat(hpRatio), // Appel à repeat pour obtenir hpRatio ▮
			"▯".repeat(10 - hpRatio), // Appel à repeat pour obtenir les ▯ complémentaires
			card.getHealthPoints(), 
			card.getMaxHealthPoints());
	String mpLabel = "PM : %s%s %d/%d%n"
			.formatted("▮".repeat(mpRatio), "▯".repeat(5 - mpRatio),
			card.getManaPoints(), card.getMaxManaPoints());
	String attrLabel = "ATK : %d - DEF : %d%n".formatted(card.getAttack(), card.getDefense());

	return nameLabel + textLabel + hpLabel + mpLabel + attrLabel;
}
```

```java
@Test
void format_should_returns_a_string_with_card_data_2() {
	TCGCard dragon = TCGCardSample.makeDragonCard();
	dragon.setHealthPoints(75);
	dragon.setManaPoints(6);
	String[] actual = TCGCardApp.format(dragon).split("\n");
	
	assertEquals(5, actual.length);
	assertEquals("Carte : Dragon", actual[0].strip());
	assertEquals("Une créature légendaire qui crache du feu et domine le champ de bataille.", actual[1].strip());
	assertEquals("PV : ▮▮▮▮▮▯▯▯▯▯ 75/150", actual[2].strip());
	assertEquals("PM : ▮▯▯▯▯ 6/20", actual[3].strip());
	assertEquals("ATK : 9 - DEF : 7", actual[4].strip());
}
```

## Exo 2

```java
public static TCGCard makeCard() {
	Console.print("Nouvelle carte\n");
	Console.print("-".repeat(14));
	Console.println();

	String name = readNonBlank("Nom :");
	String text = readNonBlank("Texte :");
	int hp = readInt("HP [10; 999] :", 10, 999);
	int mp = readInt("MP [5; 99] :", 5, 99);
	int atk = readInt("ATK [1; 10] :", 1, 10);
	int def = readInt("DEF [1; 10] :", 1, 10);

	return new TCGCard(name, text, hp, mp, atk, def);
}

public static String readNonBlank(String message) {
	String value = Console.readLine(message);

	// Répéter dans un seul cas : value est un texte blanc
	// while(value.isBlank())
	while (value.isBlank()) {
		value = Console.readLine(message);
	}

	return value;
}

public static int readInt(String message, int min, int max) {
	int value = Console.readInt(message);
	
	// Répéter dans deux cas : si value < min ou si value > max
	// while(value < min || value > max) 
	while (value < min || value > max) {
		value = Console.readInt(message);
	}

	return value;
}
```