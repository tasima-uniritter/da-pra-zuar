package br.com.tasima.ida.daprazuar.eventman.models;

import java.util.Date;

public class Evento {
	
	private String nome;
	private Date data;
	
	public Evento() {
		
	}
	
	public Evento(String nome, Date data) {
		this.nome = nome;
		this.data = data;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Date getData() {
		return this.data;
	}
}