package src.booleans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VerdaderoTest {

	@Test void testAndOnTrue() {
		assertEquals( new Verdadero().yy( new Verdadero() ), new Verdadero() );
	}

	@Test void testAndOnFalse() {
		assertEquals( new Verdadero().yy( new Falso() ), new Falso() );
	}

	@Test void testOrOnTrue() {
		assertEquals( new Verdadero().oo( new Verdadero() ), new Verdadero() );
	}

	@Test void testOrOnFalse() {
		assertEquals( new Verdadero().oo( new Falso() ), new Verdadero() );
	}

	@Test void testNot() {
		assertEquals( new Verdadero().not(), new Falso() );
	}



}
