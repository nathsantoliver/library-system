package santoliver.library.dto;

import java.time.LocalDate;

import santoliver.library.model.Fatura;

public class NovoEmprestimo {

	private Integer estudanteId;
	private Integer livroId;
	private LocalDate dataEmprestimo;
	private LocalDate devolucaoPrevista;
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
	
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
	public LocalDate getDevolucaoPrevista() {
		return devolucaoPrevista;
	}
	public void setDevolucaoPrevista(LocalDate devolucaoPrevista) {
		this.devolucaoPrevista = devolucaoPrevista;
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
