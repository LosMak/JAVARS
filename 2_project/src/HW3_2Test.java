import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HW3_2Test {

    private String runMainAndCaptureOutput() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        try {
            System.setOut(ps);
            HW3_2.main(new String[0]);
            ps.flush();
        } finally {
            System.setOut(originalOut);
        }
        return baos.toString();
    }

    public void testPrintsZeroToFifteenInclusive() {
        String output = runMainAndCaptureOutput();
        String ls = System.lineSeparator();
        String sep = "_________________________" + ls;

        int firstSepIndex = output.indexOf(sep);
        assert firstSepIndex >= 0 : "First separator not found in output";

        String task1Output = output.substring(0, firstSepIndex);

        StringBuilder expectedTask1 = new StringBuilder();
        for (int i = 0; i <= 15; i++) {
            expectedTask1.append(i).append(ls);
        }

        assert expectedTask1.toString().equals(task1Output) : "Task 1 output should list 0..15 inclusive in ascending order";
    }

    public void testPrintsPowersOfFiveBelow10000() {
        String output = runMainAndCaptureOutput();
        String ls = System.lineSeparator();
        String sep = "_________________________" + ls;

        int firstSepIndex = output.indexOf(sep);
        int secondSepIndex = output.indexOf(sep, firstSepIndex + sep.length());
        assert firstSepIndex >= 0 && secondSepIndex > firstSepIndex : "Separators not found in correct order";

        String task2Output = output.substring(firstSepIndex + sep.length(), secondSepIndex);

        StringBuilder expectedTask2 = new StringBuilder();
        int[] values = {1, 5, 25, 125, 625, 3125};
        for (int v : values) {
            expectedTask2.append(v).append(ls);
        }

        assert expectedTask2.toString().equals(task2Output) : "Task 2 output should list powers of 5 below 10000";
    }

    public void testPrintsMultiplesOfFourBetween40And60Inclusive() {
        String output = runMainAndCaptureOutput();
        String ls = System.lineSeparator();

        int idx40 = output.indexOf("40" + ls);
        int idx44 = output.indexOf("44" + ls);
        int idx48 = output.indexOf("48" + ls);
        int idx52 = output.indexOf("52" + ls);
        int idx56 = output.indexOf("56" + ls);
        int idx60 = output.indexOf("60" + ls);

        assert idx40 >= 0 : "Should print 40";
        assert idx44 >= 0 : "Should print 44";
        assert idx48 >= 0 : "Should print 48";
        assert idx52 >= 0 : "Should print 52";
        assert idx56 >= 0 : "Should print 56";
        assert idx60 >= 0 : "Should print 60";

        assert idx40 < idx44 && idx44 < idx48 && idx48 < idx52 && idx52 < idx56 && idx56 < idx60 :
                "Multiples of 4 between 40 and 60 should be printed in ascending order";
    }

    public void testFirstTaskExcludesOutOfRangeValues() {
        String output = runMainAndCaptureOutput();
        String ls = System.lineSeparator();
        String sep = "_________________________" + ls;

        int firstSepIndex = output.indexOf(sep);
        assert firstSepIndex >= 0 : "First separator not found in output";

        String task1Output = output.substring(0, firstSepIndex);

        assert !task1Output.contains("-1" + ls) : "Task 1 should not print -1";
        assert !task1Output.contains("16" + ls) : "Task 1 should not print 16";
    }

    public void testPowersOfFiveTerminatesBeforeThreshold() {
        String output = runMainAndCaptureOutput();
        String ls = System.lineSeparator();
        String sep = "_________________________" + ls;

        int firstSepIndex = output.indexOf(sep);
        int secondSepIndex = output.indexOf(sep, firstSepIndex + sep.length());
        assert firstSepIndex >= 0 && secondSepIndex > firstSepIndex : "Separators not found in correct order";

        String task2Output = output.substring(firstSepIndex + sep.length(), secondSepIndex);

        assert task2Output.endsWith("3125" + ls) : "Last printed power of 5 should be 3125";
        assert !task2Output.contains("15625") : "15625 should not be printed";
    }

    public void testSeparatorsPrintedExactlyTwiceInCorrectPositions() {
        String output = runMainAndCaptureOutput();
        String ls = System.lineSeparator();
        String sep = "_________________________" + ls;

        // Count occurrences
        int count = 0;
        int idx = 0;
        while ((idx = output.indexOf(sep, idx)) != -1) {
            count++;
            idx += sep.length();
        }
        assert count == 2 : "Separator line should be printed exactly twice";

        int firstSepIndex = output.indexOf(sep);
        int secondSepIndex = output.indexOf(sep, firstSepIndex + sep.length());
        assert firstSepIndex >= 0 && secondSepIndex > firstSepIndex : "Separators not found correctly";

        // Build expected blocks
        StringBuilder expectedTask1 = new StringBuilder();
        for (int i = 0; i <= 15; i++) {
            expectedTask1.append(i).append(ls);
        }
        StringBuilder expectedTask2 = new StringBuilder();
        int[] values = {1, 5, 25, 125, 625, 3125};
        for (int v : values) {
            expectedTask2.append(v).append(ls);
        }

        // Verify positions relative to content
        assert expectedTask1.length() == firstSepIndex : "First separator should be right after Task 1 output";
        assert firstSepIndex + sep.length() + expectedTask2.length() == secondSepIndex :
                "Second separator should be right after Task 2 output";

        // Ensure nothing after second separator
        assert secondSepIndex + sep.length() == output.length() : "No extra output should follow the second separator";
    }

    public static void main(String[] args) {
        HW3_2Test test = new HW3_2Test();
        
        System.out.println("Running tests...");
        
        try {
            test.testPrintsZeroToFifteenInclusive();
            System.out.println("✓ testPrintsZeroToFifteenInclusive passed");
        } catch (AssertionError e) {
            System.out.println("✗ testPrintsZeroToFifteenInclusive failed: " + e.getMessage());
        }
        
        try {
            test.testPrintsPowersOfFiveBelow10000();
            System.out.println("✓ testPrintsPowersOfFiveBelow10000 passed");
        } catch (AssertionError e) {
            System.out.println("✗ testPrintsPowersOfFiveBelow10000 failed: " + e.getMessage());
        }
        
        try {
            test.testPrintsMultiplesOfFourBetween40And60Inclusive();
            System.out.println("✓ testPrintsMultiplesOfFourBetween40And60Inclusive passed");
        } catch (AssertionError e) {
            System.out.println("✗ testPrintsMultiplesOfFourBetween40And60Inclusive failed: " + e.getMessage());
        }
        
        try {
            test.testFirstTaskExcludesOutOfRangeValues();
            System.out.println("✓ testFirstTaskExcludesOutOfRangeValues passed");
        } catch (AssertionError e) {
            System.out.println("✗ testFirstTaskExcludesOutOfRangeValues failed: " + e.getMessage());
        }
        
        try {
            test.testPowersOfFiveTerminatesBeforeThreshold();
            System.out.println("✓ testPowersOfFiveTerminatesBeforeThreshold passed");
        } catch (AssertionError e) {
            System.out.println("✗ testPowersOfFiveTerminatesBeforeThreshold failed: " + e.getMessage());
        }
        
        try {
            test.testSeparatorsPrintedExactlyTwiceInCorrectPositions();
            System.out.println("✓ testSeparatorsPrintedExactlyTwiceInCorrectPositions passed");
        } catch (AssertionError e) {
            System.out.println("✗ testSeparatorsPrintedExactlyTwiceInCorrectPositions failed: " + e.getMessage());
        }
        
        System.out.println("All tests completed.");
    }
}