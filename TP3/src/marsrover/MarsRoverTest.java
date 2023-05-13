package marsrover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class MarsRoverTest {

        @Test public void test00() {
            //We need to have an initial position. 
            Location initialPosition = new Location (1, 1);
            //The rover must be standing on the initial position. 
            MarsRover rover = new MarsRover(initialPosition);
            //assert that checks if the rover is on the initial position.
            assertEquals(initialPosition, rover.getPosition());
            //assert that checks if the rover is heading north.
            assertTrue(rover.isHeadingNorth());

        }

        @Test public void test01() {

            Location initialPosition = new Location(1, 1); 
            MarsRover rover = new MarsRover(initialPosition);

            rover.move("");

            assertEquals(initialPosition, rover.getPosition());
            assertTrue(rover.isHeadingNorth());
        }

        @Test public void test02() {

        }
}