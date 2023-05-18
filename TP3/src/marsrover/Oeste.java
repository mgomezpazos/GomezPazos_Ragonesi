package marsrover;

public abstract class Oeste extends Heading{

	public Oeste(char direction) {
		super('O');
	}
	
	public void isHeadingWest() {
		if (move == 'f') {
			
			x -= 1;
		}
		else if (move == 'b') {
			x += 1;
		}
		else if (move == 'l') {
			puntoCardinal = 'S';
		}
		else if (move == 'r') {
			puntoCardinal = 'N';
		}
	}

}
