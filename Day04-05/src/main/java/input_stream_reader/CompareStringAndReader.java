package input_stream_reader;

import java.io.*;
import java.util.StringTokenizer;

public class CompareStringAndReader {

    public static void main(String[] args) {

        System.out.println("Comparing StringBuilder and StringBuffer:");
        compareStringBuilders();


        String filePath = "example";
        System.out.println("\nComparing FileReader and InputStreamReader for word count:");
        compareFileReaders(filePath);
    }

    // Part 1: Compare StringBuilder and StringBuffer
    public static void compareStringBuilders() {
        int iterations = 1_000_000;
        String sample = "hello";

        // StringBuilder
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(sample);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (endTime - startTime) + " ms");

        // StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(sample);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (endTime - startTime) + " ms");
    }

    // Part 2: Compare FileReader and InputStreamReader for word count
    public static void compareFileReaders(String filePath) {
        // FileReader
        long startTime = System.currentTimeMillis();
        int wordCountFileReader = countWordsUsingFileReader(filePath);
        long endTime = System.currentTimeMillis();
        System.out.println("FileReader word count: " + wordCountFileReader + ", time: " + (endTime - startTime) + " ms");

        // InputStreamReader
        startTime = System.currentTimeMillis();
        int wordCountInputStreamReader = countWordsUsingInputStreamReader(filePath);
        endTime = System.currentTimeMillis();
        System.out.println("InputStreamReader word count: " + wordCountInputStreamReader + ", time: " + (endTime - startTime) + " ms");
    }

    // Count words using FileReader
    public static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += new StringTokenizer(line).countTokens();
            }
        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }
        return wordCount;
    }

    // Count words using InputStreamReader
    public static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += new StringTokenizer(line).countTokens();
            }
        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
        return wordCount;
    }
}
