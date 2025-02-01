package insertionsort;

public class InsertionSort {

    // Function to perform Insertion Sort
    static int[] insertionSort(int[] arr) {
        // Iterate through the array
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i]; // Current element to be placed correctly
            int prev = i - 1;

            // Shift larger elements to the right
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            // Place current element in the correct position
            arr[prev + 1] = curr;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] employeeId = {1, 4, 3, 5, 2, 6};

        System.out.println("Original array:");
        for (int num : employeeId) {
            System.out.print(num + " ");
        }

        int[] sortedArr = insertionSort(employeeId); // Sort the array

        System.out.println("\nSorted array:");
        for (int num : sortedArr) {
            System.out.print(num + " ");
        }
    }
}
