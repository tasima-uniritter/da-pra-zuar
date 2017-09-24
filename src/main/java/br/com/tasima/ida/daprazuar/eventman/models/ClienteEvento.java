package br.com.tasima.ida.daprazuar.eventman.models;

import javax.persistence.*;

@Entity
public class ClienteEvento {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	@Column
	private String Nome;
	
	@Column
	private String Email;
	
	@Column
	private String Telefone;
	
	
	public ClienteEvento() {
		
	}
	
	public ClienteEvento(String Nome, String Email, String Telefone) {
		this.Nome = Nome;
	}
	
	private String getNome() {
		return Nome;
	}
	private void setNome(String Nome) {
		this.Nome = Nome;
	}
	
	private String getEmail() {
		return Email;
	}
	private void setEmail(String Email) {
		this.Email = Email;
	}
	private String getTelefone() {
		return Telefone;
	}
	private void setTelefone(String Telefone) {
		this.Telefone = Telefone;
	}
    
}
