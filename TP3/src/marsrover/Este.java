package marsrover;

public class Este extends Heading {

	public char orientation;

	public Este() {
		orientation = 'E';
	}

	public Location foward() {
		return new Location(1, 0);
	}

	public Location backwards() {
		return new Location(-1, 0);

	}

	public Heading rotateRight() {
		return new Sur();
	}

	public Heading rotateLeft() {
		return new Norte();
	}

}
