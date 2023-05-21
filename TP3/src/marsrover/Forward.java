package marsrover;

public class Forward extends Command {

	public Forward() {
		super('f');
	}

	public boolean canHandle(char command) {
		return value == command;
	}

	public void mover(MarsRover rover) {
		rover.position.modifyCoordinates(rover.puntoCardinal.foward());
	}
}