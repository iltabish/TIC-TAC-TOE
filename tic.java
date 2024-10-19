import java.util.Scanner;

public class TicTacToeChallenge {
    private static char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;
        
        System.out.println("Tic Tac Toe Challenge!");
        printBoard();

        while (!gameEnded) {
            // Player input
            System.out.println("Player " + currentPlayer + "'s turn. Enter row and column (1-3): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            // Check if the move is valid
            if (row < 0 || col < 0 || row >= 3 || col >= 3 || board[row][col] != ' ') {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            // Place the move
            board[row][col] = currentPlayer;
            printBoard();

            // Check for a winner or draw
            if (checkWinner()) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (checkDraw()) {
                System.out.println("The game is a draw!");
                gameEnded = true;
            } else {
                // Switch the current player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
        scanner.close();
    }

    // Print the game board
    private static void printBoard() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    // Check for a winner
    private static boolean checkWinner() {
        // Check rows, columns, and diagonals
        return (checkRowCol(board[0][0], board[0][1], board[0][2]) || // Row 1
                checkRowCol(board[1][0], board[1][1], board[1][2]) || // Row 2
                checkRowCol(board[2][0], board[2][1], board[2][2]) || // Row 3
                checkRowCol(board[0][0], board[1][0], board[2][0]) || // Column 1
                checkRowCol(board[0][1], board[1][1], board[2][1]) || // Column 2
                checkRowCol(board[0][2], board[1][2], board[2][2]) || // Column 3
                checkRowCol(board[0][0], board[1][1], board[2][2]) || // Diagonal 1
                checkRowCol(board[0][2], board[1][1], board[2][0]));  // Diagonal 2
    }

    // Helper method to check rows, columns, or diagonals
    private static boolean checkRowCol(char c1, char c2, char c3) {
        return (c1 != ' ' && c1 == c2 && c2 == c3);
    }

    // Check for a draw
    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
