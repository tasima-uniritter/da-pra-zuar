package br.com.tasima.ida.daprazuar.eventman.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface EventoRepositorio extends PagingAndSortingRepository<Evento, Long> {
	List<Evento> buscarPorNome(@Param("nome") String nome);
	List<Evento> buscaPorData(@Param("data") Date data);
}
