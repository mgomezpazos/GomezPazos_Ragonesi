package marsrover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class MarsRoverTest {
	
		@Test public void test00CrearMarsRover() {
			MarsRover rover = new MarsRover (0, 0, 'N');
			assertNotNull(rover);
			assertTrue(rover.checkCoordinates(new Location(0,0,'N')));
//			assertEquals(0, rover.position.x);
//			assertEquals(0, rover.position.y);
//			assertEquals('N', rover.position.puntoCardinal);
		}

		@Test public void testMultiplesComandos() {
			MarsRover rover = new MarsRover (0, 0, 'N');
			rover.comandos("fbf");
//			System.out.println(rover.position.y);
			assertTrue(rover.checkCoordinates(new Location(0, 1,'N')));
		}


	//	
//		@Test public void testGetCoordinateX() {
//			MarsRoverPrueba rover = new MarsRoverPrueba (5, 2, 'E'); 
//			int coordinateX = rover.position.x;
//			assertEquals(5, coordinateX);
//		}
	//
//		@Test public void testGetCoordinateY() {
//			MarsRoverPrueba rover = new MarsRoverPrueba (5, 2, 'E'); 
//			int coordinateY = rover.position.y;
//			assertEquals(2, coordinateY);
//		}
	//	
//		@Test public void testGetPuntoCardinal() {
//			MarsRoverPrueba rover = new MarsRoverPrueba (5, 2, 'E'); 
//			int direccion = rover.position.puntoCardinal;
//			assertEquals('E', direccion);
//		}
		
//		@Test public void test01PuntoCardinalInválido() {
//			MarsRover rover = new MarsRover (0, 0, 'M');
//			assertNotNull(rover);
//			assertTrue(rover.checkCoordinates(new Location(0,0,'M')));
//			rover.comandos("f");
//			assertThrows( RuntimeException.class, () -> rover.comandos("f"));
//			//assertEquals(rover.comandos('f'),RuntimeException("PuntoCardinal Inválido"));
//				}
		
		
		@Test public void testComandos() {
			MarsRover rover = new MarsRover (0, 0, 'N');
			rover.comandos("fb");
		//	System.out.println(rover.position.x);
		//	System.out.println(rover.position.y);
		//	System.out.println(rover.position.puntoCardinal);
			assertTrue(rover.checkCoordinates(new Location(0,0,'N')));
//			assertEquals(0, rover.position.x);
//			assertEquals(0, rover.position.y);
//			assertEquals('N', rover.position.puntoCardinal);

		}

		@Test public void testMoveForward() {
			MarsRover rover = new MarsRover (1, 2, 'O');
			rover.comandos("f");
			//System.out.println(rover.position.x);
			assertTrue(rover.checkCoordinates(new Location(0,2,'O')));
//			assertEquals(0, rover.position.x);
//			assertEquals(2, rover.position.y);
			
			MarsRover rover1 = new MarsRover (1, 2, 'E');
			rover1.comandos("f");
			assertTrue(rover1.checkCoordinates(new Location(2,2,'E')));
//			assertEquals(2, rover1.position.x);
//			assertEquals(2, rover1.position.y);
			
			MarsRover rover2 = new MarsRover (1, 2, 'N');
			rover2.comandos("f");
			assertTrue(rover2.checkCoordinates(new Location(1,3,'N')));
//			assertEquals(1, rover2.position.x);
//			assertEquals(3, rover2.position.y);
			
			MarsRover rover3 = new MarsRover (1, 2, 'S');
			rover3.comandos("f");
			assertTrue(rover3.checkCoordinates(new Location(1,1,'S')));
//			assertEquals(1, rover3.position.x);
//			assertEquals(1, rover3.position.y);
		}
		
		@Test public void testMoveBackwards() {
			MarsRover rover = new MarsRover (0, 0, 'O');
			rover.comandos("b");
//			System.out.println(rover.position.y);
			assertTrue(rover.checkCoordinates(new Location(1, 0,'O')));
			
			MarsRover rover1 = new MarsRover (0, 0, 'E');
			rover1.comandos("b");
//			System.out.println(rover1.position.x);
			assertTrue(rover1.checkCoordinates(new Location(-1, 0,'E')));
			
			MarsRover rover2 = new MarsRover (0, 0, 'N');
			rover2.comandos("b");
//			System.out.println(rover2.position.y);
			assertTrue(rover2.checkCoordinates(new Location(0, -1,'N')));
			
			MarsRover rover3 = new MarsRover (0, 0, 'S');
			rover3.comandos("b");
//			System.out.println(rover3.position.y);
			assertTrue(rover3.checkCoordinates(new Location(0, 1,'S')));
		}	
		
		@Test public void testRotateLeft() {
			MarsRover rover = new MarsRover (0, 0, 'O');
			rover.comandos("l");
//			System.out.println(rover.position.puntoCardinal);
			assertTrue(rover.checkCoordinates(new Location(0, 0,'S')));
			
			MarsRover rover1 = new MarsRover (0, 0, 'E');
			rover1.comandos("l");
//			System.out.println(rover1.position.puntoCardinal);
			assertTrue(rover1.checkCoordinates(new Location(0, 0,'N')));
			
			MarsRover rover2 = new MarsRover(0, 0, 'N'); //FALLA 
			rover2.comandos("l");
//			System.out.println(rover2.position.puntoCardinal);
			assertTrue(rover2.checkCoordinates(new Location(0, 0,'O')));

			MarsRover rover3 = new MarsRover (0, 0, 'S'); //NO IMPRIME NADA
			rover3.comandos("l");
//			System.out.println(rover3.position.puntoCardinal);
			assertTrue(rover3.checkCoordinates(new Location(0, 0,'E')));
		}
		
		@Test public void testRotateRight() {
			MarsRover rover = new MarsRover(0, 0, 'O');
			rover.comandos("r");
//			System.out.println(rover.position.puntoCardinal);
			assertTrue(rover.checkCoordinates(new Location(0, 0,'N')));
			
			MarsRover rover1 = new MarsRover (0, 0, 'E');
			rover1.comandos("r");
			//System.out.println(rover1.position.puntoCardinal);
			assertTrue(rover1.checkCoordinates(new Location(0, 0,'S')));

			MarsRover rover2 = new MarsRover (0, 0, 'N'); //FALLA  
			rover2.comandos("r");
			System.out.println(rover2.position.puntoCardinal);
			assertTrue(rover2.checkCoordinates(new Location(0, 0,'E')));
			
			MarsRover rover3 = new MarsRover (0, 0, 'S'); //NO IMPRIME NADA
			rover3.comandos("r");
			System.out.println(rover3.position.puntoCardinal);

			assertTrue(rover3.checkCoordinates(new Location(0, 0,'O')));
		}	
		
		@Test public void testInvalidArgument() {
			MarsRover rover = new MarsRover (0, 0, 'N');
			
			assertThrowsLike ( () -> rover.comandos("fblx"), "Comando inválido: x");
			
		}
//			try {
//		        rover.comandos("fblx");
//		        fail("Se esperaba IllegalArgumentException pero no se lanzó ninguna excepción.");
//		    } catch (IllegalArgumentException e) {
//		        assertEquals("Comando inválido: x", e.getMessage());
//		    }
			
//			IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
//				rover.comandos("ffxcl");
//			});
//			
//			assertEquals("Comando inválido: x", exception.getMessage());
//		}

		@Test public void testMoveInBigSquare() {
			MarsRover rover = new MarsRover (100, 50, 'N');
			rover.comandos("ffbfbfbfbffrlfbf");
		//	System.out.println(rover.position.y);
			assertTrue(rover.checkCoordinates(new Location(100, 54,'N')));
		}
	
		private void assertThrowsLike (Executable executable, String message) {
			assertEquals (message, assertThrows (Exception.class, executable).getMessage());
		}
		
		@Test public void testGirosEnElMismoLugarRight() {
			MarsRover rover = new MarsRover (0, 0, 'N');
			rover.comandos("rrrr");
			assertTrue(rover.checkCoordinates(new Location(0, 0, 'N')));
		}
		
		@Test public void testGirosEnElMismoLugarLeft() {
			MarsRover rover = new MarsRover (0, 0, 'N');
			rover.comandos("llll");
			assertTrue(rover.checkCoordinates(new Location(0, 0, 'N')));
		}
		
		@Test public void testVariosGirosDistintos() {
			MarsRover rover = new MarsRover (0, 0, 'N');
			rover.comandos("lrll");
			assertTrue(rover.checkCoordinates(new Location(0,0,'S')));
		}
		@Test public void testMovimientoDiagonal() { //NO ES DIAGONAL TROLL
			MarsRover rover = new MarsRover (0, 0, 'N');
			rover.comandos("frfrf");
			assertTrue(rover.checkCoordinates(new Location(1, 0, 'S')));
		}
		
		@Test public void testMovimientosRectosFoward() {
			MarsRover rover = new MarsRover(0, 0, 'N');
			rover.comandos("ffff");
			assertTrue(rover.checkCoordinates(new Location(0, 4, 'N')));
		}
		
		@Test public void testMovimientosRectosBackwards() {
			MarsRover rover = new MarsRover(0, 0, 'N');
			rover.comandos("bbbb");
			assertTrue(rover.checkCoordinates(new Location(0, -4, 'N')));
		}
	}