package chap5.formes;

public class Rectangle{
	    
    public static double perimetre(double l, double h){
    	if (h <= 0 || l <=0) {
    		return 0;
    	}
        return 2*l + 2*h;
    }
    
    public static double aire(double l, double h){
        return l*h;
    }
}