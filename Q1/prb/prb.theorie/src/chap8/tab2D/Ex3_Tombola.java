package chap8.tab2D;

import java.util.Arrays;

import io.Console;

public class Ex3_Tombola {

	public static void main(String[] args) {
		// Tableaux
		final String[] NOMS_VENDEURS = { "Amir", "Lotte", "Yasmina", "Michael", "Julie" };
		int[][] numerosBillets = new int[NOMS_VENDEURS.length][0]; // initialement, le tableau ne doit pas contenir de
																	// valeurs mais bien des références
		
		// debut tests 
		numerosBillets = new int[][] {
			{121,126,127},
			{},
			{91,92,93},
			{},
			{}
		};
		//fin tests
		
		
		// Variables
		final int QUITTER = 4;
		int choix;
		String nomVendeur;

		// Traitement
		do {
			// Affichage du menu
			System.out.println("TOMBOLA\n-------");
			System.out.println("1. Enregistrer des billets vendus"); // qui a vendu ?
			System.out.println("2. Compter les billets vendus"); // combien de cases dans chaque lignes
			System.out.println("3. Chercher le vendeur d'un billet"); // interroger chaque ligne pour voir dans quelle
																		// ligne se trouve le numbillet
			System.out.println("4. Quitter");
			choix = Console.lireInt("Choix ? ");

			// Traitement du choix
			if (choix == 1) {
				// acquisitiondu nom du vendeur
				int posVendeur;
				do {
					nomVendeur = Console.lireString("Nom du vendeur ? ").trim(); // acquisition du nom du vendeur
					posVendeur = positionDe(NOMS_VENDEURS, nomVendeur);
				} while (posVendeur == -1);

				// acquisition des numéros de billets vendus
				String saisie;
				do {
					saisie = Console.lireString("Numéro ? ").trim();
					int numeroBillet = Integer.parseInt(saisie);

					// Ajouter le numéro au tableau 2D (que je dois créer au préalable)
					numerosBillets[posVendeur] = ajouterElement(numerosBillets[posVendeur], numeroBillet); // je vais
																											// chercher
																											// la
																											// référence
																											// d'une
																											// ligne de
																											// mon
																											// tableau
																											// 2d pour
																											// obtenir
																											// tous les
																											// numéros
																											// vendus
																											// par le
																											// vendeur X

				} while (!saisie.isEmpty()); // tant que ma saisie n'est pas vide, je recommence la boulce

			} else if (choix == 2) {
				
				System.out.println("Vous avez vendu " + compterElements(numerosBillets) + " billet(s).");

			} else if (choix == 3) {
				
				int numeroBillet = Console.lireInt("Numéro du billet ? ");
				
				

			} else if (choix != QUITTER) {
				System.out.println("Choix incorrect !\n");
			}
			System.out.println();

		} while (choix != QUITTER);

		System.out.println("Fin de l'application.");
	}

	public static int positionDe(String[] t, String valeur) { // je reçois un tableau de chaine de caractères et je vais
																// chercher la valeur dans le tableau
		for (int i = 0; i < t.length; i++) {
			if (t[i] == valeur || (t[i] != null && t[i].equalsIgnoreCase(valeur))) {
				return i;
			}
		}
		return -1;
	}

	public static int[] ajouterElement(int[] t, int element) {
		// par exemple, si t = {97,98} et element = 99
		// alors nouveau t = {97, 98, 0} 0 grâce au T.length + 1
		int[] nouveau = Arrays.copyOf(t, t.length + 1); // le second paramètre indique combien d'élément de T je dois
														// copier dans le nouveau tableau
		nouveau[nouveau.length - 1] = element;
		return nouveau;

	}
	
	public static int compterElements(int[][] t) {

		int nbElements = 0;

		for (int[] ligne : t) {
			if (ligne != null)
				nbElements += ligne.length;
		}

		return nbElements;
	}

}
