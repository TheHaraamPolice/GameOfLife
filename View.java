public class View {
    // Reference to the model object
    private Model model;

    public View(Model model) {
        this.model = model;
    }

    // Method for displaying the current state of the game
    public void display() {
        // Get the number of rows and columns in the grid
        int rows = model.getRows();
        int cols = model.getCols();

        // Loop through each row in the grid
        for (int r = 0; r < rows; r++) {
            // Loop through each column in the grid
            for (int c = 0; c < cols; c++) {
                // If the current cell is alive, print the live character
                if (model.display()[r][c] == 1) {
                    System.out.print(Model.LIVE_CHAR);
                }
                // If the current cell is dead, print the delimiter character
                else {
                    System.out.print(Model.DELIMITER_CHAR);
                }
            }
            // After each row, print a newline character
            System.out.println();
        }
        // After the grid is printed, print another newline character
        System.out.println();
    }
}