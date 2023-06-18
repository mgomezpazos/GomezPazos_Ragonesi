package terniLapilli;

import java.util.Set;

public class Sliding extends GameStatus{

	public void putXat(Position position, Set<Position> Xs, Set<Position> Os, Player turn) {
		throw new RuntimeException("Cannot put pieces, only moving allowed");
		
	}

	public void putOat(Position position, Set<Position> Xs, Set<Position> Os, Player turn) {
		throw new RuntimeException("Cannot put pieces, only moving allowed");
		
	}

	public void slideX(Position initialPosition, Position finalPosition, Set<Position> Xs, Set<Position> Os,Player turn) {
		if (!Xs.contains(initialPosition)) {
			throw new RuntimeException(Ternilapili.NoPieceAtInitialPosition);
		}
		if (Xs.contains(finalPosition)) {
			throw new RuntimeException(Ternilapili.ThatCellIsTaken);
		}
		if (Os.contains(finalPosition)){
			throw new RuntimeException(Ternilapili.ThatCellIsTaken);
		}
		Xs.remove(initialPosition);
		Xs.add(finalPosition);
		
	}

	public void slideO(Position initialPosition, Position finalPosition, Set<Position> Xs, Set<Position> Os,Player turn) {
		if (!Os.contains(initialPosition)) {
			throw new RuntimeException(Ternilapili.NoPieceAtInitialPosition);
		}

		if (Os.contains(finalPosition)) {
			throw new RuntimeException(Ternilapili.ThatCellIsTaken);
		}
		Os.remove(initialPosition);
		Os.add(finalPosition);
		
	}

}
