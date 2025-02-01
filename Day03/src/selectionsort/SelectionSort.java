package selectionsort;

public class SelectionSort {

    // Function to perform Selection Sort
    static int[] selectionSort(int[] arr) {
        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            int smallestIndex = i;

            // Find the smallest element in the unsorted portion
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallestIndex]) {
                    smallestIndex = j;  // Update the index of the smallest element
                }
            }

            // Swap the smallest element with the first unsorted element
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
        return arr;  // Return the sorted array
    }

    public static void main(String[] args) {
        int[] scores = {1, 4, 3, 5, 2, 6};

        System.out.println("Original array:");
        for (int score : scores) {
            System.out.print(score + " ");
        }

        int[] sortedScores = selectionSort(scores);  // Sort the array

        System.out.println("\nSorted array:");
        for (int score : sortedScores) {
            System.out.print(score + " ");
        }
    }
}
