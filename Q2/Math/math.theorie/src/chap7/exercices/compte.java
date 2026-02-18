package chap7.exercices;

public class compte {

	public static void compte_f(int n){
		
		compte_f(0,n);
		
	}
	
	private static void compte_f(int i, int n) {
		
		if (i<=n) {
			System.out.print(i + " ");
			compte_f(i+1,n);
		}
		
	}
	
	public static void main(String[] args) {
		
		compte_f(5);
		
	}
	
}
