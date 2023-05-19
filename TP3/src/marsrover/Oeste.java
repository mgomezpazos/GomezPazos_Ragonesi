package marsrover;

public class Oeste extends Heading {

	public char orientacion;

	public Oeste() {
		orientacion = 'O';
	}

	public Location foward() {
		return new Location(-1, 0);
	}

	public Location backwards() {
		return new Location(1, 0);

	}

	public Heading rotateRight() {
		return new Norte();
	}

	public Heading rotateLeft() {
		return new Sur();
	}

}