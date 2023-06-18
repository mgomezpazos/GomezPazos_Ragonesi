package terniLapilli;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class TernilapiliTest {

	@Test
	public void test00CreatesBoard() {
		Ternilapili juego = new Ternilapili();
		assertNotNull(juego);
	}

	@Test
	public void test01CreatesEmptyBoard() {
		Ternilapili juego = new Ternilapili();
		assertTrue(juego.isEmpty());
	}
	
	@Test
	public void test02PutsPieceOutOfTheBoard() {
		Ternilapili juego = new Ternilapili();
		try {
			juego.putXat(new Position(3, 1));
			fail("Expected RuntimeException was not thrown.");
		} catch (RuntimeException e) {
			assertEquals("Please check the limits", e.getMessage());
		}
	}

	@Test
	public void test03PutsPieceOutOfTheBoardInNegatives() {
		Ternilapili juego = new Ternilapili();
		try {
			juego.putXat(new Position(-4, -1));
			fail("Expected RuntimeException was not thrown.");
		} catch (RuntimeException e) {
			assertEquals("Please check the limits", e.getMessage());
		}
	}

	@Test
	public void test04PutXAtAGivenPosition() {
		Ternilapili juego = new Ternilapili();
		Position position = new Position(1, 1); 

		juego.putXat(position);
		assertEquals(1, juego.getXs().size());
		assertTrue(juego.getXs().contains(position));
		assertTrue(juego.getOs().isEmpty());
	}

	@Test
	public void test05XIsTheFirstoneToPlay() {
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
	public void test06PutOAtAGivenPosition() {
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
	public void test07XPlays2Times() {
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
	public void test08OPlays2Times() {
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
	public void test09TriesToPutPieceInOccupiedCell() {
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
	public void test10XHasNoMoreThan3Pieces() {
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
	
	@Test 
	public void test11NobodyWonYet() {
		   Ternilapili game = new Ternilapili();

		   game.putXat( new Position( 1, 1 ));
		   game.putOat( new Position( 2, 2 ));
		   game.putXat( new Position( 0, 0 ));
		   game.putOat( new Position( 1, 2 ));
		   
		   assertFalse(game.isWinnerX());
		   assertFalse(game.isWinnerO());

	   }
	   
	   @Test
	   public void test12XWinsTheGameInStraightLine() {
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
	   public void test130WinsTheGameInStraightLine() {
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
	   public void test14XWinsTheGameInDiagonal() {
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
	   public void test150WinsTheGameInDiagonal() {
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
	   
	   @Test
	   public void test16SlidingFromX() {
		   Ternilapili game = new Ternilapili();
		   
		   game.putXat(new Position(0, 0));
	       game.putOat(new Position(1, 0));
	       game.putXat(new Position(2, 0));
	       game.putOat(new Position(2, 2));
	       game.putXat(new Position(1, 2));
	       game.putOat(new Position(0, 2));
	       game.slideX(new Position(0,0), new Position(1,1));
	       assertTrue(game.getXs().contains(new Position(1,1)));
	       assertFalse(game.getXs().contains(new Position(0,0)));
	       
	   }
}