import org.junit.jupiter.api.Test;
import compare_linear_binarysearch.*;
import static org.junit.jupiter.api.Assertions.*;

class CompareLinearBinarySearchTest {

    @Test
    void testLinearSearch() {
        long[] array = new long[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 10;
        }

        // Test case 1: Searching for an element that exists
        int index = CompareLinearBinarySearch.linearSearch(array, 50);
        assertEquals(40, index, "Linear search should return the correct index for an existing element");

        // Test case 2: Searching for an element that doesn't exist
        index = CompareLinearBinarySearch.linearSearch(array, 200);
        assertEquals(-1, index, "Linear search should return -1 for an element that doesn't exist");
    }

    @Test
    void testBinarySearch() {
        long[] array = new long[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 10;
        }
        // Array is already sorted, which is a requirement for binary search

        // Test case 1: Searching for an element that exists
        int index = CompareLinearBinarySearch.binarySearch(array, 50);
        assertEquals(40, index, "Binary search should return the correct index for an existing element");

        // Test case 2: Searching for an element that doesn't exist
        index = CompareLinearBinarySearch.binarySearch(array, 200);
        assertEquals(-1, index, "Binary search should return -1 for an element that doesn't exist");
    }

    @Test
    void testPerformanceComparison() {
        long[] array = new long[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 10;
        }

        // Record the start time for linearSearch
        long startTime = System.currentTimeMillis();
        CompareLinearBinarySearch.linearSearch(array, 183256);
        long endTime = System.currentTimeMillis();
        long linearSearchTime = endTime - startTime;

        // Record the start time for binarySearch
        startTime = System.currentTimeMillis();
        CompareLinearBinarySearch.binarySearch(array, 183256);
        endTime = System.currentTimeMillis();
        long binarySearchTime = endTime - startTime;

        // Assert that binarySearch is faster (or that it should be for large arrays)
        assertTrue(binarySearchTime < linearSearchTime, "Binary search should generally be faster than linear search for large arrays");

        // Optionally, print the performance times for manual inspection
        System.out.println("Time taken by linearSearch: " + linearSearchTime);
        System.out.println("Time taken by binarySearch: " + binarySearchTime);
    }
}
