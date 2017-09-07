package br.com.tasima.ida.daprazuar.eventman.models;

public class ClienteEvento {
	
	String nome;
    String email;
    String telefone;
	private String getNome() {
		return nome;
	}
	private void setNome(String nome) {
		this.nome = nome;
	}
	private String getEmail() {
		return email;
	}
	private void setEmail(String email) {
		this.email = email;
	}
	private String getTelefone() {
		return telefone;
	}
	private void setTelefone(String telefone) {
		this.telefone = telefone;
	}
    
}
