/*
 * Name: QI YIN
 * BU ID: U31787103
 */

public class Marker {

	String marker;

	public Marker(String marker) {
		this.marker = marker;
	}

	public Marker() {
		this(" ");
	}

	public String getMarker() {
		return this.marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}

	public boolean isEqual(Marker marker) {
		return this.marker.equals(marker.getMarker());
	}
}
