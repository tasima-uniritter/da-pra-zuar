package br.com.tasima.ida.daprazuar.eventman.models.enumeration;

import javax.persistence.Column;

public enum TipoIngresso {
	VIP ("VIP", Double.valueOf(1000) ),
    BACKSTAGE ("BACKSTAGE", Double.valueOf(800)),
    PLATEIA_VIP ("PLATEIA VIP", Double.valueOf(500)),
    PLATEIA ("PLATEIA", Double.valueOf(300));

	@Column
    private final String nome;
    
	@Column
    private final Double valor;

    TipoIngresso(String nome, Double valor){
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }
}
