package br.com.tasima.ida.daprazuar.eventman.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tasima.ida.daprazuar.eventman.exceptions.business.InvalidParameterException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.NotFoundException;
import br.com.tasima.ida.daprazuar.eventman.models.Evento;
import br.com.tasima.ida.daprazuar.eventman.models.Ingresso;
import br.com.tasima.ida.daprazuar.eventman.models.TipoCliente;
import br.com.tasima.ida.daprazuar.eventman.models.TipoIngresso;
import br.com.tasima.ida.daprazuar.eventman.models.dtos.IngressoPostDto;
import br.com.tasima.ida.daprazuar.eventman.repositories.IngressoRepository;

@Service
@Transactional
public class IngressoService {

	@Autowired
	private IngressoRepository ingressoRepository;
	
	@Autowired
	private TipoClienteService tipoClienteService;
	
	@Autowired
	private TipoIngressoService tipoIngressoService;
	
	public Ingresso get(long id, Evento ev) throws NotFoundException {
		Ingresso in = null;
		
		for (Ingresso ing : ev.getIngressos()) {
			if (ing.getId() == id) {
				in = ing;
				break;
			}
		}

		if (in == null) {
			throw new NotFoundException();
		}

		return in;
	}
	
	private Ingresso create(long tipoClienteId, long tipoIngressoId, Evento ev) throws NotFoundException {
		TipoCliente tc = tipoClienteService.get(tipoClienteId, ev);
		TipoIngresso ti = tipoIngressoService.get(tipoIngressoId, ev);
		
		Ingresso in = new Ingresso();
		in.setTipoCliente(tc);
		in.setTipoIngresso(ti);
		in.setEvento(ev);
		
		int percentual = 100 - tc.getDesconto();
		float multiplicador = (float)percentual/(float)100;
		in.setValorCobrado(ti.getValor() * multiplicador);
		
		return ingressoRepository.save(in);
	}
	
	public Ingresso create(IngressoPostDto inDto, Evento ev) throws InvalidParameterException, NotFoundException {
		if (inDto == null || inDto.getTipoIngressoId() <= 0 || inDto.getTipoClienteId() <= 0) {
			throw new InvalidParameterException();
		}
		
		return create(inDto.getTipoClienteId(), inDto.getTipoIngressoId(), ev);
	}
	
	public void delete(Ingresso in) throws InvalidParameterException {
		if (in == null) {
			throw new InvalidParameterException();
		}
		
		ingressoRepository.delete(in);
	}
}
