package io;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

/**
 * La classe {@code Console} fournit des méthodes utilitaires pour faciliter
 * les interactions avec la console en Java. Elle permet de lire des entrées
 * utilisateur, d'afficher des messages, et de gérer la redirection des flux
 * d'entrée/sortie.
 *
 * <p>Cette classe utilise un {@link Scanner} pour lire les entrées et un
 * {@link PrintStream} pour écrire les sorties. Elle est conçue pour simplifier
 * les opérations courantes de lecture et d'écriture en console.</p>
 *
 * <p><strong>Exemple d'utilisation basique :</strong></p>
 * <pre>
 *   // Lire un entier et un flottant, puis les afficher
 *   int age = Console.readInt("Quel est votre âge ? ");
 *   float taille = Console.readFloat("Quel est votre taille (en mètres) ? ");
 *   Console.printf("Vous avez %d ans et mesurez %.2f mètres.%n", age, taille);
 * </pre>
 */
public class Console {
    private static final NumberFormat FORMATTER = NumberFormat.getNumberInstance(Locale.ENGLISH);
    private static Scanner scanner = new Scanner(System.in);
    private static PrintStream out = System.out;

    /**
     * Redirige le flux d'entrée standard vers un nouveau flux spécifié.
     *
     * @param newInput Le nouveau flux d'entrée à utiliser pour la lecture.
     */
    public static void redirectInput(InputStream newInput) {
        scanner.close();
        scanner = new Scanner(newInput);
    }

    /**
     * Redirige le flux de sortie standard vers un nouveau flux spécifié.
     *
     * @param newOutput Le nouveau flux de sortie à utiliser pour l'écriture.
     */
    public static void redirectOutput(OutputStream newOutput) {
        if(out != System.out) {
            out.close();
        }
        out = new PrintStream(newOutput);
    }

    /**
     * Affiche un message formaté sur la console.
     *
     * @param format La chaîne de format (au format {@link java.util.Formatter}).
     * @param args   Les arguments à insérer dans la chaîne de format.
     *
     * <p><strong>Exemple :</strong></p>
     * <pre>
     *   Console.printf("Valeur : %.2f%n", 3.14159);
     *   // Affiche : "Valeur : 3,14"
     * </pre>
     */
    public static void printf(String format, Object... args) {
        out.printf(Locale.ENGLISH, format, args);
    }

    /**
     * Affiche un message sur la console, sans retour à la ligne.
     *
     * @param message Le message à afficher.
     *
     * <p><strong>Exemple :</strong></p>
     * <pre>
     *   Console.print("Bonjour, ");
     *   Console.println("monde !");
     *   // Affiche : "Bonjour, monde !" sur une seule ligne.
     * </pre>
     */
    public static void print(String message) {
        out.print(message);
    }

    /**
     * Affiche un message sur la console, suivi d'un retour à la ligne.
     *
     * @param message Le message à afficher.
     *
     * <p><strong>Exemple :</strong></p>
     * <pre>
     *   Console.println("Bonjour, monde !");
     *   // Affiche : "Bonjour, monde !" suivi d'un retour à la ligne.
     * </pre>
     */
    public static void println(String message) {
        out.println(message);
    }

    /**
     * Affiche un retour à la ligne sur la console.
     *
     * <p><strong>Exemple :</strong></p>
     * <pre>
     *   Console.println();
     *   // Affiche une ligne vide.
     * </pre>
     */
    public static void println() {
        out.println();
    }

    /**
     * Lit une ligne de texte depuis la console.
     *
     * @param message Le message à afficher avant de lire l'entrée (peut être {@code null}).
     * @return La ligne de texte lue.
     *
     * <p><strong>Exemple :</strong></p>
     * <pre>
     *   String nom = Console.readLine("Quel est votre nom ? ");
     *   // Si l'utilisateur entre "Alice", la variable nom contiendra "Alice".
     * </pre>
     */
    public static String readLine(String message) {
        if (message != null && !message.isEmpty()) {
            printf(message);
        }
        return scanner.nextLine();
    }

    /**
     * Lit un entier depuis la console. En cas d'erreur de saisie, l'utilisateur
     * est invité à réessayer jusqu'à ce qu'une valeur valide soit entrée.
     *
     * @param message Le message à afficher avant de lire l'entrée (peut être {@code null}).
     * @return L'entier lu.
     *
     * <p><strong>Exemple :</strong></p>
     * <pre>
     *   int nombre = Console.readInt("Entrez un nombre entier : ");
     *   // Si l'utilisateur entre "42", la variable nombre contiendra 42.
     * </pre>
     */
    public static int readInt(String message) {
        String value = "";
        Number n = null;
        while(n == null) {
            try {
                value = readLine(message).strip();
                n = FORMATTER.parse(value);
            } catch(ParseException pe) {
                n = null;
            }
        }
        return n.intValue();
    }

    /**
     * Lit un nombre flottant depuis la console. En cas d'erreur de saisie, l'utilisateur
     * est invité à réessayer jusqu'à ce qu'une valeur valide soit entrée.
     *
     * @param message Le message à afficher avant de lire l'entrée (peut être {@code null}).
     * @return Le flottant lu.
     *
     * <p><strong>Exemple :</strong></p>
     * <pre>
     *   float pi = Console.readFloat("Entrez une valeur décimale : ");
     *   // Si l'utilisateur entre "3,14", la variable pi contiendra 3.14.
     * </pre>
     */
    public static float readFloat(String message) {
        String value = "";
        Number n = null;
        while(n == null) {
            try {
                value = readLine(message).strip();
                n = FORMATTER.parse(value);
            } catch(ParseException pe) {
                n = null;
            }
        }
        return n.floatValue();
    }

    /**
     * Lit un entier depuis la console, sans afficher de message.
     *
     * @return L'entier lu.
     *
     * <p><strong>Exemple :</strong></p>
     * <pre>
     *   int age = Console.readInt();
     *   // L'utilisateur entre "30", la variable age contiendra 30.
     * </pre>
     */
    public static int readInt() {
        return readInt(null);
    }

    /**
     * Lit un nombre flottant depuis la console, sans afficher de message.
     *
     * @return Le flottant lu.
     *
     * <p><strong>Exemple :</strong></p>
     * <pre>
     *   float taille = Console.readFloat();
     *   // L'utilisateur entre "1,75", la variable taille contiendra 1.75.
     * </pre>
     */
    public static float readFloat() {
        return readFloat(null);
    }
}
