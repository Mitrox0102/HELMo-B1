package tcg;

final class TCGCardSample {

  private TCGCardSample() {}

  static TCGCard makeDragonCard() {
    return new TCGCard(
      "Dragon",
      "Une créature légendaire qui crache du feu et domine le champ de bataille.",
      150,
      20,
      9,
      7
    );
  }

  static TCGCard makeStoneGolemCard() {
    return new TCGCard(
      "Golem de Pierre",
      "Une créature solide qui absorbe les dégâts pour ses alliés.",
      200,
      10,
      5,
      10
    );
  }

  static TCGCard makeRoyalKnightCard() {
    return new TCGCard(
      "Chevalier Royal",
      "Un guerrier loyal qui protège ses alliés avec honneur.",
      120,
      18,
      7,
      6
    );
  }

  static TCGCard makeWerewolfCard() {
    return new TCGCard(
      "Loup-Garou",
      "Attaque rapidement et se régénère pendant la nuit.",
      90,
      14,
      8,
      3
    );
  }

  static TCGCard makeShadowMageCard() {
    return new TCGCard(
      "Mage des Ombres",
      "Utilise la magie noire pour infliger des dégâts indirects.",
      80,
      25,
      6,
      2
    );
  }

  static TCGCard makePhoenixCard() {
    return new TCGCard(
      "Phénix",
      "Ressuscite avec la moitié de ses points de vie après avoir été vaincu.",
      180,
      30,
      2,
      7
    );
  }
}
