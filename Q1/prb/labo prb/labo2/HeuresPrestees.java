package labo2;

public class HeuresPrestees {
    
    public static void main(String[] args){

        double TARIF_PAR_HEURE = 15.75, duree;
        String luH, luM, maH, maM, meH, meM, jeH, jeM, veH, veM;
        int minutesTotales = 0, heuresTotales = 0;
        double montantTotal;
        String lundi, mardi, mercredi, jeudi, vendredi;
        int positionDP;

        for (int i = 0 ; i < 5 ; i ++){

            switch (i) {
                case 0:
                    lundi = Console.lireString("Lundi ? ");
                    positionDP = lundi.indexOf(":");
                    luH = lundi.substring(0, positionDP);
                    luM = lundi.substring((positionDP + 1));

                    minutesTotales = Integer.parseInt(luH) * 60;
                    minutesTotales = minutesTotales + Integer.parseInt(luM);

                    break;

                case 1:
                    mardi = Console.lireString("Mardi ? ");
                    positionDP = mardi.indexOf(":");
                    maH = mardi.substring(0, positionDP);
                    maM = mardi.substring((positionDP + 1), mardi.length());

                    minutesTotales = minutesTotales + Integer.parseInt(maH) * 60;
                    minutesTotales = minutesTotales + Integer.parseInt(maM);

                    break;

                case 2:
                    mercredi = Console.lireString("Mercredi ? ");
                    positionDP = mercredi.indexOf(":");
                    meH = mercredi.substring(0, positionDP);
                    meM = mercredi.substring((positionDP + 1), mercredi.length());

                    minutesTotales = minutesTotales + Integer.parseInt(meH) * 60;
                    minutesTotales = minutesTotales + Integer.parseInt(meM);

                    break;

                case 3:
                    jeudi = Console.lireString("Jeudi ? ");
                    positionDP = jeudi.indexOf(":");
                    jeH = jeudi.substring(0, positionDP);
                    jeM = jeudi.substring((positionDP + 1), jeudi.length());

                    minutesTotales = minutesTotales + Integer.parseInt(jeH) * 60;
                    minutesTotales = minutesTotales + Integer.parseInt(jeM);

                    break;

                case 4:
                    vendredi = Console.lireString("Vendredi ? ");
                    positionDP = vendredi.indexOf(":");
                    veH = vendredi.substring(0, positionDP);
                    veM = vendredi.substring((positionDP + 1), vendredi.length());

                    minutesTotales = minutesTotales + Integer.parseInt(veH) * 60;
                    minutesTotales = minutesTotales + Integer.parseInt(veM);

                    System.out.println(minutesTotales);

                    break;
            
                default:
                    break;

            }
        }

        montantTotal = TARIF_PAR_HEURE * (double) minutesTotales / 60.;

        heuresTotales = minutesTotales / 60;
        minutesTotales = minutesTotales % 60;

        System.out.println("Durée Hebdomadaire = " + heuresTotales + "h " + minutesTotales + "min");

        System.out.printf("Montant à facturer = %.2f EUR", montantTotal);

    }

}
