package marsrover;

public abstract class Command {

	public char value;

	public Command(char comando) {
		this.value = comando;
	}

	public abstract boolean canHandle(char comando);

	public abstract void mover(MarsRover rover);

	public static void moverse(char comando, MarsRover rover) {
		rover.commands.stream().filter(comand -> comand.canHandle(comando)).findFirst()
			 .orElseThrow(() -> new RuntimeException("Comando Inválido!")).mover(rover);
	}
}
