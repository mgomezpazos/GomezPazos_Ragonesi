package marsrover;

public class Location {

	public int x;
	public int y;
	public char puntoCardinal;

	public Location(int x, int y, char puntoCardinal) {
		this.x = x;
		this.y = y;
		this.puntoCardinal = puntoCardinal;
	}

	@Override //
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Location other = (Location) obj;
		return x == other.x && y == other.y && puntoCardinal == other.puntoCardinal;

	}
	
	public boolean areCoordinatesEqual(Location location) {
		if (this.x == location.x && this.y == location.y && this.puntoCardinal == location.puntoCardinal) {
				return true;
		}
				return false; 
	}
	
	public void comandos(String movimientos) {
		for (int comando = 0; comando < movimientos.length(); comando++) {
			char move = movimientos.charAt(comando);

			if (move != 'f' && move != 'b' && move != 'l' && move != 'r') {
				throw new RuntimeException("Comando inválido: " + move);
			}
			
			else if (puntoCardinal == 'N') {
				if (move == 'f') {
					y += 1;
				}
				else if (move == 'b') {
					y -= 1;
				}
				else if (move == 'l') {
					puntoCardinal = 'O';
				}
				else if (move == 'r') {
					puntoCardinal = 'E';
				}
			}

			else if (puntoCardinal == 'S') {

			 if (move == 'f') {
					y -= 1;
				}
			 else if (move == 'b') {
					y += 1;
				}
			 else if (move == 'l') {
					puntoCardinal = 'E';
				}
			else if (move == 'r') {
					puntoCardinal = 'O';
				}
			}

			else if (puntoCardinal == 'E') {

				if (move == 'f') {
					x += 1;
				}
				else if (move == 'b') {
					x -= 1;
				}
				else if (move == 'l') {
					puntoCardinal = 'N';
				}
				else if (move == 'r') {
					puntoCardinal = 'S';
				}
			}

			else if (puntoCardinal == 'O') {

				if (move == 'f') {
					x -= 1;
				}
				else if (move == 'b') {
					x += 1;
				}
				else if (move == 'l') {
					puntoCardinal = 'S';
				}
				else if (move == 'r') {
					puntoCardinal = 'N';
				}
			}

		}
	}
}