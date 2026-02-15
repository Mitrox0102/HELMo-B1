package chap4;

import io.Console;

public class FormaterNom{

    public static String FormaterChaine(String chaine){
        
        char lettre1;
        String reste;
        
        // Formater le prénom
        // 1. Mettre la première lettre en majuscule
        lettre1 = Character.toUpperCase(chaine.charAt(0));
        
        // 2. Mettre le reste en minuscule
        reste = chaine.substring(1).toLowerCase();
        
        // 3. Assembler les 2 parties
        chaine = lettre1 + reste;
        
        // Afficher le résultat
        System.out.println(chaine);
        
        return chaine;
    }

    public static void main(String[] args){
    
        // Variables
        String nom, prenom, ville;
        
        // Acquisitions
        Console.simulerSaisies(" tHoMaS", "FELIX", "EmBourg");
        prenom = Console.lireString("Prénom ? ").trim();
        nom    = Console.lireString("Nom ? ").trim();
        ville  = Console.lireString("Ville ? ").trim();
        
        // Formatage des noms
        prenom = FormaterChaine(prenom);
        nom    = FormaterChaine(nom);
        ville  = FormaterChaine(ville);
        
   }

}