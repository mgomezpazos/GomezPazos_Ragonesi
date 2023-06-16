package terniLapilli;
import java.util.Set;
import java.util.HashSet;

public class Ternilapili {
	public char currentPlayer;

	public String turn = "X";

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
		if (turn.equals("O")) {
			throw new RuntimeException("Not your turn");
		}
		if (Xs.contains(position)) {
			throw new RuntimeException("That cell is taken");
		}
		if (Os.contains(position)) {
			throw new RuntimeException("That cell is taken");
		}
		if ((position.row) > 3 || (position.column) > 3 && (position.row) < 0 || (position.column) < 0) {
			throw new RuntimeException("Please check the limits");
		}
		if (Xs.size() >= 3) {
			throw new RuntimeException("You have no pieces left");
		}

		Xs.add(position);

		System.out.println("X: " + Xs);
		System.out.println("X size: " + Xs.size());
		turn = "O";

	}

	public void putOat(Position position) {
		if (turn.equals("X")) {
			throw new RuntimeException("Not your turn");
		}
		if (Xs.contains(position)) {
			throw new RuntimeException("That cell is taken");
		}
		if (Os.contains(position)) {
			throw new RuntimeException("That cell is taken");
		}
		if ((position.row) > 3 || (position.column) > 3 && (position.row) < 0 || (position.column) < 0) {
			throw new RuntimeException("Please check the limits");
		}
//		if (Os.size() >= 3) {
//			throw new RuntimeException("You cunt, you already have 3 pieces!");
//		}

		Os.add(position);
		System.out.println("O: " + Os);
		System.out.println("O size: " + Os.size());
		turn = "X";
	}

	public boolean isEmpty() {
		return (Xs.size() == 0) && (Os.size() == 0);
	}

	public boolean isWinnerX() {
		return XhasCompletedRow() || XhasCompletedColumn() || XhasCompletedDiagonal();
	}

	public boolean isWinnerO() {
		return OhasCompletedRow() || OhasCompletedColumn() || OhasCompletedDiagonal();
	}

	public boolean XhasCompletedRow() {
		for (int iteradorFilas = 1; iteradorFilas <= 3; iteradorFilas++) {
			int filaObservable = iteradorFilas;
			int count = (int) Xs.stream().filter(p -> p.row == filaObservable).count();
			if (count == 3) {
				return true;
			}
		}
		return false;
	}

	public boolean OhasCompletedRow() {
		for (int iteradorFilas = 1; iteradorFilas <= 3; iteradorFilas++) {
			int filaObservable = iteradorFilas;
			int count = (int) Os.stream().filter(p -> p.row == filaObservable).count();
			if (count == 3) {
				return true;
			}
		}
		return false;
	}

	public boolean XhasCompletedColumn() {
		for (int iteradorColumnas = 1; iteradorColumnas <= 3; iteradorColumnas++) {
			int columnaObservable = iteradorColumnas;
			int count = (int) Xs.stream().filter(p -> p.column == columnaObservable).count();
			if (count == 3) {
				return true;
			}
		}
		return false;
	}

	public boolean OhasCompletedColumn() {
		for (int iteradorColumnas = 1; iteradorColumnas <= 3; iteradorColumnas++) {
			int columnaObservable = iteradorColumnas;
			int count = (int) Os.stream().filter(p -> p.column == columnaObservable).count();
			if (count == 3) {
				return true;
			}
		}
		return false;
	}

	public boolean XhasCompletedDiagonal() {
		boolean diagonal1 = Xs.contains(new Position(1, 1)) && Xs.contains(new Position(2, 2))
				&& Xs.contains(new Position(3, 3));

		boolean diagonal2 = Xs.contains(new Position(1, 3)) && Xs.contains(new Position(2, 2))
				&& Xs.contains(new Position(3, 1));

		return diagonal1 || diagonal2;
	}

	public boolean OhasCompletedDiagonal() {
		boolean diagonal1 = Os.contains(new Position(1, 1)) && Os.contains(new Position(2, 2))
				&& Os.contains(new Position(3, 3));

		boolean diagonal2 = Os.contains(new Position(1, 3)) && Os.contains(new Position(2, 2))
				&& Os.contains(new Position(3, 1));

		return diagonal1 || diagonal2;
	}
//	public boolean isPiecePlacedCorrectly(Coordinate coordinate, char piece) {
//        return board[row][col] == piece;
//    }
}