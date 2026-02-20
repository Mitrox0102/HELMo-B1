package practices;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TitleTest {
  @Test
  void should_know_his_name() {
    assertEquals("Headmaster", Title.HEADMASTER.getName());
    assertEquals("Professor", Title.PROFESSOR.getName());
    assertEquals("Graduated", Title.GRADUATED.getName());
    assertEquals("Student", Title.STUDENT.getName());
  }

  @Test
  void should_know_about_the_time_between_words() {
    assertEquals(1, Title.HEADMASTER.getTimeBetweenWords());
    assertEquals(3, Title.PROFESSOR.getTimeBetweenWords());
    assertEquals(5, Title.GRADUATED.getTimeBetweenWords());
    assertEquals(7, Title.STUDENT.getTimeBetweenWords());
  }

  // TODO: valider la méthode Title.next()
  @Test
  void next_test() {
	    assertEquals(Title.HEADMASTER, Title.HEADMASTER.next());
	    assertEquals(Title.HEADMASTER, Title.PROFESSOR.next());
	    assertEquals(Title.PROFESSOR, Title.GRADUATED.next());
	    assertEquals(Title.GRADUATED, Title.STUDENT.next());
	  }
}
