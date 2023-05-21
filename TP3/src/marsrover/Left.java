package marsrover;

public class Left extends Command {

	public Left() {
		super('l');
	}

	public boolean canHandle(char command) {
		return value == command;
	}

	public void mover(MarsRover rover) {
		rover.modifyOrientation(rover.puntoCardinal.rotateLeft());
	}
}