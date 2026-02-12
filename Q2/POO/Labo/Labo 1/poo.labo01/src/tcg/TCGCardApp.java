package tcg;

import java.util.Arrays;

import io.Console;
import util.Contract;

public class TCGCardApp {

	public static void main(String[] args) {

		Console.println("POO - Labo 1");
		Console.println("============");
		Console.println();
		
		TCGCard[] deck = {};
		
		int choix_menu;
		
		do {
		    choix_menu = afficher_menu(5 - deck.length);
		    
		    switch (choix_menu) {
		        case 1 -> deck = ajouter_carte(deck);
		        case 2 -> afficher_deck(deck);
		        case 3 -> attaquer_carte(deck);
		        case 4 -> restore(deck, deck.length);
		        case 5 -> System.out.println("Au revoir !");
		        
		        default -> System.out.println("Nombre pas supporté");
		    }
		} while (choix_menu != 5);
		
	}
	
	public static TCGCard[] ajouter_carte(TCGCard[] deck) {
		
		TCGCard[] nvDeck = Arrays.copyOf(deck, deck.length + 1);
		
		nvDeck[deck.length] = makeCard();
		
		System.out.println();
		
		System.out.printf("Carte %s ajoutée%n%n", nvDeck[deck.length].getName());
		
		return nvDeck;
	}
	
	public static void afficher_deck(TCGCard[] deck) {
		Contract.require(deck.length > 0, "Deck non existant");
		
		for (int i = 0; i < deck.length; i++) {
			
			System.out.println(format(deck[i]));
			System.out.println("---------------------------------------------------------------------------");
			System.out.println();
		}
		
		
	}
	
	public static void attaquer_carte(TCGCard[] deck){
		
		for (int i = 0; i < deck.length; i++) {
			System.out.printf("%d.  %s \t", i+1, deck[i].getName());
		}
		System.out.println();
		System.out.println();
		
		int attacker = Console.readInt("Carte qui attaque : ") - 1;
		
		int target = Console.readInt("Carte qui subit : ") - 1;
		
		System.out.println();
		
		System.out.printf("%s attaque %s%n", deck[attacker], deck[target]);
		
		System.out.println();
		
		int degats = applyDamage(deck[attacker], deck[target]);
		
		System.out.printf("%s a subi %d points de dégâts%n", deck[target], degats);
		
		System.out.println();
		
		if (deck[target].getHealthPoints() == 0)
			System.out.println(deck[target].getName() + " A perdu la vie.");
		

	}
	
	
	public static int afficher_menu(int slots) {
		
		System.out.println("1. Ajouter une carte ["+ slots +" slots disponibles]\r\n"
				+ "2. Afficher le deck\r\n"
				+ "3. Attaquer\r\n"
				+ "4. Restaurer le deck\r\n"
				+ "5. Terminer l'exécution");
		System.out.println();
		
		int choix = Console.readInt("Votre choix ? ");
		System.out.println();
		System.out.println();
		
		return choix;
	}

	public static String format(TCGCard card) {

		Contract.require(card, card != null, "Argument card doit être défini");

		int case_libre_hp = (int) ((double) card.getHealthPoints() / card.getMaxHealthPoints() * 10.);
		int case_libre_mp = (int) ((double) card.getManaPoints() / card.getMaxManaPoints() * 5.);

		String nameLabel = "Carte : %s%n".formatted(card.getName());
		String textLabel = "%s%n".formatted(card.getText());
		String hpLabel = "PV : %s%s %d/%d%n".formatted("▮".repeat(case_libre_hp), "▯".repeat(10 - case_libre_hp),
				card.getHealthPoints(), card.getMaxHealthPoints());
		String mpLabel = "PM : %s%s %d/%d%n".formatted("▮".repeat(case_libre_mp), "▯".repeat(5 - case_libre_mp),
				card.getManaPoints(), card.getMaxManaPoints());
		String attrLabel = "ATK : %d - DEF : %d%n".formatted(card.getAttack(), card.getDefense());

		return nameLabel + textLabel + hpLabel + mpLabel + attrLabel;
	}

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

	public static int applyDamage(TCGCard attacker, TCGCard target) {
		Contract.require(attacker != null, attacker.isAlive(), "Attaque pas définie");
		Contract.require(target != null, target.isAlive(), "Cible pas définie");

		int mana_cons = (int) Math.max(1, (attacker.getAttack() + attacker.getDefense()) / 4.);

		if (attacker.getManaPoints() < mana_cons)
			return -1;

		int degats = (4 * attacker.getAttack()) - (2 * target.getDefense());
	    
	    if (degats < 0) {
	        degats = 0;
	    }

		if (target.getHealthPoints() - degats < 0) {
			target.setHealthPoints(0);
		} else {
			target.setHealthPoints(target.getHealthPoints() - degats);
		}

		attacker.setManaPoints(attacker.getManaPoints() - mana_cons);

		return degats;
	}

	
	public static int[] restore(TCGCard[] deck, int cardsCount) {
		
		Contract.require(deck != null, "Deck non-existant");
		Contract.require(cardsCount >= 0,  cardsCount <= deck.length, "Count pas compris");
		
		int heal = 0;
		int mana = 0;
		
		for (int i = 0; i < cardsCount; i++) {
			
			if (deck[i].getHealthPoints() == 0) {
				deck[i].setHealthPoints(deck[i].getMaxHealthPoints());
				heal++;
			}
			
			if (deck[i].getManaPoints() < (int) Math.max(1, (deck[i].getAttack() + deck[i].getDefense()) / 4.)) {
				deck[i].setManaPoints(deck[i].getMaxManaPoints());
				mana++;
			}
			
		}
		
		int[] tab = {heal, mana};
		
		return tab;
	}
	
	
	public static String readNonBlank(String message) {

		String input;

		do {
			input = Console.readLine(message).trim();

		} while (input.isBlank());
		return input;
	}

	public static int readInt(String message, int min, int max) {

		int input;

		do {
			input = Console.readInt(message);
		} while (input < min || input > max);

		return input;
	}
}
