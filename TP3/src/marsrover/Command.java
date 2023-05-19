package marsrover;

public abstract class Command {

	public char comando;
	public MarsRover rover;

	public Command(char comando) {
		this.comando = comando; // BUSCAR UN MEJOR NOMBRE
	}

	public void moverse(String comandos) {
		for (int comando = 0; comando < comandos.length(); comando++) {
			if (comando != 'f' && comando != 'b' && comando != 'r' && comando != 'l') {
				throw new RuntimeException("Comando Inválido!");
			} else
				applyComandos(comandos, rover);
		}

	}

	private void applyComandos(String comandos, MarsRover rover) {
		for (int comando = 0; comando < comandos.length(); comando++) {

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
}