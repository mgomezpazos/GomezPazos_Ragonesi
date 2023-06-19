package terniLapilli;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

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
		gameStartsOutOfBoardLimits(3, 1);
	}

	@Test
	public void test03PutsPieceOutOfTheBoardInNegatives() {
		gameStartsOutOfBoardLimits(-4, -1);
	}

	@Test
	public void test04PutXAtAGivenPosition() {
		Ternilapili juego = new Ternilapili();
		juego.putXat(new Position(1, 1));
		assertEquals(1, juego.getXs().size());
		assertTrue(juego.getXs().contains(new Position(1, 1)));
		assertTrue(juego.getOs().isEmpty());
	}

	@Test
	public void test05PutOAtAGivenPosition() {
		Ternilapili juego = new Ternilapili();
		juego.putXat(new Position(1, 0));
		juego.putOat(new Position(1, 2));
		assertEquals(1, juego.getXs().size());
		assertTrue(juego.getXs().contains(new Position(1, 0)));
		assertEquals(1, juego.getOs().size());
		assertTrue(juego.getOs().contains(new Position(1, 2)));
	}

	@Test
	public void test06XIsTheFirstoneToPlay() {
		Ternilapili juego = new Ternilapili();
		assertThrowsLike(Ternilapili.NotYourTurn, () -> juego.putOat(new Position(1, 1)));
	}

	@Test
	public void test07XPlays2Times() {
		Ternilapili juego = xPutsTheStartingPiece(1, 0);
		assertThrowsLike(Ternilapili.NotYourTurn, () -> juego.putXat(new Position(1, 2)));
	}

	@Test
	public void test08OPlays2Times() {
		Ternilapili juego = xPutsTheStartingPiece(0, 0);
		juego.putOat(new Position(1, 0));
		assertThrowsLike(Ternilapili.NotYourTurn, () -> juego.putOat(new Position(1, 2)));
	}

	@Test
	public void test09OTriesToPutPieceInOccupiedCell() {
		Ternilapili juego = xPutsTheStartingPiece(0, 0);
		assertThrowsLike(Ternilapili.ThatCellIsTaken, () -> juego.putOat(new Position(0, 0)));
	}

	@Test
	public void test10XTriesToPutPieceInOccupiedCell() {
		Ternilapili juego = xPutsTheStartingPiece(0, 0);
		juego.putOat(new Position(1, 0));
		assertThrowsLike(Ternilapili.ThatCellIsTaken, () -> juego.putXat(new Position(1, 0)));
	}

	@Test
	public void test11XHasNoMoreThan3Pieces() {
		Ternilapili juego = startGameWithAllPiecesOnTheBoard();
		assertThrowsLike(Ternilapili.CannotPutPiecesOnlyMovingAllowed, () -> juego.putXat(new Position(2, 0)));
	}

	@Test
	public void test12NobodyWonYet() {
		Ternilapili juego = startGameWithAllPiecesOnTheBoard();
		assertFalse(juego.isWinnerX());
		assertFalse(juego.isWinnerO());

	}

	@Test
	public void test13XWinsTheGameInRow() {
		Ternilapili juego = xPutsTheStartingPiece(0, 0);
		juego.putOat(new Position(1, 0));
		juego.putXat(new Position(0, 1));
		juego.putOat(new Position(2, 0));
		juego.putXat(new Position(0, 2));

		XWins(juego);
	}

	@Test
	public void test14OWinsTheGameInRow() {
		Ternilapili juego = xPutsTheStartingPiece(2, 0);
		juego.putOat(new Position(0, 0));
		juego.putXat(new Position(1, 0));
		juego.putOat(new Position(0, 1));
		juego.putXat(new Position(2, 2));
		juego.putOat(new Position(0, 2));

		OWins(juego);
	}

	@Test
	public void test15XWinsTheGameInColumn() {
		Ternilapili juego = xPutsTheStartingPiece(0, 0);
		juego.putOat(new Position(0, 1));
		juego.putXat(new Position(1, 0));
		juego.putOat(new Position(0, 2));
		juego.putXat(new Position(2, 0));

		XWins(juego);
	}

	@Test
	public void test16OWinsTheGameInColumn() {
		Ternilapili juego = xPutsTheStartingPiece(0, 2);
		juego.putOat(new Position(0, 0));
		juego.putXat(new Position(0, 1));
		juego.putOat(new Position(1, 0));
		juego.putXat(new Position(2, 2));
		juego.putOat(new Position(2, 0));

		OWins(juego);
	}

	@Test
	public void test17XWinsTheGameInDiagonal() {
		Ternilapili juego = xPutsTheStartingPiece(0, 0);
		juego.putOat(new Position(0, 2));
		juego.putXat(new Position(1, 1));
		juego.putOat(new Position(2, 0));
		juego.putXat(new Position(2, 2));

		XWins(juego);
	}

	@Test
	public void test18OWinsTheGameInDiagonal() {
		Ternilapili juego = xPutsTheStartingPiece(1, 0);
		juego.putOat(new Position(0, 0));
		juego.putXat(new Position(2, 0));
		juego.putOat(new Position(1, 1));
		juego.putXat(new Position(0, 2));
		juego.putOat(new Position(2, 2));

		OWins(juego);
	}

	@Test
	public void test19SlidingFromX() {
		Ternilapili juego = gameWithOneSlide();
		assertTrue(juego.getXs().contains(new Position(2, 1)));
		assertFalse(juego.getXs().contains(new Position(2, 0)));
	}

	@Test
	public void test20SlidingFromO() {
		Ternilapili juego = xPutsTheStartingPiece(0, 0);
		firstSlideFromO(juego);
		assertTrue(juego.getOs().contains(new Position(1, 1)));
		assertFalse(juego.getOs().contains(new Position(1, 0)));
	}

	@Test
	public void test21XSlidesOutOfLimit() {
		Ternilapili juego = fullBoard();
		assertThrowsLike(Ternilapili.PleaseCheckTheLimits, () -> juego.slideX(new Position(2, 0), new Position(3, 1)));
	}

	@Test
	public void test22OSlidesOutOfLimit() {
		Ternilapili juego = fullBoard();
		juego.slideX(new Position(2, 0), new Position(1, 1));
		assertThrowsLike(Ternilapili.PleaseCheckTheLimits, () -> juego.slideO(new Position(1, 0), new Position(3, 2)));
	}

	@Test
	public void test23XSlidesToAnOccupiedCellByO() {
		Ternilapili juego = fullBoard();
		assertThrowsLike(Ternilapili.ThatCellIsTaken, () -> juego.slideX(new Position(0, 0), new Position(1, 0)));
	}

	@Test
	public void test24XSlidesToAnOccupiedCellByX() {
		Ternilapili juego = xPutsTheStartingPiece(0, 0);
		firstSlideFromO(juego);
		assertThrowsLike(Ternilapili.ThatCellIsTaken, () -> juego.slideX(new Position(2, 1), new Position(1, 2)));
	}

	@Test
	public void test25OSlidesToAnOccupiedCellByX() {
		Ternilapili juego = gameWithOneSlide();
		assertThrowsLike(Ternilapili.ThatCellIsTaken, () -> juego.slideO(new Position(0, 2), new Position(1, 2)));
	}

	@Test
	public void test26OSlidesToAnOccupiedCellByO() {
		Ternilapili juego = xPutsTheStartingPiece(0, 0);
		firstSlideFromO(juego);
		juego.slideX(new Position(0, 0), new Position(0, 1));
		assertThrowsLike(Ternilapili.ThatCellIsTaken, () -> juego.slideO(new Position(1, 1), new Position(0, 2)));
	}

	@Test
	public void test27XTriesToSlideFromAnEmptyCell() {
		Ternilapili juego = fullBoard();
		assertThrowsLike(Ternilapili.NoPieceAtInitialPosition,
				() -> juego.slideX(new Position(2, 1), new Position(1, 1)));
	}

	@Test
	public void test28OTriesToSlideFromAnEmptyCell() {
		Ternilapili juego = gameWithOneSlide();
		assertThrowsLike(Ternilapili.NoPieceAtInitialPosition,
				() -> juego.slideO(new Position(1, 1), new Position(0, 1)));
	}

	@Test
	public void test29XSlidesADistanceBiggerThanOne() {
		Ternilapili juego = fullBoard();
		assertThrowsLike(Ternilapili.ThisMoveIsNotValid, () -> juego.slideX(new Position(0, 0), new Position(2, 1)));
	}

	@Test
	public void test30OSlidesADistanceBiggerThanOne() {
		Ternilapili juego = gameWithOneSlide();
		assertThrowsLike(Ternilapili.ThisMoveIsNotValid, () -> juego.slideO(new Position(2, 2), new Position(0, 1)));
	}

	private void assertThrowsLike(String msg, Executable codeToRun) {
		assertEquals(msg, assertThrows(Exception.class, codeToRun).getMessage());
	}

	private void gameStartsOutOfBoardLimits(int row, int column) {
		Ternilapili juego = new Ternilapili();
		assertThrowsLike(Ternilapili.PleaseCheckTheLimits, () -> juego.putXat(new Position(row, column)));
	}

	private Ternilapili xPutsTheStartingPiece(int row, int column) {
		Ternilapili juego = new Ternilapili();
		juego.putXat(new Position(row, column));
		return juego;
	}

	private Ternilapili startGameWithAllPiecesOnTheBoard() {
		Ternilapili juego = fullBoard();
		return juego;
	}

	private void XWins(Ternilapili juego) {
		assertTrue(juego.isWinnerX());
		assertFalse(juego.isWinnerO());
	}

	private void OWins(Ternilapili juego) {
		assertFalse(juego.isWinnerX());
		assertTrue(juego.isWinnerO());
	}

	private void addFivePiecesToBoard(Ternilapili juego) {
		juego.putOat(new Position(1, 0));
		juego.putXat(new Position(2, 0));
		juego.putOat(new Position(2, 2));
		juego.putXat(new Position(1, 2));
		juego.putOat(new Position(0, 2));
	}

	private void fullBoardWithXSlide(Ternilapili juego) {
		addFivePiecesToBoard(juego);
		juego.slideX(new Position(2, 0), new Position(2, 1));
	}

	private void firstSlideFromO(Ternilapili juego) {
		fullBoardWithXSlide(juego);
		juego.slideO(new Position(1, 0), new Position(1, 1));
	}

	private Ternilapili fullBoard() {
		Ternilapili juego = xPutsTheStartingPiece(0, 0);
		addFivePiecesToBoard(juego);
		return juego;
	}

	private Ternilapili gameWithOneSlide() {
		Ternilapili juego = xPutsTheStartingPiece(0, 0);
		fullBoardWithXSlide(juego);
		return juego;
	}
}