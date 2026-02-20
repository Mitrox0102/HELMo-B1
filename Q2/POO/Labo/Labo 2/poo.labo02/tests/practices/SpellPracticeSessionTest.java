package practices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SpellPracticeSessionTest {

	@Test
    public void testGetWizardNames() {
        SpellPracticeSession session = new SpellPracticeSession();
        String[] actualNames = session.getWizardNames();
        
        assertEquals(true, actualNames != null, "Le tableau des sorciers ne doit pas être null.");
        assertEquals(6, actualNames.length, "La taille du tableau doit être exactement de 6.");
        assertEquals("Albus Dumbledore", actualNames[0]);
        assertEquals("Severus Rogue", actualNames[1]);
        assertEquals("Harry Potter", actualNames[2]);
        assertEquals("Hermione Granger", actualNames[3]);
        assertEquals("Ronald Weasley", actualNames[4]);
        assertEquals("You-Know-Who", actualNames[5]);
    }

    @Test
    public void testGetSpellNames() {
        SpellPracticeSession session = new SpellPracticeSession();
        String[] actualSpells = session.getSpellNames();
        
        assertEquals(true, actualSpells != null, "Le tableau des sorts ne doit pas être null.");
        assertEquals(5, actualSpells.length, "La taille du tableau doit être exactement de 5.");
        assertEquals("STUPEFY", actualSpells[0]);
        assertEquals("EXPECTO PATRONUM", actualSpells[1]);
        assertEquals("WINGARDIUM LEVIOSA", actualSpells[2]);
        assertEquals("MUCUS AD NUSEUM", actualSpells[3]);
        assertEquals("SILENCIO", actualSpells[4]);
    }

    @Test
    public void testPracticeReturnsValidArray() {
        SpellPracticeSession session = new SpellPracticeSession();
        String[] result = session.practice(2, 2);
        
        assertEquals(true, result != null, "Le résultat ne doit pas être null.");
        
        boolean isLengthValid = (result.length == 1 || result.length == 2);
        assertEquals(true, isLengthValid, "Le tableau de résultat doit contenir 1 ou 2 éléments.");
        assertEquals(true, result[0] != null, "La chaîne de cast ne doit pas être null.");
        
        if (result.length == 2) {
            boolean hasTitleUpdate = result[1].startsWith("Title update :");
            assertEquals(true, hasTitleUpdate, "Le second élément doit indiquer une mise à jour de titre.");
        }
    }

    @Test
    public void testPracticeArrayShrinkingLogic() {
        SpellPracticeSession session = new SpellPracticeSession();
        int initialWizardCount = session.getWizardNames().length;
        
        session.practice(0, 0); 
        
        int newWizardCount = session.getWizardNames().length;
        
        boolean isCountValid = (newWizardCount == initialWizardCount || newWizardCount == initialWizardCount - 1);
        assertEquals(true, isCountValid, "Le nombre de sorciers doit rester le même ou diminuer de 1 en cas de promotion.");
    }
	
}
