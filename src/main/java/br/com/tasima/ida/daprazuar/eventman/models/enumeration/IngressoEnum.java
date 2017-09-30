package br.com.tasima.ida.daprazuar.eventman.models.enumeration;

public enum IngressoEnum {
	VIP ("VIP", Double.valueOf(1000) ),
    BACKSTAGE ("BACKSTAGE", Double.valueOf(800)),
    PLATEIA_VIP ("PLATEIA VIP", Double.valueOf(500)),
    PLATEIA ("PLATEIA", Double.valueOf(300));

    private final String nome;
    private final Double valor;

    IngressoEnum(String nome, Double valor){
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
