package br.com.tasima.ida.daprazuar.eventman.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_CLIENTE")
public class TipoCliente {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_TIPO_CLIENTE")
	private Long id;
	
	@Column
	private int categoria;
	
	@Column
	private int desconto;
	
	// chave estrangeira para evento
	@ManyToOne
	@JoinColumn(name = "ID_EVENTO")
	private Evento evento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
}
