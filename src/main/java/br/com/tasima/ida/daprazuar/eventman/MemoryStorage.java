package br.com.tasima.ida.daprazuar.eventman;

import java.util.LinkedList;
import java.util.List;

import br.com.tasima.ida.daprazuar.eventman.models.Evento;

public class MemoryStorage {

	private static MemoryStorage instance;
	
	public List<Evento> eventos;
	
	private MemoryStorage() {
		eventos = new LinkedList<Evento>();
	}
	
	public static MemoryStorage getInstance() {
		if (instance == null) {
			instance = new MemoryStorage();
		}
		
		return instance;
	}
}
