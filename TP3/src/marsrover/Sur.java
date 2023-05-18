package marsrover;

public abstract class Sur extends Heading {

	public Sur(char direction) {
		super('S');
	}

	public void isHeadingSouth() {

		if (move == 'f') {
			y -= 1;
		} else if (move == 'b') {
			y += 1;
		} else if (move == 'l') {
			puntoCardinal = 'E';
		} else if (move == 'r') {
			puntoCardinal = 'O';
		}

	}
}