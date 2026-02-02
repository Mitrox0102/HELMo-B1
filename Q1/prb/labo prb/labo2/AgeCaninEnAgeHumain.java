package labo2;

public class AgeCaninEnAgeHumain {

    public static void main(String[] args){

        double ageCanin, ageHumain;
        int ageHumainInt;
        String nomChien;

        System.out.print("Nom de votre chien : ");
        nomChien = Console.lireString();

        System.out.print("Age de votre chien : ");
        ageCanin = Console.lireDouble();

        ageHumain = 16. * Math.log(ageCanin) + 31.;
        ageHumain = Math.round(ageHumain);
        ageHumainInt = (int) ageHumain;

        System.out.println(nomChien + " aurait " + ageHumainInt + " an(s) s'il était un humain");

    }
    
}
