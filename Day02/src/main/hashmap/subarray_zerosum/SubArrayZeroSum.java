package main.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SubArrayZeroSum {

    public static void helper(int[] arr) {
        // Create a HashMap to store the sum and its frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
    for (int i = 0; i < arr.length; i++) {
        for (int j = i ; j < arr.length; j++) {
            sum += arr[j];
            if(sum == 0) {
                map.put(i,j);
            }
        }
    }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        // Iterate through the entries and print them
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            for(int m = entry.getKey(); m<= entry.getValue(); m++) {

                System.out.print(arr[m]+ " ");

            }
            System.out.println();
        }

        }


    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 4,-3, 5, 6, -7, -4,8, 9};

        helper(arr);
    }
}
