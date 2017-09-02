package br.com.tasima.ida.daprazuar.eventman.controllers;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tasima.ida.daprazuar.eventman.models.Evento;

@RestController
public class EventoController {

    @RequestMapping(method=RequestMethod.GET, path="/evento")
    public Evento evento(@RequestParam(value="name", defaultValue="World") String name) {
        return new Evento("teste", new Date("01/01/01"));
    }
}