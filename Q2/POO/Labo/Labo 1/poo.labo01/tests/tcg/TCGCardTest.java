package tcg;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cette classe valide et documente la classe TCGCard
 * 
 * @see tcg.TCGCard
 * */
class TCGCardTest {

    // Tests pour le constructeur avec des valeurs valides
    @Test
    @DisplayName("Création d'une carte avec des valeurs valides")
    void testValidCardCreation() {
        TCGCard card = new TCGCard("Dragon", "Un dragon puissant", 100, 50, 8, 6);
        assertEquals("Dragon", card.getName());
        assertEquals("Un dragon puissant", card.getText());
        assertEquals(100, card.getHealthPoints());
        assertEquals(100, card.getMaxHealthPoints());
        assertEquals(50, card.getManaPoints());
        assertEquals(50, card.getMaxManaPoints());
        assertEquals(8, card.getAttack());
        assertEquals(6, card.getDefense());
    }

    // Tests pour les valeurs incorrectes du nom
    @Test
    @DisplayName("Lever une exception pour les arguments null")
    void testInvalidName() {
        assertThrows(IllegalArgumentException.class, () ->
            new TCGCard(null, "Un dragon puissant", 100, 50, 8, 6)
        );
        assertThrows(IllegalArgumentException.class, () ->
        new TCGCard("Dragon", null, 100, 50, 8, 6)
    );
    }
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("Lever une exception pour un nom invalide")
    void testInvalidName(String invalidName) {
        assertThrows(IllegalArgumentException.class, () ->
            new TCGCard(invalidName, "Un dragon puissant", 100, 50, 8, 6)
        );
    }

    // Tests pour les valeurs incorrectes de la description
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("Lever une exception pour une description invalide")
    void testInvalidText(String invalidText) {
        assertThrows(IllegalArgumentException.class, () ->
            new TCGCard("Dragon", invalidText, 100, 50, 8, 6)
        );
    }

    // Tests pour les valeurs incorrectes des points de vie
    @ParameterizedTest
    @ValueSource(ints = {9, 1000, -1})
    @DisplayName("Lever une exception pour des points de vie invalides")
    void testInvalidHealthPoints(int invalidHp) {
        assertThrows(IllegalArgumentException.class, () ->
            new TCGCard("Dragon", "Un dragon puissant", invalidHp, 50, 8, 6)
        );
    }

    // Tests pour les valeurs incorrectes des points de mana
    @ParameterizedTest
    @ValueSource(ints = {4, 100, -1})
    @DisplayName("Lever une exception pour des points de mana invalides")
    void testInvalidManaPoints(int invalidMp) {
        assertThrows(IllegalArgumentException.class, () ->
            new TCGCard("Dragon", "Un dragon puissant", 100, invalidMp, 8, 6)
        );
    }

    // Tests pour les valeurs incorrectes de l'attaque
    @ParameterizedTest
    @ValueSource(ints = {0, 11, -1})
    @DisplayName("Lever une exception pour une valeur d'attaque invalide")
    void testInvalidAttack(int invalidAtk) {
        assertThrows(IllegalArgumentException.class, () ->
            new TCGCard("Dragon", "Un dragon puissant", 100, 50, invalidAtk, 6)
        );
    }

    // Tests pour les valeurs incorrectes de la défense
    @ParameterizedTest
    @ValueSource(ints = {0, 11, -1})
    @DisplayName("Lever une exception pour une valeur de défense invalide")
    void testInvalidDefense(int invalidDef) {
        assertThrows(IllegalArgumentException.class, () ->
            new TCGCard("Dragon", "Un dragon puissant", 100, 50, 8, invalidDef)
        );
    }

    // Tests pour les méthodes setHealthPoints et setManaPoints avec des valeurs invalides
    @Test
    @DisplayName("Lever une exception pour des points de vie invalides lors de la mise à jour")
    void testSetInvalidHealthPoints() {
        TCGCard card = new TCGCard("Dragon", "Un dragon puissant", 100, 50, 8, 6);
        assertThrows(IllegalArgumentException.class, () -> card.setHealthPoints(-1));
        assertThrows(IllegalArgumentException.class, () -> card.setHealthPoints(101));
    }

    @Test
    @DisplayName("Lever une exception pour des points de mana invalides lors de la mise à jour")
    void testSetInvalidManaPoints() {
        TCGCard card = new TCGCard("Dragon", "Un dragon puissant", 100, 50, 8, 6);
        assertThrows(IllegalArgumentException.class, () -> card.setManaPoints(-1));
        assertThrows(IllegalArgumentException.class, () -> card.setManaPoints(51));
    }

    // Tests pour les méthodes heal et fillMana
    @Test
    @DisplayName("Vérifier que heal rétablit les points de vie à leur maximum")
    void testHeal() {
        TCGCard card = new TCGCard("Dragon", "Un dragon puissant", 100, 50, 8, 6);
        card.setHealthPoints(50);
        card.heal();
        assertEquals(100, card.getHealthPoints());
    }

    @Test
    @DisplayName("Vérifier que fillMana rétablit les points de mana à leur maximum")
    void testFillMana() {
        TCGCard card = new TCGCard("Dragon", "Un dragon puissant", 100, 50, 8, 6);
        card.setManaPoints(25);
        card.fillMana();
        assertEquals(50, card.getManaPoints());
    }

    // Tests pour la méthode isAlive
    @Test
    @DisplayName("Vérifier que isAlive retourne false si les points de vie sont à 0")
    void testIsAliveWhenDead() {
        TCGCard card = new TCGCard("Dragon", "Un dragon puissant", 100, 50, 8, 6);
        card.setHealthPoints(0);
        assertFalse(card.isAlive());
    }

    @Test
    @DisplayName("Vérifier que isAlive retourne true si les points de vie sont supérieurs à 0")
    void testIsAliveWhenAlive() {
        TCGCard card = new TCGCard("Dragon", "Un dragon puissant", 100, 50, 8, 6);
        assertTrue(card.isAlive());
    }
}

