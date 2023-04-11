package src.booleans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BooleTest {

	@Test void testDeMorganAndOnVF() {
		assertEquals(         new Verdadero().yy( new Falso() ),
				      ( new Verdadero().not().oo( new Falso().not() ) ).not() );
	}

	@Test void testDeMorganAndOnFV() {
		assertEquals(         new Falso().yy( new Verdadero() ),
				      ( new Falso().not().oo( new Verdadero().not() ) ).not() );
	}

	@Test void testDeMorganOrOnVF() {
		assertEquals(         new Verdadero().oo( new Falso() ), 					//    v | f    -> v
				      ( new Verdadero().not().yy( new Falso().not() ) ).not() );	// -(-v & -f ) -> ?
	}																				// -( f &  v ) -> v

	@Test void testDeMorganOrOnFV() {
		assertEquals(         new Falso().oo( new Verdadero() ),
				      ( new Falso().not().yy( new Verdadero().not() ) ).not() );
	}

}
