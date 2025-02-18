import compare_sorting_algorithm.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompareSortingAlgorithmTest {

    // Helper method to check if the array is sorted
    private boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;  // Array is not sorted
            }
        }
        return true;  // Array is sorted
    }

    @Test
    void testBubbleSort() {
        int[] array = {5, 2, 9, 1, 5, 6};

        // Apply Bubble Sort
        CompareSortingAlgorithm.bubbleSort(array);

        // Assert that the array is sorted
        assertTrue(isSorted(array), "Array should be sorted after bubbleSort");
    }

    @Test
    void testMergeSort() {
        int[] array = {5, 2, 9, 1, 5, 6};

        // Apply Merge Sort
        CompareSortingAlgorithm.mergesort(array, 0, array.length - 1);

        // Assert that the array is sorted
        assertTrue(isSorted(array), "Array should be sorted after mergeSort");
    }

    @Test
    void testQuickSort() {
        int[] array = {5, 2, 9, 1, 5, 6};

        // Apply Quick Sort
        CompareSortingAlgorithm.quickSort(array, 0, array.length - 1);

        // Assert that the array is sorted
        assertTrue(isSorted(array), "Array should be sorted after quickSort");
    }

    @Test
    void testPerformanceComparison() {
        int[] array = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000); // Filling with random values
        }

        // Record time taken by Bubble Sort
        long startTime = System.nanoTime();
        CompareSortingAlgorithm.bubbleSort(array.clone());  // Using a clone to preserve the original array
        long bubbleSortTime = System.nanoTime() - startTime;

        // Record time taken by Merge Sort
        startTime = System.nanoTime();
        CompareSortingAlgorithm.mergesort(array.clone(), 0, array.length - 1);
        long mergeSortTime = System.nanoTime() - startTime;

        // Record time taken by Quick Sort
        startTime = System.nanoTime();
        CompareSortingAlgorithm.quickSort(array.clone(), 0, array.length - 1);
        long quickSortTime = System.nanoTime() - startTime;

        // Print out the time taken by each sorting algorithm
        System.out.println("Time taken by bubbleSort: " + bubbleSortTime);
        System.out.println("Time taken by mergeSort: " + mergeSortTime);
        System.out.println("Time taken by quickSort: " + quickSortTime);

        // Basic assertion to check that quick sort is generally faster than bubble sort
        assertTrue(quickSortTime < bubbleSortTime, "Quick Sort should generally be faster than Bubble Sort");
        assertTrue(mergeSortTime < bubbleSortTime, "Merge Sort should generally be faster than Bubble Sort");
    }
}
