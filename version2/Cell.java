/*
 * Name: QI YIN
 * BU ID: U31787103
 */

public class Cell {

	private int col;
	private int row;
	private Marker marker;

	public Cell(int col, int row, Marker marker) {
		this.col = col;
		this.row = row;
		this.marker = marker;
	}

	public Cell() {
		this(0, 0, new Marker(" "));
	}

	public int getCol() {
		return this.col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return this.row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public Marker getMarker() {
		return this.marker;
	}

	public void setMarker(Marker marker) {
		this.marker = marker;
	}
}
