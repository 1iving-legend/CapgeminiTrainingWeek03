package mergesort;

public class MergeSort {

    // Merging two sorted halves into a single sorted array
    static void merge(int[] arr, int si, int mid, int ei) {
        int[] merged = new int[ei - si + 1];
        int indx1 = si, indx2 = mid + 1, x = 0;

        // Merge elements from both halves
        while (indx1 <= mid && indx2 <= ei) {
            if (arr[indx1] <= arr[indx2]) {
                merged[x++] = arr[indx1++];
            } else {
                merged[x++] = arr[indx2++];
            }
        }

        // Copy remaining elements from left half
        while (indx1 <= mid) {
            merged[x++] = arr[indx1++];
        }

        // Copy remaining elements from right half
        while (indx2 <= ei) {
            merged[x++] = arr[indx2++];
        }

        // Copy merged elements back to original array
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    // Dividing the array into two halves
    static void divide(int[] arr, int si, int ei) {
        if (si >= ei) {
            return; // Base condition for recursion
        }
        int mid = si + (ei - si) / 2;

        // Recursively divide the array
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);

        // Merge the divided arrays
        merge(arr, si, mid, ei);
    }

    public static void main(String[] args) {
        int[] bookPrice = {23, 43, 65, 90, 76, 60};

        System.out.println("Original array:");
        for (int num : bookPrice) {
            System.out.print(num + " ");
        }

        divide(bookPrice, 0, bookPrice.length - 1); // Sort the array

        System.out.println("\nSorted array:");
        for (int num : bookPrice) {
            System.out.print(num + " ");
        }
    }
}
