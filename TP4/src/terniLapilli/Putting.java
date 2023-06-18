package terniLapilli;
import java.util.Set;

public class Putting extends GameStatus {

	public Player turno = new PlayerX();
	
	public void putXat(Position position, Set<Position> Xs, Set<Position> Os, Player turn) {
		if (turno.isPlayingO()) {
			throw new RuntimeException(Ternilapili.NotYourTurn);
		}
		if (Xs.contains(position) ||(Os.contains(position))) {
			throw new RuntimeException(Ternilapili.ThatCellIsTaken);
		}
		if ((position.row) > 3 || (position.column) > 3 && (position.row) < 0 || (position.column) < 0) {
			throw new RuntimeException(Ternilapili.PleaseCheckTheLimits);
		}
		if (Xs.size() >= 3) {
			throw new RuntimeException(Ternilapili.NoPiecesLeft);
		}
		Xs.add(position);
		turno = turno.playsO();
	}

	public void putOat(Position position, Set<Position> Xs, Set<Position> Os, Player turn) {
		if (turno.isPlayingX()) {
			throw new RuntimeException(Ternilapili.NotYourTurn);
		}
		if (Xs.contains(position)||(Os.contains(position)) ) {
			throw new RuntimeException(Ternilapili.ThatCellIsTaken);
		}
		if ((position.row) > 3 || (position.column) > 3 && (position.row) < 0 || (position.column) < 0) {
			throw new RuntimeException(Ternilapili.PleaseCheckTheLimits);
		}
		if (Os.size() >= 3) {
			throw new RuntimeException(Ternilapili.NoPiecesLeft);
		}
		Os.add(position);
		turno = turno.playsX();
	}

	public void slideX(Position initialPosition, Position finalPosition, Set<Position> Xs, Set<Position> Os,Player turn) {
		throw new RuntimeException("No piece is placed at the inicial position");

	}

	public void slideO(Position initialPosition, Position finalPosition, Set<Position> Xs, Set<Position> Os,Player turn) {
		throw new RuntimeException("No piece is placed at the inicial position");

	}

}