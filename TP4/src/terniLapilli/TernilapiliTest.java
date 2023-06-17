package terniLapilli;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class TernilapiliTest {

	@Test
	public void testCreatesBoard() {
		Ternilapili juego = new Ternilapili();
		assertNotNull(juego);
	}

	@Test
	public void testCreatesEmptyBoard() {
		Ternilapili juego = new Ternilapili();
		assertTrue(juego.isEmpty());
	}

	public void testPutsPieceOutOfTheBoard() {
		Ternilapili juego = new Ternilapili();
		Position position = new Position(3, 1); 

		try {
			juego.putXat(position);
			fail("Expected RuntimeException was not thrown.");
		} catch (RuntimeException e) {
			assertEquals("Please check the limits", e.getMessage());
		}
	}

	public void testPutsPieceOutOfTheBoardInNegatives() {
		Ternilapili juego = new Ternilapili();
		Position position = new Position(-4, -1); 

		try {
			juego.putXat(position);
			fail("Expected RuntimeException was not thrown.");
		} catch (RuntimeException e) {
			assertEquals("Please check the limits", e.getMessage());
		}
	}

	@Test
	public void testPutXAtAGivenPosition() {
		Ternilapili juego = new Ternilapili();
		Position position = new Position(1, 1); 

		juego.putXat(position);
		assertEquals(1, juego.getXs().size());
		assertTrue(juego.getXs().contains(position));
		assertTrue(juego.getOs().isEmpty());
	}

	@Test
	public void testXIsTheFirstoneToPlay() {
		Ternilapili juego = new Ternilapili();
		Position position = new Position(1, 1); 
		try {
			juego.putOat(position);
			fail("Expected RuntimeException was not thrown.");
		} catch (RuntimeException e) {
			assertEquals("Not your turn", e.getMessage());
		}
	}

	@Test
	public void testPutOAtAGivenPosition() {
		Ternilapili juego = new Ternilapili();
		Position positionX = new Position(1, 0); 
		Position positionO = new Position(1, 2); 

		juego.putXat(positionX);
		juego.putOat(positionO);
		
		assertEquals(1, juego.getXs().size());
		assertEquals(1, juego.getOs().size());
		assertTrue(juego.getXs().contains(positionX));
		assertTrue(juego.getOs().contains(positionO));
	}

	@Test
	public void testXPlays2Times() {
		Ternilapili juego = new Ternilapili();
		Position position1 = new Position(1, 0); 
		Position position2 = new Position(1, 2); 


		juego.putXat(position1);
		try {
			juego.putXat(position2);
			fail("Expected RuntimeException was not thrown.");
		} catch (RuntimeException e) {
			assertEquals("Not your turn", e.getMessage());
		}
	}

	@Test
	public void testOPlays2Times() {
		Ternilapili juego = new Ternilapili();
		Position positionX = new Position(0, 0);
		Position positionO = new Position(1, 0); 
		Position positionO2 = new Position(1, 2); 

		juego.putXat(positionX);
		juego.putOat(positionO);
		try {
			juego.putOat(positionO2);
			fail("Expected RuntimeException was not thrown.");
		} catch (RuntimeException e) {
			assertEquals("Not your turn", e.getMessage());
		}
	}

	@Test
	public void testTriesToPutPieceInOccupiedCell() {
		Ternilapili juego = new Ternilapili();
		Position position = new Position(0, 0); 

		juego.putXat(position);
		try {
			juego.putOat(position);
			fail("Expected RuntimeException was not thrown.");
		} catch (RuntimeException e) {
			assertEquals("That cell is taken", e.getMessage());
		}
	}

	@Test
	public void testXHasNoMoreThan3Pieces() {
		Ternilapili juego = new Ternilapili(); 
		juego.putXat(new Position(0, 0));
		juego.putOat(new Position(0, 2));
		juego.putXat(new Position(0, 1));
		juego.putOat(new Position(1, 0));
		juego.putXat(new Position(1, 1));
		juego.putOat(new Position(1, 2));
		try {
			juego.putXat(new Position(2, 0));
			fail("Expected RuntimeException was not thrown.");
		} catch (RuntimeException e) {
			assertEquals("You have no pieces left", e.getMessage());
		}
	}
	
	@Test public void testNobodyWonYet() {
		   Ternilapili game = new Ternilapili();

		   game.putXat( new Position( 1, 1 ));
		   game.putOat( new Position( 2, 2 ));
		   game.putXat( new Position( 0, 0 ));
		   game.putOat( new Position( 1, 2 ));
		   
		   assertFalse(game.isWinnerX());
		   assertFalse(game.isWinnerO());

	   }
	   
	   @Test
	   public void testXWinsTheGameInStraightLine() {
	       Ternilapili game = new Ternilapili();
	       game.putXat(new Position(0, 0));
	       game.putOat(new Position(2, 1));
	       game.putXat(new Position(1, 0));
	       game.putOat(new Position(1, 1));
	       game.putXat(new Position(2, 0));

	       assertTrue(game.isWinnerX());
	       assertFalse(game.isWinnerO());
	   }
	   
	   @Test
	   public void test0WinsTheGameInStraightLine() {
	       Ternilapili game = new Ternilapili();
	       game.putXat(new Position(2, 1));
	       game.putOat(new Position(0, 0));
	       game.putXat(new Position(1, 1));
	       game.putOat(new Position(1, 0));
	       game.putXat(new Position(1, 2));
	       game.putOat(new Position(2, 0));

	       assertFalse(game.isWinnerX());
	       assertTrue(game.isWinnerO());
	   }
	
	   @Test
	   public void testXWinsTheGameInDiagonal() {
	       Ternilapili game = new Ternilapili();
	       game.putXat(new Position(0, 0));
	       game.putOat(new Position(0, 1));
	       game.putXat(new Position(1, 1));
	       game.putOat(new Position(1, 0));
	       game.putXat(new Position(2, 2));

	       assertTrue(game.isWinnerX());
	       assertFalse(game.isWinnerO());
	   }
	   
	   @Test
	   public void test0WinsTheGameInDiagonal() {
	       Ternilapili game = new Ternilapili();
	       
	       game.putXat(new Position(2, 1));
	       game.putOat(new Position(0, 0));
	       game.putXat(new Position(1, 0));
	       game.putOat(new Position(1, 1));
	       game.putXat(new Position(1, 2));
	       game.putOat(new Position(2, 2));

	       assertFalse(game.isWinnerX());
	       assertTrue(game.isWinnerO());
	   }
}