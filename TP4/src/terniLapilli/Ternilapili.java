package terniLapilli;
import java.util.Set;
import java.util.HashSet;

public class Ternilapili {
	public static final String NoPiecesLeft = "You have no pieces left";
	public static final String PleaseCheckTheLimits = "Please check the limits";
	public static final String ThatCellIsTaken = "That cell is taken";
	public static final String NotYourTurn = "Not your turn";
	public static final String NoPieceAtInitialPosition = "No piece is placed at the inicial position";

	public GameStatus gameStatus;
	public Player turno = new PlayerX();

	public Set<Position> Xs;
	public Set<Position> Os;

	public Ternilapili() {
		Xs = new HashSet<>();
		Os = new HashSet<>();
		gameStatus = new Putting();
	}

	public Set<Position> getXs() {
		return Xs;
	}

	public Set<Position> getOs() {
		return Os;
	}

	public GameStatus statusSetter() {
		if ((Os.size() == 3 && Xs.size()== 3)&&(!(isWinnerX()|| isWinnerO()))) {
			return gameStatus = new Sliding();
		}
		if ((isWinnerO() || isWinnerX())&& (Os.size() == 3 && Xs.size()== 3)) {
			return gameStatus = new Over();
		}
		return gameStatus;

	}

	public void putXat(Position position) {
		gameStatus.putXat(position, Xs, Os, turno);
		gameStatus = statusSetter();
	}

	public void putOat(Position position) {
		gameStatus.putOat(position, Xs, Os, turno);
		gameStatus = statusSetter();
	}

	public void slideX(Position initialPosition, Position finalPosition) {
		
		gameStatus.slideX(initialPosition, finalPosition, Xs, Os, turno);
		gameStatus = statusSetter();
	}

	public void slideO(Position initialPosition, Position finalPosition) {
		gameStatus.slideO(initialPosition, finalPosition, Xs, Os, turno);
		gameStatus = statusSetter();
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