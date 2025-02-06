package bufferreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordInFile {

    public static void main(String[] args) {
        String filePath = "forBufferReaderProgram";
        String value= "exception";
        int count = 0;
        try (
                BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) { // Read line by line
                if (line.contains(value)) {
                    count++;
                }
            }
        } catch (
                IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(count);
    }

}
