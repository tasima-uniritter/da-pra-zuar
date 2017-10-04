package br.com.tasima.ida.daprazuar.eventman.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tasima.ida.daprazuar.eventman.exceptions.business.InvalidParameterException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.NotFoundException;
import br.com.tasima.ida.daprazuar.eventman.models.Evento;
import br.com.tasima.ida.daprazuar.eventman.models.TipoCliente;
import br.com.tasima.ida.daprazuar.eventman.repositories.TipoClienteRepository;

@Service
public class TipoClienteService {

	@Autowired
	private TipoClienteRepository tipoClienteRepository;
	
	public TipoCliente get(long id, Evento ev) throws NotFoundException {
		TipoCliente tc = null;
		
		for (TipoCliente tipo : ev.getTiposCliente()) {
			if (tipo.getId() == id) {
				tc = tipo;
				break;
			}
		}

		if (tc == null) {
			throw new NotFoundException();
		}

		return tc;
	}
	
	public TipoCliente create(TipoCliente tc, Evento ev) throws InvalidParameterException {
		if (tc == null || tc.getCategoria() <= 0 || tc.getDesconto() <= 0) {
			throw new InvalidParameterException();
		}
		
		tc.setEvento(ev);
		return tipoClienteRepository.save(tc);
	}
}
