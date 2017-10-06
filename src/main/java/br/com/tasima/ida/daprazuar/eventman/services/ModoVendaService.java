package br.com.tasima.ida.daprazuar.eventman.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tasima.ida.daprazuar.eventman.exceptions.business.InvalidParameterException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.NotFoundException;
import br.com.tasima.ida.daprazuar.eventman.models.Evento;
import br.com.tasima.ida.daprazuar.eventman.models.ModoVenda;
import br.com.tasima.ida.daprazuar.eventman.repositories.ModoVendaRepository;

@Service
public class ModoVendaService {

	@Autowired
	private ModoVendaRepository modoVendaRepository;
	
	public ModoVenda get(long id, Evento ev) throws NotFoundException {
		ModoVenda mv = null;
		
		for (ModoVenda modo : ev.getModosVenda()) {
			if (modo.getId() == id) {
				mv = modo;
				break;
			}
		}

		if (mv == null) {
			throw new NotFoundException();
		}

		return mv;
	}
	
	public ModoVenda create(ModoVenda mv, Evento ev) throws InvalidParameterException {
		if (mv == null || mv.getModo() == null || mv.getModo().isEmpty()) {
			throw new InvalidParameterException();
		}
		
		mv.setEvento(ev);
		return modoVendaRepository.save(mv);
	}
}
