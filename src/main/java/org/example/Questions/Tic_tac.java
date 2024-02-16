package org.example.Questions;


import java.util.Scanner;

public class Tic_tac {
    private char[][] board;
    private char currentPlayerMark;

    public Tic_tac(int boardSize) {
        board = new char[boardSize][boardSize];
        currentPlayerMark = 'X';
        initializeBoard();
    }

    // Settinb board back to all empty values.
    private void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------------------");

        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------------------");
        }
    }

    //To Check if the board is full.
    boolean isBoardFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // Check if the given mark has won.
    boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    // Check the rows for a win.
    private boolean checkRowsForWin() {
        for (int i = 0; i < board.length; i++) {
            if (checkRowCol(board[i])) {
                return true;
            }
        }
        return false;
    }

    // Check the columns for a win.
    private boolean checkColumnsForWin() {
        for (int i = 0; i < board.length; i++) {
            char[] column = new char[board.length];
            for (int j = 0; j < board.length; j++) {
                column[j] = board[j][i];
            }
            if (checkRowCol(column)) {
                return true;
            }
        }
        return false;
    }

    // Check the diagonals for a win.
    private boolean checkDiagonalsForWin() {
        return (checkLeftDiagonal() || checkRightDiagonal());
    }

    // Check the left diagonal for a win.
    private boolean checkLeftDiagonal() {
        for (int i = 0; i < board.length - 1; i++) {
            if (board[i][i] == '-' || board[i][i] != board[i + 1][i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Check the right diagonal for a win.
    private boolean checkRightDiagonal() {
        for (int i = 0; i < board.length - 1; i++) {
            if (board[i][board.length - 1 - i] == '-' || board[i][board.length - 1 - i] != board[i + 1][board.length - 2 - i]) {
                return false;
            }
        }
        return true;
    }

    //we are Checking if all elements in the array are the same and not empty indicating a win.
    private boolean checkRowCol(char[] arr) {
        char first = arr[0];
        if (first == '-') {
            return false;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != first) {
                return false;
            }
        }
        return true;
    }

    // Change player marks back and forth.
    private void changePlayer() {
        currentPlayerMark = (currentPlayerMark == 'X') ? 'O' : 'X';
    }

   // to check whether we r placing at volid position
    public boolean placeMark(int row, int col) {
        if ((row >= 0) && (row < board.length) && (col >= 0) && (col < board[row].length) && (board[row][col] == '-')) {
            board[row][col] = currentPlayerMark;
            return true;
        }
        return false;
    }


    private boolean isDraw() {
        if (!checkForWin() && isBoardFull()) {
            return true;
        }
        return false;
    }

    // Method to start the game.
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        while (true) {
            printBoard();
            System.out.println("Player " + currentPlayerMark + ", enter your move (row[0-" + (board.length - 1) + "] col[0-" + (board.length - 1) + "]): ");
            row = scanner.nextInt();
            col = scanner.nextInt();

            if (placeMark(row, col)) {
                if (checkForWin()) {
                    printBoard();
                    System.out.println("Player " + currentPlayerMark + " wins!");
                    break;
                } else if (isDraw()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    break;
                } else {
                    changePlayer();
                }
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        int boardSize = 3;
        Tic_tac game = new Tic_tac(boardSize);
        game.startGame();
    }

    public char getCurrentPlayerMark() {
        return currentPlayerMark ;
    }
}


////// The time complexity for the code is O(n^2)