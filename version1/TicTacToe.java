import java.util.Scanner;

/*
 * Name: QI YIN
 * BUID: U31787103
 */

public class TicTacToe {
	
	String[] board = new String[9];
	int playerOWinTimes = 0;
	int playerXWinTimes = 0;
	int tieTimes = 0;
	int totalTimes = 0;
	
	private void init() {
		System.out.println("Welcome to Tic Tac Toe!");
		//References: https://www.exploratorium.edu/brain_explorer/tictactoe.html
		System.out.println("Game Rules:");
		System.out.println("1. The game is played on a grid that's 3 squares by 3 squares.");
		System.out.println("2. Two players are o and x, and player o plays first. Players take turns putting their marks in empty squares.");
		System.out.println("3. The first player to get 3 of his/her marks in a row (up, down, across, or diagonally) is the winner.");
		System.out.println("4. When all 9 squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie.");
		
	}
	
	private void initBoard() {
		totalTimes++;
		for(int i = 0; i < 9; i++) {
			board[i] = String.valueOf(i+1);
		}
		
	}
	
	private void printBoard() {
		for(int i = 0; i < 9; i+=3) {
			System.out.println("+--+--+--+");
			for(int j=i; j<i+3; j++) {
				System.out.print("|" + board[j] + " ");
			}
			
			System.out.print("|\n");
			
		}
		System.out.println("+--+--+--+");
	}
	
	private int scanFromPlayer(int player, Scanner scan) {
		int location = 0;
		try{
			location = Integer.parseInt(scan.nextLine());
		} catch(Exception e) {
			System.out.println("not a number, please enter again: ");
			return -1;
		}
		if(location < 1 || location > 9 || board[location-1].equals("o") || board[location-1].equals("x")) {
			System.out.println("wrong location, please enter again: ");
			return -1;
		}
		if(player == 1) {
			board[location-1] = "o";
		}
		else if(player == 2) {
			
			board[location-1] = "x";
		}
		
		return 0;
	}
	
	private boolean win() {
		if((board[0].equals(board[1]) && board[1].equals(board[2]))
				||(board[3].equals(board[4]) && board[4].equals(board[5]))
				||(board[6].equals(board[7]) && board[7].equals(board[8]))
				||(board[0].equals(board[3]) && board[3].equals(board[6]))
				||(board[1].equals(board[4]) && board[4].equals(board[7]))
				||(board[2].equals(board[5]) && board[5].equals(board[8]))
				||(board[0].equals(board[4]) && board[4].equals(board[8]))
				||(board[2].equals(board[4]) && board[4].equals(board[6]))) {
			return true;
		}
		return false;
	}
	
	private boolean tie() {
		for(int i = 0; i < 9; i++) {
			if(!board[i].equals("o") && !board[i].equals("x")) {
				return false;
			}
		}
		return true;
	}
	
	public boolean anotherGame(Scanner scan) {
		System.out.println("Do you want to play another game? y/n:");
		String input = scan.next();
		while(true) {
			if(input.equalsIgnoreCase("y")) {
				initBoard();
				printBoard();
				return true;
			}
			else if(input.equalsIgnoreCase("n")) {
				return false;
			}
			else {
				System.out.println("Input error, please choose y/n:");
				input = scan.next();
			}
		}
	}
	
	private void printResults() {
		System.out.println("Final Results:");
		System.out.println("Total: " + totalTimes + " games");
		System.out.println("Player o win: " + playerOWinTimes + " games");
		System.out.println("Player x win: " + playerXWinTimes + " games");
		System.out.println("End in a tie:" + tieTimes + " games");
	}
	
	
	public static void main(String args[]) {
		TicTacToe t = new TicTacToe();
		t.init();
		int player1 = 1;
		int player2 = 2;
		t.initBoard();
		t.printBoard();
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("Player o enter your move: ");
			int retResult = t.scanFromPlayer(player1, scan);
			while(retResult == -1) {
				retResult = t.scanFromPlayer(player1, scan);
			}
			t.printBoard();
			if(t.win()) {
				t.playerOWinTimes++;
				System.out.println("Player o is winner!!");
				if(!t.anotherGame(scan)) {
					break;
				}
				else{
					continue;
				}
				
			}
			if(t.tie()) {
				t.tieTimes++;
				System.out.println("The game ended in a tie!!");
				if(!t.anotherGame(scan)) {
					break;
				}
				else{
					continue;
				}
			}
			
			
			System.out.println("Player x enter your move: ");
			retResult = t.scanFromPlayer(player2, scan);
			while(retResult == -1) {
				retResult = t.scanFromPlayer(player2, scan);
			}
			t.printBoard();
			if(t.win()) {
				t.playerXWinTimes++;
				System.out.println("Player x is winner!!");
				if(!t.anotherGame(scan)) {
					break;
				}
				else{
					continue;
				}
			}
		}
		
		t.printResults();
	}
}
