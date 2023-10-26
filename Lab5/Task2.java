package Lab5;

import java.util.Random;
import java.util.Scanner;

public class Task2 {
	private static final char EMPTY = ' ';
	private char[][] board;
	private char currentPlayer;
	private Random random;

	public Task2() {
		board = new char[3][3];
		currentPlayer = 'X';
		random = new Random();
		initializeBoard();
	}

	private void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = EMPTY;
			}
		}
	}

	private void printBoard() {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println("\n-------------");
		}
	}

	private boolean isValidMove(int row, int col) {
		if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != EMPTY) {
			return false;
		}
		return true;
	}

	private void makeMove(int row, int col) {
		board[row][col] = currentPlayer;
	}

	private boolean checkWin() {
		/*
		 * This method checks all rows and returns true if any of them are marked with
		 * all of a single player's markers. Otherwise, returns false.
		 */
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
				return true; // check rows
			}

			/*
			 * This method checks all columns and returns true if any of them are marked
			 * with all of a single player's markers. Otherwise, returns false
			 */
			if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
				return true; // check columns
			}
		}

		/*
		 * This method checks both diagonals and returns true if any of them are marked
		 * with all of a single player's markers. Otherwise, returns false
		 */
		if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
			return true; // Check top-left to bottom-right
		}
		if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
			return true; // Check bottom-left to top-right
		}
		return false;
	}

	private boolean isBoardFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == EMPTY) {
					return false;
				}
			}
		}
		return true;
	}

	private void computerMove() {
		int row, col;
		do {
			row = random.nextInt(3);
			col = random.nextInt(3);
		} while (!isValidMove(row, col));

		makeMove(row, col);
	}

	public void play() {
		Scanner scanner = new Scanner(System.in);
		boolean gameFinished = false;

		System.out.println("Welcome to Tic-Tac-Toe!");

		while (!gameFinished) {
			printBoard();
			if (currentPlayer == 'X') {
				System.out.println("Player X, enter your move (row and column):");
				int row = scanner.nextInt();
				int col = scanner.nextInt();

				if (isValidMove(row, col)) {
					makeMove(row, col);

					if (checkWin()) {
						printBoard();
						System.out.println("Player X wins!");
						gameFinished = true;
					} else if (isBoardFull()) {
						printBoard();
						System.out.println("It's a draw!");
						gameFinished = true;
					}
				} else {
					System.out.println("Invalid move. Try again.");
				}
			} else {
				System.out.println("Computer's turn (O):");
				computerMove();

				if (checkWin()) {
					printBoard();
					System.out.println("Computer (O) wins!");
					gameFinished = true;
				} else if (isBoardFull()) {
					printBoard();
					System.out.println("It's a draw!");
					gameFinished = true;
				}
			}
			currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
		}

		scanner.close();
	}

	public static void main(String[] args) {
		Task2 game = new Task2();
		game.play();
	}

}
