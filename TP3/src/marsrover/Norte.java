package marsrover;

public abstract class Norte extends Heading {

	public Norte(char direction) {
		super('N');
	}
	
	public void isHeadingNorth() {
//		return (location.x, location.y+1, location.puntoCardinal);
		if (move == 'f') {
			Command.moveForward();
//			y += 1;
		}
		else if (move == 'b') {
			Command.moveBackwards();
//			y -= 1;
		}
		else if (move == 'l') {
			Command.rotateLeft();
//			puntoCardinal = 'O';
		}
		else if (move == 'r') {
			Command.rotateRight();
//			puntoCardinal = 'E';
		}
	}

}