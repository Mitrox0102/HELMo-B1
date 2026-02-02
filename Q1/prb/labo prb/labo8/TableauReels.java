package labo8;

public class TableauReels {

	public static int minimum(double[] t) {
		if (t.length == 0) {
			return -1;
		}

		int min = 0;
		double minDouble = t[0];

		for (int i = 1; i < t.length; i++) {
			if (minDouble < t[i]) {
				min = i + 1;
				minDouble = t[i];
			}
		}

		return min;
	}

	public static int maximum(double[] t) {
		if (t.length == 0) {
			return -1;
		}

		int max = 0;
		double maxDouble = t[0];

		for (int i = 1; i < t.length; i++) {
			if (maxDouble > t[i]) {
				max = i + 1;
				maxDouble = t[i];
			}
		}

		return max;
	}

	public static double moyenne(double[] t) {

		if (t.length == 0) {
			return Double.NaN;
		}

		double moyenne = 0;
		double nombre = t.length;

		for (int i = 0; i < nombre; i++) {

			moyenne += t[i];

		}

		return (moyenne / nombre);

	}
	
	

}
