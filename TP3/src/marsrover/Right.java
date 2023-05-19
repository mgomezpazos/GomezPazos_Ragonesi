package marsrover;

public class Right extends Command {

	public Right() {
		super('r');
	}

	public Heading move(Heading direccion) {
		return direccion.rotateRight();

	}
}