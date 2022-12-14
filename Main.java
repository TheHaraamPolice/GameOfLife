import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Initialize model, view, and controller
        Model model = new Model();
        model.randomize();
        View view = new View(model);
        Controller controller = new Controller(model, view);

        // Create a File object for the directory
        File directoryPath = new File("/Users/bilal/Downloads/IntelliJ Work/GOL/GOL/files");
        // Get a list of all the files in the directory
        String[] contents = directoryPath.list();
        // Iterate over the list of files
        for (String fileName: contents) {
            // Read patterns from file
            try {
                File file = new File("/Users/bilal/Downloads/IntelliJ Work/GOL/GOL/files/" + fileName);
                Scanner patternScanner = new Scanner(file);
               //  System.out.println(file); //Test line
                while (patternScanner.hasNextLine()) {
                    String line = patternScanner.nextLine();
                    String[] patternRows = line.split(","); // Assume patterns are delimited by commas
                    String[][] pattern = new String[patternRows.length][];
                    for (int i = 0; i < patternRows.length; i++) {
                        String[] row = patternRows[i].split(",");
                        pattern[i] = row;
                    }
                    model.addPattern(pattern);
                }
            } catch (FileNotFoundException e) {
                System.err.println("Error: Could not find file " + fileName);
            }


        }
        controller.init();
        controller.run();
    }
}