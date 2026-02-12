package tcg;

import util.Contract;

/**
 * Représente une carte de jeu de cartes à collectionner (TCG).
 * <p>
 * Chaque carte possède un nom, une description, des points de vie, des points de mana,
 * une valeur d'attaque et une valeur de défense. Les valeurs des champs sont soumises à des contraintes pour garantir la cohérence du jeu.
 */
public final class TCGCard {
    private final String name;
    private final String text;
    private final int attack;
    private final int defense;
    private int healthPoints;
    private int maxHealthPoints;
    private int manaPoints;
    private int maxManaPoints;

    /**
     * Construit une nouvelle instance de TCGCard.
     *
     * @param name Le nom de la carte. Doit être défini et non vide.
     * @param text La description de la carte. Doit être définie et non vide.
     * @param hp Les points de vie initiaux (et maximaux) de la carte. Doit être compris entre 10 et 999 (inclus).
     * @param mp Les points de mana initiaux (et maximaux) de la carte. Doit être compris entre 5 et 99 (inclus).
     * @param atk La valeur d'attaque de la carte. Doit être comprise entre 1 et 10 (inclus).
     * @param def La valeur de défense de la carte. Doit être comprise entre 1 et 10 (inclus).
     * @throws IllegalArgumentException Si l'une des contraintes sur les arguments n'est pas respectée.
     */
    public TCGCard(String name, String text, int hp, int mp, int atk, int def) {
        this.name = Contract.require(name, name != null && !name.isBlank(),
                "Argument name doit être défini et non blanc.");
        this.text = Contract.require(text, text != null && !text.isBlank(),
                "Argument text doit être défini et non blanc.");
        this.healthPoints = this.maxHealthPoints = Contract.require(hp, 10 <= hp && hp <= 999,
                "Argument hp doit être dans [10; 999]. Reçu " + hp);
        this.manaPoints = this.maxManaPoints = Contract.require(mp, 5 <= mp && mp <= 99,
                "Argument mp doit être dans [5; 99]. Reçu " + mp);
        this.attack = Contract.require(atk, 1 <= atk && atk <= 10, "Argument atk doit être dans [1; 10]. Reçu "+atk);
        this.defense = Contract.require(def, 1 <= def && def <= 10, "Argument def doit être dans [1; 10]. Reçu "+def);
    }

    /**
     * @return Les points de vie actuels de la carte.
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * Définit les points de vie de la carte.
     *
     * @param hp La nouvelle valeur des points de vie. Doit être comprise entre 0 et {@link #getMaxHealthPoints()}.
     * @throws IllegalArgumentException Si la valeur fournie n'est pas dans l'intervalle autorisé.
     */
    public void setHealthPoints(int hp) {
        Contract.require(hp, 0 <= hp && hp <= maxHealthPoints,
                "Argument hp doit être dans [0; %d]. Reçu %d.".formatted(maxHealthPoints, hp));
        this.healthPoints = hp;
    }

    /**
     * @return Les points de mana actuels de la carte.
     */
    public int getManaPoints() {
        return manaPoints;
    }

    /**
     * Définit les points de mana de la carte.
     *
     * @param mp La nouvelle valeur des points de mana. Doit être comprise entre 0 et {@link #getMaxManaPoints()}.
     * @throws IllegalArgumentException Si la valeur fournie n'est pas dans l'intervalle autorisé.
     */
    public void setManaPoints(int mp) {
        Contract.require(mp, 0 <= mp && mp <= maxManaPoints,
                "Argument mp doit être dans [0; %d]. Reçu %d.".formatted(maxManaPoints, mp));
        this.manaPoints = mp;
    }

    /**
     * @return Le nom de la carte.
     */
    public String getName() {
        return name;
    }

    /**
     * @return La description de la carte.
     */
    public String getText() {
        return text;
    }

    /**
     * @return Les points de vie maximaux de la carte.
     */
    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    /**
     * @return Les points de mana maximaux de la carte.
     */
    public int getMaxManaPoints() {
        return maxManaPoints;
    }

    /**
     * @return La valeur d'attaque de la carte.
     */
    public int getAttack() {
        return attack;
    }

    /**
     * @return La valeur de défense de la carte.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Soigne la carte : rétablit ses points de vie à leur valeur maximale.
     */
    public void heal() {
        this.healthPoints = maxHealthPoints;
    }

    /**
     * Remplit les points de mana de la carte à leur valeur maximale.
     */
    public void fillMana() {
        this.manaPoints = maxManaPoints;
    }

    /**
     * @return {@code true} si la carte est en vie (points de vie > 0), {@code false} sinon.
     */
    public boolean isAlive() {
        return this.healthPoints > 0;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}

