package input_stream_reader;

import java.io.*;

public class InputStraem {

    public static void main(String[] args) {

        String filePath = "example";

        try (
                // Create a FileInputStream to read the binary data
                FileInputStream fileInputStream = new FileInputStream(filePath);

                // Wrap the FileInputStream with an InputStreamReader to convert byte stream to character stream
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

                // Use a BufferedReader for efficient reading of characters
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
