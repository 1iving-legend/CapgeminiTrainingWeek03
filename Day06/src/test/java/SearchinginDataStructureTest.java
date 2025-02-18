import searching_comparison.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

class SearchinginDataStructureTest {

    // Helper method to generate the array, HashSet, and TreeSet
    private Object[] generateData(int n) {
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1_000_000);
        }

        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int value : arr) {
            hashSet.add(value);
            treeSet.add(value);
        }

        return new Object[]{arr, hashSet, treeSet};
    }

    @Test
    void testArraySearch() {
        int n = 100_000; // Test with a large dataset
        Object[] data = generateData(n);
        int[] arr = (int[]) data[0];
        int target = arr[n / 2]; // Use the middle element as target

        boolean foundInArray = false;
        for (int value : arr) {
            if (value == target) {
                foundInArray = true;
                break;
            }
        }

        assertTrue(foundInArray, "Target should be found in the array using linear search");
    }

    @Test
    void testHashSetSearch() {
        int n = 100_000; // Test with a large dataset
        Object[] data = generateData(n);
        HashSet<Integer> hashSet = (HashSet<Integer>) data[1];
        int target = (int) hashSet.toArray()[n / 2]; // Use the middle element as target

        boolean foundInHashSet = hashSet.contains(target);

        assertTrue(foundInHashSet, "Target should be found in the HashSet");
    }

    @Test
    void testTreeSetSearch() {
        int n = 100_000; // Test with a large dataset
        Object[] data = generateData(n);
        TreeSet<Integer> treeSet = (TreeSet<Integer>) data[2];
        int target = (int) treeSet.toArray()[n / 2]; // Use the middle element as target

        boolean foundInTreeSet = treeSet.contains(target);

        assertTrue(foundInTreeSet, "Target should be found in the TreeSet");
    }

    @Test
    void testPerformanceComparison() {
        int n = 100_000; // Use a large dataset size
        Object[] data = generateData(n);
        int[] arr = (int[]) data[0];
        HashSet<Integer> hashSet = (HashSet<Integer>) data[1];
        TreeSet<Integer> treeSet = (TreeSet<Integer>) data[2];

        // Target for testing
        int target = arr[n / 2];

        // Measure Array search (Linear Search)
        long startArray = System.nanoTime();
        boolean foundInArray = false;
        for (int value : arr) {
            if (value == target) {
                foundInArray = true;
                break;
            }
        }
        long endArray = System.nanoTime();
        double arraySearchTime = (endArray - startArray) / 1_000_000.0; // in milliseconds

        // Measure HashSet search (Average O(1) time complexity)
        long startHashSet = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(target);
        long endHashSet = System.nanoTime();
        double hashSetSearchTime = (endHashSet - startHashSet) / 1_000_000.0; // in milliseconds

        // Measure TreeSet search (O(log N) time complexity)
        long startTreeSet = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(target);
        long endTreeSet = System.nanoTime();
        double treeSetSearchTime = (endTreeSet - startTreeSet) / 1_000_000.0; // in milliseconds

        // Print search times
        System.out.println("Performance Comparison for target " + target + ":");
        System.out.println("Array (Linear Search) found target in " + arraySearchTime + " ms");
        System.out.println("HashSet found target in " + hashSetSearchTime + " ms");
        System.out.println("TreeSet found target in " + treeSetSearchTime + " ms");

        // Assert performance: HashSet and TreeSet should generally be faster than Array search
        assertTrue(hashSetSearchTime < arraySearchTime, "HashSet search should be faster than Array search");
        assertTrue(treeSetSearchTime < arraySearchTime, "TreeSet search should be faster than Array search");
    }
}
