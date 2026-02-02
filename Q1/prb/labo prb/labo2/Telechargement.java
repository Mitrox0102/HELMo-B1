package labo2;

public class Telechargement {
    
    public static void main(String[] args){

        double tailleFichier, debit;
        int duree, h, m, s;
        String nomFichier;

        System.out.print("Nom du fichier à télécharger ? ");
        nomFichier = Console.lireString();

        System.out.print("Taille du fichier en Mo ? ");
        tailleFichier = Console.lireDouble();

        System.out.print("Débit en Mbps ? ");
        debit = Console.lireDouble();

        duree = (int) Math.round((tailleFichier * 8.) / debit);
        System.out.println(duree);

        h = duree / 3600;
        m = (duree % 3600) / 60;
        s = (duree % 3600) % 60;

        System.out.println("Durée du téléchargement du fichier \"" + nomFichier + "\" est estimée à " + h + "h " + m + "min " + s + "sec.");
    }

}