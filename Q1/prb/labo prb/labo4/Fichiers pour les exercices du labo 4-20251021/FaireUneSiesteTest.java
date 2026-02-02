package labo4;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import fake.FakePrintStream;
import fake.FakePrintStreamRule;
import io.Console;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@ExtendWith(FakePrintStreamRule.class)
@TestMethodOrder(OrderAnnotation.class)
class FaireUneSiesteTest {

	final static List<String[]> CHOIX_POUR_FAIRE_UNE_SIESTE = List.of(
		new String[] { "non", "non", "non", "oui" },
		new String[] { "oui", "non", "non", "non", "oui" },
		new String[] { "non", "non", "oui", "non", "oui" },
		new String[] { "oui", "non", "non", "oui", "non", "oui" },
		new String[] { "non", "non", "non", "non", "oui" },
		new String[] { "oui", "non", "non", "non", "non", "oui" },
		new String[] { "non", "non", "oui", "non", "non", "oui" },
		new String[] { "oui", "non", "non", "oui", "non", "non", "oui" }
	);

	final static List<String[]> CHOIX_POUR_NE_PAS_FAIRE_UNE_SIESTE = List.of(
		new String[] { "oui", "oui" },
		new String[] { "non", "oui" },
		new String[] { "oui", "non", "oui" },
		new String[] { "non", "non", "oui", "oui" },
		new String[] { "oui", "non", "non", "oui", "oui" },
		new String[] { "non", "non", "non", "non", "non" },
		new String[] { "oui", "non", "non", "non", "non", "non" },
		new String[] { "non", "non", "oui", "non", "non", "non" },
		new String[] { "oui", "non", "non", "oui", "non", "non", "non" }
		
	);

	@AfterEach
	void resetAfterEachTest() {
		reinitialiser();
	}

	void reinitialiser() {
		Console.nettoyerSaisies();
		FakePrintStream.clearOutput();
	}

	@Test
	@Order(1)
	void main_faireUneSieste() throws Exception {
		for (String[] choix : CHOIX_POUR_FAIRE_UNE_SIESTE) {
			reinitialiser();
			Console.simulerSaisies(choix);
			final String MESSAGE_ERREUR = String.format("Les choix %s doivent aboutir au résultat \"%s\"", Arrays.toString(choix), FaireUneSieste.FAIRE_UNE_SIESTE);
			assertTimeoutPreemptively(Duration.ofMillis(500), () -> FaireUneSieste.main(null), MESSAGE_ERREUR);
			String sortie = FakePrintStream.getOutput();
			assertTrue(sortie.contains(FaireUneSieste.FAIRE_UNE_SIESTE) && !sortie.contains(FaireUneSieste.NE_PAS_FAIRE_UNE_SIESTE), MESSAGE_ERREUR);
		}
	}

	@Test
	@Order(2)
	void main_nePasFaireUneSieste() throws Exception {
		for (String[] choix : CHOIX_POUR_NE_PAS_FAIRE_UNE_SIESTE) {
			reinitialiser();
			Console.simulerSaisies(choix);
			final String MESSAGE_ERREUR = String.format("Les choix %s doivent aboutir au résultat \"%s\"", Arrays.toString(choix), FaireUneSieste.FAIRE_UNE_SIESTE);
			assertTimeoutPreemptively(Duration.ofMillis(500), () -> FaireUneSieste.main(null), MESSAGE_ERREUR);
			String sortie = FakePrintStream.getOutput();
			assertTrue(!sortie.contains(FaireUneSieste.FAIRE_UNE_SIESTE) && sortie.contains(FaireUneSieste.NE_PAS_FAIRE_UNE_SIESTE), MESSAGE_ERREUR);
		}
	}

}
