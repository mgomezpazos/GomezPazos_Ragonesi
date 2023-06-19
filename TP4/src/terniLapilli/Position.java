package terniLapilli;

import java.util.Objects;

public class Position {

	public int row;

	public int column;

	public Position(int i, int j) {

		if (i >= 3 || j >= 3 && i < 0 || j < 0) {
			throw new RuntimeException(Ternilapili.PleaseCheckTheLimits);
		}
		row = i;

		column = j;

	}

	public static int SlidingDistanceCalculator(Position inicialPosition, Position finalPosition) {
		int rowDistance = Math.abs(inicialPosition.getRow() - finalPosition.getRow());
		int colDistance = Math.abs(inicialPosition.getColum() - finalPosition.getColum());
		if (rowDistance == colDistance) {
			return rowDistance;
		}
		return Math.max(rowDistance, colDistance);
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Position other = (Position) obj;
		return row == other.row && column == other.column;

	}

	public int hashCode() {

		return Objects.hash(row, column);

	}

	public int getRow() {

		return row;

	}

	public int getColum() {

		return column;
	}

}