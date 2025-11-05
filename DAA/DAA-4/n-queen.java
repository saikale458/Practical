public class NQueens {

    static int N = 4; // you can change for any N

    // Function to print board
    static void printBoard(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    // Function to check if placing queen is safe
    static boolean isSafe(int board[][], int row, int col) {
        int i, j;

        // Check this column on upper side
        for (i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        // Check upper-left diagonal
        for (i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check upper-right diagonal
        for (i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Solve N-Queen using recursion & backtracking
    static boolean solveNQ(int board[][], int row) {
        // Base case: all queens placed
        if (row == N) {
            printBoard(board);
            return true;
        }

        boolean res = false;

        // Try placing queen in all columns of this row
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1; // Place queen

                // Recurse for next row
                res = solveNQ(board, row + 1) || res;

                // Backtrack
                board[row][col] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        if (!solveNQ(board, 0))
            System.out.println("No solution exists");
    }
}
