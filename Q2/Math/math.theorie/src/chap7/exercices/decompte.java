package chap7.exercices;

public class decompte {

	public static Object decompte_f(int n) {
		
		if(n<0)
			return null;
		System.out.print(n + " ");
		
		return decompte_f(n-1);
		
	}
	
	public static void main(String[] args) {
		decompte_f(10);
	}
	
}
