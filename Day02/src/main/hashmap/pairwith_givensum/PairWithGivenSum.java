package main.hashmap.pairwith_givensum;

import java.util.*;

public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int complement = target - num;

            // Check if complement exists in map
            if (map.containsKey(complement)) {
                return true; // Pair found
            }

            // Store current number in map
            map.put(num, 1);
        }
        return false; // No pair found
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        if (hasPairWithSum(arr, target)) {
            System.out.println("Pair found!");
        } else {
            System.out.println("No pair found.");
        }
    }
}
