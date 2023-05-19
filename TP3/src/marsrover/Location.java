package marsrover;

public class Location {

	public int x;
	public int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Location other = (Location) obj;
		return x == other.x && y == other.y;

	}

	public boolean areCoordinatesEqual(Location location) {
		if (this.x == location.x && this.y == location.y) {
			return true;
		}
		return false;
	}

	public void modifyCoordinates(Location location) {

		this.x = this.x + location.x;
		this.y = this.y + location.y;

	}

}