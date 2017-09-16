package br.com.tasima.ida.daprazuar.eventman.models;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClienteRepositorio extends PagingAndSortingRepository<ClienteEvento, Long>{
   
	 List<ClienteEvento> buscarPorNome(@Param("nome") String nome);
	 ClienteEvento buscaPorID(@Param("ID")int id);
	 
}
