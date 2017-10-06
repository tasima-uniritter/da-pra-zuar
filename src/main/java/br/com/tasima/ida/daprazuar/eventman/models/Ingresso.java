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
public class Ingresso {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_INGRESSO")
	private Long Id;
	
	// chave estrangeira para tipo de ingresso
	@JsonBackReference(value="ingresso-tipoIngresso")
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_INGRESSO")
	private TipoIngresso tipoIngresso;
	
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
	
	@Column
	private float valorCobrado;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public TipoIngresso getTipoIngresso() {
		return tipoIngresso;
	}

	public void setTipoIngresso(TipoIngresso tipoIngresso) {
		this.tipoIngresso = tipoIngresso;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public float getValorCobrado() {
		return valorCobrado;
	}

	public void setValorCobrado(float valorCobrado) {
		this.valorCobrado = valorCobrado;
	}
}