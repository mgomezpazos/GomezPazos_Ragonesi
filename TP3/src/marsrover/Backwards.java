package marsrover;

public class Backwards extends Command {

	public Backwards() {
		super('b');
	}

	public boolean canHandle(char command) {
		return value == command;
	}

	public void mover(MarsRover rover) {
		rover.position.modifyCoordinates(rover.puntoCardinal.backwards());
	}
}