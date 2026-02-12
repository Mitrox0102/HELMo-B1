package chap8.tab2D;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.nio.file.*;
import java.util.*;

public class Ex4_Sokoban extends JPanel implements KeyListener {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Ex4_Sokoban::new);
	}

	/**
	 * Fonction exécutée lorsqu'un joueur presse une touche du clavier.
	 * 
	 * @param touche     - La touche pressée par le joueur.
	 * @param joueur     - La référence du tableau contenant la position (i, j) du
	 *                   joueur.
	 * @param murs       - La référence du tableau contenant les positions (i, j)
	 *                   des murs .
	 * @param rangements - La référence du tableau contenant les positions (i, j)
	 *                   des rangements.
	 * @param caisses    - La référence du tableau contenant les positions (i, j)
	 *                   des caisses.
	 */
	private void touchePressee(Touche touche, int[] joueur, int[][] murs, int[][] rangements, int[][] caisses) {
		// TODO: compléter la fonction...

		if (touche == Touche.REINITIALISER) {

			reinitialiserNiveau();
			return;

		}

		int[] arrivee = positionArrivee(joueur, touche);
		
		// si l'arrivée ne contient pas un mur, alors y déplacer le joueur
		joueur[0] = arrivee[0];
		joueur[1] = arrivee[1];
		
	}

	/**
	 * Calcule la position d'arrivée d'un déplacement sur base de la position (i, j)
	 * de départ et de la direction du déplacement.
	 * 
	 * @param depart    - La référence du tableau contenant la position (i, j) de
	 *                  départ d'un déplacement.
	 * @param direction - La direction du déplacement.
	 * @return La référence d'un tableau contenant la position d'arrivée du
	 *         déplacement effectué.
	 */
	private int[] positionArrivee(int[] depart, Touche direction) {
		// TODO: compléter la fonction...

		int[] arrivee = new int[] {depart[0], depart[1]};
		
		switch (direction) {

		case HAUT -> arrivee[0]--;

		case DROITE -> arrivee[1]++;

		case BAS -> arrivee[0]++;

		case GAUCHE -> arrivee[1]--;

		default -> throw new IllegalArgumentException("Unexpected value: " + direction);
		}

		return arrivee;
	}

	/**
	 * Recherche la première occurrence d'une position (i, j) au sein d'un tableau
	 * de positions (i, j).
	 * 
	 * @param tabPositions - La référence d'un tableau contenant des positions (i,
	 *                     j).
	 * @param position     - La référence d'un tableau contenant la position (i, j)
	 *                     recherchée.
	 * @return L'indice de la première occurrence de la position spécifiée au sein
	 *         du tableau, -1 si aucune correspondance n'est trouvée.
	 */
	private int positionDe(int[][] tabPositions, int[] position) {
		// TODO: compléter la fonction...

		for (int i = 0; i < tabPositions.length; i++) {
			if (Arrays.equals(tabPositions[i], position)) {
				return i;
			}
		}
		
		return -1;
	}

	/**
	 * Détermine si une position (i, j) est présente dans un tableau de positions
	 * (i, j).
	 * 
	 * @param tabPositions - La référence d'un tableau contenant des positions (i,
	 *                     j).
	 * @param position     - La référence d'un tableau contenant la position (i, j)
	 *                     recherchée.
	 * @return {@code true} si une correspondance de la position spécifiée est
	 *         trouvée, {@code false} dans le cas contraire.
	 */
	private boolean contient(int[][] tabPositions, int[] position) {
		// TODO: compléter la fonction...

		return false;
	}

	/**
	 * Charge le niveau suivant.
	 */
	private void chargerNiveauSuivant() {
		numNiveau = numNiveau + 1;
		chargerNiveau(numNiveau);
	}

	/**
	 * Réinitialise le niveau actuel.
	 */
	private void reinitialiserNiveau() {
		chargerNiveau(numNiveau);
	}

	/**
	 * Affiche un message dans une boîte de dialogue.
	 * 
	 * @param message - Le message à afficher.
	 */
	private void afficherMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	private static final long serialVersionUID = 3617321166567789220L;

	// Directions pour les déplacements du joueur
	private enum Touche {
		AUCUN_EFFET, REINITIALISER, HAUT, DROITE, BAS, GAUCHE
	}

	// Constantes
	private static final String CHEMIN_IMAGES = "sokoban/images/";
	private static final String CHEMIN_NIVEAUX = "sokoban/niveaux/";
	private static final String[] NOMS_IMAGES = { "mur", "sol", "caisse", "rangement", "caisse_sur_rangement",
			"joueur_haut", "joueur_droite", "joueur_bas", "joueur_gauche" };
	private static final int TAILLE_CASE = 64;

	// Variables
	private int nbCasesLargeur = 5, nbCasesHauteur = 5;
	private int[][] murs;
	private int[][] caisses;
	private int[][] rangements;
	private int[] joueur;
	private int numNiveau = 1;

	// Images
	private Map<String, Image> images;
	private Map<Touche, Image> imgJoueurParDir;
	private Image imgJoueur;

	// Fenêtre principale
	private JFrame frame;

	public Ex4_Sokoban() {
		frame = new JFrame("Sokoban");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(this);

		chargerImages();
		chargerNiveau(numNiveau);

		frame.setVisible(true);
	}

	private void chargerImages() {
		// Chargement de toutes les images
		images = new HashMap<>();
		for (String nomImage : NOMS_IMAGES) {
			final String CHEMIN_FICHIER = CHEMIN_IMAGES + nomImage + ".png";
			ImageIcon icone = new ImageIcon(CHEMIN_FICHIER);

			if (icone.getImageLoadStatus() == MediaTracker.ERRORED) {
				afficherFichierIntrouvable(CHEMIN_FICHIER);
			}

			images.put(nomImage, icone.getImage());
		}

		// Définition des images du joueur selon les directions de déplacement
		imgJoueurParDir = new HashMap<>();
		imgJoueurParDir.put(Touche.HAUT, images.get("joueur_haut"));
		imgJoueurParDir.put(Touche.DROITE, images.get("joueur_droite"));
		imgJoueurParDir.put(Touche.BAS, images.get("joueur_bas"));
		imgJoueurParDir.put(Touche.GAUCHE, images.get("joueur_gauche"));
		imgJoueur = imgJoueurParDir.get(Touche.BAS);
	}

	private void chargerNiveau(int numFichier) {
		final String CHEMIN_FICHIER = String.format("%sniveau%02d.txt", CHEMIN_NIVEAUX, numFichier);
		try {
			java.util.List<String> lignes = Files.readAllLines(Paths.get(CHEMIN_FICHIER));
			nbCasesHauteur = lignes.size();

			murs = new int[0][];
			caisses = new int[0][];
			rangements = new int[0][];
			joueur = null;

			nbCasesLargeur = 5;
			for (int i = 0; i < lignes.size(); i++) {
				nbCasesLargeur = Math.max(nbCasesLargeur, lignes.get(i).length());
				for (int j = 0; j < lignes.get(i).length(); j++) {
					char car = lignes.get(i).charAt(j);
					if (car == ' ') {
						continue;
					}

					int[] position = { i, j };
					switch (car) {
					case '#' -> murs = ajouterLigne(murs, position);
					case '$' -> caisses = ajouterLigne(caisses, position);
					case '.' -> rangements = ajouterLigne(rangements, position);
					case '*' -> {
						caisses = ajouterLigne(caisses, position);
						rangements = ajouterLigne(rangements, position.clone());
					}
					case '@' -> joueur = position;
					case '+' -> {
						joueur = position;
						rangements = ajouterLigne(rangements, position.clone());
					}
					}
				}
			}

			frame.setTitle("Sokoban - Niveau " + numNiveau);
			frame.setSize(nbCasesLargeur * TAILLE_CASE + 20, nbCasesHauteur * TAILLE_CASE + 40);
			frame.setLocationRelativeTo(null);

		} catch (Exception e) {
			afficherFichierIntrouvable(CHEMIN_FICHIER);
		}
	}

	private static int[][] ajouterLigne(int[][] t, int[] ligne) {
		int[][] nouveau = Arrays.copyOf(t, t.length + 1);
		nouveau[nouveau.length - 1] = ligne;
		return nouveau;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Afficher le sol
		for (int i = 0; i < nbCasesHauteur; i++) {
			for (int j = 0; j < nbCasesLargeur; j++) {
				g.drawImage(images.get("sol"), j * TAILLE_CASE, i * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE, null);
			}
		}

		// Afficher les murs
		for (int[] ij : murs) {
			g.drawImage(images.get("mur"), ij[1] * TAILLE_CASE, ij[0] * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE, null);
		}

		// Afficher les rangements
		for (int[] ij : rangements) {
			g.drawImage(images.get("rangement"), ij[1] * TAILLE_CASE, ij[0] * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE,
					null);
		}

		// Afficher les caisses
		for (int[] ij : caisses) {
			int i = 0;
			while (i < rangements.length && !Arrays.equals(rangements[i], ij)) {
				i++;
			}
			Image img = images.get("caisse");
			if (i < rangements.length) {
				img = images.get("caisse_sur_rangement");
			}
			g.drawImage(img, ij[1] * TAILLE_CASE, ij[0] * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE, null);
		}

		// Afficher le joueur
		g.drawImage(imgJoueur, joueur[1] * TAILLE_CASE, joueur[0] * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE, null);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Touche touche = switch (e.getKeyCode()) {
		case KeyEvent.VK_UP, KeyEvent.VK_Z -> Touche.HAUT;
		case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> Touche.DROITE;
		case KeyEvent.VK_DOWN, KeyEvent.VK_S -> Touche.BAS;
		case KeyEvent.VK_LEFT, KeyEvent.VK_Q -> Touche.GAUCHE;
		case KeyEvent.VK_R -> Touche.REINITIALISER;
		default -> Touche.AUCUN_EFFET;
		};
		if (touche == Touche.AUCUN_EFFET) {
			return;
		}
		if (touche != Touche.REINITIALISER) {
			imgJoueur = imgJoueurParDir.get(touche);
		}
		touchePressee(touche, joueur, murs, rangements, caisses);
		repaint();
	}

	private void afficherFichierIntrouvable(String nomFichier) {
		afficherMessage("Le fichier '" + nomFichier + "' est introuvable !");
		System.exit(-1);
	}
}