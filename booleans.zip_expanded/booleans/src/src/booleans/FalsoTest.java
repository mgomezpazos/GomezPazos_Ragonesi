package src.booleans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FalsoTest {

	@Test void testAndOnTrue() {
		assertEquals( new Falso().yy( new Verdadero() ), new Falso() );
	}

	@Test void testAndOnFalse() {
		assertEquals( new Falso().yy( new Falso() ), new Falso() );
	}

	@Test void testOrOnTrue() {
		assertEquals( new Falso().oo( new Verdadero() ), new Verdadero() );
	}

	@Test void testOrOnFalse() {
		assertEquals( new Falso().oo( new Falso() ), new Falso() );
	}


	@Test void testNot() {
		assertEquals( new Falso().not(), new Verdadero() );
	}


}
