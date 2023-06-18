package terniLapilli;
import java.util.Set;

public abstract class GameStatus {
	
	public abstract void putXat(Position position, Set<Position> Xs, Set<Position> Os, Player turn);

	public abstract void putOat(Position position, Set<Position> Xs, Set<Position> Os, Player turn);

	public abstract void slideX(Position initialPosition, Position finalPosition, Set<Position> Xs, Set<Position> Os,Player turn);

	public abstract void slideO(Position initialPosition, Position finalPosition, Set<Position> Xs, Set<Position> Os,Player turn);

}
