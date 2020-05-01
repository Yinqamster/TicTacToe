/*
 * Name: QI YIN
 * BU ID: U31787103
 */

import java.util.Scanner;

public class TicTacToe {

	public static void init() {
		System.out.println("Welcome to Tic Tac Toe!");
		// References:
		// https://www.exploratorium.edu/brain_explorer/tictactoe.html
		System.out.println("Game Rules:");
		System.out.println("1. The game is played on a grid that's n squares by n squares.");
		System.out.println(
				"2. Two players' markers are o and x, and player o plays first. Players take turns putting their marks in empty squares.");
		System.out.println(
				"3. The first player to get 3 of his/her marks in a row (up, down, across, or diagonally) is the winner.");
		System.out.println(
				"4. When all squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie.");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		Scanner scan = new Scanner(System.in);
		Judge judge = new Judge();
		ScoreBoard scoreBoard = new ScoreBoard();

		Player player1 = new Player();
		Player player2 = new Player();
		Marker markerO = new Marker("o");
		Marker markerX = new Marker("x");
		System.out.print("Player 1 first, marker is " + markerO.getMarker() + ", please input name: ");
		player1.setUsername(scan.next());
		player1.setMarker(markerO);
		System.out.print("Player 2, marker is " + markerX.getMarker() + ", please input name: ");
		player2.setUsername(scan.next());
		player2.setMarker(markerX);

		GameBoard gameBoard = new GameBoard();
		gameBoard.setLength(scan);
		gameBoard.initBoard(scoreBoard);
		gameBoard.printBoard();

		while (true) {
			gameBoard.playGame(player1, scan);
			if (judge.isTie(gameBoard.getLength())) {
				scoreBoard.tieTimesGrow();
				System.out.println("The game ended in a tie!!");
				if (!gameBoard.anotherGame(scan, scoreBoard)) {
					break;
				} else {
					continue;
				}
			}
			if (judge.isWin(gameBoard)) {
				scoreBoard.player1WinTimesGrow();
				System.out.println(player1.getUsername() + " is winner!!");
				if (!gameBoard.anotherGame(scan, scoreBoard)) {
					break;
				} else {
					continue;
				}
			}

			gameBoard.playGame(player2, scan);
			if (judge.isTie(gameBoard.getLength())) {
				scoreBoard.tieTimesGrow();
				System.out.println("The game ended in a tie!!");
				if (!gameBoard.anotherGame(scan, scoreBoard)) {
					break;
				} else {
					continue;
				}
			}
			if (judge.isWin(gameBoard)) {
				scoreBoard.play2WinTimesGrow();
				System.out.println(player2.getUsername() + " is winner!!");
				if (!gameBoard.anotherGame(scan, scoreBoard)) {
					break;
				} else {
					continue;
				}
			}
		}
		scoreBoard.printResults(player1, player2);
	}
}
