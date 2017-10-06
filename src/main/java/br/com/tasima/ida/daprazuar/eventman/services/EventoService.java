package br.com.tasima.ida.daprazuar.eventman.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tasima.ida.daprazuar.eventman.exceptions.business.DateException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.InvalidParameterException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.NameTooLongException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.NotFoundException;
import br.com.tasima.ida.daprazuar.eventman.models.Evento;
import br.com.tasima.ida.daprazuar.eventman.repositories.EventoRepository;

@Service
@Transactional
public class EventoService {
	
	@Autowired
	private EventoRepository eventoRepository;

	public List<Evento> getAll() {
		return eventoRepository.findAll();
	}

	public Evento get(long id) throws NotFoundException {
		Evento ev = eventoRepository.findOne(id);

		if (ev == null) {
			throw new NotFoundException();
		}

		return ev;
	}

	public Evento get(String name) throws InvalidParameterException, NotFoundException {
		if (name == null) {
			throw new InvalidParameterException();
		}

		Evento ev = eventoRepository.findByNome(name);

		if (ev == null) {
			throw new NotFoundException();
		}

		return ev;
	}


	public Evento create(Evento ev) throws InvalidParameterException, NameTooLongException, DateException {
		if (ev == null || (ev.getNome() == null || ev.getNome().isEmpty()) || ev.getData() == null) {
			throw new InvalidParameterException();
		}

		if (ev.getNome().length() > 150) {
			throw new NameTooLongException("O nome permite no máximo 150 caracteres");
		}
		
		Date today = Calendar.getInstance().getTime();
		if (ev.getData().before(today)) {
			throw new DateException("A data do evento deve ser igual ou maior que a de hoje");
		}
		
		return eventoRepository.save(ev);
	}

	public Evento update(long id, Evento ev) throws InvalidParameterException, NotFoundException {
		if (ev == null) {
			throw new InvalidParameterException();
		}

		Evento localEv = get(id);

		localEv.setNome(ev.getNome());
		localEv.setData(ev.getData());

		eventoRepository.save(localEv);

		return localEv;
	}
	
	public void delete(Evento ev) throws InvalidParameterException {
		if (ev == null) {
			throw new InvalidParameterException();
		}
		
		eventoRepository.delete(ev);
	}
	
}
