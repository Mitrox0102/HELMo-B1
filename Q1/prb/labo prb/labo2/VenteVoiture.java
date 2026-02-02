package labo2;

public class VenteVoiture {
    
    public static void main(String[] args){

        double prixHtva, tva, remise, pFinal;
        final double tauxTva = 0.21, tauxReduction = 0.03;

        System.out.print("Montant HTVA de la voiture ?");
        prixHtva = Console.lireDouble();

        tva = prixHtva * tauxTva;

        System.out.println("Montant de la TVA\t= " + tva + "\tEUR" );

        pFinal = tva + prixHtva;

        remise = pFinal * tauxReduction;

        System.out.println("Montant de la remise\t= " + remise + "\tEUR");

        pFinal = pFinal - remise;

        System.out.println("Montant final \t=" + pFinal + "\tEUR");


    }
}
