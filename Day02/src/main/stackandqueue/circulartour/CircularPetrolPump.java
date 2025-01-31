package main.stackandqueue.circulartour;

import java.util.*;

class CircularPetrolPump {
    static int findStartingPump(int[] petrol, int[] distance, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int total_surplus = 0, current_surplus = 0;
        int start = 0; // Possible starting index

        for (int i = 0; i < n; i++) {
            int surplus = petrol[i] - distance[i];
            total_surplus += surplus;
            current_surplus += surplus;
            queue.add(i);

            // If surplus becomes negative, reset start
            if (current_surplus < 0) {
                while (!queue.isEmpty()) {
                    queue.poll();  // Remove pumps from the queue
                }
                start = i + 1;  // Move to next pump
                current_surplus = 0;  // Reset current surplus
            }
        }

        return (total_surplus >= 0) ? start : -1;  // Check if tour is possible
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        int n = petrol.length;

        int startPump = findStartingPump(petrol, distance, n);
        System.out.println((startPump != -1) ? "Start at pump: " + startPump : "No solution possible");
    }
}
