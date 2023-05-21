package marsrover;

public class Norte extends Heading {

	public char orientation;

	public Norte() {
		orientation = 'N';
	}

	public Location foward() {
		return new Location(0, 1);
	}

	public Location backwards() {
		return new Location(0, -1);

	}

	public Heading rotateRight() {
		return new Este();
	}

	public Heading rotateLeft() {
		return new Oeste();
	}

}