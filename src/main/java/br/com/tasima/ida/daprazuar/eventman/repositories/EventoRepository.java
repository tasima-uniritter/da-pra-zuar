package br.com.tasima.ida.daprazuar.eventman.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tasima.ida.daprazuar.eventman.MemoryStorage;
import br.com.tasima.ida.daprazuar.eventman.models.Evento;

@Repository
public interface EventoRepository extends CrudRepository<Evento, Long>  {

	
}
