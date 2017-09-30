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
		this.Email = Email;
		this.Telefone = Telefone;
	}
	
	public ClienteEvento(Long id,String Nome, String Email, String Telefone) {
		this(Nome,Email,Telefone);
		this.Id = id;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	public String getTelefone() {
		return Telefone;
	}
	
	public void setTelefone(String Telefone) {
		this.Telefone = Telefone;
	}
    
}
