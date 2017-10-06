package br.com.tasima.ida.daprazuar.eventman.services;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.tasima.ida.daprazuar.eventman.exceptions.business.InvalidParameterException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.NotFoundException;
import br.com.tasima.ida.daprazuar.eventman.models.Evento;
import br.com.tasima.ida.daprazuar.eventman.models.Ingresso;
import br.com.tasima.ida.daprazuar.eventman.models.TipoCliente;
import br.com.tasima.ida.daprazuar.eventman.models.TipoIngresso;
import br.com.tasima.ida.daprazuar.eventman.models.dtos.IngressoPostDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IngressoServiceTest {

	@Autowired
	private IngressoService ingressoService;

	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private TipoIngressoService tipoIngressoService;
	
	@Autowired
	private TipoClienteService tipoClienteService;
	
	private Evento festaNoAp;
	private TipoCliente estudante;
	private TipoIngresso vip;
	private Ingresso ingresso;
	
	@Before
	public void setUp() throws Exception {
		Calendar cal = Calendar.getInstance();
		
		Evento ev = new Evento();
		ev.setNome("bundalele");
		cal.add(Calendar.DATE, 10);
		ev.setData(cal.getTime());
		
		festaNoAp = eventoService.create(ev);
		
		TipoCliente tc = new TipoCliente();
		tc.setCategoria("estudante");
		tc.setEvento(festaNoAp);
		
		tc.setDesconto(50);
		estudante = tipoClienteService.create(tc, festaNoAp);
		
		Set<TipoCliente> tiposClientes = new HashSet<TipoCliente>();
		tiposClientes.add(estudante);
		festaNoAp.setTiposCliente(tiposClientes);
		
		TipoIngresso ti = new TipoIngresso();
		ti.setCategoria("VIP");
		cal.add(Calendar.DATE, -9);
		ti.setInicioVendas(cal.getTime());
		cal.add(Calendar.DATE, 8);
		ti.setFimVendas(cal.getTime());
		ti.setEvento(festaNoAp);
		
		ti.setValor((long) 1000);
		vip = tipoIngressoService.create(ti, festaNoAp);
		
		Set<TipoIngresso> tiposIngressos = new HashSet<TipoIngresso>();
		tiposIngressos.add(vip);
		festaNoAp.setTiposIngresso(tiposIngressos);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	private IngressoPostDto toDto(Ingresso in) {
		IngressoPostDto dto = new IngressoPostDto();
		dto.setTipoClienteId(in.getTipoCliente().getId());
		dto.setTipoIngressoId(in.getTipoIngresso().getId());
		
		return dto;
	}
	
	// US 4

	@Test
	public void testAplicaDescontoCorretamente() throws InvalidParameterException, NotFoundException {
		// given
		Ingresso in = new Ingresso();
		in.setEvento(festaNoAp);
		in.setTipoCliente(estudante);
		in.setTipoIngresso(vip);
		
		// then
		ingresso = ingressoService.create(toDto(in), festaNoAp);
		
		// when
		Assert.assertTrue("Desconto no ingresso calculado errado.", ingresso.getValorCobrado() == 500);
	}
}
