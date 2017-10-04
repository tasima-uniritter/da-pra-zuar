package br.com.tasima.ida.daprazuar.eventman.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "EVENTO")
public class Evento {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_EVENTO")
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private Date data;
	
	@JsonIgnoreProperties("evento")
	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
	private Set<TipoIngresso> tiposIngresso;
	
	@JsonIgnoreProperties("evento")
	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
	private Set<TipoCliente> tiposCliente;
	
	@JsonIgnoreProperties("evento")
	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
	private Set<Ingresso> ingressos;
	
	public Evento() {
	}
	
	public Evento(String nome, Date data) {
		this.nome = nome;
		this.data = data;
	}
	
	public Evento(Long id, String nome, Date data) {
		this.id = id;
		this.nome = nome;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Set<TipoIngresso> getTiposIngresso() {
		return tiposIngresso;
	}

	public void setTiposIngresso(Set<TipoIngresso> tiposIngresso) {
		this.tiposIngresso = tiposIngresso;
	}

	public Set<TipoCliente> getTiposCliente() {
		return tiposCliente;
	}

	public void setTiposCliente(Set<TipoCliente> tiposCliente) {
		this.tiposCliente = tiposCliente;
	}

	public Set<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(Set<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", Nome=" + nome + ", Data=" + data + "]";
	}

}