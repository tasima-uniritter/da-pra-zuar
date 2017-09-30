package br.com.tasima.ida.daprazuar.eventman.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.tasima.ida.daprazuar.eventman.exceptions.business.InvalidParameterException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.NotFoundException;
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
		System.out.println("chegou aqui");
		
		Evento ev = eventoRepo.Find(name);
		
		if (ev == null) {
			throw new NotFoundException();
    	}
		
		return ev;
	}
	
	public void Create(Evento ev) throws InvalidParameterException {
		System.out.println("passei aqui");
		if (ev == null || ev.getNome() == null || ev.getData() == null) {
			throw new InvalidParameterException();
		}
		
		eventoRepo.Insert(ev);
	}
}
