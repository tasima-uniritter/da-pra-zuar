package br.com.tasima.ida.daprazuar.eventman.models;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.com.tasima.ida.daprazuar.eventman.models.enumeration.TipoIngresso;

@Entity
public class Evento {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String Nome;
	
	@Column(nullable=false)
	private Date Data;
	
//	@NotNull
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "EVENTO_INGRESSO",
//            joinColumns = { @JoinColumn(name = "ID") },
//            inverseJoinColumns = { @JoinColumn(name = "ID") })
	
	@NotNull
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "EVENTO_INGRESSOEVENTO",
		joinColumns = { @JoinColumn(name = "ID_EVENTO") },
		inverseJoinColumns = { @JoinColumn(name = "ID_INGRESSOEVENTO") })
	private Set<IngressoEvento> tiposIngresso;
	
	public Evento() {
	}
	
	public Evento(String nome, Date data) {
		this.Nome = nome;
		this.Data = data;
	}
	
	public Evento(Long id, String nome, Date data) {
		this.id = id;
		this.Nome = nome;
		this.Data = data;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}
	
	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	public Date getData() {
		return Data;
	}
	
	public void setData(Date Data) {
		this.Data = Data;
	}

//	public List<TipoIngresso> getTiposIngresso() {
//		return tiposIngresso;
//	}
//
//	public void setTiposIngresso(List<TipoIngresso> tiposIngresso) {
//		this.tiposIngresso = tiposIngresso;
//	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", Nome=" + Nome + ", Data=" + Data + "]";
	}

}