package br.com.tasima.ida.daprazuar.eventman.models;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IngressoEventoRepositorio extends PagingAndSortingRepository<IngressoEvento, Long> {
	List<IngressoEvento> buscarPorTipo(@Param("tipo") String tipo);
}
