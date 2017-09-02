package br.com.tasima.ida.daprazuar.eventman.models;

import java.util.Date;

public class Evento {
	String Nome;
	Date Data;
	
	public Evento() {
		
	}
	
	public Evento(String nome, Date data) {
		Nome = nome;
		Data = data;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public Date getData() {
		return Data;
	}
}