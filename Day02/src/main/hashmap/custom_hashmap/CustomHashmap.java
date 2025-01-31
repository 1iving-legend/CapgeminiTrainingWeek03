package main.hashmap.custom_hashmap;

import java.util.LinkedList;

public class CustomHashmap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int INITIAL_CAPACITY = 16;  // Default size
    private LinkedList<Entry<K, V>>[] buckets;

    @SuppressWarnings("unchecked")
    public CustomHashmap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;  // Update value if key exists
                return;
            }
        }

        buckets[index].add(new Entry<>(key, value)); // Insert new entry
    }

    public V get(K key) {
        int index = getBucketIndex(key);

        if (buckets[index] == null) return null;

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;  // Key not found
    }

    public void remove(K key) {
        int index = getBucketIndex(key);

        if (buckets[index] == null) return;

        buckets[index].removeIf(entry -> entry.key.equals(key));
    }

    public void display() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                System.out.print("Bucket " + i + ": ");
                for (Entry<K, V> entry : buckets[i]) {
                    System.out.print("[" + entry.key + " -> " + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        CustomHashmap<String, Integer> map = new CustomHashmap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);
        map.put("banana", 25);  // Update existing key

        System.out.println("Value for 'banana': " + map.get("banana")); // 25
        System.out.println("Value for 'grape': " + map.get("grape")); // null

        map.remove("banana");
        System.out.println("Value for 'banana' after deletion: " + map.get("banana")); // null

        map.display();
    }
}
