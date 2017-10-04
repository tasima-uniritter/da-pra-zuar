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
import br.com.tasima.ida.daprazuar.eventman.models.TipoCliente;
import br.com.tasima.ida.daprazuar.eventman.services.EventoService;
import br.com.tasima.ida.daprazuar.eventman.services.TipoClienteService;

@RestController
@RequestMapping("/evento/{eventoId}")
public class TipoClienteController {

	@Autowired
	private EventoService eventoService;
	@Autowired
	private TipoClienteService tipoClienteService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/tipos-cliente")
	public ResponseEntity<Set<TipoCliente>> GetAll(@PathVariable long eventoId) {
		try {
			Evento ev = eventoService.get(eventoId);
			return ResponseEntity.ok(ev.getTiposCliente());
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/tipo-cliente/{id}")
	public ResponseEntity<TipoCliente> GetById(@PathVariable long eventoId, @PathVariable("id") long id) {
		try {
			Evento ev = eventoService.get(eventoId);
			TipoCliente tc = tipoClienteService.get(id, ev);
			return ResponseEntity.ok(tc);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/tipo-cliente")
    public ResponseEntity<TipoCliente> Create(@PathVariable long eventoId, @RequestBody TipoCliente tc) {
    	try {
    		Evento ev = eventoService.get(eventoId);
    		
    		TipoCliente created = tipoClienteService.create(tc, ev);
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
