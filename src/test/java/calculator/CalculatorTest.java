package calculator;

import org.exemple.calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    //adunarea ar trebui sa fie corecta pt numere intregi
    @Test
    public void testAdunare() {
        double rezltatActual = calculator.adunare(4,5);
        System.out.println("S-a intrat in testul pt verificarea adunarii!");
        //definiti rezultatul actual asteptat -> double rezultatAsteptat = 9;
        assertEquals(9, rezltatActual); //assert(expected, actual);

    }

    @Test
    public void testScadere() {
        double rezltatActual = calculator.scadere(4,5);

        assertEquals(-1, rezltatActual);


    }
}
