package santoliver.library.dto;

import santoliver.library.model.StatusTipo;

public class NovoLivro {
	
	private String titulo;
	private String autor;
	private Integer edicao;
	private StatusTipo status;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Integer getEdicao() {
		return edicao;
	}
	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}
	
	public StatusTipo getStatus() {
		return status;
	}
	public void setStatus(StatusTipo status) {
		this.status = status;
	}
	
}
