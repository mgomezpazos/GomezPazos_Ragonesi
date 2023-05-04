package marsrover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class MarsRoverTest {

		@Test public void test00() {
			//tengo que tenenr una posicion inicial. El rover debe estar ubicado en la poscion inicial.
			Point initialPoint = new Point (1, 1);
			MarsRover rover = new MarsRover(initialPoint);
			//assert de que el rover este ubicado en la posicion inicial.
			assertEquals(initialPoint, rover.getPosition());
			assertTrue(rover.isHeadingNorth()); //assert está apuntando al norte
			
		}
		
		@Test public void test01() {
			
			Point initialPoint = new Point(1, 1); 
			MarsRover rover = new MarsRover(initialPoint);
			
			rover.move("");
			
			assertEquals(initialPoint, rover.getPosition());
			assertTrue(rover.isHeadingNorth());
		}
}
