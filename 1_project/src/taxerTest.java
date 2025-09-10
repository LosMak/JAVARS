import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class taxerTest {

    private InputStream originalIn;
    private PrintStream originalOut;


    @AfterEach
    void restoreIO() {
        System.setIn(originalIn);
        System.setOut(originalOut);
        taxer.keyboard = new Scanner(System.in);
    }

    private ByteArrayOutputStream prepareIO(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        taxer.keyboard = new Scanner(System.in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        return out;
    }

    private String runMainAndCapture(String input) {
        ByteArrayOutputStream out = prepareIO(input);
        taxer.main(new String[]{});
        return out.toString(StandardCharsets.UTF_8);
    }

    @Test
    void shouldDisplayPromptsBeforeReadingInputs() {
        String output = runMainAndCapture("1\n2\n");
        assertTrue(output.startsWith("Enter price: Enter tax in %: "), "Prompts should appear with colon and space before reading inputs");
        assertTrue(output.contains("Total: "), "Total should be printed after prompts");
    }

    @Test
    void shouldHandleZeroTaxPercentAsNoChange() {
        String output = runMainAndCapture("250\n0\n");
        Assertions.assertTrue(output.contains("Total: 250.0"));
    }

    @Test
    void shouldThrowInputMismatchOnNonNumericPriceOrTaxInput() {
        // Non-numeric price
        prepareIO("abc\n5.0\n");
        assertThrows(InputMismatchException.class, () -> taxer.main(new String[]{}));

        // Non-numeric tax percent
        prepareIO("100\nabc\n");
        assertThrows(InputMismatchException.class, () -> taxer.main(new String[]{}));
    }

    @Test
    void shouldCalculateTotalWithNegativePriceOrTaxPercent() {
        String outNegativePrice = runMainAndCapture("-100\n10\n");
        Assertions.assertTrue(outNegativePrice.contains("Total: -110.0"));

        String outNegativeTax = runMainAndCapture("100\n-10\n");
        Assertions.assertTrue(outNegativeTax.contains("Total: 90.0"));
    }

    @Test
    void shouldThrowInputMismatchWhenPriceExceedsIntRange() {
        prepareIO("2147483648\n5\n"); // one more than Integer.MAX_VALUE
        assertThrows(InputMismatchException.class, () -> taxer.main(new String[]{}));
    }

    @Test
    void shouldPropagateSpecialFloatTaxPercentToOutput() {
        String outputNaN = runMainAndCapture("100\nNaN\n");
        Assertions.assertTrue(outputNaN.contains("Total: NaN"));

        String outputInf = runMainAndCapture("100\nInfinity\n");
        Assertions.assertTrue(outputInf.contains("Total: Infinity"));

        String outputNegInf = runMainAndCapture("100\n-Infinity\n");
        Assertions.assertTrue(outputNegInf.contains("Total: -Infinity"));
    }

    @Test
    void shouldCalculateZeroTotalWhenPriceIsZero() {
        String[] percents = {"0", "15", "7.5", "-3.25", "1000000", "1e2"};
        for (String p : percents) {
            String output = runMainAndCapture("0\n" + p + "\n");
            Assertions.assertTrue(output.startsWith("Enter price: Enter tax in %: "));
            assertTrue(output.contains("Total: 0.0") || output.contains("Total: -0.0"),
                    "Total should be zero when price is 0 regardless of tax percent (" + p + ")");
        }
    }

    private void assertTrue(boolean startsWith, String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
    }
}