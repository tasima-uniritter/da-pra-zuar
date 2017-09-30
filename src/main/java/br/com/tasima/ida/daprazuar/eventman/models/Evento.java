package br.com.tasima.ida.daprazuar.eventman.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Evento {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	@Column
	private String Nome;
	
	@Column
	private Date Data;
	
	public Evento() {
	}
	
	public Evento(String nome, Date data) {
		this.Nome = nome;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

}