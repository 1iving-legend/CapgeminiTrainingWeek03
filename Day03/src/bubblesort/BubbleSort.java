package bubblesort;

public class BubbleSort {

    // Function to perform Bubble Sort
    static int[] bubbleSort(int[] arr) {
        int n = arr.length;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparisons
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the current element is greater than the next
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] marks = {22, 56, 33, 43, 23, 66, 34};

        System.out.println("Original array:");
        for (int num : marks) {
            System.out.print(num + " ");
        }

        int[] sortedArr = bubbleSort(marks); // Sort the array

        System.out.println("\nSorted array:");
        for (int num : sortedArr) {
            System.out.print(num + " ");
        }
    }
}
