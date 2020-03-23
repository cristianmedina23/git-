package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class testCerradura {

	@Test
	public void testQueVerificaAperturaContraseñaCorrecta() {
		Cerradura c1=new Cerradura(123);
		c1.abrirCerradura(123);
		assertTrue(c1.verEstado());
	}
	
	@Test
	public void testQueVerificaNoAperturaContraseñaIncorrecta() {
		Cerradura c1=new Cerradura(123);
		c1.abrirCerradura(333);
		assertFalse(c1.verEstado());
	}
	
	@Test
	public void testQueVerificaBloqueoIntentosFallidosConsecutivos() {
		Cerradura c1=new Cerradura(123);
		
		c1.abrirCerradura(333);
		c1.abrirCerradura(122);
		c1.abrirCerradura(131);

		assertTrue("La cerradura fue bloqueada", c1.bloqueada());
		
	}
	
	@Test
	public void testQueVerificaAperturaUltimoIntento() {
		Cerradura c2=new Cerradura(123);
		
		c2.abrirCerradura(122);
		assertFalse(c2.verEstado());
		
		c2.abrirCerradura(111);
		assertFalse(c2.verEstado());
		
		c2.abrirCerradura(123);
		assertTrue(c2.verEstado());
	}
	
}
