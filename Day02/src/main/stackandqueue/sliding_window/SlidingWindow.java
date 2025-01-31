package main.stackandqueue.sliding_window;

import java.util.*;

public class SlidingWindow {
    public static int[] maxSlidingWindow(int[] arr, int k) {
        if (arr.length == 0) return new int[0];

        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements in k range as they are useless
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            // Add current element at the back of the deque
            deque.offerLast(i);

            // Store max element when the first valid window is completed
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] maxValues = maxSlidingWindow(arr, k);
        System.out.println(Arrays.toString(maxValues));  // Output: [3, 3, 5, 5, 6, 7]
    }
}
