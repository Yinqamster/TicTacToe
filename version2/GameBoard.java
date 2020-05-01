/*
 * Name: QI YIN
 * BU ID: U31787103
 */

import java.util.Scanner;

public class GameBoard {

	private Cell[][] board;
	private int length = 0;

	public int getLength() {
		return this.length;
	}

	public void setLength(Scanner scan) {
		System.out.print("Please input the length of game board: ");
		length = scanLengthFromPlayer(scan);
		while (length == -1) {
			length = scanLengthFromPlayer(scan);
		}
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Cell getBoardCell(int row, int col) {
		return board[row][col];
	}

	public void initBoard(ScoreBoard scoreBoard) {
		scoreBoard.totalTimesGrow();

		board = new Cell[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				board[i][j] = new Cell(i, j, new Marker(String.valueOf(i * length + j + 1)));
			}
		}
	}

	public int getMaxLength() {
		return String.valueOf(length * length).length();
	}

	public void printLine() {
		for (int i = 0; i < length; i++) {
			System.out.print("+");
			for (int j = 0; j < getMaxLength(); j++) {
				System.out.print("-");
			}
		}
		System.out.print("+\n");
	}

	public void printSpace(int markerLength) {
		for (int i = 0; i < (getMaxLength() - markerLength); i++) {
			System.out.print(" ");
		}
	}

	public void printBoard() {
		for (int i = 0; i < length; i++) {
			printLine();
			for (int j = 0; j < length; j++) {
				System.out.print("|" + board[i][j].getMarker().getMarker());
				printSpace(board[i][j].getMarker().getMarker().length());
			}
			System.out.print("|\n");
		}
		printLine();
	}

	public int scanLengthFromPlayer(Scanner scan) {
		int number = 0;
		try {
			number = Integer.parseInt(scan.next());
			if (number < 3) {
				System.out.print("number must larger than 3, please enter again: ");
				return -1;
			}
		} catch (Exception e) {
			System.out.print("not a number, please enter again: ");
			return -1;
		}
		return number;
	}

	public int setMarker(Scanner scan, Player player) {
		int number = 0;
		try {
			number = Integer.parseInt(scan.next());
			if (number < 1 || number > (length * length)) {
				System.out.print("invalid location, please enter again: ");
				return -1;
			}
			int row = (number - 1) / length;
			int col = (number - 1) % length;
			if (!board[row][col].getMarker().getMarker().equals(String.valueOf(number))) {
				System.out.print("invalid location, please enter again: ");
				return -1;
			} else {
				board[row][col].setMarker(player.getMarker());
			}

		} catch (Exception e) {
			System.out.print("not a number, please enter again: ");
			return -1;
		}
		return number;
	}

	public void playGame(Player player, Scanner scan) {
		System.out.print(player.getUsername() + ", enter your move: ");
		int retResult = setMarker(scan, player);
		while (retResult == -1) {
			retResult = setMarker(scan, player);
		}
		printBoard();

	}

	public boolean anotherGame(Scanner scan, ScoreBoard scoreBoard) {
		System.out.println("Do you want to play another game? y/n:");
		String input = scan.next();
		while (true) {
			if (input.equalsIgnoreCase("y")) {
				initBoard(scoreBoard);
				printBoard();
				return true;
			} else if (input.equalsIgnoreCase("n")) {
				return false;
			} else {
				System.out.println("Input error, please choose y/n:");
				input = scan.next();
			}
		}
	}
}
