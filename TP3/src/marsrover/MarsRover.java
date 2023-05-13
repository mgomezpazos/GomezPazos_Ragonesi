package marsrover;

public class MarsRover {

    private Location position;

    public MarsRover(Location initialPosition) {
        position = initialPosition;
    }

    public Location getPosition() {
        return position;
    }

    public boolean isHeadingNorth() {
        return true;
    }

    public void move(String string) {

    }
}