import java.util.*;
public class Model {
    // Constants for delimiter characters
    public static final char DELIMITER_CHAR = '-';
    public static final char LIVE_CHAR = 'X';

    // 2D array representing the current state of the simulation
    private int[][] grid;

    // List of possible patterns that can be added to the grid
    private List <int[][]> patterns;

    // Parameters for the simulation
    private int rows;
    private int cols;
    private int generations;
    private int sleepTime;

    public Model() {
        patterns = new ArrayList<>();
        // Initialize grid here
        grid = new int[rows][cols];
    }

    // Method for adding a pattern to the list of possible patterns
    public void addPattern(String[][] pattern) {
        // Create a new 2D array for the pattern
        int[][] patternArray = new int[pattern.length][];
        for (int i = 0; i < pattern.length; i++) {
            patternArray[i] = new int[pattern[i].length];
            for (int j = 0; j < pattern[i].length; j++) {
                try {
                    patternArray[i][j] = Integer.parseInt(pattern[i][j]);
                } catch (NumberFormatException e) {
                    // Skip any elements that cannot be parsed as integers
                    continue;
                }
            }
        }
        // Add the new pattern to the list of patterns
        patterns.add(patternArray);
    }

    // Method for setting the number of rows in the grid
    public void setRows(int rows) {
        this.rows = rows;
        grid = new int[rows][cols];
    }

    // Method for setting the number of columns in the grid
    public void setCols(int cols) {
        this.cols = cols;
        grid = new int[rows][cols];
    }

    // Method for setting the number of generations in the simulation
    public void setGenerations(int generations) {
        this.generations = generations;
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getGenerations() {
        return generations;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public void update() {
        int[][] newGrid = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int liveNeighbors = getLiveNeighbors(r, c);

                if (grid[r][c] == 1 && (liveNeighbors == 2 || liveNeighbors == 3)) {
                    newGrid[r][c] = 1;
                } else if (grid[r][c] == 0 && liveNeighbors == 3) {
                    newGrid[r][c] = 1;
                } else {
                    newGrid[r][c] = 0;
                }
            }
        }
        // Assign the newGrid field to the grid field
        grid = newGrid;
    }


    public int getLiveNeighbors(int row, int col) {
        // Initialize the count of live neighbors to 0
        int liveNeighbors = 0;

        // Check the top-left neighbor
        if (row > 0 && col > 0 && grid[row - 1][col - 1] == 1) {
            liveNeighbors++;
        }

        // Check the top neighbor
        if (row > 0 && grid[row - 1][col] == 1) {
            liveNeighbors++;
        }

        // Check the top-right neighbor
        if (row > 0 && col < cols - 1 && grid[row - 1][col + 1] == 1) {
            liveNeighbors++;
        }

        // Check the left neighbor
        if (col > 0 && grid[row][col - 1] == 1) {
            liveNeighbors++;
        }

        // Check the right neighbor
        if (col < cols - 1 && grid[row][col + 1] == 1) {
            liveNeighbors++;
        }

        // Check the bottom-left neighbor
        if (row < rows - 1 && col > 0 && grid[row + 1][col - 1] == 1) {
            liveNeighbors++;
        }

        // Check the bottom neighbor
        if (row < rows - 1 && grid[row + 1][col] == 1) {
            liveNeighbors++;
        }

        // Check the bottom-right neighbor
        if (row < rows - 1 && col < cols - 1 && grid[row + 1][col + 1] == 1) {
            liveNeighbors++;
        }

        // Return the number of live neighbors
        return liveNeighbors;
    }

    public void randomize() {
        Random random = new Random();
        // Loop through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Set the cell to either live or dead, with a 50% chance of each
                grid[i][j] = random.nextBoolean() ? 1 : 0;
            }
        }
    }

    public int[][] display() {
        return grid;
    }
}