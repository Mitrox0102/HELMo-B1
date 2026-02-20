package practices;

import util.Contract;
import java.util.StringJoiner;

public class Spell {
	
	private final String incantation;
	
	
	public Spell(String givenIncantation) {

		Contract.require(givenIncantation != null,  !givenIncantation.isBlank(), "");
		
		this.incantation = givenIncantation.toUpperCase();
		
	}
	
	public String getIncantation() {
		
		return this.incantation;
	}
	
	public String cast(int timeBetweenWords) {
		
		Contract.require(timeBetweenWords > 0, "");
		
		StringJoiner castJoiner = new StringJoiner (".".repeat(timeBetweenWords), "", " !");
		
		String[] words = this.incantation.split("\\s+");
		
		for (String word : words) {
			
			castJoiner.add(word);
			
		}
		
		return castJoiner.toString();
		
	}
	
	
}
