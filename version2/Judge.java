/*
 * Name: QI YIN
 * BU ID: U31787103
 */

public class Judge {

	private int totalSteps = 0;

	final private int winMarkers = 3;

	public boolean cellHasEqualMarkers(Cell c1, Cell c2) {
		return c1.getMarker().isEqual(c2.getMarker());
	}

	public boolean isWin(GameBoard gameBoard) {
		int len = gameBoard.getLength();
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				boolean rowWin = true;
				boolean colWin = true;
				boolean leftDiaWin = true;
				boolean rightDiaWin = true;

				for (int k = 1; k < winMarkers; k++) {
					rowWin = rowWin && j + k < len
							&& cellHasEqualMarkers(gameBoard.getBoardCell(i, j + k), gameBoard.getBoardCell(i, j));
					colWin = colWin && i + k < len
							&& cellHasEqualMarkers(gameBoard.getBoardCell(i + k, j), gameBoard.getBoardCell(i, j));
					leftDiaWin = leftDiaWin && i + k < len && j - k >= 0
							&& cellHasEqualMarkers(gameBoard.getBoardCell(i + k, j - k), gameBoard.getBoardCell(i, j));
					rightDiaWin = rightDiaWin && i + k < len && j + k < len
							&& cellHasEqualMarkers(gameBoard.getBoardCell(i + k, j + k), gameBoard.getBoardCell(i, j));
				}
				if (rowWin || colWin || leftDiaWin || rightDiaWin) {
					totalSteps = 0;
					return true;
				}

			}
		}
		return false;
	}

	public boolean isTie(int length) {
		totalSteps++;
		if (totalSteps == length * length) {
			totalSteps = 0;
			return true;
		}
		return false;
	}
}
