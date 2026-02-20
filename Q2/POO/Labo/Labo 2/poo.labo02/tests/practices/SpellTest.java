package practices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;


public class SpellTest {
	
	@Test
    public void testGetIncantationReturnsUpperCase() {
        Spell spell = new Spell("wingardium leviosa");
        assertEquals("WINGARDIUM LEVIOSA", spell.getIncantation(),"");
    }

    @Test
    public void testCastWithThreePoints() {
        Spell spell = new Spell("wingardium leviosa");
        assertEquals("WINGARDIUM...LEVIOSA !", spell.cast(3), "");
    }

    @Test
    public void testCastWithSingleWord() {
        Spell spell = new Spell("Stupefy");
        assertEquals("STUPEFY !", spell.cast(5), "");
    }

    @Test
    public void testCastWithMultipleWordsAndTwoPoints() {
        Spell spell = new Spell("Mucus ad nuseum");
        assertEquals("MUCUS..AD..NUSEUM !", spell.cast(2), "");
    }
    
    
    @Test
    public void testEqualsSameObject() {
        Spell s = new Spell("Stupefy");
        assertTrue(s.equals(s), "Un sortilège doit être égal à lui-même.");
    }

    @Test
    public void testEqualsNull() {
        Spell s = new Spell("Stupefy");
        assertFalse(s.equals(null), "Un sortilège ne doit pas être égal à null.");
    }

    @Test
    public void testEqualsDifferentType() {
        Spell s = new Spell("Stupefy");
        String str = "Stupefy";
        assertFalse(s.equals(str), "Un sortilège ne doit pas être égal à un String, même s'ils ont le même texte.");
    }

    @Test
    public void testEqualsSameIncantation() {
        Spell s1 = new Spell("Wingardium leviosa");
        Spell s2 = new Spell("Wingardium leviosa");
        
        assertTrue(s1.equals(s2), "s1 doit être égal à s2 car ils ont la même incantation.");
        assertTrue(s2.equals(s1), "La propriété de symétrie doit être respectée (s2 = s1).");
    }

    @Test
    public void testEqualsDifferentIncantation() {
        Spell s1 = new Spell("Stupefy");
        Spell s2 = new Spell("Silencio");
        
        assertFalse(s1.equals(s2), "Des sortilèges différents ne doivent pas être égaux.");
        assertFalse(s2.equals(s1), "La propriété de symétrie doit être respectée (s2 != s1).");
    }
   
    
}
