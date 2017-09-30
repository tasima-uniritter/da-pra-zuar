package br.com.tasima.ida.daprazuar.eventman.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.tasima.ida.daprazuar.eventman.exceptions.business.InvalidParameterException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.NameTooLongException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.NotFoundException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.PastDateException;
import br.com.tasima.ida.daprazuar.eventman.models.Evento;
import br.com.tasima.ida.daprazuar.eventman.repositories.EventoRepository;

@Service
public class EventoService {

	private EventoRepository eventoRepo;

	public EventoService() {
		eventoRepo = new EventoRepository();
	}

	public List<Evento> GetAll() {
		return eventoRepo.FindAll();
	}

	public Evento Get(int id) throws NotFoundException {
		Evento ev = eventoRepo.Find(id);

		if (ev == null) {
			throw new NotFoundException();
		}

		return ev;
	}

	public Evento Get(String name) throws InvalidParameterException, NotFoundException {
		if (name == null) {
			throw new InvalidParameterException();
		}

		Evento ev = eventoRepo.Find(name);

		if (ev == null) {
			throw new NotFoundException();
		}

		return ev;
	}

	public void Create(Evento ev) throws InvalidParameterException, NameTooLongException, PastDateException {
		if (ev == null || (ev.getNome() == null || ev.getNome().isEmpty()) || ev.getData() == null) {
			throw new InvalidParameterException();
		}

		if (ev.getNome().length() > 150) {
			throw new NameTooLongException("O nome permite no máximo 150 caracteres");
		}
		
		Date today = Calendar.getInstance().getTime();
		if (ev.getData().before(today)) {
			throw new PastDateException("A data do evento deve ser igual ou maior que a de hoje");
		}

		eventoRepo.Insert(ev);
	}

	public Evento Update(int id, Evento ev) throws InvalidParameterException, NotFoundException {
		if (ev == null) {
			throw new InvalidParameterException();
		}

		Evento localEv = Get(id);

		localEv.setNome(ev.getNome());
		localEv.setData(ev.getData());

		eventoRepo.Update(localEv);

		return localEv;
	}
}
