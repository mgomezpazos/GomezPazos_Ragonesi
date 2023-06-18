package terniLapilli;
import java.util.Set;

public class Over extends GameStatus {

	public static final String GameOver = "Game over";

	public boolean isWinnerX(Set<Position> Xs) {
		return XhasCompletedRow(Xs) || XhasCompletedColumn(Xs) || XhasCompletedDiagonal(Xs);
	}

	public boolean isWinnerO(Set<Position> Os) {
		return OhasCompletedRow(Os) || OhasCompletedColumn(Os) || OhasCompletedDiagonal(Os);
	}

	public boolean XhasCompletedRow(Set<Position> Xs) {
		for (int iteradorFilas = 0; iteradorFilas < 3; iteradorFilas++) {
			int filaObservable = iteradorFilas;
			int count = (int) Xs.stream().filter(p -> p.row == filaObservable).count();
			if (count == 3) {
				return true;
			}
		}
		return false;
	}

	public boolean OhasCompletedRow(Set<Position> Os) {
		for (int iteradorFilas = 0; iteradorFilas < 3; iteradorFilas++) {
			int filaObservable = iteradorFilas;
			int count = (int) Os.stream().filter(p -> p.row == filaObservable).count();
			if (count == 3) {
				return true;
			}
		}
		return false;
	}

	public boolean XhasCompletedColumn(Set<Position> Xs) {
		for (int iteradorColumnas = 0; iteradorColumnas < 3; iteradorColumnas++) {
			int columnaObservable = iteradorColumnas;
			int count = (int) Xs.stream().filter(p -> p.column == columnaObservable).count();
			if (count == 3) {
				return true;
			}
		}
		return false;
	}

	public boolean OhasCompletedColumn(Set<Position> Os) {
		for (int iteradorColumnas = 0; iteradorColumnas < 3; iteradorColumnas++) {
			int columnaObservable = iteradorColumnas;
			int count = (int) Os.stream().filter(p -> p.column == columnaObservable).count();
			if (count == 3) {
				return true;
			}
		}
		return false;
	}

	public boolean XhasCompletedDiagonal(Set<Position> Xs) {
		boolean diagonal1 = Xs.contains(new Position(0, 0)) && Xs.contains(new Position(1, 1))
				&& Xs.contains(new Position(2, 2));

		boolean diagonal2 = Xs.contains(new Position(0, 2)) && Xs.contains(new Position(1, 1))
				&& Xs.contains(new Position(2, 0));

		return diagonal1 || diagonal2;
	}

	public boolean OhasCompletedDiagonal(Set<Position> Os) {
		boolean diagonal1 = Os.contains(new Position(0, 0)) && Os.contains(new Position(1, 1))
				&& Os.contains(new Position(2, 2));

		boolean diagonal2 = Os.contains(new Position(0, 2)) && Os.contains(new Position(1, 1))
				&& Os.contains(new Position(2, 0));

		return diagonal1 || diagonal2;
	}

	public void putXat(Position position, Set<Position> Xs, Set<Position> Os, Player turn) {
		throw new RuntimeException(GameOver);
	}

	public void putOat(Position position, Set<Position> Xs, Set<Position> Os, Player turn) {
		throw new RuntimeException(GameOver);
	}

	public void slideX(Position initialPosition, Position finalPosition, Set<Position> Xs, Set<Position> Os,
			Player turn) {
		throw new RuntimeException(GameOver);
	}

	public void slideO(Position initialPosition, Position finalPosition, Set<Position> Xs, Set<Position> Os,
			Player turn) {
		throw new RuntimeException(GameOver);
	}

}