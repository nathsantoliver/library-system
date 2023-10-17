package santoliver.library.dto;

import santoliver.library.model.Fatura;

public class NovaTransacao {

	private Integer estudanteId;
	private Integer livroId;
	private Boolean estaPendente;
	private Fatura fatura;
	
	public Integer getEstudanteId() {
		return estudanteId;
	}
	public void setEstudanteId(Integer estudanteId) {
		this.estudanteId = estudanteId;
	}
	public Integer getLivroId() {
		return livroId;
	}
	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
	}
	public Boolean getEstaPendente() {
		return estaPendente;
	}
	public void setEstaPendente(Boolean estaPendente) {
		this.estaPendente = estaPendente;
	}
	public Fatura getFatura() {
		return fatura;
	}
	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
	
}
