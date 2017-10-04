package br.com.tasima.ida.daprazuar.eventman.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_INGRESSO")
public class TipoIngresso {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_TIPO_INGRESSO")
	private Long id;
	
	@Column
	private int categoria;
	
	@Column
	private int valor;
	
	@Column
	private Date inicioVendas;
	
	@Column
	private Date fimVendas;
	
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

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Date getInicioVendas() {
		return inicioVendas;
	}

	public void setInicioVendas(Date inicioVendas) {
		this.inicioVendas = inicioVendas;
	}

	public Date getFimVendas() {
		return fimVendas;
	}

	public void setFimVendas(Date fimVendas) {
		this.fimVendas = fimVendas;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
}
