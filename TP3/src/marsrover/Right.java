package marsrover;

public class Right extends Command {

	public Right() {
		super('r');
	}
	
	public boolean canHandle(char command) {
		return value == command;
	}
	
	public void mover(MarsRover rover) {
		rover.modifyOrientation(rover.puntoCardinal.rotateRight());
	}
	
//	public Heading move(Heading direccion) {
//		return direccion.rotateRight();
//
//	}
}