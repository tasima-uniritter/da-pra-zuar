package br.com.tasima.ida.daprazuar.eventman.models;

public class IngressoEvento {
	
	private String tipo;
	private int Valor;
	
	private String getTipo() {
		return tipo;
	}
	private void setTipo(String tipo) {
		this.tipo = tipo;
	}
	private int getValor() {
		return Valor;
	}
	private void setValor(int valor) {
		Valor = valor;
	}

}