package input_stream_reader;

import java.io.*;

public class UserInputFile {

    public static void main(String[] args) {
        // Specify the file to write user input
        String filePath = "example";  // Replace with your desired file path

        try (
                // Create an InputStreamReader to read from System.in (console)
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);

                // Wrap the InputStreamReader with a BufferedReader for efficient reading
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                // Create a FileWriter to write to the specified file
                FileWriter fileWriter = new FileWriter(filePath)
        ) {
            System.out.println("Enter text to write to the file. Type 'exit' to finish:");

            String line;

            while (!(line = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                fileWriter.write(line + System.lineSeparator());  // Write the line to the file
            }

            System.out.println("User input has been successfully written to " + filePath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
