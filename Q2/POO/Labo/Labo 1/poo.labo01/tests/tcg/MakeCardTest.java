package tcg;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.Console;

class MakeCardTest {
	private ByteArrayOutputStream out;
	
	@BeforeEach
	public void setup() {
		out = new ByteArrayOutputStream(1024);
		
		Console.redirectOutput(out);
	}
	
	@Test
	void should_pass_the_happy_path() {
		Console.redirectInput(new ByteArrayInputStream("Dragon\nUn puissant dragon\n100\n10\n4\n2\n".getBytes()));
		
		TCGCard card = TCGCardApp.makeCard();

		assertEquals("Dragon", card.getName());
		assertEquals("Un puissant dragon", card.getText());
		assertEquals(100, card.getHealthPoints());
		assertEquals(10, card.getManaPoints());
		assertEquals(4, card.getAttack());
		assertEquals(2, card.getDefense());
	}
	
	@Test
	void should_ask_the_name_and_text_again_when_input_is_blank() {
		Console.redirectInput(new ByteArrayInputStream(" \nRoger\n \nUn puissant viking\n999\n42\n8\n2\n".getBytes()));
		
		TCGCard card = TCGCardApp.makeCard();
		
		assertEquals("Roger", card.getName());
		assertEquals("Un puissant viking", card.getText());
		assertEquals(999, card.getHealthPoints());
		assertEquals(42, card.getManaPoints());
		assertEquals(8, card.getAttack());
		assertEquals(2, card.getDefense());
	}
	
	@Test
	void should_ask_the_int_value_again_when_input_is_out_of_bounds() {
		Console.redirectInput(new ByteArrayInputStream("Gudule\nSainte de Bruxelles\n1000\n0\n100\n99\n100\n0\n1\n10\n".getBytes()));
		
		TCGCard card = TCGCardApp.makeCard();
		
		assertEquals("Gudule", card.getName());
		assertEquals("Sainte de Bruxelles", card.getText());
		assertEquals(100, card.getHealthPoints());
		assertEquals(99, card.getManaPoints());
		assertEquals(1, card.getAttack());
		assertEquals(10, card.getDefense());
	}

}
