package labo1;

public class JourDeLaSemaine {

        public static void main(String[] args) {
            // Variables pour les données de départ
            int jour = 02, mois = 9, annee = 2024;

            // Variables pour le traitement
            int anneeEnCours, a, b, m;

            // Variables pour le résultat
            int jourDeLaSemaine;

            // Traitement
            anneeEnCours = (14 - mois) / 12;
            a = annee - anneeEnCours;
            b = a + a / 4 - a / 100 + a / 400;
            m = mois + 12 * anneeEnCours - 2;
            jourDeLaSemaine = (jour + b + 31 * m / 12) % 7;

            // Affichage du résultat
            System.out.println(jourDeLaSemaine);
        }

}
