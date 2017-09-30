package br.com.tasima.ida.daprazuar.eventman.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.stereotype.Service;

import br.com.tasima.ida.daprazuar.eventman.exceptions.business.InvalidParameterException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.NameTooLongException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.NotFoundException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.PastDateException;
import br.com.tasima.ida.daprazuar.eventman.models.Evento;
import br.com.tasima.ida.daprazuar.eventman.repositories.EventoRepository;
import br.com.tasima.ida.daprazuar.eventman.repositories.EventoRepositoryH2;

@Service
public class EventoService {

	private EventoRepositoryH2 eventoRepo;

	public EventoService() {
		//deve receber Datasource, now hardcoded in EventoRepositoryH2
		eventoRepo = new EventoRepositoryH2( new JdbcDataSource());
	}

	public List<Evento> getAll() {
		return eventoRepo.findAll();
	}

	public Evento get(int id) throws NotFoundException {
		Evento ev = eventoRepo.find(id);

		if (ev == null) {
			throw new NotFoundException();
		}

		return ev;
	}

	public Evento get(String name) throws InvalidParameterException, NotFoundException {
		if (name == null) {
			throw new InvalidParameterException();
		}

		Evento ev = eventoRepo.find(name);

		if (ev == null) {
			throw new NotFoundException();
		}

		return ev;
	}


	public void create(Evento ev) throws InvalidParameterException, NameTooLongException, PastDateException {
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

		eventoRepo.insert(ev);
	}

	public Evento update(int id, Evento ev) throws InvalidParameterException, NotFoundException {
		if (ev == null) {
			throw new InvalidParameterException();
		}

		Evento localEv = get(id);

		localEv.setNome(ev.getNome());
		localEv.setData(ev.getData());

		eventoRepo.update(localEv);

		return localEv;
	}
}
