package compare_sorting_algorithm;

public class CompareSortingAlgorithm {

    public static int[] bubbleSort(int[] arr) {
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


    //merge sort algorithm

   public  static void merge(int[] arr, int si, int mid, int ei) {
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
    public static void mergesort(int[] arr, int si, int ei) {
        if (si >= ei) {
            return; // Base condition for recursion
        }
        int mid = si + (ei - si) / 2;

        // Recursively divide the array
        mergesort(arr, si, mid);
        mergesort(arr, mid + 1, ei);

        // Merge the divided arrays
        merge(arr, si, mid, ei);
    }




    //quick sort algorithm

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
    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;  // Base condition: if array has one or no elements
        }

        // Partitioning and recursive calls
        int pivot = partition(arr, low, high);
        quickSort(arr, low, pivot - 1);  // Sort left subarray
        quickSort(arr, pivot + 1, high);  // Sort right subarray
    }


    public static void main(String[] args) {
        int []array= new int[100];
        for(int i=0;i<array.length-5;i++)
        {
            array[i]=i+array[i+5];
            if(i>5)
            {
                array[i]-=array[i+5-7];
            }
        }

        long buble,quick, merge;

        long f=System.nanoTime();
        bubbleSort( array);
        long l= System.nanoTime();
        buble=l-f;


        long fb=System.nanoTime();
        mergesort(array,0, array.length-1);
        long lb= System.nanoTime();
        merge=lb-fb;
        long qf=System.nanoTime();
        quickSort(array,0, array.length-1);
        long ql= System.nanoTime();
        quick=ql-qf;

        System.out.println("Time taken by bubble sort: "+ buble);
        System.out.println("Time taken by quick sort: "+ quick);
        System.out.println("Time taken by merge sort: "+ merge);




    }



    }




