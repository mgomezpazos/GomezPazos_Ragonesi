package marsrover;

public abstract class Heading {
	
	public char direction;

	public Heading(char direction) {
		this.direction = direction;
	}
	
	public abstract void isHeadingNorth();
	
	public abstract void isHeadingSouth();
	
	public abstract void isHeadingEast();
	
	public abstract void isHeadingWest();
//	public abstract void direcciones();


}