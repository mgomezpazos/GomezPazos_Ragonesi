package terniLapilli;
import java.util.Set;

public class Over extends GameStatus {

	public static final String GameOver = "Game over";

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