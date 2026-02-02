package labo5;

import io.Console;
import io.Fichier;

public class LDVELH {
    
    public static char lireChoix(String question, String choixAdmis) {
        
        String choixStr = Console.lireString(question);
        while (!choixAdmis.contains(choixStr) || choixStr.length() != 1) {
            System.out.println("Choix incorrect ! Veuillez reessayer ...");
            choixStr = Console.lireString(question);
        }
        
        char choix = choixStr.charAt(0);
        return choix;
    }

    public static void main(String[] args) {
        final String DIR = "data/ldvelh.txt";
        
        
        String texte = Fichier.lireString(DIR, "intro");
        System.out.println(texte); 
        
        String choixStr = "choix";
        
        
        while (!texte.endsWith("FIN\n")) {
            char choixChar = lireChoix ("Que choisis-tu (A ou B) ? ", "AaBb");
            choixStr = (choixStr + "-" + choixChar).toLowerCase();
            texte = Fichier.lireString(DIR, choixStr);
            System.out.println(texte); 
        };

    }

}