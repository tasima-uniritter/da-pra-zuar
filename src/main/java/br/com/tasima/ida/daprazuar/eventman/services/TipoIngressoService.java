package br.com.tasima.ida.daprazuar.eventman.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tasima.ida.daprazuar.eventman.exceptions.business.InvalidParameterException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.NotFoundException;
import br.com.tasima.ida.daprazuar.eventman.models.Evento;
import br.com.tasima.ida.daprazuar.eventman.models.TipoIngresso;
import br.com.tasima.ida.daprazuar.eventman.repositories.TipoIngressoRepository;

@Service
public class TipoIngressoService {

	@Autowired
	private TipoIngressoRepository tipoIngressoRepository;
	
	public TipoIngresso get(long id, Evento ev) throws NotFoundException {
		TipoIngresso ti = null;
		
		for (TipoIngresso tipo : ev.getTiposIngresso()) {
			if (tipo.getId() == id) {
				ti = tipo;
				break;
			}
		}

		if (ti == null) {
			throw new NotFoundException();
		}

		return ti;
	}
	
	public TipoIngresso create(TipoIngresso ti, Evento ev) throws InvalidParameterException {
		if (ti == null || ti.getCategoria() <= 0 || ti.getValor() <= 0
				|| ti.getInicioVendas() == null || ti.getFimVendas() == null) {
			throw new InvalidParameterException();
		}
		
		ti.setEvento(ev);
		return tipoIngressoRepository.save(ti);
	}
}
