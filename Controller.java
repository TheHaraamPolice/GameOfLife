import java.util.*;
public class Controller {
    // Reference to the model object
    private Model model;

    // Reference to the view object
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // Method for initializing the game
    public void init() {
        // Create a Scanner object for reading input from the user
        Scanner input = new Scanner(System.in);

        // Prompt the user for the number of rows in the grid
        System.out.print("Enter the number of rows: ");
        int rows = input.nextInt();

        // Prompt the user for the number of columns in the grid
        System.out.print("Enter the number of columns: ");
        int cols = input.nextInt();

        // Prompt the user for the number of generations in the simulation
        System.out.print("Enter the number of generations: ");
        int generations = input.nextInt();

        // Prompt the user for the sleep time between generations
        System.out.print("Enter the sleep time between generations (in milliseconds): ");
        int sleepTime = input.nextInt();

        // Set the number of rows, columns, and generations
        model.setRows(rows);
        model.setCols(cols);
        model.setGenerations(generations);
        model.setSleepTime(sleepTime);
    }

    // Method for running the game
    public void run() {
        // Loop through the specified number of generations
        for (int i = 0; i < model.getGenerations(); i++) {
            // Update the grid for the next generation
            model.update();

            // Update the view to display the current state of the grid
            view.display();

            // Pause the simulation for the specified sleep time
            try {
                Thread.sleep(model.getSleepTime());
            } catch (Exception e) {
                System.out.print("Problem with sleep time");
            }
        }
    }
}