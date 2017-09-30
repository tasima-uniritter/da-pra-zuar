package br.com.tasima.ida.daprazuar.eventman.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tasima.ida.daprazuar.eventman.exceptions.business.InvalidParameterException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.NotFoundException;
import br.com.tasima.ida.daprazuar.eventman.models.Evento;
import br.com.tasima.ida.daprazuar.eventman.services.EventoService;

@RestController
public class EventoController {

	private EventoService service;

	public EventoController() {
		service = new EventoService();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/eventos")
	public ResponseEntity<List<Evento>> GetAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@RequestMapping(method = RequestMethod.GET, path = "/evento/{id}")
	public ResponseEntity<Evento> GetById(@PathVariable("id") int id) {
		try {
			Evento ev = service.get(id);
			return ResponseEntity.ok(ev);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/evento")
	public ResponseEntity<Evento> GetByNome(@RequestParam(value = "nome") String nome) {
		try {
			Evento ev = service.get(nome);
			return ResponseEntity.ok(ev);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (InvalidParameterException e) {
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

    }
    
    
    @RequestMapping(method=RequestMethod.POST, path="/evento")
    public HttpStatus Create(/*@RequestParam Map<String,String> allRequestParams*/@RequestBody Evento ev) {
    	
    	System.out.println(ev.toString());
    	
    	try {
    		service.create(ev);
    		return HttpStatus.OK;
    	} catch (InvalidParameterException e) {
    		System.out.println(e.getMessage()+"Aquiii");
			return HttpStatus.BAD_REQUEST;
		} catch (Exception e) {
			System.out.println(e.getMessage()+"aQUIII");
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}



	@RequestMapping(method = RequestMethod.PUT, path = "/evento/{id}")
	public ResponseEntity<Evento> Update(@PathVariable("id") int id, @RequestBody Evento ev) {
		try {
			Evento updated = service.update(id, ev);
			return ResponseEntity.ok(updated);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (InvalidParameterException e) {
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}