/*
 * Name: QI YIN
 * BU ID: U31787103
 */

public class Player {

	private String username;
	private Marker marker;

	public Player(String username, Marker marker) {
		this.username = username;
		this.marker = marker;
	}

	public Player() {
		this(" ", new Marker());
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Marker getMarker() {
		return this.marker;
	}

	public void setMarker(Marker marker) {
		this.marker = marker;
	}
}
