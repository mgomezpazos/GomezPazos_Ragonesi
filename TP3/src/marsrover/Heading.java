package marsrover;

public abstract class Heading {
	
	public Heading() {}

	public abstract Location foward();

	public abstract Location backwards();

	public abstract Heading rotateRight();

	public abstract Heading rotateLeft();

}