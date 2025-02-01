package quicksort;

public class QuickSort {

    // Partition function to select a pivot and place it in the correct position
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Pivot is selected as the last element
        int i = low - 1;

        // Rearrange elements smaller than pivot to the left
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap elements
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in its correct position
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;  // Return pivot index
    }

    // QuickSort function that recursively sorts the array
    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;  // Base condition: if array has one or no elements
        }

        // Partitioning and recursive calls
        int pivot = partition(arr, low, high);
        quickSort(arr, low, pivot - 1);  // Sort left subarray
        quickSort(arr, pivot + 1, high);  // Sort right subarray
    }

    public static void main(String[] args) {
        int[] productPrices = {200, 400, 321, 335, 53, 735};

        System.out.println("Original array:");
        for (int price : productPrices) {
            System.out.print(price + " ");
        }

        quickSort(productPrices, 0, productPrices.length - 1);  // Sort the array

        System.out.println("\nSorted array:");
        for (int price : productPrices) {
            System.out.print(price + " ");
        }
    }
}
