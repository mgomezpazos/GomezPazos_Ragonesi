package marsrover;

public class Sur extends Heading {

	public char orientacion;

	public Sur() {
		orientacion = 'S';
	}

	public Location foward() {
		return new Location(0, -1);
	}

	public Location backwards() {
		return new Location(0, 1);
	}

	public Heading rotateRight() {
		return new Oeste();
	}

	public Heading rotateLeft() {
		return new Este();
	}

}