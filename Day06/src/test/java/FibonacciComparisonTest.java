import fibonacci_comparison.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciComparisonTest {

    @Test
    void testFibonacciIterative() {
        assertEquals(0, FibonacciComparison.fibonacciIterative(0));
        assertEquals(1, FibonacciComparison.fibonacciIterative(1));
        assertEquals(5, FibonacciComparison.fibonacciIterative(5));
        assertEquals(55, FibonacciComparison.fibonacciIterative(10));
        assertEquals(832040, FibonacciComparison.fibonacciIterative(30));  // Higher test case
    }

    @Test
    void testFibonacciRecursive() {
        assertEquals(0, FibonacciComparison.fibonacciRecursive(0));
        assertEquals(1, FibonacciComparison.fibonacciRecursive(1));
        assertEquals(5, FibonacciComparison.fibonacciRecursive(5));
        assertEquals(55, FibonacciComparison.fibonacciRecursive(10));
        assertEquals(832040, FibonacciComparison.fibonacciRecursive(30));  // Higher test case
    }

    @Test
    void testPerformanceComparison() {
        int n = 30;  // Using 30 for performance test

        // Measure time for iterative method
        long startIterative = System.nanoTime();
        FibonacciComparison.fibonacciIterative(n);
        long endIterative = System.nanoTime();
        long iterativeTime = endIterative - startIterative;

        // Measure time for recursive method
        long startRecursive = System.nanoTime();
        FibonacciComparison.fibonacciRecursive(n);
        long endRecursive = System.nanoTime();
        long recursiveTime = endRecursive - startRecursive;

        System.out.println("Iterative time for n=" + n + ": " + iterativeTime + " nanoseconds");
        System.out.println("Recursive time for n=" + n + ": " + recursiveTime + " nanoseconds");

        // Ensure recursive method takes longer than iterative
        assertTrue(recursiveTime > iterativeTime, "Recursive method should take longer than iterative method");
    }
}
