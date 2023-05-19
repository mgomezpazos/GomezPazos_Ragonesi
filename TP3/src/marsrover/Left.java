package marsrover;

public class Left extends Command {

	public Left() {
		super('l');
	}

	public Heading move(Heading direccion) {
		return direccion.rotateLeft();
	}

}