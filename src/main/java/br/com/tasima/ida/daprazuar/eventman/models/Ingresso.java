package br.com.tasima.ida.daprazuar.eventman.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "INGRESSO")
public abstract class Ingresso {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_INGRESSO")
	private Long Id;
	
	// chave estrangeira para tipo de ingresso
	@JsonBackReference(value="ingresso-tipoIngresso")
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_INGRESSO")
	private TipoIngresso tipoIgresso;
	
	// chave estrangeira para tipo de cliente
	@JsonBackReference(value="ingresso-tipoCliente")
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_CLIENTE")
	private TipoCliente tipoCliente;
	
	// chave estrangeira para evento
	@JsonBackReference(value="ingresso")
	@ManyToOne
	@JoinColumn(name = "ID_EVENTO")
	private Evento evento;
}