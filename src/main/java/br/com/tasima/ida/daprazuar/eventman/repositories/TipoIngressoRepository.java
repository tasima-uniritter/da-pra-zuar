package br.com.tasima.ida.daprazuar.eventman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tasima.ida.daprazuar.eventman.models.TipoIngresso;

@Repository
public interface TipoIngressoRepository extends JpaRepository<TipoIngresso, Long> {
}
