package br.com.tasima.ida.daprazuar.eventman.models;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Evento {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String Nome;
	
	@Column(nullable=false)
	private Date Data;
	
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

	@Override
	public String toString() {
		return "Evento [id=" + id + ", Nome=" + Nome + ", Data=" + Data + "]";
	}

}