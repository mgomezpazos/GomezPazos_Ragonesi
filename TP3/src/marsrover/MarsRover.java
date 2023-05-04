package marsrover;

public class MarsRover {

	private Point position;
	
	public MarsRover(Point initialPoint) {
		position = initialPoint;
	}
	
	public Point getPosition() {
		return position;
	}
	
	public boolean isHeadingNorth() {
		return true;
	}
	
	public void move(String string) {
		
	}
}
