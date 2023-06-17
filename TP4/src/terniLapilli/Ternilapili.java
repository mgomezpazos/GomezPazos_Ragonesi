package terniLapilli;
import java.util.Set;
import java.util.HashSet;

public class Ternilapili {
	public static final String NoPiecesLeft = "You have no pieces left";
	public static final String PleaseCheckTheLimits = "Please check the limits";
	public static final String ThatCellIsTaken = "That cell is taken";
	public static final String NotYourTurn = "Not your turn";

	public GameStatus gameStatus;
	public Player turno = new PlayerX();

	public Set<Position> Xs;
	public Set<Position> Os;

	public Ternilapili() {
		Xs = new HashSet<>();
		Os = new HashSet<>();
	}

	public Set<Position> getXs() {
		return Xs;
	}

	public Set<Position> getOs() {
		return Os;
	}

	public void putXat(Position position) {
		if (turno.isPlayingO()) {
			throw new RuntimeException(NotYourTurn);
		}
		if (Xs.contains(position)) {
			throw new RuntimeException(ThatCellIsTaken);
		}
		if (Os.contains(position)) {
			throw new RuntimeException(ThatCellIsTaken);
		}
		if ((position.row) >= 3 || (position.column) >= 3 && (position.row) < 0 || (position.column) < 0) {
			throw new RuntimeException(PleaseCheckTheLimits);
		}
		if (Xs.size() >= 3) {
			throw new RuntimeException(NoPiecesLeft);
		}

		Xs.add(position);
//		turn = "O";
		turno = turno.playsO();

	}

	public void putOat(Position position) {
		if (turno.isPlayingX()) {
			throw new RuntimeException(NotYourTurn);
		}
		if (Xs.contains(position)) {
			throw new RuntimeException(ThatCellIsTaken);
		}
		if (Os.contains(position)) {
			throw new RuntimeException(ThatCellIsTaken);
		}
		if ((position.row) >= 3 || (position.column) >= 3 && (position.row) < 0 || (position.column) < 0) {
			throw new RuntimeException(PleaseCheckTheLimits);
		}
//		if (Os.size() >= 3) {
//			throw new RuntimeException("You cunt, you already have 3 pieces!");
//		}

		Os.add(position);
//		turn = "X";
		turno = turno.playsX();
	}

	public boolean isWinnerX() {
		return XhasCompletedRow() || XhasCompletedColumn() || XhasCompletedDiagonal();
	}

	public boolean isWinnerO() {
		return OhasCompletedRow() || OhasCompletedColumn() || OhasCompletedDiagonal();
	}

	public boolean XhasCompletedRow() {
		for (int iteradorFilas = 0; iteradorFilas < 3; iteradorFilas++) {
			int filaObservable = iteradorFilas;
			int count = (int) Xs.stream().filter(p -> p.row == filaObservable).count();
			if (count == 3) {
				return true;
			}
		}
		return false;
	}

	public boolean OhasCompletedRow() {
		for (int iteradorFilas = 0; iteradorFilas < 3; iteradorFilas++) {
			int filaObservable = iteradorFilas;
			int count = (int) Os.stream().filter(p -> p.row == filaObservable).count();
			if (count == 3) {
				return true;
			}
		}
		return false;
	}

	public boolean XhasCompletedColumn() {
		for (int iteradorColumnas = 0; iteradorColumnas < 3; iteradorColumnas++) {
			int columnaObservable = iteradorColumnas;
			int count = (int) Xs.stream().filter(p -> p.column == columnaObservable).count();
			if (count == 3) {
				return true;
			}
		}
		return false;
	}

	public boolean OhasCompletedColumn() {
		for (int iteradorColumnas = 0; iteradorColumnas < 3; iteradorColumnas++) {
			int columnaObservable = iteradorColumnas;
			int count = (int) Os.stream().filter(p -> p.column == columnaObservable).count();
			if (count == 3) {
				return true;
			}
		}
		return false;
	}

	public boolean XhasCompletedDiagonal() {
		boolean diagonal1 = Xs.contains(new Position(0, 0)) && Xs.contains(new Position(1, 1))
				&& Xs.contains(new Position(2, 2));

		boolean diagonal2 = Xs.contains(new Position(0, 2)) && Xs.contains(new Position(1, 1))
				&& Xs.contains(new Position(2, 0));

		return diagonal1 || diagonal2;
	}

	public boolean OhasCompletedDiagonal() {
		boolean diagonal1 = Os.contains(new Position(0, 0)) && Os.contains(new Position(1, 1))
				&& Os.contains(new Position(2, 2));

		boolean diagonal2 = Os.contains(new Position(0, 2)) && Os.contains(new Position(1, 1))
				&& Os.contains(new Position(2, 0));

		return diagonal1 || diagonal2;
	}
	
	public boolean isEmpty() {
		return (Xs.size() == 0) && (Os.size() == 0);
	}
}