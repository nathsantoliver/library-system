package santoliver.library.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Fatura {
	
	private Long codFatura;
	private Double valor;

	public Long getCodFatura() {
		return codFatura;
	}

	public void setCodFatura(Long codFatura) {
		this.codFatura = codFatura;
	}

	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}

}
