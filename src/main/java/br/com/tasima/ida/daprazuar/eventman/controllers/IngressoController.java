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
import br.com.tasima.ida.daprazuar.eventman.models.Ingresso;
import br.com.tasima.ida.daprazuar.eventman.models.dtos.IngressoPostDto;
import br.com.tasima.ida.daprazuar.eventman.services.EventoService;
import br.com.tasima.ida.daprazuar.eventman.services.IngressoService;

@RestController
@RequestMapping("/evento/{eventoId}")
public class IngressoController {

	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private IngressoService ingressoService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/ingresso")
	public ResponseEntity<Set<Ingresso>> GetAll(@PathVariable long eventoId) {
		try {
			Evento ev = eventoService.get(eventoId);
			return ResponseEntity.ok(ev.getIngressos());
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/ingresso/{id}")
	public ResponseEntity<Ingresso> GetById(@PathVariable long eventoId, @PathVariable("id") long id) {
		try {
			Evento ev = eventoService.get(eventoId);
			Ingresso in = ingressoService.get(id, ev);
			return ResponseEntity.ok(in);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/ingresso")
    public ResponseEntity<Ingresso> Create(@PathVariable long eventoId, @RequestBody IngressoPostDto inDto) {
    	try {
    		Evento ev = eventoService.get(eventoId);
    		
    		Ingresso created = ingressoService.create(inDto, ev);
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
