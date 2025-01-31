package main.hashmap.longets_sequence;

import java.util.*;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;

        for (int num : nums) {
            if (!map.containsKey(num)) {  // Process each number only once
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int length = left + right + 1;

                map.put(num, length);  // Store the length for current number
                map.put(num - left, length); // Update the start of sequence
                map.put(num + right, length); // Update the end of sequence

                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence Length: " + longestConsecutive(nums));
    }
}
