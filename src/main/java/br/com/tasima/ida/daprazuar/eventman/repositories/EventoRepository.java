package br.com.tasima.ida.daprazuar.eventman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tasima.ida.daprazuar.eventman.models.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
	Evento findByNome(String nome);
}
