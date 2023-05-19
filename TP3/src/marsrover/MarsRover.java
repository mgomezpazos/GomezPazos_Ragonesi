package marsrover;

public class MarsRover {

	public Location position;
	public String movimientos;
	public Heading puntoCardinal;

	public MarsRover(int x, int y, Heading puntoCardinal) {
		position = new Location(x, y);
		this.puntoCardinal = puntoCardinal;
	}

	public boolean checkCoordinates(Location location) {
		if (this.position.x == location.x && this.position.y == location.y) {
			return true;
		}
		return false;
	}

	public void modifyOrientation(Heading newPuntoCardinal) {
		this.puntoCardinal = newPuntoCardinal;
	}
}
