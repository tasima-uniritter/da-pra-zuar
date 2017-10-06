package br.com.tasima.ida.daprazuar.eventman.services;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.tasima.ida.daprazuar.eventman.exceptions.business.DateException;
import br.com.tasima.ida.daprazuar.eventman.models.Evento;
import br.com.tasima.ida.daprazuar.eventman.models.TipoIngresso;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TipoIngressoServiceTest {

	@Autowired
	private TipoIngressoService tipoIngressoService;
	
	@Autowired
	private EventoService eventoService;

	private Evento evento;
	private TipoIngresso sujeira;
	private Date today;
	private Date yesterday;
	
	@Before
	public void setUp() throws Exception {
		Calendar cal = Calendar.getInstance();
		today = cal.getTime();
		
		cal.add(Calendar.DATE, -1);
		yesterday = cal.getTime();
		
		Evento ev = new Evento();
		ev.setNome("teste auto");
		cal.add(Calendar.DATE, 10);
		ev.setData(cal.getTime());
		evento = eventoService.create(ev);
	}

	@After
	public void tearDown() throws Exception {
		if (evento != null)
			eventoService.delete(evento);
		
		if (sujeira != null)
			tipoIngressoService.delete(sujeira);
	}

	// US 3 - AC 2

	@Test
	public void testDataInicioMaiorQueDataFimFalha() {
		// given
		TipoIngresso ti = new TipoIngresso();
		ti.setEvento(evento);
		ti.setCategoria("teste");
		ti.setValor((long) 200);
		ti.setInicioVendas(today);
		ti.setFimVendas(yesterday);
		
		assertThatThrownBy(() -> {
			// when
			sujeira = tipoIngressoService.create(ti, evento);

			// then
		}).isInstanceOf(DateException.class)
		.hasMessage("A data de início de venda deve ser inferior a data de fim");
	}
}
