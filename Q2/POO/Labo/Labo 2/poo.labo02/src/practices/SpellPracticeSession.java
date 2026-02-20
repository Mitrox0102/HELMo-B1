package practices;

public class SpellPracticeSession {
  private Wizard[] wizards = {
		  new Wizard("Albus Dumbledore", Title.HEADMASTER),
		  new Wizard("Severus Rogue", Title.PROFESSOR),
		  new Wizard("Harry Potter", Title.GRADUATED),
		  new Wizard("Hermione Granger",Title.GRADUATED),
		  new Wizard("Ronald Weasley", Title.STUDENT),
		  new Wizard("",Title.STUDENT)
		  
  };

  private Spell[] spells = {
      new Spell("Stupefy"),
      new Spell("Expecto patronum"),
      new Spell("Wingardium leviosa"),
      new Spell("Mucus ad nuseum"),
      new Spell("Silencio")
  };

  public String[] getWizardNames() {
	    String[] names = new String[wizards.length];
	    
	    for (int i = 0; i < names.length; i++) {
			names[i] = wizards[i].getName();
		}
      return names;
  }
  

  public String[] getSpellNames() {
    String[] names = new String[spells.length];
    
    for (int i = 0; i < names.length; i++) {
		names[i] = spells[i].getIncantation();
	}
    
    return names;
  }

  public String[] practice(int wizardIndex, int spellIndex) {
	  
	  
	  Title init = wizards[wizardIndex].getTitle();
	  
	  String cast = wizards[wizardIndex].cast(spells[spellIndex]);
	  
	  Title new_t = wizards[wizardIndex].getTitle();
	  
	  
	  if (init != new_t) {
		  
		  String update = "Title update : " + wizards[wizardIndex].getName() + " has become " + wizards[wizardIndex].getTitle().getName();
		  
		  if (new_t == Title.HEADMASTER) {
			  wizards[wizardIndex] = null;
			  
			  Wizard[] new_tab = new Wizard [wizards.length -1];
			  
			  int null_index = 0;
			  
			  for (int i = 0; i < wizards.length; i++) {
				  
				  if (wizards[i] != null) {
					  new_tab[i - null_index] = wizards[i];
				  } else {
					  null_index++;
				  }
				
			}
			  wizards = new_tab;
		  }
		  
		  
		  return new String[] {cast, update};
	  }
	  
	  return new String[] {cast};
    
  }


}
