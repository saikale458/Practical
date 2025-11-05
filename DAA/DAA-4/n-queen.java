import java.util.Scanner;

public class NQueens {
    private int size;
    private boolean[][] board;
    private int count;

    // Constructor
    public NQueens() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of chessboard: ");
        this.size = sc.nextInt();
        this.board = new boolean[size][size];
        this.count = 0;
    }

    // Print the board
    private void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] ? "Q " : "X ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if placing a queen at (row, col) is safe
    private boolean isSafe(int row, int col) {
        // Check column
        for (int i = 0; i < size; i++) {
            if (board[i][col]) return false;
        }

        // Check backward slash (\) diagonal - upward
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) return false;
        }

        // Check backward slash (\) diagonal - downward
        for (int i = row, j = col; i < size && j < size; i++, j++) {
            if (board[i][j]) return false;
        }

        // Check forward slash (/) diagonal - upward
        for (int i = row, j = col; i >= 0 && j < size; i--, j++) {
            if (board[i][j]) return false;
        }

        // Check forward slash (/) diagonal - downward
        for (int i = row, j = col; i < size && j >= 0; i++, j--) {
            if (board[i][j]) return false;
        }

        return true;
    }

    // Set the first queen manually
    private void setPositionFirstQueen(Scanner sc) {
        System.out.println("Enter coordinates of first queen: ");
        System.out.print("Enter row (1-" + size + "): ");
        int row = sc.nextInt();
        System.out.print("Enter column (1-" + size + "): ");
        int col = sc.nextInt();

        board[row - 1][col - 1] = true;
        printBoard();
    }

    // Recursive function to solve the N-Queens problem
    private void solve(int row) {
        if (row == size) {
            count++;
            printBoard();
            return;
        }

        // If there's already a queen in this row, skip to next
        for (int col = 0; col < size; col++) {
            if (board[row][col]) {
                solve(row + 1);
                return;
            }
        }

        // Try placing a queen in each column
        for (int col = 0; col < size; col++) {
            if (isSafe(row, col)) {
                board[row][col] = true;
                solve(row + 1);
                board[row][col] = false;
            }
        }
    }

    // Display final message
    private void displayMessage() {
        if (count > 0)
            System.out.println("Solution exists for the given position of the queen.");
        else
            System.out.println("Solution doesn't exist for the given position of the queen.");
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NQueens solver = new NQueens();
        solver.setPositionFirstQueen(sc);
        solver.solve(0);
        solver.displayMessage();
        sc.close();
    }
}
