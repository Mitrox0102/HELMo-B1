package practices;

/**
 * Définit le titre qu'un sorcier peut avoir.
 * <p>
 * Vous ne pouvez pas créer de nouveaux objets avec cette classe. En revanche, vous pouvez utiliser
 * les constantes Title.STUDENT, Title.HEADMASTER, etc.
 * </p>
 */
public enum Title {
	
	HEADMASTER(1, "Headmaster"),
    PROFESSOR(3, "Professor"),
    GRADUATED(5, "Graduated"),
    STUDENT(7, "Student");

  private final int pauseTime;
  private final String name;

  private Title(int time, String name) {
    this.pauseTime = time;
    this.name = name;
  }

  /**
   * Retourne le temps de pause de ce titre.
   */
  public int getTimeBetweenWords() {
    return this.pauseTime;
  }

  /**
   * Retourne le nom de ce titre.
   */
  public String getName() {
    return this.name;
  }

  public Title next() {
	  return switch (this) {
	  case HEADMASTER -> HEADMASTER;
      case PROFESSOR -> HEADMASTER;
      case GRADUATED -> PROFESSOR;
      case STUDENT-> GRADUATED;
	default ->
	throw new IllegalArgumentException("Unexpected value: " + this.name);
	};
	  
  }
	  
}
