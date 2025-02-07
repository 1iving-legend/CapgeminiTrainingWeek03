
package binary_search;

import java.util.Arrays;

public class ChallangeBinarySearch {

    // Function to find the first missing positive integer using Linear Search
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    // Function to perform Binary Search on a sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;  // Target not found
    }

    public static void main(String[] args) {
        // Example usage:

        // Array for finding first missing positive integer
        int[] nums = {3, 4, -1, 1};
        System.out.println("First missing positive integer: " + firstMissingPositive(nums));

        // Array for binary search (must be sorted first)
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        System.out.println("Index of target " + target + ": " + binarySearch(arr, target));
    }
}
