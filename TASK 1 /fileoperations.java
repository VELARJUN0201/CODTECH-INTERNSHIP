import java.io.*;

public class FileOperations {

    public static void main(String[] args) {
        String fileName = "TEXT.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Hello, this is a Java File Handling task.\n");
            writer.write("Internship Task 1 completed.");
            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nReading file:");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("\nFile modified successfully.");
            System.out.println("\nFile modified.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
