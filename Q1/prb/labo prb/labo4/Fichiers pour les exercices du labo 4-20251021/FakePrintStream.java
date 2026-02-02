package fake;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Cette classe permet de remplacer le flux de sortie standard par un flux
 * capable de capturer les informations affichées.
 * 
 * @author Arnaud Comblin
 * @version 1.0
 */
public final class FakePrintStream {

	private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();

	private static volatile PrintStream instance = null;

	private FakePrintStream() {
		super();
	}

	public final static PrintStream getPrintStream() {
		if (instance == null) {
			synchronized (FakePrintStream.class) {
				if (instance == null) {
					instance = new PrintStream(OUTPUT_STREAM);
				}
			}
		}
		return instance;
	}

	public static String getOutput() {
		return OUTPUT_STREAM.toString();
	}

	public static void clearOutput() {
		OUTPUT_STREAM.reset();
	}

}
