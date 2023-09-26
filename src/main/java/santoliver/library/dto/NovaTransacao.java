package santoliver.library.dto;

public class NovaTransacao {

	private Integer estudanteId;
	private Integer livroId;
	private Boolean estaPendente;
	
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
	
}
