package chap5.formes;

public class Cercle{
    
    public static double perimetre(double rayon){
        return 2 * Math.PI * rayon;
    }
    
    public static double aire(double rayon){
        return Math.PI * Math.pow(rayon, 2);
    }
    
    
}