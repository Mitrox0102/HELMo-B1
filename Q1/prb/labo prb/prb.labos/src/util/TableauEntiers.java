package util;

public class TableauEntiers {
	
    public static boolean contient(int[] tableau, int a) {
        boolean output = false;
        for (int i = 0; i < tableau.length; i++) {
            if (tableau[i] == a)
                output = true;
        }
        return output;
    }
    
    public static void permuter(int[] tableau, int i, int j)  {
        int temp = tableau[i];
        tableau [i] = tableau[j];
        tableau[j] = temp;
    }
    
    public static String toString(int[] tableau) {
        String output = "";
        for (int i = 0; i < tableau.length; i++) {
            String virgule = i == tableau.length - 1 ? "" : ", ";
            output += tableau[i] + virgule;
        }
        return output;
    }
}