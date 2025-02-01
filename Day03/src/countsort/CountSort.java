package countsort;


public class CountSort {

    // Function to perform Counting Sort
    static void countSort(int[] arr) {
        int max = 0;

        // Find the maximum value in the array
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        // Create and initialize count array
        int[] c = new int[max + 1];

        // Count occurrences of each element
        for (int i = 0; i < arr.length; i++) {
            c[arr[i]]++;
        }

        // Compute prefix sum in count array
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        // Create output array to store sorted elements
        int[] b = new int[arr.length];

        // Place elements in sorted order
        for (int i = arr.length - 1; i >= 0; i--) {
            b[c[arr[i]] - 1] = arr[i];
            c[arr[i]]--;
        }

        // Copy sorted elements back to original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = b[i];
        }
    }

    public static void main(String[] args) {
        int[] studentAge = {10, 12, 11, 15, 14, 18, 17, 16, 13};

        System.out.println("Original array:");
        for (int num : studentAge) {
            System.out.print(num + " ");
        }

        countSort(studentAge); // Sort the array

        System.out.println("\nSorted array:");
        for (int num : studentAge) {
            System.out.print(num + " ");
        }
    }
}
