package lecon04;

import java.util.Arrays;

public class Lotto {
	
	public static void main(String[] args) {
		GrilleLotto grille1 = new GrilleLotto(42, 6 + 1);
		GrilleLottoV2 grille2 = new GrilleLottoV2(42, 6 + 1);
		
		grille1.tirageGrille();
		grille2.tirageGrille();
		
		System.out.println(Arrays.toString(grille1.getGrille()));
		System.out.println(Arrays.toString(grille2.getGrille()));
	}
	
}
