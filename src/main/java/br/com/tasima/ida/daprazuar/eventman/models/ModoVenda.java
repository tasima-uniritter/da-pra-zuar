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
@Table(name = "MODO_VENDA")
public class ModoVenda {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_MODO_VENDA")
	private Long id;
	
	@Column
	private String modo;
	
	// chave estrangeira para evento
	@JsonBackReference(value="modo-venda")
	@ManyToOne
	@JoinColumn(name = "ID_EVENTO")
	private Evento evento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
}
