package practices;

import java.awt.Container;

import util.Contract;

public class Wizard {
	
	public static final String DEFAULT_NAME = null;
	private String name;
	private Title title;
	private int spellCount = 0;
	
  
	public Wizard(String givenName, Title givenTitle) {

		this.title = givenTitle;
		
		if (givenName == null || givenName.isBlank()) {
			this.name = "You-Know-Who";
			this.title = Title.HEADMASTER;
		}else {
			this.name = givenName;
			
			if (givenTitle == null) {
				this.title = Title.STUDENT;
			}else {
				this.title = givenTitle;
			}
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public Title getTitle() {
		return this.title;
	}
	
	public String cast(Spell spell) {
		Contract.require(spell != null, "");
		
		String output = this.name + " casts " + spell.cast(this.title.getTimeBetweenWords());
		
		this.spellCount++;
		
		if (this.spellCount == this.title.getTimeBetweenWords()) {
            this.title = this.title.next();
            this.spellCount = 0;
        }
        
        return output;
	}
	

}
