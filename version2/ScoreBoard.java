/*
 * Name: QI YIN
 * BU ID: U31787103
 */

public class ScoreBoard {

	private int player1WinTimes = 0;
	private int player2WinTimes = 0;
	private int tieTimes = 0;
	private int totalTimes = 0;

	public int getPlayer1WinTimes() {
		return this.player1WinTimes;
	}

	public void setPlayer1WinTimes(int player1WinTimes) {
		this.player1WinTimes = player1WinTimes;
	}

	public int getPlayer2WinTimes() {
		return this.player2WinTimes;
	}

	public void setPlayer2WinTimes(int player2WinTimes) {
		this.player2WinTimes = player2WinTimes;
	}

	public int getTieTimes() {
		return this.tieTimes;
	}

	public void setTieTimes(int tieTimes) {
		this.tieTimes = tieTimes;
	}

	public int getTotalTimes() {
		return this.totalTimes;
	}

	public void setTotalTimes(int totalTimes) {
		this.totalTimes = totalTimes;
	}

	public void tieTimesGrow() {
		setTieTimes(tieTimes + 1);
	}

	public void player1WinTimesGrow() {
		setPlayer1WinTimes(player1WinTimes + 1);
	}

	public void play2WinTimesGrow() {
		setPlayer2WinTimes(player2WinTimes + 1);
	}

	public void totalTimesGrow() {
		setTotalTimes(totalTimes + 1);
	}

	public void printResults(Player player1, Player player2) {
		System.out.println("Final Scores:");
		System.out.println("Total: " + totalTimes + " game(s).");
		System.out.println("Player " + player1.getUsername() + " wins: " + player1WinTimes + " game(s).");
		System.out.println("Player " + player2.getUsername() + " wins: " + player2WinTimes + " game(s).");
		System.out.println("End in a tie:" + tieTimes + " game(s).");
	}

}
