package labo8;

public class TableauChaines {
	
	
	public static boolean contient(String[] t, String chaine) {
		for (int i = 0; i < t.length; i++) {
			if(t[i] != null && t[i].equalsIgnoreCase(chaine)) {
				return true;
			}
		}
		return false;
	}

	
}
