package marsrover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class MarsRoverTest {
	
		@Test public void test00CrearMarsRover() {
//			MarsRover rover = marsRoverStartsHeadingNorth();
			assertNotNull(marsRoverStartsHeadingNorth()); //preguntar a zoe si esto se puede hacer o no
			assertTrue(checkNewCoordinates(marsRoverStartsHeadingNorth(), 0, 0));
		}

		@Test public void test01MultiplesComandos() {
//			MarsRover rover = marsRoverStartsHeadingNorth(); PREGUNTAR SI SE PUEDE HACER ESTO
			roverMovesCorrectly(marsRoverStartsHeadingNorth(), "ffbf", 0, 2);
		}

		@Test public void test02VolverAlPuntoDePartida() {
			MarsRover rover = marsRoverStartsHeadingNorth();
			roverMovesCorrectly(rover, "fb", 0, 0);
		}
		
		@Test public void test03MoveForwardToTheWest() {
			MarsRover rover = marsRoverStartsHeadingWest();
			roverMovesCorrectly(rover, "f", -1, 0);
		}
			
		@Test public void test04MoveForwardToTheEast() {	
			MarsRover rover = marsRoverStartsHeadingEast();
			roverMovesCorrectly(rover, "f", 1, 0);
		}
		
		@Test public void test05MoveForwardToTheNorth() {
			MarsRover rover = marsRoverStartsHeadingNorth();
			roverMovesCorrectly(rover, "f", 0, 1);
		}
		
		@Test public void test06MoveForwardToTheSouth() {
			MarsRover rover = marsRoverStartsHeadingSouth();
			roverMovesCorrectly(rover, "f", 0, -1);
		}
		
		@Test public void test07MoveBackwardsToTheWest() {
			MarsRover rover = marsRoverStartsHeadingWest();
			roverMovesCorrectly(rover, "b", 1, 0);
		}
		
		@Test public void test08MoveBackwardsToTheEast() {
			MarsRover rover = marsRoverStartsHeadingEast();
			roverMovesCorrectly(rover, "b", -1, 0);
		}
		
		@Test public void test09MoveBackwardsToTheWest() {
			MarsRover rover = marsRoverStartsHeadingNorth();
			roverMovesCorrectly(rover, "b", 0, -1);
		}
		
		@Test public void test10MoveBackwardsToTheSouth() {
			MarsRover rover = marsRoverStartsHeadingSouth();
			roverMovesCorrectly(rover, "b", 0, 1);
		}	
		
		@Test public void test11RotateLeftToTheWest() {
			MarsRover rover = marsRoverStartsHeadingWest();
			roverMovesCorrectly(rover, "l", 0, 0);
		}
		
		@Test public void test12RotateLeftToTheEast() {	
			MarsRover rover = marsRoverStartsHeadingEast();
			roverMovesCorrectly(rover, "l", 0, 0);
		}
		
		@Test public void test13RotateLeftToTheNorth() {	
			MarsRover rover = marsRoverStartsHeadingNorth();
			roverMovesCorrectly(rover, "l", 0, 0);
		}
		
		@Test public void test14RotateLeftToTheSouth() {	
			MarsRover rover = marsRoverStartsHeadingSouth(); 
			roverMovesCorrectly(rover, "l", 0, 0);
		}
		
		@Test public void test15RotateRightToTheWest() {
			MarsRover rover = marsRoverStartsHeadingWest();
			roverMovesCorrectly(rover, "r", 0, 0);
		}
		
		@Test public void test16RotateRightToTheEast() {
			MarsRover rover = marsRoverStartsHeadingEast();
			roverMovesCorrectly(rover, "r", 0, 0);
		}

		@Test public void test17RotateRightToTheNorth() {
			MarsRover rover = marsRoverStartsHeadingNorth(); 
			roverMovesCorrectly(rover, "r", 0, 0);
		}
		
		@Test public void test18RotateRightToTheSouth() {
			MarsRover rover = marsRoverStartsHeadingSouth();
			roverMovesCorrectly(rover, "r", 0, 0);
		}	
		
		@Test public void test19InvalidArgument() {
			MarsRover rover = marsRoverStartsHeadingNorth();
			
			assertThrowsLike ( () -> rover.moveRover("fblx"), "Comando Inválido!");
			
		}

		@Test public void test20MoveInBigSquare() {
			MarsRover rover = new MarsRover (100, 50, new Norte());
			roverMovesCorrectly(rover, "ffbfbfbfbffrlfbf", 100, 54);
		}
		
		@Test public void test21GirosEnElMismoLugarRight() {
			MarsRover rover = marsRoverStartsHeadingNorth();
			roverMovesCorrectly(rover, "rrrr", 0, 0);
		}
		
		@Test public void test22GirosEnElMismoLugarLeft() {
			MarsRover rover = marsRoverStartsHeadingNorth();
			roverMovesCorrectly(rover, "llll", 0, 0);
		}
		
		@Test public void test23VariosGirosDistintos() {
			MarsRover rover = marsRoverStartsHeadingNorth();
			roverMovesCorrectly(rover, "lrll", 0, 0);
		}
		
		@Test public void test24MovimientoDiagonal() {
			MarsRover rover = marsRoverStartsHeadingNorth();
			roverMovesCorrectly(rover, "frfrf", 1, 0);
		}
		
		@Test public void test25MovimientosRectosFoward() {
			MarsRover rover = marsRoverStartsHeadingNorth();
			roverMovesCorrectly(rover, "ffff", 0, 4);
		}
		
		@Test public void test26MovimientosRectosBackwards() {
			MarsRover rover = marsRoverStartsHeadingNorth();
			roverMovesCorrectly(rover, "bbbb", 0, -4);
		}
		

		private MarsRover marsRoverStartsHeadingNorth() {
			return new MarsRover (0, 0, new Norte());
		}

		private MarsRover marsRoverStartsHeadingWest() {
			return new MarsRover (0,0, new Oeste());
		}

		private MarsRover marsRoverStartsHeadingEast() {
			return new MarsRover (0, 0, new Este());
		}

		private MarsRover marsRoverStartsHeadingSouth() {
			return new MarsRover (0, 0, new Sur());
		}

		private boolean checkNewCoordinates(MarsRover rover, int x, int y) {
			return rover.checkCoordinates(new Location(x,y));
		}
		
		private void roverMovesCorrectly(MarsRover rover, String commands, int x, int y) {
			rover.moveRover(commands);
			assertTrue(checkNewCoordinates(rover, x, y));
		}
		
		private void assertThrowsLike (Executable executable, String message) {
			assertEquals (message, assertThrows (Exception.class, executable).getMessage());
		}
	}