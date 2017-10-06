package br.com.tasima.ida.daprazuar.eventman.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tasima.ida.daprazuar.eventman.exceptions.business.DateException;
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
	
	public TipoIngresso create(TipoIngresso ti, Evento ev) throws InvalidParameterException, DateException {
		if (ti == null || ti.getCategoria() == null || ti.getCategoria().isEmpty() || ti.getValor() <= 0
				|| ti.getInicioVendas() == null || ti.getFimVendas() == null) {
			throw new InvalidParameterException();
		}
		
		if (ti.getInicioVendas().after(ti.getFimVendas())) {
			throw new DateException("A data de início de venda deve ser inferior a data de fim");
		}
		
		ti.setEvento(ev);
		return tipoIngressoRepository.save(ti);
	}
	
	public void delete(TipoIngresso ti) throws InvalidParameterException {
		if (ti == null) {
			throw new InvalidParameterException();
		}
		
		tipoIngressoRepository.delete(ti);
	}
}
