package fake;

import java.io.PrintStream;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * Cette classe permet de définir une nouvelle règle utilisable dans lors de
 * tests unitaires afin de capturer les informations affichées sur la sortie
 * standard.
 * 
 * @author Arnaud Comblin
 * @version 1.0
 */
public class FakePrintStreamRule implements BeforeAllCallback, BeforeEachCallback, AfterAllCallback {

	private final PrintStream STD_PRINT_STREAM = System.out;
	private final PrintStream FAKE_PRINT_STREAM = FakePrintStream.getPrintStream();

	@Override
	public void beforeAll(ExtensionContext extensionContext) throws Exception {
		System.setOut(FAKE_PRINT_STREAM);
	}

	@Override
	public void beforeEach(ExtensionContext arg0) throws Exception {
		FakePrintStream.clearOutput();
	}

	@Override
	public void afterAll(ExtensionContext extensionContext) throws Exception {
		System.setOut(STD_PRINT_STREAM);
	}
}