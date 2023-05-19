package marsrover;

public abstract class Command {

	public char comando;

	public Command(char comando) {
		this.comando = comando; // BUSCAR UN MEJOR NOMBRE
	}

	public static void moverse(char comando, MarsRover rover ) {
			if (comando != 'f' && comando != 'b' && comando != 'r' && comando != 'l') {
				throw new RuntimeException("Comando Inválido!");
			} else
				applyComandos(comando, rover);
		

	}

	private static void applyComandos(char comando, MarsRover rover) {
			if (comando == 'f') {
				rover.position.modifyCoordinates(new Forward().mover(rover.puntoCardinal));
			} else if (comando == 'b') {
				rover.position.modifyCoordinates(new Backwards().mover(rover.puntoCardinal));
			} else if (comando == 'r') {
				rover.modifyOrientation(new Right().move(rover.puntoCardinal));
			} else if (comando == 'l') {
				rover.modifyOrientation(new Left().move(rover.puntoCardinal));
			}

		}
}