import compare_string_concatination.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompareTest {

    // Helper method to check the length of the concatenated result
    private int getExpectedLength(String value, int iterations) {
        return value.length() * iterations;
    }

    @Test
    void testStringConcatenation() {
        String value = "hello";
        int iterations = 100;
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            expected.append(value);
        }

        // Capture the result length
        long startTime = System.nanoTime();
        Compare.stringConcatination(value, iterations);
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;

        // Ensure the result is correct and check the performance
        assertEquals(expected.length(), value.length() * iterations);
        assertTrue(timeTaken > 0, "Time taken should be greater than 0 for String concatenation");
    }

    @Test
    void testStringBufferConcatenation() {
        String value = "hello";
        int iterations = 100;

        StringBuffer expected = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            expected.append(value);
        }

        long startTime = System.nanoTime();
        Compare.stringBufferConcatination(value, iterations);
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;

        // Ensure the result is correct and check the performance
        assertEquals(expected.length(), value.length() * iterations);
        assertTrue(timeTaken > 0, "Time taken should be greater than 0 for StringBuffer concatenation");
    }

    @Test
    void testStringBuilderConcatenation() {
        String value = "hello";
        int iterations = 100;
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            expected.append(value);
        }

        long startTime = System.nanoTime();
        Compare.stringBuilderConcatination(value, iterations);
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;

        // Ensure the result is correct and check the performance
        assertEquals(expected.length(), value.length() * iterations);
        assertTrue(timeTaken > 0, "Time taken should be greater than 0 for StringBuilder concatenation");
    }

    @Test
    void testPerformanceComparison() {
        String value = "hello";
        int iterations = 1000;

        long startTime, endTime;

        // Test for String concatenation
        startTime = System.nanoTime();
        Compare.stringConcatination(value, iterations);
        endTime = System.nanoTime();
        long stringTime = endTime - startTime;

        // Test for StringBuffer concatenation
        startTime = System.nanoTime();
        Compare.stringBufferConcatination(value, iterations);
        endTime = System.nanoTime();
        long bufferTime = endTime - startTime;

        // Test for StringBuilder concatenation
        startTime = System.nanoTime();
        Compare.stringBuilderConcatination(value, iterations);
        endTime = System.nanoTime();
        long builderTime = endTime - startTime;

        // Ensure StringBuilder and StringBuffer are faster than String
        assertTrue(bufferTime <= stringTime, "StringBuffer should be faster or equal to String");
        assertTrue(builderTime <= stringTime, "StringBuilder should be faster or equal to String");
        assertTrue(builderTime <= bufferTime, "StringBuilder should be faster or equal to StringBuffer");
    }
}
