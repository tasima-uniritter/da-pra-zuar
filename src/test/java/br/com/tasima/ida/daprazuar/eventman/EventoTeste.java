package br.com.tasima.ida.daprazuar.eventman;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.tasima.ida.daprazuar.eventman.models.*;


public class EventoTeste {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNovoEvento() {
		Evento evento = new Evento();
		assertEquals(true,true);
	}

}
