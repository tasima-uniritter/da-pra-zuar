package br.com.tasima.ida.daprazuar.eventman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tasima.ida.daprazuar.eventman.models.TipoCliente;

@Repository
public interface TipoClienteRepository extends JpaRepository<TipoCliente, Long> {
}
