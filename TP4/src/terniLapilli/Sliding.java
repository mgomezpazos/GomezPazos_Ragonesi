package terniLapilli;

import java.util.Set;

public class Sliding extends GameStatus {

	public Player turno = new PlayerX();

	public void putXat(Position position, Set<Position> Xs, Set<Position> Os, Player turn) {
		throw new RuntimeException(Ternilapili.CannotPutPiecesOnlyMovingAllowed);

	}

	public void putOat(Position position, Set<Position> Xs, Set<Position> Os, Player turn) {
		throw new RuntimeException(Ternilapili.CannotPutPiecesOnlyMovingAllowed);

	}

	public void slideX(Position initialPosition, Position finalPosition, Set<Position> Xs, Set<Position> Os,
			Player turn) {
		if (!Xs.contains(initialPosition)) {
			throw new RuntimeException(Ternilapili.NoPieceAtInitialPosition);
		}
		if (Xs.contains(finalPosition)) {
			throw new RuntimeException(Ternilapili.ThatCellIsTaken);
		}
		if (Os.contains(finalPosition)) {
			throw new RuntimeException(Ternilapili.ThatCellIsTaken);
		}
		if ((finalPosition.row) > 3 || (finalPosition.column) > 3 && (finalPosition.row) < 0
				|| (finalPosition.column) < 0) {
			throw new RuntimeException(Ternilapili.PleaseCheckTheLimits);
		}
		if (Position.SlidingDistanceCalculator(initialPosition, finalPosition) != 1) {
			throw new RuntimeException(Ternilapili.ThisMoveIsNotValid);
		}
		Xs.remove(initialPosition);
		Xs.add(finalPosition);
		turno = turno.playsO();

	}

	public void slideO(Position initialPosition, Position finalPosition, Set<Position> Xs, Set<Position> Os,
			Player turn) {
		if (!Os.contains(initialPosition)) {
			throw new RuntimeException(Ternilapili.NoPieceAtInitialPosition);
		}

		if ((Os.contains(finalPosition)) || (Xs.contains(finalPosition))) {

			throw new RuntimeException(Ternilapili.ThatCellIsTaken);
		}
		if ((finalPosition.row) > 3 || (finalPosition.column) > 3 && (finalPosition.row) < 0
				|| (finalPosition.column) < 0) {
			throw new RuntimeException(Ternilapili.PleaseCheckTheLimits);
		}
		if (Position.SlidingDistanceCalculator(initialPosition, finalPosition) != 1) {
			throw new RuntimeException(Ternilapili.ThisMoveIsNotValid);
		}
		Os.remove(initialPosition);
		Os.add(finalPosition);
		turno = turno.playsX();
	}

}
