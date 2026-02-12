package labo5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


import io.*;

public class LDVELHTest {
    @BeforeEach
    void nettoyerSaisiesAvantChaqueTest() {
        Console.nettoyerSaisies();
    }

    @AfterAll
    static void nettoyerSaisiesFinDesTests() {
        Console.nettoyerSaisies();
    }

    @Test
    void lireChoix_saisieValide() {
        Console.simulerSaisies("A");
        assertEquals('A', LDVELH.lireChoix("A ou B ? ", "AaBb"));
    }

    @Test
    void lireChoix_saisieNonValide() {
        Console.simulerSaisies("C", "", "a");
        assertEquals('a', LDVELH.lireChoix("A ou B ? ", "AaBb"));
    }
}