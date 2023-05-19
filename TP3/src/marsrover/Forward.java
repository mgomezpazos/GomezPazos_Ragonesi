package marsrover;

public class Forward extends Command {

	public Forward() {
		super('f');
	}

	public Location mover(Heading direccion) {
		return direccion.foward();
	}
}