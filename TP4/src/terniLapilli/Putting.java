package terniLapilli;
import java.util.Set;

public class Putting extends GameStatus {

	public Player turno = new PlayerX();
	
	public void putXat(Position position, Set<Position> Xs, Set<Position> Os, Player turn) {
		if (turno.isPlayingX()) {
			throw new RuntimeException(Ternilapili.NotYourTurn);
		}
		if (Xs.contains(position)) {
			throw new RuntimeException(Ternilapili.ThatCellIsTaken);
		}
		if (Os.contains(position)) {
			throw new RuntimeException(Ternilapili.ThatCellIsTaken);
		}
		if ((position.row) >= 3 || (position.column) >= 3 && (position.row) < 0 || (position.column) < 0) {
			throw new RuntimeException(Ternilapili.PleaseCheckTheLimits);
		}
		if (Xs.size() >= 3) {
			throw new RuntimeException(Ternilapili.NoPiecesLeft);
		}

		Xs.add(position);
//		turn = "O";
		turno = turno.playsX();
	}

	public void putOat(Position position, Set<Position> Xs, Set<Position> Os, Player turn) {
		if (turno.isPlayingO()) {
			throw new RuntimeException(Ternilapili.NotYourTurn);
		}
		if (Xs.contains(position)) {
			throw new RuntimeException(Ternilapili.ThatCellIsTaken);
		}
		if (Os.contains(position)) {
			throw new RuntimeException(Ternilapili.ThatCellIsTaken);
		}
//		if (Os.size() >= 3) {
//			throw new RuntimeException("You cunt, you already have 3 pieces!");
//		}

		Os.add(position);
//		turn = "X";
		turno = turno.playsO();
	}

	public void movePiece(Position inicialPosition, Position finalPosition) {

	}

	public void moveX(Position initialPosition, Position finalPosition, Set<Position> Xs, Set<Position> Os,Player turn) {

	}

	public void moveO(Position initialPosition, Position finalPosition, Set<Position> Xs, Set<Position> Os,Player turn) {

	}

}