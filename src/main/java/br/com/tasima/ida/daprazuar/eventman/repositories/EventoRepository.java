package br.com.tasima.ida.daprazuar.eventman.repositories;


import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.tasima.ida.daprazuar.eventman.MemoryStorage;
import br.com.tasima.ida.daprazuar.eventman.models.Evento;

@Repository
public class EventoRepository {

	private MemoryStorage memStorage;
	
	
	public EventoRepository() {
		memStorage = MemoryStorage.getInstance();
	}
	
	public List<Evento> findAll() {
		return memStorage.eventos;
		
	}
	
	public Evento find(int id) {
		if (id > memStorage.eventos.size()-1)
    		return null;
    	
    	return memStorage.eventos.get(id);
		
	}
	
	public Evento find(String name) {
		Evento found = null;
    	
    	for (Evento e : memStorage.eventos) {
			if (e.getNome().equalsIgnoreCase(name)) {
				found = e;
				break;
			}
		}
    	
    	return found;

	}
	
	public void insert(Evento ev) {
		memStorage.eventos.add(ev);
	}
	
	public void update(Evento ev) {
		//memStorage.eventos.remove(ev.getId());
		//memStorage.eventos.add(ev.getId(), ev);
	}
}
