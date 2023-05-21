package marsrover;

import java.util.ArrayList;
import java.util.List;

public class MarsRover {

	public Location position;
	public Command command;
	public Heading puntoCardinal;
	public char comando;

	public List<Command> commands = new ArrayList<>(List.of(new Forward(), new Backwards(), new Left(), new Right()));

	public MarsRover(int x, int y, Heading newpuntoCardinal) {
		position = new Location(x, y);
		puntoCardinal = newpuntoCardinal;
	}

	public boolean checkCoordinates(Location location) {
		if (this.position.x == location.x && this.position.y == location.y) {
			return true;
		}
		return false;
	}

	public Heading modifyOrientation(Heading newPuntoCardinal) {
		return puntoCardinal = newPuntoCardinal;
	}

	public void moveRover(String comandos) {
		for (int movimiento = 0; movimiento <= (comandos.length() - 1); movimiento++) {
			char comando = comandos.charAt(movimiento);
			Command.moverse(comando, this);
		}
	}

}
