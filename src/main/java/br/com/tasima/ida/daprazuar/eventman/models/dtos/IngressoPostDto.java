package br.com.tasima.ida.daprazuar.eventman.models.dtos;

public class IngressoPostDto {

	private Long tipoIngressoId;
	
	private Long tipoClienteId;

	public Long getTipoIngressoId() {
		return tipoIngressoId;
	}

	public void setTipoIngressoId(Long tipoIngressoId) {
		this.tipoIngressoId = tipoIngressoId;
	}

	public Long getTipoClienteId() {
		return tipoClienteId;
	}

	public void setTipoClienteId(Long tipoClienteId) {
		this.tipoClienteId = tipoClienteId;
	}
	
}
