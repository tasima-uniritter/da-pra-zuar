package br.com.tasima.ida.daprazuar.eventman.models;

import javax.persistence.*;

@Entity
public abstract class IngressoEvento {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	@Column
	private String Tipo;
	
	@Column
	private int Valor;
	
	public IngressoEvento() {
	}
	
	public IngressoEvento(String Tipo, int valor) {
		this.Tipo = Tipo;
	}
	
	public String getTipo() {
		return Tipo;
	}
	
	public void setTipo(String Tipo) {
		this.Tipo = Tipo;
	}
	
	public int getValor() {
		return Valor;
	}
	
	public void setValor(int Valor) {
		this.Valor = Valor;
		
	}

}