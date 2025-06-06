package task1;

import org.exemple.task1.Perimetru;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

//utilizam in momentul in care vrem sa avem in clasa de test hook urile BeforAll & AfterAll
//ne permite sa restrangem modul de rulare la un ciclu la nivelul clasei
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class PerimetruTest {

    //Instanta de obiect se deefineste mereu la nivel de clasa
    private Perimetru perimetru;


    /* Hook inainte de fiecare test*/
    //GIVEN test instance - definire si initializare a prerechizitelor necesare rularii unui test
    @BeforeEach
    public void init() {
        System.out.println("S-a intrat in hook-ul de before each...");
        //initializarea instantei de obiect se face mereu in hook ul de before
        perimetru = new Perimetru();
    }


    /* Testul functional - de regula se utilizeaza date de test pt un happy flow comun*/
    @Test
    @DisplayName("Test pentru verificarea unui happy flow")
    public void testPerimetruHappyFlow() {


        //se poate defini diametrul ca variabila globala a metodei de este
        //astfel incat sa fie pasat la definirea celor 2 variabile de rezultat

        //WHEN test action - se calculeazam definesc si initializeaza rezultatele de comparat (asteptat vs actual)

        double rezultatActual = perimetru.calculeazaPerimetru(2.0);
        double rezultatAsteptat = 2.0 * Math.PI;

        //THEN test result - se aserteaza si verifica din multe puncte de vedere validitatea rezultatelor
        assertEquals(rezultatAsteptat, rezultatActual, 0.0001);
    }


    /* Boundery Test -> verifica valori in zona lui 0, empty sau null*/
    @Test
    @Disabled
    public void testPerimetruZero() {

        double rezultatActual = perimetru.calculeazaPerimetru(0.0);

        assertEquals(0.0, rezultatActual, 0.0001);
    }


    /* Negativ test -> verifica valori in zona numerelor negative*/
    @Test
    @DisplayName("Test pentru verificarea unui set de date negative")
    @Disabled
    public void testPerimetruNumarNegative() {


        double rezultatActual = perimetru.calculeazaPerimetru(2.0);
        assertEquals(2.0 * Math.PI, rezultatActual, 0.0001);
    }


    @AfterAll
    public void cleanup() {
        System.out.println("s-a intrat in hook-ul de after all...");
    }

    /* Precision Test -> verifica valori fractionare*/
    @Test
    public void testPerimetruPrecizie() {


        double rezultatActual = perimetru.calculeazaPerimetru(1.5);
        assertEquals(4.71239,rezultatActual,0.0001);
    }

    /* Scaling test -> verifica valori intr o plaja de multiplicari*/
    @Test
    public void  testPerimetruScalat(){


        double diametru1 = 5.0;
        double diametru2 = 2 * diametru1;

        double rezultatAsteptatP1 = perimetru.calculeazaPerimetru(diametru1);
        double rezultatAsteptatP2 = perimetru.calculeazaPerimetru(diametru2);

        assertEquals(rezultatAsteptatP1 * 2, rezultatAsteptatP2, 0.0001);
    }

}
