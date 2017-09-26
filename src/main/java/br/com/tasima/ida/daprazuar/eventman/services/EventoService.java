package br.com.tasima.ida.daprazuar.eventman.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tasima.ida.daprazuar.eventman.exceptions.business.InvalidParameterException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.NotFoundException;
import br.com.tasima.ida.daprazuar.eventman.models.Evento;
import br.com.tasima.ida.daprazuar.eventman.repositories.EventoRepository;
import br.com.tasima.ida.daprazuar.eventman.repositories.EventoRepositoryImpl;

@Service
public class EventoService {
//TODO: criar classe que implementa interface EventoRepository
	// ex. Repositorio
	private EventoRepositoryImpl repo;
	@Autowired
	private EventoRepository eventoRepo;
	
	public EventoService() {
		
		
	}
	
	public List<Evento> GetAll() {
		return (List<Evento>) eventoRepo.findAll();
	}
	
	public Evento Get(long id) throws NotFoundException {
		Evento ev = eventoRepo.findOne(id);
		
		if (ev == null) {
			throw new NotFoundException();
		}
		
		return ev;
	}
	
	public Evento Get(String name) throws InvalidParameterException, NotFoundException {
		if (name == null) {
			throw new InvalidParameterException();
		}
		
		Evento ev = eventoRepo.findByName(name);
		
		if (ev == null) {
			throw new NotFoundException();
    	}
		
		return ev;
	}
	
	public void Create(Evento ev) throws InvalidParameterException {
		if (ev == null || ev.getNome() == null || ev.getData() == null) {
			throw new InvalidParameterException();
		}
		
		eventoRepo.save(ev);
	}
}
