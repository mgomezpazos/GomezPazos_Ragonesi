package marsrover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class MarsRoverTest {
	
		@Test public void test00CrearMarsRover() {
			MarsRover rover = new MarsRover (0, 0, new Norte());
			assertNotNull(rover);
			assertTrue(rover.checkCoordinates(new Location(0,0)));
		}

		@Test public void test01MultiplesComandos() {
			MarsRover rover = new MarsRover (0, 0, new Norte());
			rover.moveRover("ffbf");
			assertTrue(rover.checkCoordinates(new Location(0,2)));
		}

		@Test public void test02VolverAlPuntoDePartida() {
			MarsRover rover = new MarsRover (0, 0, new Norte());
			rover.moveRover("fb");
			assertTrue(rover.checkCoordinates(new Location(0,0)));
		}
		
		@Test public void test03MoveForwardToTheWest() {
			MarsRover rover = new MarsRover (1, 2, new Oeste());
			rover.moveRover("f");
			assertTrue(rover.checkCoordinates(new Location(0,2)));	
		}
			
		@Test public void test04MoveForwardToTheEast() {	
			MarsRover rover1 = new MarsRover (1, 2, new Este());
			rover1.moveRover("f");
			assertTrue(rover1.checkCoordinates(new Location(2,2)));
		}
		
		@Test public void test05MoveForwardToTheNorth() {
			MarsRover rover2 = new MarsRover (1, 2, new Norte());
			rover2.moveRover("f");
			assertTrue(rover2.checkCoordinates(new Location(1,3)));
			
		}
		
		@Test public void test06MoveForwardToTheSouth() {
			MarsRover rover3 = new MarsRover (1, 2, new Sur());
			rover3.moveRover("f");
			assertTrue(rover3.checkCoordinates(new Location(1,1)));
		}
		
		@Test public void test07MoveBackwardsToTheWest() {
			MarsRover rover = new MarsRover (0, 0, new Oeste());
			rover.moveRover("b");
			assertTrue(rover.checkCoordinates(new Location(1, 0)));
		}
		
		@Test public void test08MoveBackwardsToTheEast() {
			MarsRover rover1 = new MarsRover (0, 0, new Este());
			rover1.moveRover("b");
			assertTrue(rover1.checkCoordinates(new Location(-1, 0)));
		}
		
		@Test public void test09MoveBackwardsToTheWest() {
			MarsRover rover2 = new MarsRover (0, 0, new Norte());
			rover2.moveRover("b");
			assertTrue(rover2.checkCoordinates(new Location(0, -1)));
		}
		
		@Test public void test10MoveBackwardsToTheSouth() {
			MarsRover rover3 = new MarsRover (0, 0, new Sur());
			rover3.moveRover("b");
			assertTrue(rover3.checkCoordinates(new Location(0, 1)));
		}	
		
		@Test public void test11RotateLeftToTheWest() {
			MarsRover rover = new MarsRover (0, 0, new Oeste());
			rover.moveRover("l");
			assertTrue(rover.checkCoordinates(new Location(0, 0)));
		}
		
		@Test public void test12RotateLeftToTheEast() {	
			MarsRover rover1 = new MarsRover (0, 0, new Este());
			rover1.moveRover("l");
			assertTrue(rover1.checkCoordinates(new Location(0, 0)));
		}
		
		@Test public void test13RotateLeftToTheNorth() {	
			MarsRover rover2 = new MarsRover(0, 0, new Norte());
			rover2.moveRover("l");
			assertTrue(rover2.checkCoordinates(new Location(0, 0)));
		}
		
		@Test public void test14RotateLeftToTheSouth() {	
			MarsRover rover3 = new MarsRover (0, 0, new Sur()); 
			rover3.moveRover("l");
			assertTrue(rover3.checkCoordinates(new Location(0, 0)));
		}
		
		@Test public void test15RotateRightToTheWest() {
			MarsRover rover = new MarsRover(0, 0, new Oeste());
			rover.moveRover("r");
			assertTrue(rover.checkCoordinates(new Location(0, 0)));
		}
		
		@Test public void test16RotateRightToTheEast() {
			MarsRover rover1 = new MarsRover (0, 0, new Este());
			rover1.moveRover("r");
			assertTrue(rover1.checkCoordinates(new Location(0, 0)));
		}

		@Test public void test17RotateRightToTheNorth() {
			MarsRover rover2 = new MarsRover (0, 0, new Norte()); 
			rover2.moveRover("r");
			assertTrue(rover2.checkCoordinates(new Location(0, 0)));
		}
		
		@Test public void test18RotateRightToTheSouth() {
			MarsRover rover3 = new MarsRover (0, 0, new Sur());
			rover3.moveRover("r");
			assertTrue(rover3.checkCoordinates(new Location(0, 0)));
		}	
		
		@Test public void test19InvalidArgument() {
			MarsRover rover = new MarsRover (0, 0, new Norte());
			
			assertThrowsLike ( () -> rover.moveRover("fblx"), "Comando Inválido!");
			
		}

		@Test public void test20MoveInBigSquare() {
			MarsRover rover = new MarsRover (100, 50, new Norte());
			rover.moveRover("ffbfbfbfbffrlfbf");
			assertTrue(rover.checkCoordinates(new Location(100, 54)));
		}
		
		@Test public void test21GirosEnElMismoLugarRight() {
			MarsRover rover = new MarsRover (0, 0, new Norte());
			rover.moveRover("rrrr");
			assertTrue(rover.checkCoordinates(new Location(0, 0)));
		}
		
		@Test public void test22GirosEnElMismoLugarLeft() {
			MarsRover rover = new MarsRover (0, 0, new Norte());
			rover.moveRover("llll");
			assertTrue(rover.checkCoordinates(new Location(0, 0)));
		}
		
		@Test public void test23VariosGirosDistintos() {
			MarsRover rover = new MarsRover (0, 0, new Norte());
			rover.moveRover("lrll");
			assertTrue(rover.checkCoordinates(new Location(0,0)));
		}
		
		@Test public void test24MovimientoDiagonal() {
			MarsRover rover = new MarsRover (0, 0, new Norte());
			rover.moveRover("frfrf");
			assertTrue(rover.checkCoordinates(new Location(1, 0)));
		}
		
		@Test public void test25MovimientosRectosFoward() {
			MarsRover rover = new MarsRover(0, 0, new Norte());
			rover.moveRover("ffff");
			assertTrue(rover.checkCoordinates(new Location(0, 4)));
		}
		
		@Test public void test26MovimientosRectosBackwards() {
			MarsRover rover = new MarsRover(0, 0, new Norte());
			rover.moveRover("bbbb");
			assertTrue(rover.checkCoordinates(new Location(0, -4)));
		}
		
		
		private void assertThrowsLike (Executable executable, String message) {
			assertEquals (message, assertThrows (Exception.class, executable).getMessage());
		}
	}