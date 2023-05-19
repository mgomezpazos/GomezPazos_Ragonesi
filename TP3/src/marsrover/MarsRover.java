package marsrover;

public class MarsRover {

	public Location position;
	public Command command;
	public Heading puntoCardinal;
	public char comando;

	public MarsRover(int x, int y, Heading puntoCardinal) {
		position = new Location(x, y);
		this.puntoCardinal = puntoCardinal;
	}

	public boolean checkCoordinates(Location location) {
		if (this.position.x == location.x && this.position.y == location.y) {
			return true;
		}
		return false;
	}

	public void modifyOrientation(Heading newPuntoCardinal) {
		this.puntoCardinal = newPuntoCardinal;
	}
	
	public void moveRover(String comandos) {
		for (int movimiento = 0; movimiento < comandos.length(); movimiento++) {
			char comando = comandos.charAt(movimiento);
			Command.moverse(comando, this);
	}
	}
	
	}
