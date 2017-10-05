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
import br.com.tasima.ida.daprazuar.eventman.models.ModoVenda;
import br.com.tasima.ida.daprazuar.eventman.services.EventoService;
import br.com.tasima.ida.daprazuar.eventman.services.ModoVendaService;

@RestController
@RequestMapping("/evento/{eventoId}")
public class ModoVendaController {

	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private ModoVendaService modoVendaService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/modos-venda")
	public ResponseEntity<Set<ModoVenda>> GetAll(@PathVariable long eventoId) {
		try {
			Evento ev = eventoService.get(eventoId);
			return ResponseEntity.ok(ev.getModosVenda());
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/modo-venda/{id}")
	public ResponseEntity<ModoVenda> GetById(@PathVariable long eventoId, @PathVariable("id") long id) {
		try {
			Evento ev = eventoService.get(eventoId);
			ModoVenda mv = modoVendaService.get(id, ev);
			return ResponseEntity.ok(mv);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/modo-venda")
    public ResponseEntity<ModoVenda> Create(@PathVariable long eventoId, @RequestBody ModoVenda mv) {
    	try {
    		Evento ev = eventoService.get(eventoId);
    		
    		ModoVenda created = modoVendaService.create(mv, ev);
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
