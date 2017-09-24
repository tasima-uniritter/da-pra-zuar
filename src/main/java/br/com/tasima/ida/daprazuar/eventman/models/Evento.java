package br.com.tasima.ida.daprazuar.eventman.models;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Evento {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	@Column
	private String Nome;
	
	@Column
	private Date Data;
	
	public Evento() {
	}
	
	public Evento(String nome, Date data) {
		this.Nome = nome;
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