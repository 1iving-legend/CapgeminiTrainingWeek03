package bufferreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class BufferReaderProblem1 {
        public static void main(String[] args) {

        String filePath = "forBufferReaderProgram";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) { // Read line by line
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}

