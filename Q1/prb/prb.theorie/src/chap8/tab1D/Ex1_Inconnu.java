package chap8.tab1D;

import java.util.Arrays;

public class Ex1_Inconnu {

	public static void main(String[] args) {
		int[] t = new int[10];
		t[0] = 1;
		for (int i = 1; i < t.length; i++) {
			t[i] = t[i - 1] + 2;
		}
		System.out.println(Arrays.toString(t));
	}

}
