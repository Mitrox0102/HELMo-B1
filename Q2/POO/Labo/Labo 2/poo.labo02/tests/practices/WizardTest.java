package practices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WizardTest {
  @Test
  void should_know_his_name() {
    Wizard harry = new Wizard("Harry Potter", Title.HEADMASTER);
    Wizard tom = new Wizard(null, Title.HEADMASTER);
    
    assertEquals("Harry Potter", harry.getName());
    assertEquals("You-Know-Who", tom.getName());
  }

  @Test
  void should_set_title_to_headmaster_when_actual_name_is_You_Know_Who() {
    Wizard voldemort = new Wizard(null, null);
    Wizard tomRiddle = new Wizard(Wizard.DEFAULT_NAME, Title.STUDENT);
    //
    assertEquals(Title.HEADMASTER, voldemort.getTitle());
    assertEquals(Title.HEADMASTER, tomRiddle.getTitle());
  }

  @Test
  void should_set_title_to_student_when_actual_level_is_null() {
    Wizard harry = new Wizard("Harry Potter", null);
    
    assertEquals(Title.STUDENT, harry.getTitle());
  }

  @Test
  void should_cast_spell() {
    Wizard harry = new Wizard("Harry Potter", Title.GRADUATED);
    Spell stupefy = new Spell("Stupefy");
    //
    assertEquals("Harry Potter casts STUPEFY !", harry.cast(stupefy));
  }

  @Test
  void should_reject_cast_when_arg_is_null() {
    Wizard cedric = new Wizard("Cédric Digory", Title.GRADUATED);
    //
    assertThrows(IllegalArgumentException.class, () -> {
    cedric.cast(null);
    });
  }

  @Test
  void should_update_title_to_graduated_after_x_casts() {
    Wizard harry = new Wizard("Harry Potter", Title.STUDENT);
    Spell stupefy = new Spell("Stupefy");
    
    repeatCasts(harry, stupefy, Title.STUDENT.getTimeBetweenWords());
    
    assertEquals(Title.GRADUATED, harry.getTitle());
  }

  @Test
  void should_update_title_to_professor_after_x_casts() {
    Wizard harry = new Wizard("Remus Lupin", Title.GRADUATED);
    Spell stupefy = new Spell("Stupefy");
    //
    repeatCasts(harry, stupefy, Title.GRADUATED.getTimeBetweenWords());
    //
    assertEquals(Title.PROFESSOR, harry.getTitle());
  }

  @Test
  void should_update_title_to_headmaster_after_x_casts() {
    Wizard rogue = new Wizard("Severus Rogue", Title.PROFESSOR);
    Spell stupefy = new Spell("Stupefy");
    //
    repeatCasts(rogue, stupefy, Title.PROFESSOR.getTimeBetweenWords());
    //
    assertEquals(Title.HEADMASTER, rogue.getTitle());
  }

  @Test
  void should_stop_update_title_at_headmaster() {
    Wizard ron = new Wizard(null, Title.HEADMASTER);
    Spell stupefy = new Spell("Stupefy");
    //
    repeatCasts(ron, stupefy, 10);
    //
    assertEquals(Title.HEADMASTER, ron.getTitle());
  }

   private void repeatCasts(Wizard w, Spell s, int times) {
	  for (int i = 0; i < times; ++i) {
	  w.cast(s);
	  }
	  }
}
