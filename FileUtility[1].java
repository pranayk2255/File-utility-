import java.io.*;
import java.util.*;

public class FileUtility {

    
    public static void writeToFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    
    public static void readFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

  
    public static void modifyFile(String filename, String oldWord, String newWord) {
        File file = new File(filename);
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line.replaceAll(oldWord, newWord)).append("\n");
            }

        } catch (IOException e) {
            System.out.println("Error reading file during modification: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content.toString());
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file during modification: " + e.getMessage());
        }
    }

   
    public static void main(String[] args) {
        String filename = "example.txt";

        
        writeToFile(filename, "Hello, this is a sample text file.\nThis file will be modified.");

     
        readFromFile(filename);

     
        modifyFile(filename, "sample", "demo");

       
        readFromFile(filename);
    }
}