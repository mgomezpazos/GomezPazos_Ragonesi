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
		if (Os.size()== 3) {
			return gameStatus = new Sliding();
		}
		if (this.isWinnerO()|| this.isWinnerX()) {
			return gameStatus = new Over();
		}
		return gameStatus;
		
	}

	public void putXat(Position position) {
		gameStatus = statusSetter();
		
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
		Os.add(position);
		turno = turno.playsX();
	}
	
	public void slideX(Position initialPosition, Position finalPosition) {
		
		if (turno.isPlayingO()) {
			throw new RuntimeException(NotYourTurn);
		}
		if (!Xs.contains(initialPosition)) {
			throw new RuntimeException("No piece is placed at the inicial position");
		}
		if (Xs.contains(finalPosition)) {
			throw new RuntimeException(Ternilapili.ThatCellIsTaken);
		}
		if (Position.SlidingDistanceCalculator(initialPosition, finalPosition)!= 1) {
			throw new RuntimeException("This move is not valid!");
		}
		Xs.remove(initialPosition);
		Xs.add(finalPosition);
		turno = turno.playsO();
		
	}

	public void slideO(Position initialPosition, Position finalPosition) {
		if (turno.isPlayingX()) {
			throw new RuntimeException(NotYourTurn);
		}
		if (!Os.contains(initialPosition)) {
			throw new RuntimeException("No piece is placed at the inicial position");
		}

		if (Os.contains(finalPosition)) {
			throw new RuntimeException(Ternilapili.ThatCellIsTaken);
		}
		if (Position.SlidingDistanceCalculator(initialPosition, finalPosition)!= 1) {
			throw new RuntimeException("This move is not valid!");
		}
		Os.remove(initialPosition);
		Os.add(finalPosition);
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