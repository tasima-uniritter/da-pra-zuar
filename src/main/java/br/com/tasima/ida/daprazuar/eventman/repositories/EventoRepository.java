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
	
	public List<Evento> FindAll() {
		return memStorage.eventos;
		
	}
	
	public Evento Find(int id) {
		if (id > memStorage.eventos.size()-1)
    		return null;
    	
    	return memStorage.eventos.get(id);
		
	}
	
	public Evento Find(String name) {
		Evento found = null;
    	
    	for (Evento e : memStorage.eventos) {
			if (e.getNome().equalsIgnoreCase(name)) {
				found = e;
				break;
			}
		}
    	
    	return found;

	}
	
	public void Insert(Evento ev) {
		memStorage.eventos.add(ev);
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
}
