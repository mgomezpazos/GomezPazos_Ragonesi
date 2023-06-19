package terniLapilli;

import java.util.Set;
import java.util.stream.IntStream;
import java.util.HashSet;

public class Ternilapili {
	public static final String NoPiecesLeft = "You have no pieces left";
	public static final String PleaseCheckTheLimits = "Please check the limits";
	public static final String ThatCellIsTaken = "That cell is taken";
	public static final String NotYourTurn = "Not your turn";
	public static final String NoPieceAtInitialPosition = "No piece is placed at the inicial position";
	public static final String ThisMoveIsNotValid = "This move is not valid!";
	public static final String CannotPutPiecesOnlyMovingAllowed = "Cannot put pieces, only moving allowed";

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
		if ((Os.size() == 3 && Xs.size() == 3) && (!(isWinnerX() || isWinnerO()))) {
			return gameStatus = new Sliding();
		}
		if ((isWinnerO() || isWinnerX()) && (Os.size() == 3 && Xs.size() == 3)) {
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
		return IntStream.range(0, 3)
				.anyMatch(iteradorFilas -> Xs.stream().filter(p -> p.row == iteradorFilas).count() == 3);
	}

	public boolean OhasCompletedRow() {
		return IntStream.range(0, 3)
				.anyMatch(iteradorFilas -> Os.stream().filter(p -> p.row == iteradorFilas).count() == 3);
	}

	public boolean XhasCompletedColumn() {
		return IntStream.range(0, 3)
				.anyMatch(iteradorColumnas -> Xs.stream().filter(p -> p.column == iteradorColumnas).count() == 3);
	}

	public boolean OhasCompletedColumn() {
		return IntStream.range(0, 3)
				.anyMatch(iteradorColumnas -> Os.stream().filter(p -> p.column == iteradorColumnas).count() == 3);
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