package heapsort;

public class HeapSort {

    // Heapify function to maintain the heap property
    static void heapify(int[] arr, int len, int i) {
        int largest = i; // Initialize largest as root
        int leftIndx = (2 * i) + 1; // Left child index
        int rightIndx = (2 * i) + 2; // Right child index

        // If left child is larger than root
        if (leftIndx < len && arr[leftIndx] > arr[largest]) {
            largest = leftIndx;
        }

        // If right child is larger than the largest so far
        if (rightIndx < len && arr[rightIndx] > arr[largest]) {
            largest = rightIndx;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, len, largest);
        }
    }

    // Function to perform heap sort
    static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build Max Heap (Rearrange array)
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root (largest) to end
            swap(arr, 0, i);

            // Restore heap property on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Swap function to swap two elements in the array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main function to test Heap Sort
    public static void main(String[] args) {
        int[] arr = {2, 44, 32, 54, 65, 32};

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        heapSort(arr); // Sort the array using Heap Sort

        System.out.println("\nSorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
