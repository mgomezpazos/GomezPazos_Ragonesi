package marsrover;

public class Backwards extends Command{

	public Backwards() {
		super('b');
	}

	public Location mover(Heading direccion) {
		return direccion.backwards();
		}
}