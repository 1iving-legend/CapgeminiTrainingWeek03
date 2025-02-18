import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import compare_file_reading.*;
class FileReadingEfficiencyTest {

    @Test
    void testFileReader() throws FileNotFoundException {
        String fileName = "testfile.txt"; // You can use any file name for testing

        // Record the start time
        long startTime = System.currentTimeMillis();

        // Call the fileReader method
        FileReadingEfficiency.fileReader(fileName);

        // Record the end time
        long endTime = System.currentTimeMillis();

        // Assert that the time taken for file reading is reasonable
        long timeTaken = endTime - startTime;
        assertTrue(timeTaken < 5000, "FileReader took too long"); // Asserts that the method takes less than 5 seconds
    }

    @Test
    void testInputStreamReader() throws FileNotFoundException {
        String fileName = "testfile.txt"; // You can use any file name for testing

        // Record the start time
        long startTime = System.currentTimeMillis();

        // Call the inputStreamReader method
        FileReadingEfficiency.inputStreamReader(fileName);

        // Record the end time
        long endTime = System.currentTimeMillis();

        // Assert that the time taken for inputStreamReader is reasonable
        long timeTaken = endTime - startTime;
        assertTrue(timeTaken < 5000, "InputStreamReader took too long"); // Asserts that the method takes less than 5 seconds
    }

    @Test
    void testPerformanceComparison() throws FileNotFoundException {
        String fileName = "largefile.txt"; // You can use any file name for testing

        // Record the start time for fileReader
        long startTime = System.currentTimeMillis();
        FileReadingEfficiency.fileReader(fileName);
        long endTime = System.currentTimeMillis();
        long fileReaderTime = endTime - startTime;

        // Record the start time for inputStreamReader
        startTime = System.currentTimeMillis();
        FileReadingEfficiency.inputStreamReader(fileName);
        endTime = System.currentTimeMillis();
        long inputStreamReaderTime = endTime - startTime;

        // Compare the performance (optional threshold of 1 second)
        assertTrue(fileReaderTime < inputStreamReaderTime, "FileReader should be faster than InputStreamReader for this file.");
        assertTrue(fileReaderTime < 5000, "FileReader took too long");
        assertTrue(inputStreamReaderTime < 5000, "InputStreamReader took too long");

        // Optionally print the performance times for manual inspection
        System.out.println("Time taken by fileReader: " + fileReaderTime + " ms");
        System.out.println("Time taken by InputStreamReader: " + inputStreamReaderTime + " ms");
    }
}
