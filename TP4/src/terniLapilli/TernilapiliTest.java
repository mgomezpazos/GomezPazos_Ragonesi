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
	public void test05PutOAtAGivenPosition() {
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
	public void test06XIsTheFirstoneToPlay() {
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
	public void test09OTriesToPutPieceInOccupiedCell() {
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
	public void test10XTriesToPutPieceInOccupiedCell() {
		Ternilapili juego = new Ternilapili();
		
		juego.putXat(new Position(0,0));
		juego.putOat(new Position(1,0));
		try {
			juego.putXat(new Position(1,0));
			fail("Expected RuntimeException was not thrown.");
		} catch (RuntimeException e) {
			assertEquals("That cell is taken", e.getMessage());
		}
	}

	@Test
	public void test11XHasNoMoreThan3Pieces() {
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
			assertEquals("Cannot put pieces, only moving allowed", e.getMessage());
		}
	}
	

	@Test
	public void test12NobodyWonYet() {
		Ternilapili juego = new Ternilapili();
		
		juego.putXat(new Position(0, 0));
		juego.putOat(new Position(1, 0));
		juego.putXat(new Position(2, 0));
		juego.putOat(new Position(2, 1));
		juego.putXat(new Position(1, 2));
		juego.putOat(new Position(0, 2));

		assertFalse(juego.isWinnerX());
		assertFalse(juego.isWinnerO());

	}

	@Test
	public void test13XWinsTheGameInRow() {
		Ternilapili juego = new Ternilapili();
		juego.putXat(new Position(0, 0));
		juego.putOat(new Position(1, 0));
		juego.putXat(new Position(0, 1));
		juego.putOat(new Position(2, 0));
		juego.putXat(new Position(0, 2));

		assertTrue(juego.isWinnerX());
		assertFalse(juego.isWinnerO());
	}

	@Test
	public void test14OWinsTheGameInRow() {
		Ternilapili juego = new Ternilapili();
		juego.putXat(new Position(2, 0));
		juego.putOat(new Position(0, 0));
		juego.putXat(new Position(1, 0));
		juego.putOat(new Position(0, 1));
		juego.putXat(new Position(2, 2));
		juego.putOat(new Position(0, 2));

		assertFalse(juego.isWinnerX());
		assertTrue(juego.isWinnerO());
	}
	
	@Test
	public void test15XWinsTheGameInColumn() {
		Ternilapili juego = new Ternilapili();
		juego.putXat(new Position(0, 0));
		juego.putOat(new Position(0, 1));
		juego.putXat(new Position(1, 0));
		juego.putOat(new Position(0, 2));
		juego.putXat(new Position(2, 0));

		assertTrue(juego.isWinnerX());
		assertFalse(juego.isWinnerO());
	}

	@Test
	public void test16OWinsTheGameInColumn() {
		Ternilapili juego = new Ternilapili();
		juego.putXat(new Position(0, 2));
		juego.putOat(new Position(0, 0));
		juego.putXat(new Position(0, 1));
		juego.putOat(new Position(1, 0));
		juego.putXat(new Position(2, 2));
		juego.putOat(new Position(2, 0));

		assertFalse(juego.isWinnerX());
		assertTrue(juego.isWinnerO());
	}

	@Test
	public void test17XWinsTheGameInDiagonal() {
		Ternilapili juego = new Ternilapili();
		juego.putXat(new Position(0, 0));
		juego.putOat(new Position(0, 2));
		juego.putXat(new Position(1, 1));
		juego.putOat(new Position(2, 0));
		juego.putXat(new Position(2, 2));

		assertTrue(juego.isWinnerX());
		assertFalse(juego.isWinnerO());
	}

	@Test
	public void test18OWinsTheGameInDiagonal() {
		Ternilapili juego = new Ternilapili();

		juego.putXat(new Position(1, 0));
		juego.putOat(new Position(0, 0));
		juego.putXat(new Position(2, 0));
		juego.putOat(new Position(1, 1));
		juego.putXat(new Position(0, 2));
		juego.putOat(new Position(2, 2));

		assertFalse(juego.isWinnerX());
		assertTrue(juego.isWinnerO());
	}

	@Test
	public void test19SlidingFromX() {
		Ternilapili juego = new Ternilapili();

		juego.putXat(new Position(0, 0));
		juego.putOat(new Position(1, 0));
		juego.putXat(new Position(2, 0));
		juego.putOat(new Position(2, 2));
		juego.putXat(new Position(1, 2));
		juego.putOat(new Position(0, 2));
		juego.slideX(new Position(0, 0), new Position(1, 1));
		assertTrue(juego.getXs().contains(new Position(1, 1)));
		assertFalse(juego.getXs().contains(new Position(0, 0)));

	}

	@Test
	public void test20SlidingFromO() {
		Ternilapili juego = new Ternilapili();

		juego.putXat(new Position(0, 0));
		juego.putOat(new Position(1, 0));
		juego.putXat(new Position(2, 0));
		juego.putOat(new Position(2, 2));
		juego.putXat(new Position(1, 2));
		juego.putOat(new Position(0, 2));
		juego.slideX(new Position(0, 0), new Position(1, 1));
		juego.slideO(new Position(1, 0), new Position(2, 1));
		assertTrue(juego.getOs().contains(new Position(2, 1)));
		assertFalse(juego.getOs().contains(new Position(1, 0)));

	}

	@Test
	public void test21XSlidesOutOfLimit() {
		Ternilapili juego = new Ternilapili();

		juego.putXat(new Position(0, 0));
		juego.putOat(new Position(1, 0));
		juego.putXat(new Position(2, 0));
		juego.putOat(new Position(2, 2));
		juego.putXat(new Position(1, 2));
		juego.putOat(new Position(0, 2));
		try {
			juego.slideX(new Position(0, 0), new Position(3, 1));
			fail("Expected RuntimeException was not thrown");
		} catch (RuntimeException e) {
			assertEquals("Please check the limits", e.getMessage());
		}
	}

	@Test
	public void test22OSlidesOutOfLimit() {
		Ternilapili juego = new Ternilapili();

		juego.putXat(new Position(0, 0));
		juego.putOat(new Position(1, 0));
		juego.putXat(new Position(2, 0));
		juego.putOat(new Position(2, 1));
		juego.putXat(new Position(1, 2));
		juego.putOat(new Position(0, 2));
		juego.slideX(new Position(0, 0), new Position(1, 1));

		try {
			juego.slideO(new Position(1, 0), new Position(3, 2));
			fail("Expected RuntimeExeption was not thrown");
		} catch (RuntimeException e) {
			assertEquals("Please check the limits", e.getMessage());
		}
	}

	@Test
	public void test23XSlidesToAnOccupiedCellByO() {
		Ternilapili juego = new Ternilapili();

		juego.putXat(new Position(0, 0));
		juego.putOat(new Position(2, 0));
		juego.putXat(new Position(1, 0));
		juego.putOat(new Position(2, 2));
		juego.putXat(new Position(1, 2));
		juego.putOat(new Position(0, 1));
		try {
			juego.slideX(new Position(0, 0), new Position(0, 1));
			fail("Expected RuntimeException was not thrown");
		} catch (RuntimeException e) {
			assertEquals(Ternilapili.ThatCellIsTaken, e.getMessage());
		}
	}

	@Test
	public void test24XSlidesToAnOccupiedCellByX() {
		Ternilapili juego = new Ternilapili();

		juego.putXat(new Position(0, 0));
		juego.putOat(new Position(2, 0));
		juego.putXat(new Position(1, 0));
		juego.putOat(new Position(2, 2));
		juego.putXat(new Position(1, 2));
		juego.putOat(new Position(0, 1));
		try {
			juego.slideX(new Position(0, 0), new Position(1, 0));
			fail("Expected RuntimeException was not thrown");
		} catch (RuntimeException e) {
			assertEquals(Ternilapili.ThatCellIsTaken, e.getMessage());
		}
	}
	
	@Test
	public void test25OSlidesToAnOccupiedCellByX() {
		Ternilapili juego = new Ternilapili();

		juego.putXat(new Position(0, 0));
		juego.putOat(new Position(2, 0));
		juego.putXat(new Position(1, 0));
		juego.putOat(new Position(2, 2));
		juego.putXat(new Position(2, 1));
		juego.putOat(new Position(0, 1));
		juego.slideX(new Position(0, 0), new Position(1, 1));
		try {
			juego.slideO(new Position(2, 0), new Position(2, 1));
			fail("Expected RuntimeException was not thrown");
		} catch (RuntimeException e) {
			assertEquals(Ternilapili.ThatCellIsTaken, e.getMessage());
		}
	}
	
	@Test
	public void test26OSlidesToAnOccupiedCellByO() {
		Ternilapili juego = new Ternilapili();

		juego.putXat(new Position(0, 0));
		juego.putOat(new Position(1, 1));
		juego.putXat(new Position(2, 2));
		juego.putOat(new Position(2, 0));
		juego.putXat(new Position(0, 2));
		juego.putOat(new Position(0, 1));
		juego.slideX(new Position(0, 0), new Position(1, 0));
		try {
			juego.slideO(new Position(2, 0), new Position(1, 1));
			fail("Expected RuntimeException was not thrown");
		} catch (RuntimeException e) {
			assertEquals(Ternilapili.ThatCellIsTaken, e.getMessage());
		}
	}
	
	@Test
	public void test27XTriesToSlideBeforePutting() {
		Ternilapili juego = new Ternilapili();

		juego.putXat(new Position(0, 0));
		juego.putOat(new Position(2, 0));
		juego.putXat(new Position(1, 0));
		juego.putOat(new Position(2, 2));
		juego.putXat(new Position(1, 2));
		juego.putOat(new Position(0, 1));
		try {
			juego.slideX(new Position(2, 1), new Position(1, 1));
			fail("Expected RuntimeException was not thrown");
		} catch (RuntimeException e) {
			assertEquals(Ternilapili.NoPieceAtInitialPosition, e.getMessage());
		}
	}

	@Test
	public void test28OTriesToSlideBeforePutting() {
		Ternilapili juego = new Ternilapili();

		juego.putXat(new Position(0, 0));
		juego.putOat(new Position(2, 0));
		juego.putXat(new Position(1, 0));
		juego.putOat(new Position(2, 2));
		juego.putXat(new Position(1, 2));
		juego.putOat(new Position(0, 1));
		juego.slideX(new Position(1, 2), new Position(0, 2));
		try {
			juego.slideO(new Position(0, 2), new Position(2, 1));
			fail("Expected RuntimeException was not thrown");
		} catch (RuntimeException e) {
			assertEquals(Ternilapili.NoPieceAtInitialPosition, e.getMessage());
		}
	}
	
	@Test
	public void test29XSlidesADistanceBiggerThanOne() {
		Ternilapili juego = new Ternilapili();

		juego.putXat(new Position(0, 0));
		juego.putOat(new Position(1, 0));
		juego.putXat(new Position(2, 0));
		juego.putOat(new Position(2, 2));
		juego.putXat(new Position(1, 2));
		juego.putOat(new Position(0, 2));
		try {
			juego.slideX(new Position(0, 0), new Position(2, 1));
			fail("Expected RuntimeException was not thrown");
		} catch (RuntimeException e) {
			assertEquals("This move is not valid!", e.getMessage());
		}
	}

	@Test
	public void test30OSlidesADistanceBiggerThanOne() {
		Ternilapili juego = new Ternilapili();

		juego.putXat(new Position(0, 0));
		juego.putOat(new Position(1, 0));
		juego.putXat(new Position(2, 0));
		juego.putOat(new Position(2, 1));
		juego.putXat(new Position(1, 2));
		juego.putOat(new Position(0, 2));
		juego.slideX(new Position(0, 0), new Position(1, 1));

		try {
			juego.slideO(new Position(1, 0), new Position(2, 2));
			fail("Expected RuntimeExeption was not thrown");
		} catch (RuntimeException e) {
			assertEquals("This move is not valid!", e.getMessage());
		}
	}
	
}