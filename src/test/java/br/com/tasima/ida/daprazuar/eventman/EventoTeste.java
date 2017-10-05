package br.com.tasima.ida.daprazuar.eventman;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.tasima.ida.daprazuar.eventman.exceptions.business.InvalidParameterException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.NameTooLongException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.DateException;
import br.com.tasima.ida.daprazuar.eventman.models.Evento;
import br.com.tasima.ida.daprazuar.eventman.services.EventoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventoTeste {

	private static final String STR_150_CHARS = "..12345_10..12345_10..12345_10..12345_10..12345_10"
			+ "..12345_10..12345_10..12345_10..12345_10..12345_10..12345_10..12345_10..12345_10"
			+ "..12345_10..12345_10";

	@Autowired
	private EventoService service;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	// US 1 - AC 2

	@Test
	public void testCriarCompleto() throws InvalidParameterException, NameTooLongException, DateException {
		// given
		Evento ev = new Evento();
		ev.setNome("testCamposObrigatorios");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		ev.setData(cal.getTime());
		
		// when
		service.create(ev);

		// then
		// nenhum erro acontece
	}

	@Test
	public void testCriarSemNomeFalha() {
		// given
		Evento ev = new Evento();
		ev.setData(Calendar.getInstance().getTime());

		assertThatThrownBy(() -> {
			// when
			service.create(ev);

			// then
		}).isInstanceOf(InvalidParameterException.class);
	}

	@Test
	public void testCriarNomeBrancoFalha() {
		// given
		Evento ev = new Evento();
		ev.setNome("");

		assertThatThrownBy(() -> {
			// when
			service.create(ev);

			// then
		}).isInstanceOf(InvalidParameterException.class);
	}

	@Test
	public void testCriarSemDataFalha() {
		// given
		Evento ev = new Evento();
		ev.setNome("testCamposObrigatorios");

		assertThatThrownBy(() -> {
			// when
			service.create(ev);

			// then
		}).isInstanceOf(InvalidParameterException.class);
	}

	@Test
	public void testCriarNuloFalha() {
		// given
		Evento ev = null;

		assertThatThrownBy(() -> {
			// when
			service.create(ev);

			// then
		}).isInstanceOf(InvalidParameterException.class);
	}

	// US 1 - AC 3

	@Test
	public void testCriarComNomeMaiorQue150CharsFalha() {
		// given
		Evento ev = new Evento();
		ev.setNome(STR_150_CHARS + "1");
		ev.setData(Calendar.getInstance().getTime());

		assertThatThrownBy(() -> {
			// when
			service.create(ev);

			// then
		}).isInstanceOf(NameTooLongException.class)
		.hasMessage("O nome permite no máximo 150 caracteres");
	}
	
	// US 1 - AC 4
	
	@Test
	public void testCriarComDataAnteriorAAtualFalha() {
		// given
		Evento ev = new Evento();
		ev.setNome("nome");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		ev.setData(cal.getTime());

		assertThatThrownBy(() -> {
			// when
			service.create(ev);

			// then
		}).isInstanceOf(DateException.class)
		.hasMessage("A data do evento deve ser igual ou maior que a de hoje");
	}
}
