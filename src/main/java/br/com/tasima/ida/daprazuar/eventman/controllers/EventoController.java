package br.com.tasima.ida.daprazuar.eventman.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tasima.ida.daprazuar.eventman.EventManApplication;
import br.com.tasima.ida.daprazuar.eventman.MemoryStorage;
import br.com.tasima.ida.daprazuar.eventman.models.Evento;

@RestController
public class EventoController {

	private MemoryStorage storage;
	
	public EventoController() {
		storage = MemoryStorage.getInstance();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/eventos")
    public ResponseEntity<List<Evento>> GetAll() {    	
        return ResponseEntity.ok(storage.eventos);
    }
	
    @RequestMapping(method=RequestMethod.GET, path="/evento/{id}")
    public ResponseEntity<Evento> GetById(@PathVariable("id") int id) {
    	if (id > storage.eventos.size()-1)
    		return ResponseEntity.notFound().build();
    	
    	Evento ev = storage.eventos.get(id);
        return ResponseEntity.ok(ev);
    }
    
    @RequestMapping(method=RequestMethod.GET, path="/evento")
    public ResponseEntity<Evento> GetByNome(@RequestParam(value="nome") String nome) {
    	Evento found = null;
    	
    	for (Evento e : storage.eventos) {
			if (e.getNome().equalsIgnoreCase(nome)) {
				found = e;
				break;
			}
		}
    	
    	if (found != null) {
    		return ResponseEntity.ok(found);
    	} else {
    		return ResponseEntity.notFound().build();
    	}
    }
    
    @RequestMapping(method=RequestMethod.POST, path="/evento")
    public HttpStatus Create(@RequestBody Evento evento) {
    	if (evento == null)
    		return HttpStatus.BAD_REQUEST;
    	
    	storage.eventos.add(evento);
        return HttpStatus.OK;
    }
}