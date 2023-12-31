package santoliver.library.model;

import java.time.LocalDate;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer emprestimoId;
	private Integer estudanteId;
	private Integer livroId;
	private LocalDate dataEmprestimo;
	private LocalDate devolucaoPrevista;
	private LocalDate dataDevolucao;
	private Boolean estaPendente;
	@Embedded
	private Fatura fatura;
	
	public Integer getEmprestimoId() {
		return emprestimoId;
	}
	
	public void setEmprestimoId(Integer emprestimoId) {
		this.emprestimoId = emprestimoId;
	}
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
	
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
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
