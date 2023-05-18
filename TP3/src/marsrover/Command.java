package marsrover;

public abstract class Command {

	public char comando;

	public Command(char comando) {
		this.comando = comando;
	}
	
	public void commands() {
		
		if (move == 'f') {
			if (puntoCardinal == 'N') {
				y += 1; //cambiar esto por un vector con el par de coordenadas y el puntoCardinal
			}
			else if(puntoCardinal == 'S') {
				y -= 1;
			}
			else if(puntoCardinal == 'E') {
				x += 1;
			}
			else if(puntoCardinal == 'O') {
				x -= 1;
			}}
		else if(move == 'b') {
			if (puntoCardinal == 'N') {
				y -= 1; //cambiar esto por un vector con el par de coordenadas y el puntoCardinal
			}
			else if(puntoCardinal == 'S') {
				y += 1;
			}
			else if(puntoCardinal == 'E') {
				x -= 1;
			}
			else if(puntoCardinal == 'O') {
				x += 1;
			}
			}
		else if(move == 'l') {
			if (puntoCardinal == 'N') {
				puntoCardinal = 'O'; //cambiar esto por un vector con el par de coordenadas y el puntoCardinal
			}
			else if(puntoCardinal == 'S') {
				puntoCardinal = 'E';
			}
			else if(puntoCardinal == 'E') {
				puntoCardinal = 'N';
			}
			else if(puntoCardinal == 'O') {
				puntoCardinal = 'S';
			}
			}
		else if(move == 'r') {
			if (puntoCardinal == 'N') {
				puntoCardinal = 'E'; //cambiar esto por un vector con el par de coordenadas y el puntoCardinal
			}
			else if(puntoCardinal == 'S') {
				puntoCardinal = 'O';
			}
			else if(puntoCardinal == 'E') {
				puntoCardinal = 'S';
			}
			else if(puntoCardinal == 'O') {
				puntoCardinal = 'N';
			}
			}
		
	}

	public abstract void moveForward();

	public abstract void moveBackwards();
	
	public abstract void rotateLeft();
	
	public abstract void rotateRight();
}