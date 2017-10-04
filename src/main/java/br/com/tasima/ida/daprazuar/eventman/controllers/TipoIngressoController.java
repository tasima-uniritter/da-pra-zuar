package br.com.tasima.ida.daprazuar.eventman.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tasima.ida.daprazuar.eventman.exceptions.business.InvalidParameterException;
import br.com.tasima.ida.daprazuar.eventman.exceptions.business.NotFoundException;
import br.com.tasima.ida.daprazuar.eventman.models.Evento;
import br.com.tasima.ida.daprazuar.eventman.models.TipoIngresso;
import br.com.tasima.ida.daprazuar.eventman.services.EventoService;
import br.com.tasima.ida.daprazuar.eventman.services.TipoIngressoService;

@RestController
@RequestMapping("/evento/{eventoId}")
public class TipoIngressoController {

	@Autowired
	private EventoService eventoService;
	@Autowired
	private TipoIngressoService tipoIngressoService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/tipos-ingresso")
	public ResponseEntity<Set<TipoIngresso>> GetAll(@PathVariable long eventoId) {
		try {
			Evento ev = eventoService.get(eventoId);
			return ResponseEntity.ok(ev.getTiposIngresso());
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/tipo-ingresso/{id}")
	public ResponseEntity<TipoIngresso> GetById(@PathVariable long eventoId, @PathVariable("id") long id) {
		try {
			Evento ev = eventoService.get(eventoId);
			TipoIngresso ti = tipoIngressoService.get(id, ev);
			return ResponseEntity.ok(ti);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/tipo-ingresso")
    public ResponseEntity<TipoIngresso> Create(@PathVariable long eventoId, @RequestBody TipoIngresso ti) {
    	try {
    		Evento ev = eventoService.get(eventoId);
    		
    		TipoIngresso created = tipoIngressoService.create(ti, ev);
    		return ResponseEntity.ok(created);
    	} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
    	} catch (InvalidParameterException e) {
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
