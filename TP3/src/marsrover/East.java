package marsrover;

public abstract class Este extends Heading{

	public Este(char direction) {
		super(direction);
	}

	@Override
	public void isHeadingEast() {
		if (move == 'f') {
			x += 1;
		}
		else if (move == 'b') {
			x -= 1;
		}
		else if (move == 'l') {
			puntoCardinal = 'N';
		}
		else if (move == 'r') {
			puntoCardinal = 'S';
		}
	}
}
