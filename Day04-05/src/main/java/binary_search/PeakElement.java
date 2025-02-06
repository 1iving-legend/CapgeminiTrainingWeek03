package binary_search;

class PeakElement {
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is a peak element
            if ((mid == 0 || arr[mid] > arr[mid - 1]) &&
                    (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                return mid;
            }

            // If left neighbor is greater, move to left half
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            }
            // Otherwise, move to right half
            else {
                left = mid + 1;
            }
        }
        return -1; // This line should never be reached
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int peakIndex = findPeakElement(arr);

        System.out.println("Peak element found at index: " + peakIndex);
        System.out.println("Peak element is: " + arr[peakIndex]);
    }
}
